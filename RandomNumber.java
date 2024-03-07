import java.util.Scanner;
public class RandomNumber {
    private final double randomNum;
    private int num;
    private static final int MAX = 100;
    public RandomNumber(){
        randomNum = (int) (Math.random()*MAX) +1;
    }
    public void Scan(){
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter a number: ");
        this.num = scan.nextInt();
    }
    public boolean check(int number){
        if(randomNum > number){
            System.out.println("Your number is smaller");
            return false;
        }
        else if(randomNum < number){
            System.out.println("Your number is bigger");
            return false;
        }
        else{
            System.out.println("Your number is correct");
            return true;
        }
    }
    public int getNum(){
        return num;
    }
    public static void main(String[] args){
        RandomNumber ranNumber = new RandomNumber();
        ranNumber.Scan();
        while (!ranNumber.check(ranNumber.getNum())){
            ranNumber.Scan();
        }
    }
}
