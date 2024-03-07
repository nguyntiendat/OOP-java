import java.util.Scanner;
public class StandardizeString {
    private String string;
    public StandardizeString(String string){
        this.string = string;
    }
    public String[] standardize(String string){
        string = string.trim();
        String[] token = string.split("\\s+");
        for (int i = 0; i < token.length; i++) {
            if(Character.isLowerCase(token[i].charAt(0))){
                token[i] = Character.toUpperCase(token[i].charAt(0)) + token[i].substring(1) + " ";
            }
        }
        return token;
    }
    public void printToken(String[] token){
        for (String i: token){
            System.out.print(i);
        }
    }
    public static void main(String[] args){
        String[] standardString ;
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter string: ");
        String string = scan.nextLine();
        StandardizeString str = new StandardizeString(string);
        standardString = str.standardize(string);
        System.out.print("Standard string: ");
        str.printToken(standardString);
    }
}
