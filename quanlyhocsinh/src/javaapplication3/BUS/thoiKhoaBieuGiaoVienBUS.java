/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication3.BUS;

import javaapplication3.DAO.thoiKhoaBieuGiaoVienDAO;
import javaapplication3.DTO.thoiKhoaBieuGiaoVienDTO;
//import java.awt.List;
import java.util.*;
//import java.util.ListIterator;
import java.util.stream.Collectors;

/**
 *
 * @author phongdiep
 */
public class thoiKhoaBieuGiaoVienBUS {

    public static ArrayList<thoiKhoaBieuGiaoVienDTO> listThoiKhoaBieu = null;

    public thoiKhoaBieuGiaoVienBUS() {
    }

    public ArrayList<ArrayList<Object>> getThoiKhoaBieuGiaoVien(String maGv, String maNamHoc, String maHocKy) {
//        get maGv thoikhoabieu from DAO
        this.build(maGv); 
        String[] arrayTiet = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        ArrayList<ArrayList<Object>> thoikhoabieu = new ArrayList<ArrayList<Object>>();

        for (String tiet : arrayTiet) {
//            tiet = arrayTiet[]
            ArrayList<Object> hello = new ArrayList<Object>();
            for (int i = 0; i < 8; i++) {
                hello.add("");
            }
            listThoiKhoaBieu
                    .stream()
                    .filter(obj -> {
                        try {
                            if (obj.getMaNamHoc().equals(maNamHoc) && obj.getMaHocKy().equals(maHocKy) && obj.getMaTiet().equals(tiet)) {
                                hello.set(Integer.parseInt(obj.getMaThu())-2,String.format("%s\n%s",obj.getTenMonHoc(),obj.getTenLop()));
                                return true;
                            } else {
                                return false;
                            }
                            
                            
                        } catch (Exception e) {
                        }
                        return false;
                    }).collect(Collectors.toList());

            hello.add(0, String.format("Tiết %s", tiet));
            thoikhoabieu.add(hello);
        }

        return thoikhoabieu;

    }

    public void build(String maGv) {
        if (listThoiKhoaBieu == null) {
            listThoiKhoaBieu = new thoiKhoaBieuGiaoVienDAO().getThoiKhoaBieu(maGv);
        }
    }

}