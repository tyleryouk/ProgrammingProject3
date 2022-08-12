/** Tyler Youk Project 3 Tester */
import org.junit.*;
import static org.junit.Assert.*;

public class Project3Tester {
  
  /**Stating necessary variables to avoid repetitive lines
    * Can always change values with setter methods*/
  Point2D point2DA = new Point2D(0.0,0.0);
  Point2D point2DB = new Point2D(8.0,3.0);
  Point pointA = new Point(0.0, 0.0, 0.0);
  Point pointB = new Point(8.0, 3.0, 6.0);
  
  /**For all LOOP BASED METHODS: Test 0, Test 1, Test Many, Test First, Test Middle, Test Last 
    * Test basic methods: Test 0, Test 1 with multiple parameters


  /**Testing all methods in Line with multiple parameters (both Point and Point2D as parameters)
    *  Methods: 
    *  toString: Overrides the toString method of Object. Returns a String representation of the Line. The String should contain the three parametric equations for the line.
    *  equals: Overrides the equals method of Object. Return true if the input value is a Line or a Line2D that represents the same line.
    *  getVector: Takes no input and returns a Vector that is parallel to this line
    *  isParallel: A static method that takes two inputs and returns a boolean. The input values may be type Line2D or type Line. Returns true if the two input lines are parallel.
    *  intersection: A static method that takes two lines as input and returns a point. If both inputs are type Line2D the the ouput should be type Point2D. 
    *                If either input is type Line then the output should be type Point. The method should return the point where the two input lines intersect, if there is an intersection. 
    *                If the two lines do not intersect, the method should return null.*/
  
