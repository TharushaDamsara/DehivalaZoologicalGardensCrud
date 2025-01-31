package edu.ijjse.dehivalazoomanagemetsystem.bo.custom.impl;

import edu.ijjse.dehivalazoomanagemetsystem.bo.custom.AdminBo;
import edu.ijjse.dehivalazoomanagemetsystem.model.dto.AdminDto;

import java.sql.SQLException;
import java.util.ArrayList;

public class AdminBoImpl implements AdminBo {
    /**
     * @param dto
     * @return
     * @throws SQLException
     */
    @Override
    public boolean add(AdminDto dto) throws SQLException {
        return false;
    }

    /**
     * @param userName
     * @param pwd
     * @throws SQLException
     */
    @Override
    public void getAdmin(String userName, String pwd) throws SQLException {

    }

    /**
     * @param dto
     * @return
     * @throws SQLException
     */
    @Override
    public boolean update(AdminDto dto) throws SQLException {
        return false;
    }

    /**
     * @param dto
     * @return
     * @throws SQLException
     */
    @Override
    public boolean delete(AdminDto dto) throws SQLException {
        return false;
    }

    /**
     * @return
     * @throws SQLException
     */
    @Override
    public ArrayList<AdminDto> getAll() throws SQLException {
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
