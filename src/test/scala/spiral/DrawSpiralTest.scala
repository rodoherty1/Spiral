package spiral

import org.scalatest.matchers.ShouldMatchers
import org.scalatest.WordSpec
import spiral.DrawSpiral2.Direction._

class DrawSpiralTest extends WordSpec with ShouldMatchers {
    
    "SpiralDraw2" should {
        "create a spiral for n = 5" in {
        	DrawSpiral2(5).points should equal (List(Point(2,2), Point(2,1), Point(2,0), Point(3,0), Point(4,0), Point(4,1), Point(4,2), Point(4,3), Point(4,4), Point(3,4), Point(2,4), Point(1,4), Point(0,4), Point(0,3), Point(0,2), Point(0,1), Point(0,0)))
        }
        
        "draw a spiral for n = 5" in {
            DrawSpiral2(5).toString should be ("xxxxx\n....x\nxxx.x\nx...x\nxxxxx\n")
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
        
        "report that p(0, 1), which is moving UP, is too close to p(0, 2)" in {
            val s = new Spiral(5, List(Point(0, 0), Point(0, 2)))            
        	DrawSpiral2.tooCloseToSelf(s, Point(0,1), UP) should be (true)
        }

        "report that p(0, 3), which is moving UP, is not too close to p(0, 2)" in {
            val s = new Spiral(5, List(Point(0, 0), Point(0, 2)))            
        	DrawSpiral2.tooCloseToSelf(s, Point(0,3), UP) should be (false)
        }

        "report that p(1, 0), which is moving RIGHT, is too close to p(2, 0)" in {
            val s = new Spiral(5, List(Point(0, 0), Point(2, 0)))            
        	DrawSpiral2.tooCloseToSelf(s, Point(1,0), RIGHT) should be (true)
        }

        "report that p(0, 3), which is moving RIGHT, is not too close to p(0, 2)" in {
            val s = new Spiral(5, List(Point(0, 0), Point(2, 0)))            
        	DrawSpiral2.tooCloseToSelf(s, Point(3, 0), RIGHT) should be (false)
        }
        
        "report that p(0, 4), which is moving DOWN, is too close to p(0, 3)" in {
            val s = new Spiral(5, List(Point(0, 5), Point(0, 3)))            
        	DrawSpiral2.tooCloseToSelf(s, Point(0,4), DOWN) should be (true)
        }

        "report that p(0, 2), which is moving DOWN, is not too close to p(0, 3)" in {
            val s = new Spiral(5, List(Point(0, 5), Point(0, 3)))            
        	DrawSpiral2.tooCloseToSelf(s, Point(0, 2), DOWN) should be (false)
        }

        "report that p(4, 0), which is moving LEFT, is too close to p(3, 0)" in {
            val s = new Spiral(5, List(Point(3, 0), Point(5, 0)))            
        	DrawSpiral2.tooCloseToSelf(s, Point(4, 0), LEFT) should be (true)
        }

        "report that p(2, 0), which is moving LEFT, is not too close to p(3, 0)" in {
            val s = new Spiral(5, List(Point(3, 0), Point(5, 0)))            
        	DrawSpiral2.tooCloseToSelf(s, Point(2, 0), LEFT) should be (false)
        }
        
        "report that p(0, 1), which is moving UP, may be placed on the grid" in {
            val s = new Spiral(5, List(Point(0, 0)))
            DrawSpiral2.isValid(s, Point(0, 1), UP) should be (true)
            
        }
        
    }
    
    
}