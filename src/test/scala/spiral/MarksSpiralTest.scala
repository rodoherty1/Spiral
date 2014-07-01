package spiral

import org.scalatest.matchers.ShouldMatchers
import org.scalatest.WordSpec

class MarksSpiralTest extends WordSpec with ShouldMatchers{

  val x = 'x'
    val o = 'o'

  "DrawSpiral" should {
    "draw a spiral of size 1" in {
      DrawSpiral.drawSpiral(1) should be (List(List(x)))
    }
    "draw a spiral of size 3" in {
      DrawSpiral.drawSpiral(3) should be (
          List(List(x,x,o),
              List(o,x,o),
              List(o,o,o))
          )
    }
    "fail on spiral of size 2" in {
      DrawSpiral.drawSpiral(2) should be (List(List()))
    }
  }
}
