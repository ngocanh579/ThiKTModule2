package service;

import model.TaiKhoanTietKiem;

import java.time.LocalDate;
import java.util.Scanner;

public class QlyTaiKhoanTietKiem {
    private Scanner sc = new Scanner(System.in);
    public TaiKhoanTietKiem them(int id){
        System.out.print("nhap ma tai khoan: ");
        String ma = sc.nextLine();
        System.out.print("nhap ten chu tai khoan: ");
        String ten = sc.nextLine();
        LocalDate ngayTao = LocalDate.now();
        double soTienGui;
        do{
            System.out.print("nhap so tien gui (lon hon 0): ");
            soTienGui = Double.parseDouble(sc.nextLine());
        }while(soTienGui<=0);
        LocalDate ngayGui = LocalDate.now();
        double laiSuat;
        do{
            System.out.print("nhap lai Suat (lon hon 0): ");
            laiSuat = Double.parseDouble(sc.nextLine());
        }while(laiSuat<=0);
        int kyHan;
        do {
            System.out.print("nhap ky han (theo thang): ");
            kyHan = Integer.parseInt(sc.nextLine());
        } while (kyHan <= 0);
        return new TaiKhoanTietKiem(id, ma, ten, ngayTao, soTienGui, ngayGui, laiSuat, kyHan);
    }
}
