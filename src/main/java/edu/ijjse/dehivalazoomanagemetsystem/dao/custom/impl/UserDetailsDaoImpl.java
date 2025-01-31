package edu.ijjse.dehivalazoomanagemetsystem.dao.custom.impl;

import edu.ijjse.dehivalazoomanagemetsystem.dao.custom.UserDetailsDao;
import edu.ijjse.dehivalazoomanagemetsystem.model.dto.UserDetailsMngDto;
import edu.ijjse.dehivalazoomanagemetsystem.dao.utill.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserDetailsDaoImpl implements UserDetailsDao {
    public boolean add(UserDetailsMngDto dto) throws SQLException {
        String sql = "insert into user values(?,?,?,?)";

        return CrudUtil.execute(sql,dto.getUserId(),dto.getEmpId(),dto.getUserName(),dto.getPassword());
    }
    public boolean update(UserDetailsMngDto dto) throws SQLException {
        String sql = "update user set empId =?, userName=?,password=? where userId=?";
     return CrudUtil.execute(sql,dto.getEmpId(),dto.getUserName(),dto.getPassword(),dto.getUserId());
    }
    public boolean delete(UserDetailsMngDto dto) throws SQLException {
        String sql = "delete from user where userId=?";
        return CrudUtil.execute(sql,dto.getUserId());
    }
    public ArrayList<UserDetailsMngDto> getAll() throws SQLException {
        String sql = "select * from user";
        ResultSet rst = CrudUtil.execute(sql);
        ArrayList<UserDetailsMngDto> dtos = new ArrayList<>();
        while (rst.next()) {
            UserDetailsMngDto dto = new UserDetailsMngDto(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4)
            );
            dtos.add(dto);
        }
        return dtos;
    }
    public String getNextId() throws SQLException {
        String sql = "select userId from user order by userId desc limit 1";
        ResultSet rst = CrudUtil.execute(sql);
        if (rst.next()) {
            String id = rst.getString(1);
            String substring = id.substring(1);
            int i = Integer.parseInt(substring);
            int newIndex = i + 1;
            return String.format("U%03d", newIndex);
        }
        return "U001";
    }
    public ArrayList<String> getEmployeeIds() throws SQLException {
        String sql = "select empId from employee";
        ResultSet rst = CrudUtil.execute(sql);
        ArrayList<String> employees = new ArrayList<>();
        while (rst.next()) {
            employees.add(rst.getString(1));
        }
        return employees;
    }
}
