package model;

import java.time.LocalDate;

public class TaiKhoanThanhToan extends TaiKhoanNganHang {
    private String soThe;
    private double soTienTrongTaiKhoan;

    public String getSoThe() {
        return soThe;
    }

    public void setSoThe(String soThe) {
        this.soThe = soThe;
    }

    public double getSoTienTrongTaiKhoan() {
        return soTienTrongTaiKhoan;
    }

    public void setSoTienTrongTaiKhoan(double soTienTrongTaiKhoan) {
        this.soTienTrongTaiKhoan = soTienTrongTaiKhoan;
    }

    public TaiKhoanThanhToan(String maTaiKhoan, String tenTaiKhoan, LocalDate ngayTao, String soThe, double soTienTrongTaiKhoan) {
        super(maTaiKhoan, tenTaiKhoan, ngayTao);
        this.soThe = soThe;
        this.soTienTrongTaiKhoan = soTienTrongTaiKhoan;
    }

    public TaiKhoanThanhToan(int id, String maTaiKhoan, String tenTaiKhoan, LocalDate ngayTao, String soThe, double soTienTrongTaiKhoan) {
        super(id, maTaiKhoan, tenTaiKhoan, ngayTao);
        this.soThe = soThe;
        this.soTienTrongTaiKhoan = soTienTrongTaiKhoan;
    }
    @Override
    public String hienThiThongTin() {
        return getId() + "," + getMaTaiKhoan() + "," + getTenTaiKhoan() + "," + getNgayTao() + "," +
                soThe + "," + soTienTrongTaiKhoan;
    }
}
