package spiral

object DrawSpiral {

    type Spiral = List[List[Char]]

    val x = '0'
    val o = '.'

    def drawSpiral (n : Int): Spiral = {
      val fillA = fill(x,o, _:Spiral)
      val fillB = fill(o,x, _:Spiral)

      createSpiral(n, fillA, fillB)
    }

    def print(s: Spiral) = {
      s map {l => l.mkString("")} mkString("\n")
    }

    def createSpiral (
        n: Int,
        fillA: Spiral => Spiral,
        fillB: Spiral => Spiral): Spiral = {

      val nMod4 = n % 4

      (n, nMod4) match {
        // base case: 1x1 array
        case (1, _) => List(List(x))

        // recursive cases: odd-valued n
        case (n, 3) => fillA( createSpiral(n-2, fillA, fillB) )
        case (n, 1) => fillB( createSpiral(n-2, fillA, fillB) )

        // error cases: even-valued n
        case (_, 2) => List(List())
        case (_, 4) => List(List())
      }
    }

    /**
     * Adds one layer around an existing spiral
     * @param p
     * @param q
     * @param spiral An n x n spiral
     * @return An n+2 x n+2 spiral
     */
    def fill(p: Char, q:Char, spiral: Spiral): Spiral = {

        val n = spiral.length

        val top = List.fill(n+1){p} ++ List(q)
        val bottom = List.fill(n+2){q}

        val middle = spiral map { row => q :: (row ++ List(q))}

        (top :: middle) :+ bottom
    }

}
