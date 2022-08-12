/** Tyler Youk: 3D Point Class */

import java.text.DecimalFormat;
public class Point {
  
  /**Instance variables*/
  private double x;
  private double y;
  private double z;
  
  /**Three @param constructor*/
  public Point(double x, double y, double z ) {
    this.x = x;
    this.y = y;
    this.z = z;}
  
   /**Two @param constructor: a Point that acts as Point2D*/
  public Point(double x, double y) {
    this.x = x;
    this.y = y;
    this.z = 0;}
  
  /**Getter methods*/
  public double getX(){return x;}
  public double getY(){return y;}
  public double getZ(){return z;}
  
  /**toString method*/
  @Override
  public String toString() {
    return "(" + x + "," + y + "," + z + ")";}
  
  /**equals method*/
  @Override
  public boolean equals(Object obj) {
    if (obj == null) {return false;}
    if (getClass() != obj.getClass()) {return false;}
    final Point other = (Point) obj;
    if (Double.doubleToLongBits(this.x) != Double.doubleToLongBits(other.x)) {
      return false;}
    if (Double.doubleToLongBits(this.y) != Double.doubleToLongBits(other.y)) {
      return false;}
    if (Double.doubleToLongBits(this.z) != Double.doubleToLongBits(other.z)) {
      return false;}
    return true;}
  
  /**distance method*/
  public static double distance(Point point1,Point point2){
    double distance;
    distance = Math.sqrt(Math.pow((point2.x - point1.x),2) + Math.pow((point2.y - point1.y),2) + Math.pow((point2.z - point1.z),2));
    return distance;}
}
