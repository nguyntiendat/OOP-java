public class HinhChuNhat {
    private Diem topLeft;
    private Diem botRight;
    public HinhChuNhat(Diem topLeft, Diem botRight){
        this.topLeft = topLeft;
        this.botRight = botRight;
    }
    public void setTopLeft(Diem topLeft){
        this.topLeft = topLeft;
    }
    public Diem getTopLeft(){
        return topLeft;
    }
    public void setBotRight(Diem botRight){
        this.botRight = botRight;
    }
    public Diem getBotRight(){
        return botRight;
    }
    public double Area(Diem topL, Diem botR){
        double length = Math.abs(topL.getAbscissa() - botR.getAbscissa());
        double width = Math.abs(topL.getOrdinate()- botR.getOrdinate());
        return length*width;
    }
    public double Perimeter(Diem topL, Diem botR){
        double length = Math.abs(topL.getAbscissa() - botR.getAbscissa());
        double width = Math.abs(topL.getOrdinate()- botR.getOrdinate());
        return 2*(length+width);
    }
    public void printInformation(){
        System.out.printf("Point top left: %c(%.2f, %.2f)", topLeft.getPoint(), topLeft.getAbscissa(), topLeft.getOrdinate());
        System.out.printf("\nPoint bottom right: %c(%.2f, %.2f)", botRight.getPoint(), botRight.getAbscissa(), botRight.getOrdinate());
        System.out.println("\nArea: " + Area(topLeft, botRight));
        System.out.println("Perimeter: " + Perimeter(topLeft, botRight));
    }
    public static void main(String[] args){
        Diem A = new Diem('A',-3,4);
        Diem B = new Diem('B',4,-1);
        HinhChuNhat hcn = new HinhChuNhat(A,B);
        hcn.printInformation();
    }
}
