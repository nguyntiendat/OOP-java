import java.util.Scanner;
public class CountWord {
    private String string;
    public CountWord(String string){
        this.string = string;
    }
    public int countWord(String string){
        String[] words = string.split("[\\s,;]");
        return words.length;
    }
    public String maxWord(String string){
        String[] words = string.split("[\\s,;.]");
        String max = words[0];
        for (String word : words) {
            if (word.length() > max.length()) {
                max = word;
            }
        }
        return max;
    }
    public static void main(String[] args){
        String maxWord = "";
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter string: ");
        String string = scan.nextLine();
        CountWord str = new CountWord(string);
        int numWords = str.countWord(string);
        maxWord = str.maxWord(string);
        System.out.println("Number of word: " + numWords);
        System.out.println("Longest word: " + maxWord);
    }
}
