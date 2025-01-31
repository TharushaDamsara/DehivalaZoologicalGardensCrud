package edu.ijjse.dehivalazoomanagemetsystem.bo.custom.impl;

import edu.ijjse.dehivalazoomanagemetsystem.bo.custom.UserDetailsBo;
import edu.ijjse.dehivalazoomanagemetsystem.model.dto.UserDetailsMngDto;

import java.sql.SQLException;
import java.util.ArrayList;

public class UserDetailsBoImpl implements UserDetailsBo {
    /**
     * @param dto
     * @return
     * @throws SQLException
     */
    @Override
    public boolean add(UserDetailsMngDto dto) throws SQLException {
        return false;
    }

    /**
     * @return
     * @throws SQLException
     */
    @Override
    public ArrayList<String> getEmployeeIds() throws SQLException {
        return null;
    }

    /**
     * @param dto
     * @return
     * @throws SQLException
     */
    @Override
    public boolean update(UserDetailsMngDto dto) throws SQLException {
        return false;
    }

    /**
     * @param dto
     * @return
     * @throws SQLException
     */
    @Override
    public boolean delete(UserDetailsMngDto dto) throws SQLException {
        return false;
    }

    /**
     * @return
     * @throws SQLException
     */
    @Override
    public ArrayList<UserDetailsMngDto> getAll() throws SQLException {
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
