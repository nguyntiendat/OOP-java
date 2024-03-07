public class SanPham {
    private static int cnt = 0;
    private int maSP;
    private String tenSP;
    private double giaSP;
    private static int soLuong = 0;

    public SanPham(String tenSP, double giaSP) {
        this.maSP = ++cnt;
        this.tenSP = tenSP;
        this.giaSP = giaSP;
        this.soLuong++;
    }
    public SanPham(String tenSP) {
        this.maSP = ++cnt;
        this.tenSP = tenSP;
        this.giaSP = 0;
        this.soLuong++;
    }
    public static int getDem() {
        return soLuong;
    }
    public void show(){
        System.out.println("Mã sản phẩm: SP" + maSP);
        System.out.println("Tên sản phẩm: " + tenSP);
        if(giaSP != 0.0){
            System.out.println("Giá sản phẩm: " + giaSP);
        }
    }
}
