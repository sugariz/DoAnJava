/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication3.DAO;

import java.util.*;
import java.util.ListIterator;
import java.sql.ResultSet;
import javaapplication3.mySQLConnect;
import javaapplication3.DTO.thoiKhoaBieuHocSinhDTO;
/**
 *
 * @author phongdiep
 */
public class thoiKhoaBieuHocSinhDAO {
    private mySQLConnect connect;
    private ResultSet results;
    
    public thoiKhoaBieuHocSinhDAO(){
//       connect = new mySQLConnect("den1.mysql4.gear.host", "quanlyhocsinh", "Ov53-TC4F82_", "quanlyhocsinh");
       connect = new mySQLConnect("localhost", "root", "", "QLHS");
    }
    
    public ArrayList<thoiKhoaBieuHocSinhDTO> getThoiKhoaBieu(String maLop){
        ArrayList<thoiKhoaBieuHocSinhDTO> listThoiKhoaBieu = new ArrayList<thoiKhoaBieuHocSinhDTO>();
        String query = "SELECT TKB.MALOP, TKB.MATHU, TKB.MATIET, MH.TENMONHOC, TKB.MAHOCKY,TKB.MANAMHOC, GV.TENGIAOVIEN "
                + "FROM thoikhoabieu2 TKB, giaovienbomon GVBM, monhoc MH, giaovien GV "
                + "WHERE GVBM.MAGV=GV.MAGV AND TKB.MAGIAOVIENBOMON=GVBM.MAGIAOVIENBOMON AND GVBM.MAMONHOC=MH.MAMONHOC AND TKB.MALOP='"+ maLop+"'";
//          String query = "SELCT * FROM ";
        try {
            results = connect.executeQuery(query);
            while(results.next()) {
                thoiKhoaBieuHocSinhDTO thoikhoabieu = new thoiKhoaBieuHocSinhDTO(
                results.getString(1),
                results.getString(2),
                results.getString(3),
                results.getString(4),
                results.getString(5),
                results.getString(6),
                results.getString(7) 
            );
            listThoiKhoaBieu.add(thoikhoabieu);
            }
        } catch (Exception e) {
            System.err.println(e);
        }
        return listThoiKhoaBieu;
    }
    
    public static void main(String[] args){
        thoiKhoaBieuHocSinhDAO hello = new thoiKhoaBieuHocSinhDAO();
        ArrayList<thoiKhoaBieuHocSinhDTO> zoo = new ArrayList<thoiKhoaBieuHocSinhDTO>();
        zoo = hello.getThoiKhoaBieu("LOP1011920");
        ListIterator<thoiKhoaBieuHocSinhDTO> iterator = zoo.listIterator();
        System.out.println("Các phần tử có trong list là: ");
        while (iterator.hasNext()) {
            System.out.println((thoiKhoaBieuHocSinhDTO) iterator.next());
        }
    }
}
