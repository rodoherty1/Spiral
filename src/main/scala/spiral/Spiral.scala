package spiral

case class Spiral(spiral: List[List[Char]]) {
    
    def size = spiral.length

    def addToSpiral(p: Point): Spiral = ???
        
    override def toString(): String = {
        val sb = new StringBuilder
        
        def appendRow (l: List[Char]): StringBuilder = {
            l match {
                case (Nil) => sb
                case (x :: xs) =>
                    sb += x
                    sb ++= appendRow(xs)
            }
        }
        
        def appendRows(rows: List[List[Char]]): StringBuilder = {
	        rows match {
	            case (Nil) => sb ++= "\n"
		        case (xs1 :: xs2) =>
		                appendRow(xs1) ++= appendRows(xs2)
		        }
	        }

        appendRows(spiral).toString
    }
}