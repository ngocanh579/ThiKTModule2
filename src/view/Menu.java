package view;

import service.QuanLyTaiKhoanNganHang;

import java.util.Scanner;

public class Menu {
    private Scanner sc = new Scanner(System.in);
    QuanLyTaiKhoanNganHang nganHang = new QuanLyTaiKhoanNganHang();
    public void menu(){
        int chon;
        do {
            System.out.println("---------------------Quản Lý Tài Khoản Ngân Hàng --------------------");
            System.out.println("1. Thêm mới");
            System.out.println("2. Xóa ");
            System.out.println("3. Xem danh sách các tài khoản ngân hàng ");
            System.out.println("4. Tìm kiếm ");
            System.out.println("5. Thoát");
            System.out.print("Lựa chọn chức năng : ");
            chon = sc.nextInt();
            sc.nextLine();

            switch (chon) {
                case 1:
                    nganHang.themTaiKhoan();
                    break;
                case 2:
                    nganHang.xoaTaiKhoan();
                    break;
                case 3:
                    nganHang.hienThiDanhSach();
                    break;
                case 4:
                    nganHang.timKiem();
                    break;
                case 5:
                    System.out.println("Thoát chương trình");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ");
            }
        } while (chon != 5);
    }
}
