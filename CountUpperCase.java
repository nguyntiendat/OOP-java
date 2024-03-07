import java.util.Scanner;
public class CountUpperCase {
    private String string;
    private int count;
    public CountUpperCase(String string){
        this.string = string;
        count = 0;
    }
    public int countCharUC(){
        for (int i = 0; i < string.length(); i++){
            if (Character.isUpperCase(string.charAt(i))){
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter string: ");
        String string = scan.nextLine();
        CountUpperCase str = new CountUpperCase(string);
        int countUPC = str.countCharUC();

        System.out.println("Numbers of uppercase character: " + countUPC);
    }
}
