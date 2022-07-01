/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication3.BUS;

/**
 *
 * @author thien
 */
import javaapplication3.DAO.AddTeacherDAO;
import javaapplication3.DTO.teacherDTO;

public class AddTeacherBUS {
    
    public void getValue(String MAGV, String hoten, String diachi, String sđt, String maMH){
        AddTeacherDAO kq = new AddTeacherDAO();
        teacherDTO a = new teacherDTO();
        if(MAGV.equals(null) && hoten.equals(null) && diachi.equals(null) && sđt.equals(null) && maMH.equals(null)){
            return;
        }else{
            a.setMAGV(MAGV);
            a.setHoTen(hoten);
            a.setDiachi(diachi);
            a.setSđt(sđt);
        }
        kq.AddTeacher(a, maMH);
    }
}