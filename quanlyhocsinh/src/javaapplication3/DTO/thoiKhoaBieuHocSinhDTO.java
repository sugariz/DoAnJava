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

public class thoiKhoaBieuHocSinhDTO {
    
    private String maLop;
    private String maThu;
    private String maTiet;
    private String maHocKy;
    private String maNamHoc;
    private String tenMonHoc;
    private String tenGv;
    
    public thoiKhoaBieuHocSinhDTO(String maLop, String maThu, String maTiet, String tenMonHoc,String maHocKy, String maNamHoc, String tenGv) {
        this.maLop = maLop;
        this.maThu = maThu;
        this.maTiet = maTiet;
        this.tenMonHoc = tenMonHoc;
        this.maHocKy = maHocKy;
        this.maNamHoc = maNamHoc;
        this.tenGv = shortName(tenGv);
    }

   
    public String getMaLop() {
        return maLop;
    }

    public String getMaThu() {
        return maThu;
    }

    public String getMaTiet() {
        return maTiet;
    }

    public String getTenMonHoc() {
        return tenMonHoc;
    }

    public String getMaHocKy() {
        return maHocKy;
    }

    public String getMaNamHoc() {
        return maNamHoc;
    }

    public void setMaLop(String maLop) {
        this.maLop = maLop;
    }

    public void setTenGv(String tenGv) {
        this.tenGv = tenGv;
    }

    public String getTenGv() {
        return tenGv;
        
    }
    public String shortName(String tenGiaoVien){
        String str = tenGiaoVien;
        String firstName = "";
        String lastName = "";
//        String[] two;
        if(str.split("\\w+").length>1){
            firstName = str.substring(str.lastIndexOf(" ")+1);
            lastName = str.substring(0,str.lastIndexOf(' '));
        }
        String one = "";
        for (int i = 0; i < lastName.length(); i++) {
            if (Character.isUpperCase(lastName.charAt(i))) {
                one +=Character.toString(lastName.charAt(i))+".";
            }
        }
        str = one + firstName;
 
        return str;
    }

    public void setMaThu(String maThu) {
        this.maThu = maThu;
    }

    public void setMaTiet(String maTiet) {
        this.maTiet = maTiet;
    }

    public void setTenMonHoc(String tenMonHoc) {
        this.tenMonHoc = tenMonHoc;
    }
    
    public void setMaHocKy(String maHocKy) {
        this.maHocKy = maHocKy;
    }

    public void setMaNamHoc(String maNamHoc) {
        this.maNamHoc = maNamHoc;
    }
    
    @Override
    public String toString() {
        return getTenMonHoc();
    }

}
