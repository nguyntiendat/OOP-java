import java.util.Scanner;
public class QuadraticEquation {
    private int degree, x;
    private int[] a;
    public QuadraticEquation(){
        degree = 0;
        a = new int[0];
        x = 0;
        degree = 0;
    }
    public void setDegree(int n){
        this.degree = n;
    }
    public int getDegree(){
        return degree;
    }

    public void setX(int x){
        this.x = x;
    }
    public int getX(){
        return x;
    }
    public int[] Arr(int n){
        Scanner scanner = new Scanner(System.in);
        this.a = new int[n+1];
        for (int i = 0; i <= n; i++){
            System.out.print("Enter the coefficient(Hệ số): ");
            this.a[i] = scanner.nextInt();
        }
        return a;
    }
    public int Result(int n, int x, int[] a){
        int rlt = 0, j = n;
        for (int i = 0; i <= n; i++) {
            if (j >= 0) {
                rlt += a[i] * (int)(Math.pow(x, j--));
            }
        }
        return rlt;
    }

}
class Main_New {
    public static void main(String[] args){
        QuadraticEquation pt = new QuadraticEquation();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the degree: ");
        int degree = scanner.nextInt();
        pt.setDegree(degree);

        int[] array ;
        array = pt.Arr(pt.getDegree());
        System.out.print("Enter x: ");
        int x = scanner.nextInt();
        pt.setX(x);

        int kq = pt.Result(pt.getDegree(), pt.getX(), array);
        System.out.println("\nResult: "+kq);
    }
}
