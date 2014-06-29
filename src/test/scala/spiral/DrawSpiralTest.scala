package spiral

import org.scalatest.matchers.ShouldMatchers
import org.scalatest.WordSpec
import spiral.DrawSpiral2.Direction._

class DrawSpiralTest extends WordSpec with ShouldMatchers {

    val x = 'x'
    val o = '.'
        
    
    "SpiralDraw2" should {
        "draw a spiral for n = 5" ignore {
            DrawSpiral2(5) should be (List(List(x, o, x, x, x), List(x, o, x, o, x), List(x, o, x, o, x), List(x, o, o, o, x), List(x, x, x, x, x)))
        }
        
        "return a new point for a given Point p and Direction UP" in {
        	DrawSpiral2.nextPoint(Point(2,2), UP) should be (Point(2,3))
        }
        "return a new point for a given Point p and Direction RIGHT" in {
        	DrawSpiral2.nextPoint(Point(2,2), RIGHT) should be (Point(3,2))
        }
        "return a new point for a given Point p and Direction LEFT" in {
        	DrawSpiral2.nextPoint(Point(2,2), LEFT) should be (Point(1,2))
        }
        "return a new point for a given Point p and Direction DOWN" in {
        	DrawSpiral2.nextPoint(Point(2,2), DOWN) should be (Point(2,1))
        }
        
        "return false if a suggested Point is too close to another Point of the Spiral" in {
            pending
        }
    }
    
    
}