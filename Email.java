import java.util.Scanner;
public class Email {
    private final String email;
    public Email(String email) {
        this.email = email;
    }
    public String getEmail(){
        return email;
    }
    public String getName(String email){
        String name = "";
        for (int i = 0; i < email.length(); i++) {
            if (email.charAt(i) != '@') {
                name += email.charAt(i);
            }
            else {
                break;
            }
        }
        return name;
    }
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter your email: ");
        String email = scan.nextLine();
        Email emailName = new Email(email);
        String name;
        name = emailName.getName(emailName.getEmail());
        System.out.println(name);
    }
}
