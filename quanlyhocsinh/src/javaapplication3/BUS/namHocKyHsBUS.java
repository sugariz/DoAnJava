/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication3.BUS;

import javaapplication3.DTO.namHocKyHsDTO;
import javaapplication3.DAO.namHocKyHsDAO;
import java.util.*;
import java.util.ListIterator;
import java.util.stream.Collectors;

/**
 *
 * @author phongdiep
 */
public class namHocKyHsBUS {

    public static ArrayList<namHocKyHsDTO> listNamHocKy = null;

    public namHocKyHsBUS() {
    }

    public ArrayList<Object> getNamHocKy(String maLop, String maNamHoc) {
        this.build(maLop);
        ArrayList<Object> namKy = new ArrayList<Object>();

        listNamHocKy
                .stream()
                .filter(obj -> {
                    try {
                        if (obj.getMaNamHoc().equals(maNamHoc)) {
//                                hello.set(Integer.parseInt(obj.getMaThu())-2, obj.getTenMonHoc());
//                                System.out.print(Integer.parseInt(obj.getMaThu())-2);
                                  namKy.add(obj.getMaHocKy());
//                                  namKy.add(obj.getMaNamHoc());
                            return true;
                        } else {
                            return false;
                        }
//                            System.out.println(obj.getTenMonHoc());

                    } catch (Exception e) {
                    }
                    return false;
                }).collect(Collectors.toList());

        return namKy;
    }

    public void build(String maLop) {
        if (listNamHocKy == null) {
            listNamHocKy = new namHocKyHsDAO().getThoiKhoaBieu(maLop);
        }

    }
     public static void main(String[] args) {
        namHocKyHsBUS cc = new namHocKyHsBUS();
        ArrayList<Object> zoo = new ArrayList<Object>();
        zoo = cc.getNamHocKy("LOP1011920", "NH1920");
        ListIterator<Object> iterator = zoo.listIterator();
        System.out.println("Các phần tử có trong list là: ");
        while (iterator.hasNext()) {
            System.out.println((Object) iterator.next());
        }

    }
}