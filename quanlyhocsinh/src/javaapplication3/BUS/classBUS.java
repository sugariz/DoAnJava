/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication3.BUS;

import java.util.ArrayList;
import javaapplication3.DAO.classDAO;
import javaapplication3.DTO.classDTO;

/**
 *
 * @author azu
 */
public class classBUS {
    
    public static ArrayList<classDTO> listLop = null;
    
    public classBUS() {}
    
    public String[] getLop() {
        this.build();
        
        String[] stringLop = new String[listLop.size()];
        int index = 0;
        for(classDTO lop : listLop) {
            stringLop[index] = lop.getTenLop();
            index += 1;
        }
        
        return stringLop;
    }
    
    public String[] getMaNamHoc() {
        this.build();
        
        String[] stringLop = new String[listLop.size()];
        int index = 0;
        for(classDTO lop : listLop) {
            stringLop[index] = lop.getMaNamHoc();
            index += 1;
        }
        
        return stringLop;
    }
    
    public ArrayList<classDTO> getListClass(String manamhoc, String makhoi) {
        ArrayList<classDTO> kq = new ArrayList<classDTO>();
        this.build();
        for(classDTO lop : listLop){
            if(lop.getMaNamHoc().equals(manamhoc) && lop.getMaKhoiLop().equals(makhoi)){
                kq.add(lop);
            }
        }

      return kq;
    }
    
    public ArrayList<Object[]> getListClass1(String manamhoc) {
        ArrayList<Object[]> kq = new ArrayList<Object[]>();
        this.build();
        for(classDTO lop : listLop){
            if(lop.getMaNamHoc().equals(manamhoc)){
                Object[] row = new Object[2];
                row[0] = lop.getMaKhoiLop();
                row[1] = lop.getTenLop();
                kq.add(row);
            }
        }

      return kq;
    }
    
    public void build() {
        if(listLop == null) {
            listLop = new classDAO().getLop();
        }
    }
    
}
