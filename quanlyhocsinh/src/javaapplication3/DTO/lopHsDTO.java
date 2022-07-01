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

public class lopHsDTO {

    private String maLop;
    private String maNamHoc;
    private String tenNamHoc;

    public void setMaLop(String maLop) {
        this.maLop = maLop;
    }

    public String getMaLop() {
        return maLop;
    }

    public String getMaNamHoc() {
        return maNamHoc;
    }

    public lopHsDTO(String maLop, String maNamHoc, String tenNamHoc) {
        this.maLop = maLop;
        this.maNamHoc = maNamHoc;
        this.tenNamHoc = tenNamHoc;

    }

    public void setMaNamHoc(String maNamHoc) {
        this.maNamHoc = maNamHoc;
    }

    public void setTenNamHoc(String tenNamHoc) {
        this.tenNamHoc = tenNamHoc;
    }

    public String getTenNamHoc() {
        return tenNamHoc;
    }

    @Override
    public String toString() {
        return this.maNamHoc;
    }

}