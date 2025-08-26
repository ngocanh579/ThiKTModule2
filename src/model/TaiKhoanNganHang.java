package model;

import java.time.LocalDate;

public abstract class TaiKhoanNganHang {
    int dem=1;
    private int id;
    private String maTaiKhoan,tenTaiKhoan;
    private LocalDate ngayTao;

    public TaiKhoanNganHang( String maTaiKhoan, String tenTaiKhoan, LocalDate ngayTao) {
        this.id = dem++;
        this.maTaiKhoan = maTaiKhoan;
        this.tenTaiKhoan = tenTaiKhoan;
        this.ngayTao = ngayTao;
    }

    public TaiKhoanNganHang(int id, String maTaiKhoan, String tenTaiKhoan, LocalDate ngayTao) {
        this.id = id;
        this.maTaiKhoan = maTaiKhoan;
        this.tenTaiKhoan = tenTaiKhoan;
        this.ngayTao = ngayTao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMaTaiKhoan() {
        return maTaiKhoan;
    }

    public void setMaTaiKhoan(String maTaiKhoan) {
        this.maTaiKhoan = maTaiKhoan;
    }

    public String getTenTaiKhoan() {
        return tenTaiKhoan;
    }

    public void setTenTaiKhoan(String tenTaiKhoan) {
        this.tenTaiKhoan = tenTaiKhoan;
    }

    public LocalDate getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(LocalDate ngayTao) {
        this.ngayTao = ngayTao;
    }
    public abstract String hienThiThongTin();

}
