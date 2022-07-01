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
import javaapplication3.DTO.thoiKhoaBieuGiaoVienDTO;
/**
 *
 * @author phongdiep
 */
public class thoiKhoaBieuGiaoVienDAO {
    private mySQLConnect connect;
    private ResultSet results;
    
    public thoiKhoaBieuGiaoVienDAO(){
//       connect = new mySQLConnect("den1.mysql4.gear.host", "quanlyhocsinh", "Ov53-TC4F82_", "quanlyhocsinh");
        connect = new mySQLConnect("localhost", "root", "", "QLHS");
    }
    
    public ArrayList<thoiKhoaBieuGiaoVienDTO> getThoiKhoaBieu(String maGv){
        ArrayList<thoiKhoaBieuGiaoVienDTO> listThoiKhoaBieu = new ArrayList<thoiKhoaBieuGiaoVienDTO>();
        String query = "SELECT L.MALOP,L.TENLOP, TKB.MATHU, TKB.MATIET, MH.TENMONHOC, TKB.MAHOCKY,TKB.MANAMHOC "
                + "FROM thoikhoabieu2 TKB, giaovienbomon GVBM, monhoc MH, lop L "
                + "WHERE TKB.MALOP = L.MALOP AND TKB.MAGIAOVIENBOMON=GVBM.MAGIAOVIENBOMON AND GVBM.MAMONHOC=MH.MAMONHOC AND GVBM.MAGV='"+ maGv+"'";
//          String query = "SELCT * FROM ";
        try {
            results = connect.executeQuery(query);
            while(results.next()) {
                thoiKhoaBieuGiaoVienDTO thoikhoabieu = new thoiKhoaBieuGiaoVienDTO(
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
        thoiKhoaBieuGiaoVienDAO hello = new thoiKhoaBieuGiaoVienDAO();
        ArrayList<thoiKhoaBieuGiaoVienDTO> zoo = new ArrayList<thoiKhoaBieuGiaoVienDTO>();
        zoo = hello.getThoiKhoaBieu("GV0001");
        ListIterator<thoiKhoaBieuGiaoVienDTO> iterator = zoo.listIterator();
        System.out.println("Các phần tử có trong list là: ");
        while (iterator.hasNext()) {
            System.out.println((thoiKhoaBieuGiaoVienDTO) iterator.next());
        }
    }
}