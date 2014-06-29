package spiral

import org.scalatest.matchers.ShouldMatchers
import org.scalatest.WordSpec

class SpiralTest extends WordSpec with ShouldMatchers {
    
    val x = 'x'
    val o = '.'
        
    
    "A Spiral" should {
        "print a 1*1 spiral" in {
            val s = new Spiral(List(List(x)))
            s.toString() should be ("x\n")
        }

        "print a 5*5 spiral" ignore {
            val s = new Spiral(List(List(x, o, x, x, x), List(x, o, x, o, x), List(x, o, x, o, x), List(x, o, o, o, x), List(x, x, x, x, x)))
            s.toString() should be ("x.xxx\nx.x.x\nx.x.x\nx...x\nxxxxx\n")
        }
    }
}