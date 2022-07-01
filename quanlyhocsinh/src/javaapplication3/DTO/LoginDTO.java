/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication3.DTO;

/**
 *
 * @author azu
 */
public class LoginDTO {
    private String loainguoidung;
    private String taikhoan;
    private String matkhau;
    
    public LoginDTO(){
        
    }
    public LoginDTO(String loainguoidung,String taikhoan, String matkhau){
        this.taikhoan = taikhoan;
        this.matkhau = matkhau;
        this.loainguoidung = loainguoidung;
    }

    public void setLoainguoidung(String loainguoidung) {
        this.loainguoidung = loainguoidung;
    }

    public void setTaikhoan(String taikhoan) {
        this.taikhoan = taikhoan;
    }

    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }

    public String getLoainguoidung() {
        return loainguoidung;
    }

    public String getTaikhoan() {
        return taikhoan;
    }

    public String getMatkhau() {
        return matkhau;
    }
    
}