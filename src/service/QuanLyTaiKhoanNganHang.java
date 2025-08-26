package service;

import de.vandermeer.asciitable.AsciiTable;
import model.TaiKhoanNganHang;
import model.TaiKhoanThanhToan;
import model.TaiKhoanTietKiem;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuanLyTaiKhoanNganHang {
    Scanner sc = new Scanner(System.in);
    List<TaiKhoanNganHang> dsNganHang = new ArrayList<>();
    private docGhiFileNganHang docGhi;

    //hien thi sanh sach
    public void hienThiDanhSach(){
        if(dsNganHang.isEmpty()){
            System.out.println("danh sach rong");
            return;
        }
        AsciiTable table = new AsciiTable();
        table.addRule();
        table.addRow("ID","Ma Tai Khoan","Ten Chu TK","Ngay Tao","So Tien Gui","Ngay Gui","Lai Suat",
                "Ky Han","So The","So Tien Trong Tai Khoan");
        table.addRule();

        for(TaiKhoanNganHang tk : dsNganHang){
            String soTienGui = "", ngayGui = "", laiSuat = "", kyHan = "";
            String soThe = "", soTienTrongTK = "";
            if(tk instanceof TaiKhoanTietKiem){
                TaiKhoanTietKiem tkTK = (TaiKhoanTietKiem)tk;
                soTienGui = String.valueOf(tkTK.getSoTienGui());
                ngayGui = String.valueOf(tkTK.getNgayGui());
                laiSuat = String.valueOf(tkTK.getLaiSuat());
                kyHan = String.valueOf(tkTK.getKyHan());
            }else if(tk instanceof TaiKhoanThanhToan){
                TaiKhoanThanhToan ttTK = (TaiKhoanThanhToan)tk;
                soThe = ttTK.getSoThe();
                soTienTrongTK = String.valueOf(ttTK.getSoTienTrongTaiKhoan());
            }
            table.addRow(tk.getId(), tk.getMaTaiKhoan(), tk.getTenTaiKhoan(), tk.getNgayTao(),
                    soTienGui, ngayGui, laiSuat, kyHan,
                    soThe, soTienTrongTK);
            table.addRule();
        }
        System.out.println(table.render());
    }
    // doc file
    public QuanLyTaiKhoanNganHang() {
        docGhi = new docGhiFileNganHang();
        dsNganHang= docGhi.docFile();
    }

    //ghi file
    public void ghiFile (){
        docGhi.ghiFile(dsNganHang);
    }

    // lay ID tiep theo
    public int layIDTiep(){
        if(dsNganHang.isEmpty()){
            return 1;
        }else{
            return dsNganHang.get(dsNganHang.size()-1).getId();
        }
    }

    //them moi
    public void themTaiKhoan(){
        System.out.println("chon loai tai khoan ngan hang: ");
        System.out.println("1. Tai khoan tiet kiem");
        System.out.println("2. Tai khoan thanh toan");
        System.out.print("nhap lua chon: ");
        String chon = sc.nextLine();
        int id =  layIDTiep();
        if(chon.equals("1")){
            QlyTaiKhoanTietKiem tietKiemList = new QlyTaiKhoanTietKiem();
            TaiKhoanTietKiem tk = tietKiemList.them(id);
            dsNganHang.add(tk);
            ghiFile();
            System.out.println("Da them tai khoan tiet kiem thanh cong");
        }
        else if(chon.equals("2")){
            QlyTaiKhoanThanhToan thanhToan = new QlyTaiKhoanThanhToan();
            TaiKhoanThanhToan tt = thanhToan.them(id);
            dsNganHang.add(tt);
            ghiFile();
            System.out.println("Da them tai khoan thanh toan cong");
        }
        else {
            System.out.println("lua chon khong hop le");
        }
    }

    // xoa tai khoan
    public void xoaTaiKhoan(){
        System.out.print("nhap ma tai khoan muon xoa: ");
        String ma = sc.nextLine();

        TaiKhoanNganHang taiKhoanXoa = null;
        for(TaiKhoanNganHang tk : dsNganHang) {
            if (tk.getMaTaiKhoan().equalsIgnoreCase(ma)) {
                taiKhoanXoa = tk;
                break;
            }
        }
        if(taiKhoanXoa == null){
            System.out.println("tai khoan can xoa khong ton tai");
            return;
        }

        System.out.print("ban co muon xoa tai khoan (yes/no): ");
        String chon = sc.nextLine();
        if(chon.equalsIgnoreCase("y")){
            dsNganHang.remove(taiKhoanXoa);
            ghiFile();
            System.out.println("Xoa thanh cong");
            hienThiDanhSach();
        }
        else {
            System.out.println("Huy thao tac");
        }
    }

    // tim kiem tai khoan gan dung
    public void timKiem() {
        System.out.print("Nhap tu khoa can tim kiem (Ma / Ten): ");
        String tuKhoa = sc.nextLine().toLowerCase();
        List<TaiKhoanNganHang> ketQua = new ArrayList<>();
        for (TaiKhoanNganHang tk : dsNganHang) {
            if (tk.getMaTaiKhoan().toLowerCase().contains(tuKhoa) ||
                    tk.getTenTaiKhoan().toLowerCase().contains(tuKhoa)) {
                ketQua.add(tk);
            }
        }
        if (ketQua.isEmpty()) {
            System.out.println("Khong tim thay tai khoan can tim");
            return;
        }
        AsciiTable table = new AsciiTable();
        table.addRule();
        table.addRow("ID","Ma TK","Ten Chu TK","Ngay Tao","So Tien Gui","Ngay Gui","Lai Suat","Ky Han","So The","So Tien TK");
        table.addRule();
        for (TaiKhoanNganHang tk : ketQua) {
            String soTienGui = "", ngayGui = "", laiSuat = "", kyHan = "", soThe = "", soTienTK = "";
            if (tk instanceof TaiKhoanTietKiem) {
                TaiKhoanTietKiem tkTK = (TaiKhoanTietKiem) tk;
                soTienGui = String.valueOf(tkTK.getSoTienGui());
                ngayGui = tkTK.getNgayGui().toString();
                laiSuat = String.valueOf(tkTK.getLaiSuat());
                kyHan = String.valueOf(tkTK.getKyHan());
            } else if (tk instanceof TaiKhoanThanhToan) {
                TaiKhoanThanhToan ttTK = (TaiKhoanThanhToan) tk;
                soThe = ttTK.getSoThe();
                soTienTK = String.valueOf(ttTK.getSoTienTrongTaiKhoan());
            }
            table.addRow(tk.getId(), tk.getMaTaiKhoan(), tk.getTenTaiKhoan(), tk.getNgayTao(),
                    soTienGui, ngayGui, laiSuat, kyHan, soThe, soTienTK);
            table.addRule();
        }
        System.out.println(table.render());
    }


}
