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

public class thoiKhoaBieuGiaoVienDTO {
    
    private String maLop;
    private String tenLop;
    private String maThu;
    private String maTiet;
    private String maHocKy;
    private String maNamHoc;
    private String tenMonHoc;

    public thoiKhoaBieuGiaoVienDTO(String maLop, String tenLop, String maThu, String maTiet, String tenMonHoc,String maHocKy, String maNamHoc) {
        this.maLop = maLop;
        this.tenLop = tenLop;
        this.maThu = maThu;
        this.maTiet = maTiet;
        this.tenMonHoc = tenMonHoc;
        this.maHocKy = maHocKy;
        this.maNamHoc = maNamHoc;
        
       
    }

    public void setMaLop(String maLop) {
        this.maLop = maLop;
    }

    public String getMaLop() {
        return maLop;
    }
    public String getTenLop() {
        return tenLop;
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

    public void setTenLop(String tenLop) {
        this.tenLop = tenLop;
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