package spiral

import org.scalatest.matchers.ShouldMatchers
import org.scalatest.WordSpec

class SpiralTest extends WordSpec with ShouldMatchers {

    "A Spiral" should {
        "return true if a given point is within the grid size of the Spiral" in {
            val s = new Spiral(2, List(Point(0,0), Point(0,1)))
            s.isContainedInGrid(Point(0,0)) should be (true)
        }

        "return false if a given point is not within the grid size of the Spiral" in {
            val s = new Spiral(2, List(Point(0,0), Point(0,1)))
            s.isContainedInGrid(Point(3,3)) should be (false)
        }
    }
    
}