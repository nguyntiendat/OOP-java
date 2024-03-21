public class Circle {
    private Diem centrePoint;
    private double radius;
    public Circle(Diem centerPoint, double radius){
        this.centrePoint = centerPoint;
        this.radius = radius;
    }
    public void setCentrePoint(Diem centrePoint) {
        this.centrePoint = centrePoint;
    }
    public Diem getCentrePoint(){
        return centrePoint;
    }
    public void setRadius(double radius){
        this.radius = radius;
    }
    public double getRadius(){
        return radius;
    }
    public double circleArea(){
        return 3.14*radius*radius;
    }
    public double circlePerimeter(){
        return  3.14*2*radius;
    }
    public void findRelativePosPoint(Diem M){
        double OM = centrePoint.distance(M);
        if (OM > radius){
            System.out.println("Point " + M.getPoint() + " is outside the circle");
        }
        else if (OM < radius){
            System.out.println("Point " + M.getPoint() + " is inside the circle");
        }
        else {
            System.out.println("Point " + M.getPoint() + " is on the circle");
        }
    }
    public void findRelativePosCircle(Circle other){
        double disCentre = centrePoint.distance(other.centrePoint);
        double RR = radius + other.radius;
        double absRR = Math.abs(radius - other.radius);
        System.out.printf("DisCentre: %.2f, RR: %.2f, absRR: %.2f\n", disCentre, RR, absRR);
        if (disCentre > RR){
            System.out.println("The two circles is do not intersect and outside each other)");
        } else if (disCentre == RR) {
            System.out.println("The two circles externally tangent to each other");
        } else if (disCentre < absRR) {
            System.out.println("The two circles do not intersect and overlap each other");
        } else if (disCentre == absRR) {
            System.out.println("The two circles are internally tangent to each other");
        }else {
            System.out.println("The two circles intersect at two distinct points");
        }
    }
    public static void main(String[] args){
        Diem centerPoint = new Diem('O', 3,2);
        Circle circle = new Circle(centerPoint, 4);
        System.out.println("Circle are: " + circle.circleArea());
        System.out.println("Circle parameter: " + circle.circlePerimeter());
        Diem point = new Diem('M', 6,2);
        circle.findRelativePosPoint(point);

        Diem centerPoint2 = new Diem('C', 9, 5);
        Circle circle2 = new Circle(centerPoint2, 5);
        circle.findRelativePosCircle(circle2);
    }
}
