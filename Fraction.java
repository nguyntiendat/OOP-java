import java.util.Scanner;

public class Fraction {
    private int numerator; // Tu so
    private int denominator; // Mau so
    private static int numberFractions = 0;

    public Fraction(){
        numerator = 0;
        denominator = 1;
        numberFractions++;
    }

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        if (denominator != 0){
            this.denominator = denominator;
        }
        else {
            throw new IllegalArgumentException("Illegal denominator!");
        }
        numberFractions++;
    }
    public void setNumerator(int numerator){
        this.numerator = numerator;
    }
    public int getNumerator(){
        return numerator;
    }
    public void setDenominator(int denominator){
        this.denominator = denominator;
    }
    public int getDenominator(){
        return denominator;
    }
    public static int getNumberFractions(){
        return numberFractions;
    }
    public static int findGreatestCommonDivisor(int a, int b){
        while (b != 0){
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    public Fraction shortenFractions(){
        int greatestCommonDivisor = findGreatestCommonDivisor(numerator,denominator);
        numerator = numerator/greatestCommonDivisor;
        denominator = denominator/greatestCommonDivisor;
        return this;
    }
    public Fraction plusFraction(Fraction fraction){
        int newNumerator = (numerator*fraction.denominator) + (fraction.numerator*denominator);
        int newDenominator = denominator * fraction.denominator;
        return new Fraction(newNumerator, newDenominator).shortenFractions();
    }
    public Fraction minusFraction(Fraction fraction){
        int newNumerator = (numerator*fraction.denominator) - (fraction.numerator*denominator);
        int newDenominator = denominator * fraction.denominator;
        return new Fraction(newNumerator, newDenominator).shortenFractions();
    }
    public Fraction timesFraction(Fraction fraction){
        int newNumerator = numerator * fraction.numerator;
        int newDenominator = denominator * fraction.denominator;
        return new Fraction(newNumerator, newDenominator).shortenFractions();
    }
    public Fraction deviceFraction(Fraction fraction){
        int newNumerator = numerator * fraction.denominator;
        int newDenominator = denominator * fraction.numerator;
        return new Fraction(newNumerator, newDenominator).shortenFractions();
    }
    public int compareFraction(Fraction fraction){
        int newNumerator1 = numerator;
        int newNumerator2 = fraction.numerator;
        if(denominator!=fraction.denominator){
            newNumerator1 = numerator*fraction.denominator;
            newNumerator2 = fraction.numerator*denominator;
        }
        if(newNumerator1 > newNumerator2){
            return 1;
            //System.out.printf("%d/%d bigger than %d/%d", numerator,denominator, fraction.numerator, fraction.denominator);
        } else if (newNumerator1 < newNumerator2) {
            return 2;
            //System.out.printf("%d/%d smaller than %d/%d", numerator,denominator, fraction.numerator, fraction.denominator);
        } else {
            return 0;
            //System.out.printf("%d/%d equals %d/%d", numerator,denominator, fraction.numerator, fraction.denominator);
        }
    }
    public static void scanArrayFraction(Fraction[] arrFraction, int num){
        Scanner scan = new Scanner(System.in);
        int numerator, denominator;
        for (int i = 0; i < num; i++) {
            System.out.printf("Enter fraction %d: ", i+1);
            numerator = scan.nextInt();
            denominator = scan.nextInt();
            arrFraction[i] = new Fraction(numerator, denominator);
        }
    }
    public static void printArrayFraction(Fraction[] arrFraction){
        for (Fraction fraction : arrFraction) {
            System.out.print("  " + fraction.getNumerator() + "/" + fraction.getDenominator());
        }
    }
    public static void sumArrayFraction(Fraction[] arrFraction){
        Fraction sumFraction = new Fraction();
        for (Fraction fraction : arrFraction) {
            sumFraction = sumFraction.plusFraction(fraction);
        }
        System.out.printf("\nSum of fractions: %d/%d", sumFraction.getNumerator(), sumFraction.getDenominator());
    }
    public static void maxFraction(Fraction[] arrFraction){
        Fraction fractionMax = new Fraction();
        for (Fraction fraction : arrFraction) {
            if (fractionMax.compareFraction(fraction) == 2) {
                fractionMax = fraction;
            }
        }
        System.out.printf("\nThe biggest fraction: %d/%d", fractionMax.getNumerator(), fractionMax.getDenominator());
    }

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter number of fractions: ");
        int num = scan.nextInt();
        // scan arr
        Fraction[] arrFraction = new Fraction[num];
        scanArrayFraction(arrFraction, num);
        // print arr
        printArrayFraction(arrFraction);
        // sum arr
        sumArrayFraction(arrFraction);
        // max fraction
        maxFraction(arrFraction);
    }
}
