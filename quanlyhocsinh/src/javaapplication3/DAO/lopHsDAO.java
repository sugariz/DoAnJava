/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication3.DAO;

import java.sql.ResultSet;
import java.util.ArrayList;
import javaapplication3.DTO.lopHsDTO;
import java.util.*;
import javaapplication3.mySQLConnect;

/**
 *
 * @author azu
 */
public class lopHsDAO {

    private mySQLConnect connect;
    private ResultSet results;

    public lopHsDAO() {
//        connect = new mySQLConnect("den1.mysql4.gear.host", "quanlyhocsinh", "Ov53-TC4F82_", "quanlyhocsinh");
        connect = new mySQLConnect("localhost", "root", "", "QLHS");
    }

    public ArrayList<lopHsDTO> getNamLop(String maLop) {
        ArrayList<lopHsDTO> listLop = new ArrayList<lopHsDTO>();
        String query = "SELECT L.MALOP, NH.MANAMHOC, NH.TENNAMHOC FROM lop L, namhoc NH WHERE L.MANAMHOC=NH.MANAMHOC AND L.MALOP='"+maLop+"'";
        try {
            results = connect.executeQuery(query);
            while (results.next()) {
                lopHsDTO lop = new lopHsDTO(
                        results.getString(1),
                        results.getString(2),
                        results.getString(3)

                );
                listLop.add(lop);
            }
        } catch (Exception e) {
            System.err.println(e);
        }

        return listLop;
    }
    public static void main(String[] args){
        lopHsDAO hello = new lopHsDAO();
        ArrayList<lopHsDTO> zoo = new ArrayList<lopHsDTO>();
        zoo = hello.getNamLop("LOP1011920");
        ListIterator<lopHsDTO> iterator = zoo.listIterator();
        System.out.println("Các phần tử có trong list là: ");
        while (iterator.hasNext()) {
            System.out.println((lopHsDTO) iterator.next());
        }
    }

}