package spiral

import org.scalatest.matchers.ShouldMatchers
import org.scalatest.WordSpec

class SpiralTest extends WordSpec with ShouldMatchers {
    
    val x = 'x'
    val o = '.'
        
    
    "A Spiral" should {
        "print a 1*1 spiral" ignore {
            val s = new Spiral(1, List(Point(0,0)))
            s.toString() should be ("x\n")
        }

        "print a 2*2 spiral" ignore {
            val s = new Spiral(2, List(Point(0,0), Point(0,1)))
            s.toString() should be ("xx\n..\n")
        }
        
        "return true if a given point is within the grid size of the Spiral" in {
            val s = new Spiral(2, List(Point(0,0), Point(0,1)))
            s.isInSpiral(Point(0,0)) should be (true)
        }

        "return false if a given point is not within the grid size of the Spiral" in {
            val s = new Spiral(2, List(Point(0,0), Point(0,1)))
            s.isInSpiral(Point(3,3)) should be (false)
        }

    }
    
}