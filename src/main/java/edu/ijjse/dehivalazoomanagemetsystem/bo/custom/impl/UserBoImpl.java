package edu.ijjse.dehivalazoomanagemetsystem.bo.custom.impl;

import edu.ijjse.dehivalazoomanagemetsystem.bo.custom.UserBo;
import edu.ijjse.dehivalazoomanagemetsystem.model.dto.UserDto;

import java.sql.SQLException;
import java.util.ArrayList;

public class UserBoImpl implements UserBo {
    /**
     * @param dto
     * @return
     * @throws SQLException
     */
    @Override
    public boolean add(UserDto dto) throws SQLException {
        return false;
    }

    /**
     * @param userName
     * @param pwd
     * @return
     * @throws SQLException
     */
    @Override
    public boolean getUserCredential(String userName, String pwd) throws SQLException {
        return false;
    }

    /**
     * @param dto
     * @return
     * @throws SQLException
     */
    @Override
    public boolean update(UserDto dto) throws SQLException {
        return false;
    }

    /**
     * @param dto
     * @return
     * @throws SQLException
     */
    @Override
    public boolean delete(UserDto dto) throws SQLException {
        return false;
    }

    /**
     * @return
     * @throws SQLException
     */
    @Override
    public ArrayList<UserDto> getAll() throws SQLException {
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
