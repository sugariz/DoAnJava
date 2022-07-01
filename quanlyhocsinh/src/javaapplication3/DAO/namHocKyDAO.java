/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication3.DAO;


import javaapplication3.DTO.namHocKyDTO;
import java.util.*;
import java.util.ListIterator;
import java.sql.ResultSet;
import javaapplication3.mySQLConnect;

/**
 *
 * @author phongdiep
 */
public class namHocKyDAO {

    private mySQLConnect connect;
    private ResultSet results;

    public namHocKyDAO() {
//         connect = new mySQLConnect("den1.mysql4.gear.host", "quanlyhocsinh", "Ov53-TC4F82_", "quanlyhocsinh");
         connect = new mySQLConnect("localhost", "root", "", "QLHS");
    }

    public ArrayList<namHocKyDTO> getThoiKhoaBieu(String maGv){
        ArrayList<namHocKyDTO> listThoiKhoaBieu = new ArrayList<namHocKyDTO>();
        String query = "SELECT DISTINCT TKB.MANAMHOC, TKB.MAHOCKY FROM thoikhoabieu2 TKB, giaovienbomon GVBM WHERE TKB.MAGIAOVIENBOMON=GVBM.MAGIAOVIENBOMON AND GVBM.MAGV='"+ maGv+"' ORDER BY TKB.MAHOCKY";
//          String query = "SELCT * FROM ";
        try {
            results = connect.executeQuery(query);
            while(results.next()) {
                namHocKyDTO nk = new namHocKyDTO(
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
//       public static void main(String[] args){
//        namHocKyDAO hello = new namHocKyDAO();
//        ArrayList<namHocKyDTO> zoo = new ArrayList<namHocKyDTO>();
//        zoo = hello.getThoiKhoaBieu("GV0001");
//        ListIterator<namHocKyDTO> iterator = zoo.listIterator();
//        System.out.println("Các phần tử có trong list là: ");
//        while (iterator.hasNext()) {
//            System.out.println((namHocKyDTO) iterator.next());
//        }
//    }
}