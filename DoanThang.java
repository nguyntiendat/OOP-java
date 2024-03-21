import java.util.Scanner;
public class DoanThang {
    private Diem x;
    private Diem y;
    public DoanThang(Diem x ,Diem y){
        this.x = x;
        this.y = y;
    }
    public void setX(Diem x){
        this.x = x;
    }
    public Diem getX(){
        return x;
    }
    public void setY(Diem y){
        this.y = y;
    }
    public Diem getY(){
        return y;
    }
    public void printStraight(Diem x, Diem y){
        System.out.printf("Line segment %c%c [(%.1f, %.1f),(%.1f, %.1f)]", x.getPoint(), y.getPoint(), x.getAbscissa(), x.getOrdinate(), y.getAbscissa(), y.getOrdinate());
    }
    public double distanceLineSegment(Diem A, Diem B){
        return Math.sqrt(Math.pow((A.getAbscissa() - B.getAbscissa()), 2) + Math.pow((A.getOrdinate() - B.getOrdinate()), 2));
    }
    public Diem midPoint(Diem A, Diem B){
        char Mid = 'C';
        Diem midPoint;
        return midPoint = new Diem(Mid, (A.getAbscissa() + B.getAbscissa())/2, (A.getOrdinate() + B.getOrdinate())/2);
    }
    public static boolean parallel(DoanThang l1, DoanThang l2){
        double a = (l1.x.getAbscissa() - l1.y.getAbscissa())/(l1.x.getOrdinate() - l1.y.getOrdinate());
        double b = (l2.x.getAbscissa() - l2.y.getAbscissa())/(l2.x.getOrdinate() - l2.y.getOrdinate());
        if(a == b){
            return true;
        }
        else {
            return false;
        }
    }

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        //System.out.print("Enter head point information:"); char point = scan.next().charAt(0); double x = scan.nextDouble(); double y = scan.nextDouble();
        //System.out.print("Enter last point information:"); char point1 = scan.next().charAt(0); double x1 = scan.nextDouble(); double y1 = scan.nextDouble();

        Diem A = new Diem('A',2,1);
        Diem B = new Diem('B',-4,9);
        DoanThang lineSegment = new DoanThang(A,B);

        lineSegment.printStraight(A,B);
        Diem MidPoint = lineSegment.midPoint(A, B);
        System.out.printf("\nLength of line segment %c%c is %.2f", A.getPoint(), B.getPoint(), lineSegment.distanceLineSegment(A, B));
        System.out.printf("\nMidpoint of the line segment %c%c is %c(%.2f, %.2f)", A.getPoint(), B.getPoint(), MidPoint.getPoint(), MidPoint.getAbscissa(), MidPoint.getOrdinate());
        //System.out.print("Enter head point information:"); char point3 = scan.next().charAt(0); double x3 = scan.nextDouble(); double y3 = scan.nextDouble();
        //System.out.print("Enter last point information:"); char point4 = scan.next().charAt(0); double x4 = scan.nextDouble(); double y4 = scan.nextDouble();

        Diem C = new Diem('C',2,-3);
        Diem D = new Diem('D',-4,5);
        DoanThang lineSegment1 = new DoanThang(C,D);

        if(parallel(lineSegment, lineSegment1)){
            System.out.println("\nYes");
        }
        else{
            System.out.println("\nNo");
        }
    }
}
