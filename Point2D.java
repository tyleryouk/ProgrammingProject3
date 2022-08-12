/** Tyler Youk: 2D Point Class */

public class Point2D {
  
  /**Instance variabeles */
  private double x;
  private double y;

  /**Two @param constructor */
  public Point2D(double x, double y) {
    this.x = x;
    this.y = y;}
  
  /*Getter methods*/
  public double getX(){return x;}
  public double getY(){return y;}
  
  /*toString method*/
  @Override
  public String toString() {
    return String.format("(%.1f,%.1f)", x,y);}
  
  /*equals method.*/
  @Override
  public boolean equals(Object obj){
    Point2D temp=(Point2D)obj;
    return x==temp.getX() &&
      y==temp.getY();}
  
  /*distance method*/
  public static double distance(Point2D p1, Point2D p2){
    double dis=0;
    dis=Math.sqrt(Math.pow(p1.getX()-p2.getX(), 2.0)
                    +Math.pow(p1.getY()-p2.getY(), 2.0));
    return dis;}
} 