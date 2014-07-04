package spiral

case class Spiral(size: Int, points: List[Point]) {

    def addToSpiral(p: Point): Spiral = {
        Spiral(size, p :: points)
    }
    
    def isContainedInGrid(p: Point) = (0 <= p.x) && (p.x < size) && (0 <= p.y) && (p.y < size)

    def contains(p: Point) = points.contains(p)
        
    override def toString(): String = {
	    val l = for {
    	    p <- points
    	} yield size * p.x + p.y
    	
    	def getCh(n: Int): String = {
    	    val ch = if (l.contains(n)) "x" else "."
    	        
    	    if ((n+1) % size == 0) {
    	        ch + "\n"
    	    } else {
    	        ch
    	    }
    	}

    	List.tabulate(size * size)(n => getCh(n)) mkString ("")
    }
}