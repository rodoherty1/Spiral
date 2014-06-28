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

    type Spiral = List[List[Char]]
    type Point = (Int, Int)
    val x = 'x'
    val o = '.'
        
    
    def printSpiral(spiral: Spiral): Unit = {
        def printRow (l: List[Char]): Unit = {
            l match {
                case (Nil) =>
                    print ("\n")
                case (x :: xs) =>
                    print(x)
                	printRow(xs)		
            }
        }
        
        spiral match {
            case (Nil) => print("\n")
            case (xs1 :: xs2) =>
                printRow(xs1)
                printSpiral(xs2)
        }
    }

    
    def apply(n: Int): Spiral = {

        def isInSpiral(p: Point) = (0 <= p._1) && (p._1 < n) && (0 <= p._2) && (p._2 < n)
            
        def notTooCloseToSelf(spiral: Spiral, p: Point, d:Direction): Boolean = {
            val p1 = movePoint(p, d)
            Math.abs(p._1 - p1._1) == 1 || Math.abs(p._2 - p1._2) == 1
        }
            
        def isValid (spiral: Spiral, p: Point, d: Direction): Boolean = {
            val x = p._1 
            val y = p._2 
            
            isInSpiral(p) && notTooCloseToSelf(spiral, p, d)
        }
        
        
        def movePoint(p: Point, d: Direction): Point = {
            val x = p._1 
            val y = p._2 

            d match {
                case UP => (x+1, y)
                case RIGHT => (x, y+1)
                case DOWN => (x-1, y)
                case LEFT => (x, y-1)
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
        
        def addToSpiral(spiral: Spiral, p: Point): Spiral = ???
        
        def drawNext(spiral: Spiral, p: Point, d: Direction): Spiral = {
            printSpiral(spiral)

            val (p1, d1) = getNextPoint(spiral, p, d)
            
            p1 match {
                case (None) => spiral
                case (Some(point)) => drawNext(addToSpiral(spiral, point), point, d1)
            }
        }
        
        
        
        drawNext(List(List(x)), (0, 0), UP)
    }
    
}