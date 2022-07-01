/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication3.DAO;

import javaapplication3.DTO.namHocKyHsDTO;
import java.util.*;
import java.util.ListIterator;
import java.sql.ResultSet;
import javaapplication3.mySQLConnect;

/**
 *
 * @author phongdiep
 */
public class namHocKyHsDAO {

    private mySQLConnect connect;
    private ResultSet results;

    public namHocKyHsDAO() {
//         connect = new mySQLConnect("den1.mysql4.gear.host", "quanlyhocsinh", "Ov53-TC4F82_", "quanlyhocsinh");
        connect = new mySQLConnect("localhost", "root", "", "QLHS");
    }

    public ArrayList<namHocKyHsDTO> getThoiKhoaBieu(String maLop){
        ArrayList<namHocKyHsDTO> listThoiKhoaBieu = new ArrayList<namHocKyHsDTO>();
        String query = "SELECT DISTINCT TKB.MANAMHOC, TKB.MAHOCKY FROM thoikhoabieu2 TKB WHERE TKB.MALOP='"+ maLop+"' ORDER BY TKB.MAHOCKY";
//          String query = "SELCT * FROM ";
        try {
            results = connect.executeQuery(query);
            while(results.next()) {
                namHocKyHsDTO nk = new namHocKyHsDTO(
                results.getString(1),
                results.getString(2)
                   
            );
            listThoiKhoaBieu.add(nk);
            }
        } catch (Exception e) {
            System.err.println(e);
        }
        return listThoiKhoaBieu;
    }
       public static void main(String[] args){
        namHocKyHsDAO hello = new namHocKyHsDAO();
        ArrayList<namHocKyHsDTO> zoo = new ArrayList<namHocKyHsDTO>();
        zoo = hello.getThoiKhoaBieu("LOP1011920");
        ListIterator<namHocKyHsDTO> iterator = zoo.listIterator();
        System.out.println("Các phần tử có trong list là: ");
        while (iterator.hasNext()) {
            System.out.println((namHocKyHsDTO) iterator.next());
        }
    }
}

