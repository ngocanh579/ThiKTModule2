package service;

import model.TaiKhoanThanhToan;

import java.time.LocalDate;
import java.util.Scanner;

public class QlyTaiKhoanThanhToan {
    private Scanner sc = new Scanner(System.in);
    public TaiKhoanThanhToan them(int id){
        System.out.print("nhap ma tai khoan: ");
        String ma = sc.nextLine();
        System.out.print("nhap ten chu tai khoan: ");
        String ten = sc.nextLine();
        LocalDate ngayTao = LocalDate.now();
        System.out.print("nhap so the: ");
        String soThe = sc.nextLine();
        double soTien;
        do {
            System.out.print("nhap so tien trong tai khoan (>0): ");
            soTien = Double.parseDouble(sc.nextLine());
        } while (soTien <= 0);

        return new TaiKhoanThanhToan(id, ma, ten, ngayTao, soThe, soTien);
    }
}
