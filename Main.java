//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        SanPham sp1 = new SanPham("iPhone 7 Plus");
        SanPham sp2 = new SanPham("iPhone 14 Pro", 23.0);
        sp1.show();
        sp2.show();
        System.out.println("->Tổng SP: " + SanPham.getDem());
    }
}