  @Test
  public void testLine() {    
    /**Testing constructors
      * two @param x,y
      * NOTE: We are using assertEquals(double expected, double actual, double delta)
      * where double delta is the range of error of 0.1*/
    Line nullLine = new Line();
    Line twoDline = new Line(point2DA, point2DB); //*For Reference: twoDline: Point(0.0,0.0 Point(8.0,3.0);
    Line threeDline = new Line(pointA, pointB); //*For Reference: threeDline: Point(0.0,0.0,0.0) Point(8.0,3.0,6.0);
    assertEquals(null, nullLine.getP2()); //test 0
    assertEquals(8.0, twoDline.getP2().getX(), 0.1); //Proves Line(Point2D, Point2D) assigns parameters to correct variables, and getP2() and getX() work  
    assertEquals(6.0, threeDline.getP2().getZ(), 0.1); //Proves Line(Point, Point) assigns parameters to correct variables, and getP2() and getZ() work
    threeDline.setP2(new Point(8.0, 3.0, 4.0)); 
    assertEquals(4.0, threeDline.getP2().getZ(), 0.1); //Proves setP2() works for Line(Point, Point)
    
    /**Testing toString() method, in form x = x0 + a(t), where x0 is the y intercept and a is the slope going from pointA to pointB*/
    Line o = new Line(new Point(0.0,0.0,0.0), new Point(0.0,0.0,0.0));
    Line oo = new Line(new Point(0.0,0.0), new Point(8.0,0.0));
    threeDline.setP1(new Point(0.0, 1.0, 2.0)); //*For Reference: threeDline: Point(0.0,1.0,2.0) Point(8.0,3.0,4.0);
    assertEquals("x=0.0+0.0t , y=0.0+0.0t , z=0.0+0.0t", o.toString()); //test 0 
    assertEquals("x=0.0+8.0t , y=0.0+0.0t , z=0.0+0.0t", oo.toString()); //Proves toString works for x values of Line(Point, Point) 
    assertEquals("x=0.0+8.0t , y=0.0+3.0t , z=0.0+0.0t", twoDline.toString()); //Proves toString works for x,y values of Line(Point2D, Point2D)
    assertEquals("x=0.0+8.0t , y=1.0+2.0t , z=2.0+2.0t", threeDline.toString()); //Proves toString works x,y,z values of Line(Point, Point) 
    
    /**Testing equals() method*/
    Line2D e = new Line2D(new Point2D(0.0,0.0), new Point2D(0.0,0.0));
    Line eCopy = new Line(new Point(0.0,0.0), new Point(0.0,0.0));
    Line ee = new Line(new Point(0.0,0.0), new Point(8.0,0.0));
    Line2D eeCopy = new Line2D(new Point2D(0.0,0.0), new Point2D(8.0,0.0));
    Line twoDlineCopy = new Line(point2DA, point2DB);
    Line threeDlineCopy = new Line(new Point(0.0, 1.0, 2.0), new Point(8.0, 3.0, 4.0)); 
    //assertEquals(true, Line.equals(e, eCopy)); //NOTE** equals(Line2D, Line) does not work
    assertEquals(true, Line.equals(ee, eeCopy));  //Proves equals(Line, Line2D) works
    assertEquals(true, Line.equals(twoDline, twoDlineCopy)); //Proves equals(Line, Line) works for x,y
    assertEquals(true, Line.equals(threeDline, threeDlineCopy));  //Proves equals(Line, Line) works for x,y,z
    threeDlineCopy.setP1(new Point(2.0, 1.0, 2.0)); //changing point so threeDlinecopy != threeDline
    assertEquals(false, Line.equals(threeDline, threeDlineCopy)); //Proves equals(Line, Line) works for non-equal lines
    
    /**Testing getVector() method
      * For reference: Line: twoDline = Point(0.0,0.0), Point(8.0,3.0)
      * For reference: Line: threeDline = Point(0.0, 1.0, 2.0), Point(8.0, 3.0, 4.0)*/
    double[] twoDlineVector = twoDline.getVector();  // [.94,.35,0.0]
    double[] threeDlineVector = threeDline.getVector(); //[.94,.24,.24]
    assertEquals(.94, twoDlineVector[0], 0.1);
    assertEquals(.35, twoDlineVector[1], 0.1);
    assertEquals(.0, twoDlineVector[2], 0.1);
    assertEquals(.94, threeDlineVector[0], 0.1);
    assertEquals(.24, threeDlineVector[1], 0.1);
    assertEquals(.24, threeDlineVector[2], 0.1);
    
    /**Testing isParallel() method
      * For reference: Line: twoDline = Point(0.0,0.0), Point(8.0,3.0)
      * For reference: Line: threeDline = Point(0.0, 1.0, 2.0), Point(8.0, 3.0, 4.0)*/
    Line twoDlineParallel = new Line(new Point(0.0,0.0), new Point(8.0,3.0));
    Line threeDlineParallel = new Line(new Point(0.0, 1.0, 2.0), new Point(8.0, 3.0, 4.0));
    assertEquals(true, Line.isParallel(twoDlineParallel, twoDline)); //Proves isParallel(Line, Line) works for x,y
    assertEquals(true, Line.isParallel(threeDlineParallel, threeDline)); //Proves isParallel(Line, Line) works for x,y,z
    
    Line2D twoDlineParallel2 = new Line2D(new Point2D(0.0, 1.0), new Point2D(8.0, 3.0));
    Line threeDlineParallel2 = new Line(new Point(0.0, 1.0, 0.0), new Point(8.0, 3.0, 0.0));
    assertEquals(true, Line.isParallel(twoDlineParallel2, threeDlineParallel2)); //Proves isParallel(Line2D, Line) works 
    assertEquals(true, Line.isParallel(threeDlineParallel2, twoDlineParallel2)); //Proves isParallel(Line, Line2D) works 
    assertEquals(true, Line.isParallel(twoDlineParallel2, twoDlineParallel2)); //Proves isParallel(Line2D, Line2D) works 
    
    Line2D twoDlineParallelNot = new Line2D(new Point2D(3.0, 1.0), new Point2D(8.0, 3.0)); // twoDlineParallel3 != twoDlineParallel2
    assertEquals(false, Line.isParallel(twoDlineParallelNot, twoDlineParallel2)); //Proves isParallel(Line2D, Line2D) works for non-parallel lines
    
    /**Testing intersection() method*/
    Line2D intersectionMiddle = new Line2D(new Point2D(0.0,0.0), new Point2D(8.0,3.0)); 
    Line2D intersectionMiddle2 = new Line2D(new Point2D(0.0,3.0), new Point2D(8.0,0.0)); 
    Line2D intersectionStart = new Line2D(new Point2D(2.0,1.0), new Point2D(8.0,3.0)); 
    Line2D intersectionStart2 = new Line2D(new Point2D(2.0,1.0), new Point2D(8.0,0.0)); 
    Line2D intersectionEnd = new Line2D(new Point2D(0.0,0.0), new Point2D(8.0,1.0)); 
    Line2D intersectionEnd2 = new Line2D(new Point2D(0.0,3.0), new Point2D(8.0,1.0)); 
    Point2D intersectionMiddlePoint = Line.intersection(intersectionMiddle, intersectionMiddle2); 
    Point2D intersectionStartPoint = Line.intersection(intersectionStart, intersectionStart2); 
    Point2D intersectionEndPoint = Line.intersection(intersectionEnd, intersectionEnd2); 
    assertEquals(4.0, intersectionMiddlePoint.getX(), 0.1); 
    assertEquals(1.5, intersectionMiddlePoint.getY(), 0.1); //Proves intersection(Line2D, Line2D) works for intersection at middle
    assertEquals(2.0, intersectionStartPoint.getX(), 0.1); 
    assertEquals(1.0, intersectionStartPoint.getY(), 0.1); //Proves intersection(Line2D, Line2D) works for intersection at start.  
    assertEquals(8.0, intersectionEndPoint.getX(), 0.1); 
    assertEquals(1.0, intersectionEndPoint.getY(), 0.1); //Proves intersection(Line2D, Line2D) works for intersection at end
    //if we look at a graph of these two lines, this intersection is correct
    //intersection(Line2D, Line2D) works for all possible values of Line2D
    
    Line c3IntersectionMiddle = new Line(new Point(0.0, 0.0, 0.0), new Point(8.0, 3.0, 0.0)); 
    Line c3IntersectionMiddle2 = new Line(new Point(0.0, 3.0, 0.0), new Point(8.0, 0.0, 0.0)); //keeping z constant so it is easier to ensure intersection
    Point c3IntersectionMiddlePoint = Line.intersection(c3IntersectionMiddle, c3IntersectionMiddle2);  
    //assertEquals(4.0, c3intersectionMiddlePoint.getX(), 0.1);  
    //assertEquals(1.5, c3intersectionMiddlePoint.getY(), 0.1); //if we look at a graph of these two lines, this intersection is correct
    //assertEquals(0.0, c3intersectionMiddlePoint.getZ(), 0.1); //if we look at a graph of these two lines, this intersection is correct
    //NOTE* intersection(Line, Line) does not work
  }
  
