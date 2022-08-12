/** Tyler Youk: 2D Line Class */

public class Line2D {
  
  /**Instance variables*/
  private Point2D p1;
  private Point2D p2;
  
  /*Two @param constructor*/
  public Line2D(Point2D p1, Point2D p2) {
    this.p1 = p1;
    this.p2 = p2; }
  
  /*toString method: in Slope-intercept form*/
  public String toString() {
    String interceptForm="";
    double m=0;
    double c=0;
    if((p1.getX()-p2.getX())==0) {
      interceptForm="undefined";}
    else {
      m=(p1.getY()-p2.getY())/(p1.getX()-p2.getX());
      c=p1.getY()-m*p1.getX();
      interceptForm=String.format("y=%.1fx + %.2f",m,c);}
    return interceptForm;}
  
  /*isParallel method*/
  public static boolean isParallel(Line2D line1, Line2D line2){
    double l1slope=0;
    double l2slope=0;
    l1slope=(line1.p1.getY()-line1.p2.getY())/(line1.p1.getX()-line1.p2.getX()); //slope of first line
    l2slope=(line2.p1.getY()-line2.p2.getY())/(line2.p1.getX()-line2.p2.getX()); //slope of second line
    return (l1slope==l2slope);} //returns true if the both lines having the same slope
  
  /*intersection method*/
  public static boolean intersection(Line2D line1, Line2D line2) {
    double l1slope=0.0;
    double l2slope=0.0;
    l1slope=(line1.p1.getY()-line1.p2.getY())/(line1.p1.getX()-line1.p2.getX());  //slope of first line
    l2slope=(line2.p1.getY()-line2.p2.getY())/(line2.p1.getX()-line2.p2.getX());  //slope of second line
    return (l1slope/l2slope==-1);} //returns true if the two slopes are reciprocals (2 and -2), also need to include if they are on the same path
  
  /*public static Point2D intersection(Line2D line1,Line2D line2){
double v1=((line1.getPoint1().getX()-line1.getPoint2().getX()))/((line1.getPoint1().getY()-line1.getPoint2().getY()));
double v2=((line2.getPoint1().getX()-line2.getPoint2().getX()))/((line2.getPoint1().getY()-line2.getPoint2().getY()));

double a1=line1.getPoint1().getX();
double b1=line1.getPoint1().getY();

double a2=line2.getPoint1().getX();
double b2=line2.getPoint1().getY();


double newy=((b1*v1-v2*b2)-(a1-a2))/(v1-v2);
double newx=((a1/v1-a2/v2)-(b1-b2))/(1/v1-1/v2);

return (new Point2D(newx,newy));
}*/

  
  /**equals method*/
  public boolean equals(Object obj) {
    Line2D temp=(Line2D)obj;
    return (p1.getX()==temp.p1.getX() && p1.getY()==temp.p1.getY()) &&
      (p2.getX()==temp.p2.getX() && p2.getY()==temp.p2.getY());}
  
  /**Extra methods*/
  public Point2D getP1(){return p1;}
  public Point2D getP2(){return p2;}
  
}
