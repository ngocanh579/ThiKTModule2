package service;

import model.TaiKhoanNganHang;
import model.TaiKhoanThanhToan;
import model.TaiKhoanTietKiem;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class docGhiFileNganHang {
    private File file;

    public docGhiFileNganHang() {
        this.file = new File("database/nganhang.csv");

    }

    public void ghiFile(List<TaiKhoanNganHang> list) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {

            bw.write("id,maTaiKhoan,tenTaiKhoan,ngayTao,soTienGui,ngayGui,laiSuat,kyHan,soThe,soTien");
            bw.newLine();

            for (TaiKhoanNganHang tk : list) {
                bw.write(tk.hienThiThongTin());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Lỗi ghi file: " + e.getMessage());
        }
    }
    public List<TaiKhoanNganHang> docFile() {
        List<TaiKhoanNganHang> danhSach = new ArrayList<>();
        if (!file.exists()) {
            System.out.println("File chưa có, sẽ tạo mới khi thêm tài khoản.");
            return danhSach;
        }
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            boolean dongDauTien = true;
            while ((line = br.readLine()) != null) {
                if (dongDauTien) {
                    dongDauTien = false;
                    continue;
                }
                String[] str = line.split(",");
                if (str.length == 8) {
                   //tai khoan tiet kiem
                    int id = Integer.parseInt(str[0].trim());
                    String ma = str[1].trim();
                    String ten = str[2].trim();
                    LocalDate ngayTao = LocalDate.parse(str[3].trim());
                    double soTienGui = Double.parseDouble(str[4].trim());
                    LocalDate ngayGui = LocalDate.parse(str[5].trim());
                    double laiSuat = Double.parseDouble(str[6].trim());
                    int kyHan = Integer.parseInt(str[7].trim());

                    TaiKhoanTietKiem tk = new TaiKhoanTietKiem(id, ma, ten, ngayTao, soTienGui, ngayGui, laiSuat, kyHan);
                    danhSach.add(tk);

                } else if (str.length == 6) {
                   //tai khoan thanh toan
                    int id = Integer.parseInt(str[0].trim());
                    String ma = str[1].trim();
                    String ten = str[2].trim();
                    LocalDate ngayTao = LocalDate.parse(str[3].trim());
                    String soThe = str[4].trim();
                    double soTien = Double.parseDouble(str[5].trim());

                    TaiKhoanThanhToan tk = new TaiKhoanThanhToan(id, ma, ten, ngayTao, soThe, soTien);
                    danhSach.add(tk);
                }
            }
        } catch (IOException e) {
            System.out.println("Loi doc file: " + e.getMessage());
        }

        return danhSach;
    }
    }

