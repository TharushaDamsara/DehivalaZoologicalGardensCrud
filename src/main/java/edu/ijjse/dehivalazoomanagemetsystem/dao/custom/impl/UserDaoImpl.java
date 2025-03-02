package edu.ijjse.dehivalazoomanagemetsystem.dao.custom.impl;

import edu.ijjse.dehivalazoomanagemetsystem.dao.custom.UserDao;
import edu.ijjse.dehivalazoomanagemetsystem.db.DBConnection;
import edu.ijjse.dehivalazoomanagemetsystem.dto.UserDto;
import edu.ijjse.dehivalazoomanagemetsystem.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserDaoImpl implements UserDao {

    public boolean getUserCredential(String userName, String pwd) throws SQLException {
        System.out.println(userName + pwd);
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "select * from user where userName = ? and password = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, userName);
        ps.setString(2, pwd);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
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
    public boolean add(User dto) throws SQLException {
        return false;
    }

    /**
     * @param dto
     * @return
     * @throws SQLException
     */
    @Override
    public boolean update(User dto) throws SQLException {
        return false;
    }

    /**
     * @param dto
     * @return
     * @throws SQLException
     */
    @Override
    public boolean delete(User dto) throws SQLException {
        return false;
    }

    /**
     * @return
     * @throws SQLException
     */
    @Override
    public ArrayList<User> getAll() throws SQLException {
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
}
