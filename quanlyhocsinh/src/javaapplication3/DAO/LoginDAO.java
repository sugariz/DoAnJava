/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication3.DAO;

/**
 *
 * @author azu
 */
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javaapplication3.mySQLConnect;
import java.util.ArrayList;
import javaapplication3.DTO.LoginDTO;
public class LoginDAO {
    mySQLConnect ps;
    ResultSet rs;
    public LoginDAO() {
        ps = new mySQLConnect("localhost", "root", "", "QLHS");
    }
    public ArrayList<LoginDTO> getAccount(){
    String query = "SELECT * FROM `nguoidung`";
    ArrayList<LoginDTO> kq = new ArrayList<LoginDTO>();
        try {
            rs = ps.executeQuery(query);
            while(rs.next()){
                LoginDTO taikhoan = new LoginDTO();
                taikhoan.setTaikhoan(rs.getString(4));
                taikhoan.setMatkhau(rs.getString(5));
                taikhoan.setLoainguoidung(rs.getString(2));
                kq.add(taikhoan);
            }
        } catch (Exception ex) {
            System.err.println(ex);
        }
        return kq;
    }
}