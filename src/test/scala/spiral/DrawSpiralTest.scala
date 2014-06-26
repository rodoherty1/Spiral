package spiral

import org.scalatest.matchers.ShouldMatchers
import org.scalatest.WordSpec

class DrawSpiralTest extends WordSpec with ShouldMatchers {

    val x = 'x'
    val o = '.'
        
    "SpiralDraw2" should {
        "draw a spiral for n = 5" in {
            DrawSpiral2(5) should be (List(List(x, o, x, x, x), List(x, o, x, o, x), List(x, o, x, o, x), List(x, o, o, o, x), List(x, x, x, x, x)))
        }
    }
    
}