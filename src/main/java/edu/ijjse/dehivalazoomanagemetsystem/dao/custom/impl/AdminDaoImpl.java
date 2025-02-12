package edu.ijjse.dehivalazoomanagemetsystem.dao.custom.impl;

import edu.ijjse.dehivalazoomanagemetsystem.dao.custom.AdminDao;
import edu.ijjse.dehivalazoomanagemetsystem.db.DBConnection;
import edu.ijjse.dehivalazoomanagemetsystem.dto.AdminDto;
import edu.ijjse.dehivalazoomanagemetsystem.entity.Admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AdminDaoImpl implements AdminDao  {
    @Override
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


    /**
     * @param dto
     * @return
     * @throws SQLException
     */
    @Override
    public boolean add(Admin admin) throws SQLException {
        return false;
    }

    /**
     * @param dto
     * @return
     * @throws SQLException
     */
    @Override
    public boolean update(Admin admin) throws SQLException {
        return false;
    }

    /**
     * @param dto
     * @return
     * @throws SQLException
     */
    @Override
    public boolean delete(Admin admin) throws SQLException {
        return false;
    }

    /**
     * @return
     * @throws SQLException
     */
    @Override
    public ArrayList<Admin> getAll() throws SQLException {
        return null;
    }

    /**
     * @return
     * @throws SQLException
     */
    @Override
    public String getNextId() throws SQLException {
        return "";
    }

    /**
     * @return
     * @throws SQLException
     */

}
