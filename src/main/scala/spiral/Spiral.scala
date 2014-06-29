package spiral

object Spiral {
    val x = 'x'
    val o = '.'
}

case class Spiral(size: Int, s: List[Point]) {

    import spiral.Spiral._
    
    def addToSpiral(p: Point): Spiral = {
        Spiral(size, p :: s)
    }
    
    def isInSpiral(p: Point) = (0 <= p.x) && (p.x < size) && (0 <= p.y) && (p.y < size)

        
//    override def toString(): String = {
//        def appendRow (l: List[Char]): String = {
//            l match {
//                case (Nil) => "\n"
//                case (x :: xs) =>
//                    x + appendRow(xs)
//            }
//        }
//        
//        def appendRows(rows: List[List[Char]]): String = {
//	        rows match {
//	            case (Nil) => ""
//		        case (xs1 :: xs2) =>
//		                appendRow(xs1) + appendRows(xs2)
//		        }
//	        }
//
//        appendRows(s)
//    }
}