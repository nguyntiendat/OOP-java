import java.beans.FeatureDescriptor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Collection;
public class FractionList {
    private ArrayList<Fraction> fractionList;
    public FractionList(){
        fractionList = new ArrayList<>();
    }
    public ArrayList<Fraction> getFractionList(){
        return fractionList;
    }
    public void inputAddFractionList(int num){
        Scanner scan = new Scanner(System.in);
        int numerator, denominator;
        for (int i = 0; i < num; i++) {
            System.out.printf("Enter fraction %d: ", i+1);
            numerator = scan.nextInt();
            denominator = scan.nextInt();
            fractionList.add(new Fraction(numerator, denominator));
        }
    }
    public void addFraction(int numerator, int denominator){
        fractionList.add(new Fraction(numerator, denominator));
    }
    public void printList(){
        System.out.println("Fractions list: ");
        for(Fraction fraction : fractionList){
            System.out.print("  " + fraction.getNumerator() + "/" + fraction.getDenominator());
        }
    }
    public Fraction findFraction(Fraction fraction){
        for (Fraction f : fractionList){
            if(f.getNumerator() == fraction.getNumerator() && f.getDenominator() == fraction.getDenominator()){
                return f;
            }
        }
        return null;
    }
    public void removeFraction(Fraction fraction){
        if(fraction != null) {
            fractionList.remove(fraction);
        }
        else{
            System.out.println("Could not find the fraction to remove from list!");
        }
    }
    public void removeFraction(int numerator, int denominator){
        Fraction fractionRemove = null;
        for(Fraction fraction : fractionList){
            if(fraction.getNumerator() == numerator && fraction.getDenominator() == denominator){
                fractionRemove = fraction;
                break;
            }
        }
        if(fractionRemove != null){
            fractionList.remove(fractionRemove);
        }else{
            System.out.println("Could not find the fraction to remove from list!");
        }
    }
    public void sumFraction(){
        Fraction sumFraction = new Fraction();
        for (Fraction fraction : fractionList) {
            sumFraction = sumFraction.plusFraction(fraction);
        }
        sumFraction = sumFraction.shortenFractions();
        System.out.printf("\nSum of fractions: %d/%d", sumFraction.getNumerator(), sumFraction.getDenominator());
    }
    public void fractionMinMax(){
        Fraction fractionMax = fractionList.getFirst();
        Fraction fractionMin = fractionList.getFirst();
        for (Fraction fraction : fractionList){
            if(fractionMax.compareFraction(fraction) == 2){
                fractionMax = fraction;
            }
            if(fractionMin.compareFraction(fraction) == 1){
                fractionMin = fraction;
            }
        }
        System.out.printf("\nMax fractions: %d/%d", fractionMax.getNumerator(), fractionMax.getDenominator());
        System.out.printf("\nMin fractions: %d/%d\n", fractionMin.getNumerator(), fractionMin.getDenominator());
    }
    public void sortList(){
        for(int i = 0; i < fractionList.size() - 1; i++){
            for (int j = i+1; j < fractionList.size(); j++){
                if (fractionList.get(i).compareFraction(fractionList.get(j)) == 1){
                    Fraction temp = fractionList.get(i);
                    fractionList.set(i, fractionList.get(j));
                    fractionList.set(j, temp);
                }
            }
        }
    }

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        //System.out.println("Enter number of fractions: ");
        //int num = scan.nextInt();

        FractionList fractionList = new FractionList();
        //input
        //fractionList.inputAddFractionList(num);
        //print
        fractionList.addFraction(1,3);
        fractionList.addFraction(2,9);
        fractionList.addFraction(6,11);
        fractionList.addFraction(7,8);
        fractionList.addFraction(2,7);

        fractionList.printList();
        System.out.println("\nRemove fraction");
        System.out.print("Enter numerator and denominator: ");
        int numerator = scan.nextInt();
        int denominator = scan.nextInt();

        Fraction fraction = new Fraction(numerator,denominator);
        Fraction tempFraction = fractionList.findFraction(fraction);
        fractionList.removeFraction(tempFraction);

        //fractionList.removeFraction(numerator,denominator);
        fractionList.printList();
        fractionList.sumFraction();
        fractionList.fractionMinMax();
        fractionList.sortList();
        System.out.println("After sort");
        fractionList.printList();
    }
}
