/** Tyler Youk: Vector Class */

public class Vector {
  
  /**Instance Variables*/
  private double x;
  private double y;
  private double z;
  
  /**Three @param constructor*/
  Vector(double x, double y, double z){
    this.x = x;
    this.y = y;
    this.z = z;}
  
  /**A constructor that takes a Point values and creates a vector with the same coordinates as the point.*/
  //Vector(Point x){
  
  //}
  
  /**Parameterized constructor.*/
  Vector(Vector direction, double magnitude){
    double a = direction.x/direction.magnitude();
    double b = direction.y/direction.magnitude();
    double c = direction.z/direction.magnitude();
    this.x = a*magnitude;
    this.y = b*magnitude;
    this.z = c*magnitude;}
  
  /**toString() method*/
  @Override
  public String toString() {
    return "<" + x + "," + y + "," + z + ">";}

  /**equals method*/
  @Override
  public boolean equals(Object obj) {
    Vector ob = (Vector) obj;
    return this.x == ob.x && this.y == ob.y && this.z == ob.z;}

  /**magnitude method*/
  public double magnitude(){
    return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2) + Math.pow(z, 2));}
  
  /**unitVector method*/
  public Vector unitVector(){
    double a = this.x/this.magnitude();
    double b = this.y/this.magnitude();
    double c = this.z/this.magnitude();
    return new Vector(a,b,c); }//returns a unit vector in the direction of the called vector. 

  /**sum method*/
  public static Vector sum(Vector a, Vector b){
    if(a == null || b == null)
      return null;
    Vector ans = new Vector(a.x+b.x,a.y+b.y,a.z+b.z); //adds 2 vectors and returns the new added vector.
    return ans;}
  
  /**scale method*/
  public static Vector scale(Vector a, double val){
    double x = a.x * val;
    double y = a.y * val;
    double z = a.z * val; 
    return new Vector(x,y,z);} //returns a vector which is the scaled version of its parameter.
}