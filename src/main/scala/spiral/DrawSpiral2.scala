package spiral

object DrawSpiral2 {

    type Spiral = List[List[Char]]
    type Point = (Int, Int)
    val x = 'x'
    val o = '.'
        
    object Direction extends Enumeration {
        type Direction = Value
    	val UP, DOWN, LEFT, RIGHT = Value
    }

    import Direction._
    
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
        
        def drawNext(spiral: Spiral, lastStep: Point, lastDirection: Direction): Spiral = {
            printSpiral(spiral)
            spiral
        }
        
        drawNext(List(List(x)), (1, 1), UP)
    }
    
}