import java.util.Scanner;

class PhanSo {
    int tuSo, mauSo;
    public void nhapPhanSo() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap tu so ");
        tuSo = sc.nextInt();
        do {
            System.out.print("Nhap mau so: ");
            mauSo = sc.nextInt();
            if (mauSo == 0) {
                System.out.println("Mau so phai khac 0, nhap lai:.");
            }
        } while (mauSo == 0);
    }

    public void hienThi() {
        System.out.println("Phan so: " + tuSo + "/" + mauSo);
    }

    public void hienThiTong() {
        System.out.println("Tong 2 phan so: " + tuSo + "/" + mauSo);
    }

    public void gianPhan() {
        int ucln = ucln(tuSo, mauSo);
        tuSo /= ucln;
        mauSo /= ucln;
    }

    private int ucln(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public int soSanh(PhanSo ps) {
        int tuSoMoi = this.tuSo * ps.mauSo;
        int mauSoMoi = this.mauSo * ps.tuSo;
        if (tuSoMoi < mauSoMoi) return -1;
        if (tuSoMoi == mauSoMoi) return 0;
        return 1;
    }

    public PhanSo cong(PhanSo ps) {
        PhanSo kq = new PhanSo();
        kq.tuSo = this.tuSo * ps.mauSo + ps.tuSo * this.mauSo;
        kq.mauSo = this.mauSo * ps.mauSo;
        kq.gianPhan();
        return kq;
    }

    public static void main(String[] args) {
        PhanSo ps1 = new PhanSo();
        PhanSo ps2 = new PhanSo();

        ps1.nhapPhanSo();
        ps2.nhapPhanSo();

        ps1.hienThi();
        ps2.hienThi();

        PhanSo kq = ps1.cong(ps2);
        kq.hienThiTong();

        int ketQuaSoSanh = ps1.soSanh(ps2);
        if (ketQuaSoSanh == -1) {
            System.out.println("Ps thu nhat nho hon ps thu hai.");
        } else if (ketQuaSoSanh == 0) {
            System.out.println("Hai ps bang nhau.");
        } else {
            System.out.println("Ps thu nhat lon hon ps thu hai.");
        }
    }
}
