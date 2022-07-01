/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication3.DAO;


/**
 *
 * @author thien
 */

import java.sql.ResultSet;
import javaapplication3.mySQLConnect;
import javaapplication3.DTO.teacherDTO;
public class AddTeacherDAO {
    mySQLConnect connect;
    ResultSet result;
    
    public AddTeacherDAO() {
        connect = new mySQLConnect("localhost", "root", "", "QLHS");
    }
    
    public void AddTeacher(teacherDTO a, String maMH){
        String query = "INSERT INTO `giaovien` VALUES('"+ a.getMAGV() + "','" +a.getHoTen() + "','" + a.getDiachi() + "','" + a.getSđt() + "')";
        String query2 = "INSERT INTO `GIAOVIENBOMON`(`MAGV`, `MAMONHOC`) VALUES('%s', '%s')";
        System.out.print(String.format(query2,a.getMAGV(),maMH));
        try { 
            result = connect.executeQuery(query);
            connect.executeUpdate(String.format(query2,a.getMAGV(),maMH));
        } catch (Exception ex) {
            System.err.println(ex);
        }
    }
    
}