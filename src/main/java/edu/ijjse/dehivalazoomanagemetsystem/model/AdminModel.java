package edu.ijjse.dehivalazoomanagemetsystem.model;

import edu.ijjse.dehivalazoomanagemetsystem.db.DBConnection;
import edu.ijjse.dehivalazoomanagemetsystem.dto.AdminDto;
import edu.ijjse.dehivalazoomanagemetsystem.utill.CrudUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminModel {
    public boolean getAdmin(String userName,String pwd) throws SQLException {
        String sql ="select * from admin where userName = ? and password = ?";
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement ps =connection.prepareStatement(sql);
        ps.setString(1,userName);
        ps.setString(2,pwd);
        ResultSet rs = ps.executeQuery();
        if(rs.next()){
            return true;
        }
        return false;
    }
}
