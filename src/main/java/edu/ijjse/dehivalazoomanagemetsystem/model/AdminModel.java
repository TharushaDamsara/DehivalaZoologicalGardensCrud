package edu.ijjse.dehivalazoomanagemetsystem.model;

import edu.ijjse.dehivalazoomanagemetsystem.dto.AdminDto;
import edu.ijjse.dehivalazoomanagemetsystem.utill.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminModel {
    public AdminDto getAdmin(AdminDto adminDto) throws SQLException {
        String sql ="select userName,password from admin";
        ResultSet rst = CrudUtil.execute(sql);
        if (rst.next()) {
            AdminDto admin = new AdminDto(
                    rst.getString(1),
                    rst.getString(2)
            );
            return admin;
        }

        return null;
    }
}
