package spiral

object DrawSpiral2 {
    object Direction extends Enumeration {
        type Direction = Value
    	val UP, RIGHT, DOWN, LEFT = Value
    	val directions = List(UP, RIGHT, DOWN, LEFT)
    	
    	def nextDirection(d: Direction): Direction = {
            d match {
                case UP => RIGHT
                case RIGHT => DOWN
                case DOWN => LEFT
                case LEFT => UP
            }
        }
    }

    import Direction._

    val x = 'x'
    val o = '.'
 
        
    def tooCloseToSelf(spiral: Spiral, p: Point, d:Direction): Boolean = {
        val p1 = nextPoint(p, d)
        spiral.contains(p1)
    }
    

    def isValid (s: Spiral, p: Point, d: Direction): Boolean = {
        s.isContainedInGrid(p) && !tooCloseToSelf(s, p, d)
    }

    
    def nextPoint(p: Point, d: Direction): Point = {
        d match {
            case UP => Point(p.x, p.y+1)
            case RIGHT => Point(p.x+1, p.y)
            case DOWN => Point(p.x, p.y-1)
            case LEFT => Point(p.x-1, p.y)
        }
    }

    
    def getNextPoint(s: Spiral, p: Point, d: Direction): (Option[Point], Direction) = {
        val p1 = nextPoint(p, d);
    	if (isValid(s, p1, d)) {
    	    (Some(p1), d)
    	}
    	else {
	    	val d2 = nextDirection(d)
	    	val p2 = nextPoint(p, d2)
	    	
	    	if (isValid(s, p2, d2)) (Some(p2), d2)
	    	else (None, d)
    	}
    	
    }

    
    def apply(n: Int): Spiral = {
	    def drawNext(s: Spiral, p: Point, d: Direction): Spiral = {
	        val (p1, d1) = getNextPoint(s, p, d)
	        
	        p1 match {
	            case (None) => s
	            case (Some(point)) => drawNext(s.addToSpiral(point), point, d1)
	        }
	    }

	    val p = Point(0, 0)
	    val s = new Spiral(n, List(p))
	    drawNext(s, p, UP)
    }
    
    
    def toString(spiral: Spiral): String = {
	    val l = for {
    	    p <- spiral.s
    	} yield p.x * p.y
    	
    	def getCh(n: Int): String = {
    	    val ch = if (l.contains(n)) "x" else "."
    	        
    	    if (n % spiral.size == 0) {
    	        ch + "\n"
    	    } else {
    	        ch
    	    }
    	}

    	List.tabulate(spiral.size ^ 2)(n => getCh(n)) mkString ("")
    }
    
}