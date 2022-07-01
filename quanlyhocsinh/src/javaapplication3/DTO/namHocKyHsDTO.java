/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication3.DTO;

/**
 *
 * @author phongdiep
 */
public class namHocKyHsDTO {
    private String maNamHoc;
    private String maHocKy;

    public namHocKyHsDTO(String maNamHoc, String maHocKy) {
        this.maNamHoc = maNamHoc;
        this.maHocKy = maHocKy;
    }

    public String getMaNamHoc() {
        return maNamHoc;
    }

    public String getMaHocKy() {
        return maHocKy;
    }

    public void setMaNamHoc(String maNamHoc) {
        this.maNamHoc = maNamHoc;
    }

    public void setMaHocKy(String maHocKy) {
        this.maHocKy = maHocKy;
    }

     @Override
    public String toString() {
        return getMaHocKy();
    }

}
