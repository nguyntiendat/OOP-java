import java.util.Scanner;

public class Diem {
    private final char point;
    private double abscissa; // Hoanh do (x)
    private double ordinate; // Tung do (y)
    public Diem(char point, double abs, double ordi){
        this.point = point;
        abscissa = abs;
        ordinate = ordi;
    }
    public char getPoint(){
        return point;
    }
    public void setAbscissa(double abs){
        abscissa = abs;
    }
    public double getAbscissa(){
        return abscissa;
    }
    public void setOrdinate(double ordi){
        ordinate = ordi;
    }
    public double getOrdinate(){
        return ordinate;
    }
    public void printPoint(){
        System.out.printf("Point information: %c(%.2f, %.2f)", point, abscissa, ordinate);
    }
    public double distance(Diem B){
        return Math.sqrt(Math.pow((abscissa - B.abscissa), 2) + Math.pow((ordinate - B.ordinate), 2));
    }
//    public static void main(String[] args){
//        Scanner scan = new Scanner(System.in);
//        System.out.println("Enter A's information:");
//        char point = scan.next().charAt(0);
//        double x = scan.nextDouble();
//        double y = scan.nextDouble();
//        System.out.println("Enter B's information:");
//        char point1 = scan.next().charAt(0);
//        double x1 = scan.nextDouble();
//        double y1 = scan.nextDouble();
//        Diem A = new Diem(point,x,y);
//        Diem B = new Diem(point1,x1,y1);
//        A.printPoint();
//        B.printPoint();
//        System.out.printf("Distance between %c and %c: %.2f", A.point, B.point, distance(A,B));
//    }
}
