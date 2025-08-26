package model;
import java.time.LocalDate;

public class TaiKhoanTietKiem extends TaiKhoanNganHang {
    private double soTienGui;
    private LocalDate ngayGui;
    private double laiSuat;
    private int kyHan;

    public double getSoTienGui() {
        return soTienGui;
    }

    public void setSoTienGui(double soTienGui) {
        this.soTienGui = soTienGui;
    }

    public LocalDate getNgayGui() {
        return ngayGui;
    }

    public void setNgayGui(LocalDate ngayGui) {
        this.ngayGui = ngayGui;
    }

    public double getLaiSuat() {
        return laiSuat;
    }

    public void setLaiSuat(double laiSuat) {
        this.laiSuat = laiSuat;
    }

    public int getKyHan() {
        return kyHan;
    }

    public void setKyHan(int kyHan) {
        this.kyHan = kyHan;
    }

    public TaiKhoanTietKiem(int id, String maTaiKhoan, String tenTaiKhoan, LocalDate ngayTao, double soTienGui, LocalDate ngayGui, double laiSuat, int kyHan) {
        super(id,maTaiKhoan,tenTaiKhoan,ngayTao);
        this.soTienGui = soTienGui;
        this.ngayGui = ngayGui;
        this.laiSuat = laiSuat;
        this.kyHan = kyHan;
    }

    public TaiKhoanTietKiem(String maTaiKhoan, String tenTaiKhoan, LocalDate ngayTao, double soTienGui, LocalDate ngayGui, double laiSuat, int kyHan) {
        super(maTaiKhoan, tenTaiKhoan, ngayTao);
        this.soTienGui = soTienGui;
        this.ngayGui = ngayGui;
        this.laiSuat = laiSuat;
        this.kyHan = kyHan;
    }

    @Override
    public String hienThiThongTin() {
        return getId() + "," + getMaTaiKhoan() + "," + getTenTaiKhoan() + "," + getNgayTao() + "," +
                soTienGui + "," + ngayGui + "," + laiSuat + "," + kyHan;
    }
}
