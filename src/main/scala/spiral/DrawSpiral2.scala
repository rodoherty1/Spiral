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
 
    def isInSpiral(s: Spiral, p: Point) = {
        (0 <= p.x) && (p.x < s.size) && (0 <= p.y) && (p.y < s.size)
    }
        


    def notTooCloseToSelf(spiral: Spiral, p: Point, d:Direction): Boolean = {
        val p1 = movePoint(p, d)
        Math.abs(p.x - p1.x) == 1 || Math.abs(p.y - p1.y) == 1
    }

    def isValid (s: Spiral, p: Point, d: Direction): Boolean = {
        isInSpiral(s, p) && notTooCloseToSelf(s, p, d)
    }

    def movePoint(p: Point, d: Direction): Point = {
        d match {
            case UP => Point(p.x+1, p.y)
            case RIGHT => Point(p.x, p.y+1)
            case DOWN => Point(p.x-1, p.y)
            case LEFT => Point(p.x, p.y-1)
        }
    }

    def getNextPoint(spiral: Spiral, p: Point, d: Direction): (Option[Point], Direction) = {
        val p1 = movePoint(p, d);
    	if (isValid(spiral, p1, d)) (Some(p1), d)
    	
    	val d2 = nextDirection(d)
    	val p2 = movePoint(p, d2)
    	
    	if (isValid(spiral, p2, d2)) (Some(p2), d2)
    	else (None, d)
    }

 
    
    def apply(n: Int): Spiral = {
	    def drawNext(spiral: Spiral, p: Point, d: Direction): Spiral = {
	        print(spiral.toString())
	
	        val (p1, d1) = getNextPoint(spiral, p, d)
	        
	        p1 match {
	            case (None) => spiral
	            case (Some(point)) => drawNext(spiral.addToSpiral(point), point, d1)
	        }
	    }

	    val p = Point(0, 0)
	    val s = new Spiral(List(List())).addToSpiral(p)
	    drawNext(s, p, UP)
    }
}