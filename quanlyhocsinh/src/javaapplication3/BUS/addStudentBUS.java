/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication3.BUS;
import javaapplication3.DAO.classDAO;
import javaapplication3.DTO.studentDTO;
/**
 *
 * @author thien
 */
public class addStudentBUS {
    
    public void getValue(String MAHS, String ho, String ten,String ngaysinh,String diachi, String gioitinh, String email, String sđt, String makhoi, String malop, String manamhoc){
        classDAO kq = new classDAO();
        studentDTO a = new studentDTO();
        if(MAHS.equals(null) && ho.equals(null) && ten.equals(null) && ngaysinh.equals(null) && diachi.equals(null) && gioitinh.equals(null)&& email.equals(null) && sđt.equals(null) && malop.equals(null) && malop.equals(null) && manamhoc.equals(null)){
            return;
        }else{
            a.setIdStudent(MAHS);
            a.setSurname(ho);
            a.setName(ten);
            a.setDob(ngaysinh);
            a.setA(gioitinh);
            a.setEmail(email);
            a.setAddress(diachi);
            a.setPhoneNumber(sđt);
        }
        kq.addStudent(a, makhoi, malop,manamhoc );
    }
}