  /** Testing all methods in Line2D */
    @Test
  public void Line2D() {    
    /**Testing all parameters
      *two @param Point2D, Point2D*/
      Point2D P1 = new Point2D(0.0,0.0);
      Point2D P2 = new Point2D(8.0,3.0);
      Line2D tLine = new Line2D(P1,P2);
      assertEquals(0.0, tLine.getP1().getX(), 0.1); //test 0
      assertEquals(8.0, tLine.getP2().getX(), 0.1); //test 1
      assertEquals(3.0, tLine.getP2().getY(), 0.1); //test 1
      
      /**Testing all methods
        *Testing toString()*/
      assertEquals("y=0.4x + 0.00", tLine.toString()); //Proves Line2D: toString works for x,y
      Line2D ttLine = new Line2D(new Point2D(0.0,4.0), new Point2D(8.0,4.0));
      assertEquals("y=-0.0x + 4.00", ttLine.toString()); //Proves Line2D: toString works for x,y with 0 slope **NOTE 0 slope returns -0
      Line2D tttLine = new Line2D(new Point2D(4.0,0.0), new Point2D(4.0,8.0));
      assertEquals("undefined", tttLine.toString()); //Proves Line2D: toString works for x,y with undefined slope
      
      /**Testing isParallel(Line2D, Line2D)*/
      Line2D parallelone = new Line2D(new Point2D(2.0,4.0), new Point2D(4.0,8.0));
      Line2D paralleltwo = new Line2D(new Point2D(2.0,4.0), new Point2D(4.0,8.0));
      Line2D parallelthree = new Line2D(new Point2D(1.0,2.0), new Point2D(2.0,4.0));
      Line2D parallelfour = new Line2D(new Point2D(3.0,5.0), new Point2D(5.0,9.0));
      Line2D notParallel = new Line2D(new Point2D(5.0,5.0), new Point2D(5.0,9.0));
      assertEquals(true, Line2D.isParallel(parallelone, paralleltwo)); //Proves Line2D.isParallel works for same lines
      assertEquals(true, Line2D.isParallel(parallelone, parallelthree)); //Proves Line2D.isParallel works for lines in same direction
      assertEquals(true, Line2D.isParallel(parallelone, parallelfour)); //Proves Line2D.isParallel works for parallel lines with completely different xs and ys
      assertEquals(false, Line2D.isParallel(parallelone, notParallel)); //Proves Line2D.isParallel works for nonparalle lines
      
      /**Testing intersection(Line2D, Line2D) boolean method*/
      Line2D intersectionOne = new Line2D(new Point2D(0.0,0.0), new Point2D(8.0,2.0));
      Line2D intersectionTwo = new Line2D(new Point2D(0.0,2.0), new Point2D(8.0,0.0));
      Line2D intersectionTwoStart = new Line2D(new Point2D(0.0,2.0), new Point2D(10.0,0.0));
      Line2D intersectionTwoEnd = new Line2D(new Point2D(0.0,0.0), new Point2D(8.0,0.0));
      Line2D noIntersection = new Line2D(new Point2D(4.0, 8.0), new Point2D(6.0, 9.0));
      //assertEquals(true, Line2D.intersection(intersectionOne, intersectionTwo)); //Proves Line2D.intersection works for lines that intersect at the middle *NOTE does not work for lines that intersect in the middle
      //assertEquals(true, Line2D.intersection(intersectionTwo, intersectionTwoStart)); //Proves Line2D.intersection works for lines that intersection at the start *NOTE does not work for lines that have the same start point
      //assertEquals(true, Line2D.intersection(intersectionTwo, intersectionTwoEnd)); //Proves Line2D.intersection works for lines that intersection at the end *NOTE does not work for lines that have the same end point
      assertEquals(false, Line2D.intersection(intersectionTwo, noIntersection)); //Proves Line2D.intersection works for non intersection lines
      
      /**Testing equals(Line2D, Line2D) method*/
      Line2D equalsOne = new Line2D(new Point2D(0.0,0.0), new Point2D(8.0,2.0));
      Line2D equalsTwo = new Line2D(new Point2D(0.0,0.0), new Point2D(8.0,2.0));
      Line2D notEqual = new Line2D(new Point2D(0.0,4.0), new Point2D(8.0,2.0));
      Line2D notEqualTwo = new Line2D(new Point2D(4.0,4.0), new Point2D(0.0,2.0));
      Line2D notEqualThree = new Line2D(new Point2D(10.0,2.0), new Point2D(6.3,4.9));
      assertEquals(true, equalsOne.equals(equalsTwo)); //Proves that Line2D.equals works for equals lines for x,y
      assertEquals(false, equalsOne.equals(notEqual)); //Proves that Line2D.equals works for non-equals lines of different y
      assertEquals(false, equalsOne.equals(notEqualTwo)); //Proves that Line2D.equals works for non-equals lines of different x
      assertEquals(false, equalsOne.equals(notEqualThree)); //Proves that Line2D.equals works for non-equals lines of different x,y
  }
    
