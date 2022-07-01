/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication3.DAO;

import java.sql.ResultSet;
import java.util.ArrayList;
import javaapplication3.DTO.classDTO;
import javaapplication3.DTO.studentDTO;
import javaapplication3.mySQLConnect;

/**
 *
 * @author azu
 */
public class classDAO {
    
    private mySQLConnect connect;
    private ResultSet results;
    
    public classDAO() {
        connect = new mySQLConnect("localhost", "root", "", "QLHS");
    }
    
    public ArrayList<classDTO> getLop() {
        ArrayList<classDTO> listLop = new ArrayList<classDTO>();
        String query = "SELECT * FROM lop";
        try {
            results = connect.executeQuery(query);
            while(results.next()) {
                classDTO lop = new classDTO(
                    results.getString(1),
                    results.getString(2),
                    results.getString(3),
                    results.getString(4),
                    results.getInt(5),
                    results.getString(6)
                );
                listLop.add(lop);
            }
        }
        catch(Exception e) {
            System.err.println(e);
        }
        
        return listLop;
    }
    
    public void addStudent(studentDTO a, String makhoi, String malop, String manamhoc) {
        String query = "INSERT INTO `hocsinh` VALUES('" + a.getIdStudent() + "','" + a.getSurname() + "','" + a.getName() + "','" + a.getDob() + "','" + a.getAddress() + "','" + a.getA() + "','" + a.getEmail() + "','" + a.getPhoneNumber() + "')";
        String query2 = "INSERT INTO `chitietlop` VALUES('%d', '%s', '%s' , '%s', '%s')";
        String query3 = "SELECT * FROM `chitietlop`";
        try { 

            connect.executeUpdate(query);
            results = connect.executeQuery(query3);
            int size = 0;
            while(results.next()){
                size = results.getInt(1);
            }
            connect.executeUpdate(String.format(query2,size + 1, manamhoc, makhoi, malop, a.getIdStudent()));
//                }
        } catch (Exception ex) {
            System.err.println(ex);
        }
    }
    
}
