package spiral

object DrawSpiral {

    type Spiral = List[List[Char]]
    
    def drawSpiral (n: Int): Spiral = ???
    
    def addLayer(spiral: Spiral, f: Spiral => Spiral): Spiral = ???
    
    def fill(x: Char, o:Char)(spiral: Spiral): Spiral = ???
}