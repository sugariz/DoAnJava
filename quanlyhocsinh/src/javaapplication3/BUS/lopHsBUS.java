/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication3.BUS;

import javaapplication3.DAO.lopHsDAO;
import javaapplication3.DTO.lopHsDTO;
import java.util.ArrayList;
/**
 *
 * @author phongdiep
 */
public class lopHsBUS {
    public static ArrayList<lopHsDTO> listLop = null;
    
    public lopHsBUS(){}
    
    public String[] getNamLop(String maLop){
        this.build(maLop);
        String[] stringLop = new String[listLop.size()];
        int index = 0;
        for(lopHsDTO lop: listLop){
            stringLop[index] = lop.getMaNamHoc();
            index++;
        }
        return stringLop;
    }
    
    public String[] getTenNamLop(String maLop){
        this.build(maLop);
        String[] stringLop = new String[listLop.size()];
        int index = 0;
        for(lopHsDTO lop: listLop){
            stringLop[index] = lop.getTenNamHoc();
            index++;
        }
        return stringLop;
    }
    public void build(String maLop){
        if(listLop ==null)
            listLop = new lopHsDAO().getNamLop(maLop);
    }
    
    public static void main(String[] args){
        lopHsBUS hello = new lopHsBUS();
        String[] nam = hello.getTenNamLop("LOP1011920");
        for(String i : nam)
            System.out.println(i);
        
    }
}