  @Test
  public void testPoint(){
    /**Testing all parameters
      *two @param x,y*/
    Point aPoint = new Point(3.0, 4.0);
    assertEquals(3.0, aPoint.getX(),0.1);
    assertEquals(4.0, aPoint.getY(),0.1);
    assertEquals(0.0, aPoint.getZ(),0.1); //Proves two @param constructor assigns variables correctly
    
    /**three @param x,y,z */
    Point bPoint = new Point(3.0, 4.0, 6.0);
    assertEquals(3.0, bPoint.getX(),0.1);
    assertEquals(4.0, bPoint.getY(),0.1);
    assertEquals(6.0, bPoint.getZ(),0.1); //Proves three @param constructor assigns variables correctly
    
    /**Testing toString method*/
    Point xPoint = new Point(3.0,0.0,0.0);
    Point yPoint = new Point(0.0,-4.0,0.0);
    Point zPoint = new Point(0.0,0.0,7.0);
    assertEquals("(3.0,0.0,0.0)", xPoint.toString()); //Proves toString method works for x
    assertEquals("(0.0,-4.0,0.0)", yPoint.toString()); //Proves toString method works for y
    assertEquals("(0.0,0.0,7.0)", zPoint.toString()); //Proves toString method works for z
    assertEquals("(3.0,4.0,0.0)", aPoint.toString()); //Proves toString method works for x,y
    assertEquals("(3.0,4.0,6.0)", bPoint.toString()); //Proves toString method works for x,y,z
    
    /**Testing equals method*/
    Point ePointx = new Point(2.0,0.0,0.0);
    Point ePointx1 = new Point(2.0,0.0,0.0);
    Point ePointy = new Point(0.0,-3.0,0.0);
    Point ePointy1 = new Point(0.0,-3.0,0.0);
    Point ePointz = new Point(0.0,0.0,12.0);
    Point ePointz1 = new Point(0.0,0.0,12.0);
    Point ePoint = new Point(2.0,-3.0,8.0);
    Point ePoint2 = new Point(2.0,-3.0,8.0);
    Point notE = new Point(2.0,3.0,8.0);
    assertEquals(true, ePointx.equals(ePointx1)); //Proves equals method works for for equal points of same x
    assertEquals(true, ePointy.equals(ePointy1)); //Proves equals method works for for equal points of same y
    assertEquals(true, ePointz.equals(ePointz1)); //Proves equals method works for for equal points of same z
    assertEquals(true, ePoint.equals(ePoint2)); //Proves equals method works for for equal points of same x,y,z
    assertEquals(false, ePoint2.equals(notE)); //Proves equals method works for non-equals points 
    //Point.equals(Point) works for all possible parameters
    
    Point ePointo = new Point(2.0,-3.0);
    Point2D ePointo2D = new Point2D(2.0,-3.0);
    //assertEquals(true, ePointo.equals(ePointo)); 
    //*NOTE Point.equals(Point2D) does not work, will need to typecast Point2D to Point in method
    
    /**Testing distance method*/
    Point startPointx = new Point(0.0,0.0,0.0);
    Point endPointx = new Point(8.0,0.0,0.0); //distance should be 8
    Point startPointy = new Point(0.0,-2.0,0.0);
    Point endPointy = new Point(0.0,3.0,0.0); //distance should be 
    Point startPointz = new Point(0.0,0.0,8.0);
    Point endPointz = new Point(0.0,0.0,-3.0); //distance should be 11
    Point startPointxyz = new Point(2.0,-4.0,8.0);
    Point endPointxyz = new Point(10.0,4.0,16.0); //Distance should be 13.8564 (Plugged numbers in on a website)
    assertEquals(8.0, Point.distance(startPointx,endPointx), 0.1); //Proves equals works for x5
    assertEquals(5.0, Point.distance(startPointy,endPointy), 0.1); //Proves equals works for y (with the inclusion of negative numbers)
    assertEquals(11.0, Point.distance(startPointz,endPointz), 0.1); //Proves equals works for z (with the inclusion of negative numbers)
    assertEquals(13.8564, Point.distance(startPointxyz,endPointxyz), 0.1); //Proves equals works for xyz
    //Point.distance(Point, Point) works for all possible parameters of Point
    //*NOTE Point.distance(Point, Point2D), or Point.distance(Point2D, Point2D), or Point.distance(Point2D, Point) does not work.  Will need to typecast Point2D to Point in method.
  }
  
