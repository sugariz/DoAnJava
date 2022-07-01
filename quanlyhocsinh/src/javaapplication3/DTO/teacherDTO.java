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
public class teacherDTO {
    
    private String MAGV;
    private String hoten;
    private String diachi;
    private String sđt;

    public teacherDTO(){
        
    }

    public String getMAGV() {
        return MAGV;
    }

    public String getHoTen() {
        return hoten;
    }

    public String getDiachi() {
        return diachi;
    }


    public String getSđt() {
        return sđt;
    }

    
    public void setMAGV(String MAGV) {
        this.MAGV = MAGV;
    }

    public void setHoTen(String hoten) {
        this.hoten = hoten;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }


    public void setSđt(String sđt) {
        this.sđt = sđt;
    }
    public teacherDTO(String MAGV, String hoten, String diachi, String sđt) {
        this.MAGV = MAGV;
        this.hoten = hoten;
        this.diachi = diachi;
        this.sđt = sđt;
    }
}