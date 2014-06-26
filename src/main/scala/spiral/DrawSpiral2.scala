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

        def isSafe (spiral: Spiral, p: Point, d: Direction, count: Int): Boolean = {
//    	    if (p._2 -1 < 0) getNextPoint((p._1, p._2, RIGHT))
//        	    else if (notTooCloseToSelf())
//        	}
            ???
        }
        
        def movePoint(p: Point, d: Direction): Point = ???
        
        def getNextPoint(spiral: Spiral, p: Point, d: Direction): (Option[Point], Direction) = {
            
//        	if (isSafe(spiral, p, d)) movePoint(p, d)
            ???
            
        }
        
        def addToSpiral(spiral: Spiral, p: Point): Spiral = ???
        
        def drawNext(spiral: Spiral, p: Point, d: Direction): Spiral = {
            printSpiral(spiral)

            val (nextPoint, nextDirection) = getNextPoint(spiral, p, d)
            
            nextPoint match {
                case (None) => spiral
                case (p1) => drawNext(addToSpiral(spiral, p1.head), p1.head, nextDirection)
            }
        }
        
        val centre = (n/2) + 1
        
        drawNext(List(List(x)), (centre, centre), UP)
    }
    
}