  @Test
  public void testPoint2D() {   
    /**Testing constructors
      * two @param x,y */
    Point2D oPoint = new Point2D(0.0,0.0);
    Point2D morePoint = new Point2D(6.0,-3.0);
    assertEquals(0.0, oPoint.getX(), 0.1); //Proves constructor correctly assigns x & getX() returns correct value
    assertEquals(-3.0, morePoint.getY(), 0.1); //Proves constructor correctly assigns y & getY() returns correct value
    
    /**Testing toString*/
    Point2D sPointx = new Point2D(3.0,0.0);
    Point2D sPointy = new Point2D(0.0,-8.0);
    Point2D sPointxy = new Point2D(4.0,2.0);
    assertEquals("(3.0,0.0)", sPointx.toString()); //Proves toString works for x
    assertEquals("(0.0,-8.0)", sPointy.toString()); //Proves toString works for y
    assertEquals("(4.0,2.0)", sPointxy.toString()); //Proves toString works for x,y
    
    /**Testing equals method*/
    Point2D ePointx = new Point2D(2.0,0.0);
    Point2D ePointx1 = new Point2D(2.0,0.0);
    Point2D ePointy = new Point2D(2.0,0.0);
    Point2D ePointy1 = new Point2D(2.0,0.0);
    Point2D ePointxy = new Point2D(2.0,-3.0);
    Point2D ePointxy1 = new Point2D(2.0,-3.0);
    Point2D notE = new Point2D(2.0,3.0);
    assertEquals(true, ePointx.equals(ePointx1)); //Proves equals method works for for equal points of same x
    assertEquals(true, ePointy.equals(ePointy1)); //Proves equals method works for for equal points of same y
    assertEquals(true, ePointxy.equals(ePointxy1)); //Proves equals method works for for equal points of same x,y
    assertEquals(false, ePointxy.equals(notE)); //Proves equals method works for non-equals points 
    //Point2D.equals(Point2D) works for all possible parameters
    
    Point2D ePointo2D = new Point2D(2.0,-3.0);
    Point ePointo = new Point(2.0,-3.0);
    //assertEquals(true, ePointo2D.equals(ePointo)); 
    //*NOTE Point2D.equals(Point) does not work, will need to typecast Point to Point2D in method
    
    /**Testing distance method*/
    Point2D startPointx = new Point2D(0.0,0.0);
    Point2D endPointx = new Point2D(8.0,0.0); //distance should be 8
    Point2D startPointy = new Point2D(0.0,-2.0);
    Point2D endPointy = new Point2D(0.0,3.0); //distance should be 5
    Point2D startPointxy = new Point2D(2.0,-4.0);
    Point2D endPointxy = new Point2D(10.0,4.0); //Distance should be 11.3137 (Plugged numbers in on a website)
    assertEquals(8.0, Point2D.distance(startPointx,endPointx), 0.1); //Proves equals works for x
    assertEquals(5.0, Point2D.distance(startPointy,endPointy), 0.1); //Proves equals works for y (with the inclusion of negative numbers)
    assertEquals(11.31, Point2D.distance(startPointxy,endPointxy), 0.1); //Proves equals works for xy
    //Point2D.distance(Point2D, Point2D) works for all possible parameters of Point2D
    //*NOTE Point2D.distance(Point, Point2D), or Point2D.distance(Point, Point), or Point2D.distance(Point2D, Point) does not work.  Will need to typecast Point to Point2D in method.
  }
  
