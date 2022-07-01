/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication3.BUS;

/**
 *
 * @author azu
 */
import javaapplication3.DAO.LoginDAO;
import javaapplication3.DTO.LoginDTO;
import java.util.ArrayList;
public class LoginBUS {

    ArrayList<LoginDTO> listAcc;
    public LoginBUS() {
    }
    public int getAccount(String taikhoan, String matkhau){
        LoginDAO dao = new LoginDAO();
        listAcc = dao.getAccount();
        for(LoginDTO account : listAcc){
            if(taikhoan.equals(account.getTaikhoan()) && matkhau.equals(account.getMatkhau())){
                if(account.getLoainguoidung().equals("LND001")) return 1;
                if(account.getLoainguoidung().equals("LND002")) return 2;
                if(account.getLoainguoidung().equals("LND003")) return 3;
                if(account.getLoainguoidung().equals("LND004")) return 4;
            }
        }
        return -1;
    }
}