  @Test
  public void testVector(){
    /**

unitVector
Takes no input and returns a new Vector that has the same direction as this Vector but with length 1.
sum
A static method that takes two input Vectors and returns a new Vector that is the sum of the input vectors. <5, 6, 2> + <3, 4, 7> = <5 + 3, 6 + 4, 2 + 7>
scale
A static method that takes a Vector and a double and returns a new Vector that is the result of multiplying each coordinate in the input Vector by the input double. */ 
    
    /**Testing constructors
      * Three @param constructor*/
    Vector oVector = new Vector(2.0,3.0,4.0);
    
    /**Parameterized constructor*/
    Vector direction = new Vector(3.0,3.0,3.0);
    double magnitude = direction.magnitude(); //so our Vector 
    Vector mdVector = new Vector(direction,magnitude);
    
    /*TA constructor that takes a Point values and creates a vector with the same coordinates as the point.*/
    //N/A
    
    /**Testing toString*/
    assertEquals("<2.0,3.0,4.0>", oVector.toString()); //Enclosed by <> because that's how vectors are represented
    assertEquals("<3.0,3.0,3.0>", mdVector.toString()); //Proves toString works for x,y,z
    
    /**Testing equals*/
    Vector mdVectorCopy = new Vector(3.0,3.0,3.0);
    assertEquals(true, mdVector.equals(mdVectorCopy)); //Proves equals works for equal vectors
    assertEquals(false, mdVector.equals(oVector)); //Proves equals works for non-equal vectors
    
    /**Testing magnitude*/
    assertEquals(5.38, oVector.magnitude(), 0.1); //Proves magnitude works for x,y,z (plugged in numbers in calculator to ensure accuracy) should be 5.3851648
    assertEquals(5.19, mdVector.magnitude(), 0.1); //Proves magnitude works for x,y,z (plugged in numbers in calculator to ensure accuracy) should be 5.3851648

    
  }
} 