package edu.ijjse.dehivalazoomanagemetsystem.bo.custom.impl;

import edu.ijjse.dehivalazoomanagemetsystem.bo.custom.VetBo;
import edu.ijjse.dehivalazoomanagemetsystem.model.dto.VetDto;

import java.sql.SQLException;
import java.util.ArrayList;

public class VetBoImpl implements VetBo {
    /**
     * @param dto
     * @return
     * @throws SQLException
     */
    @Override
    public boolean add(VetDto dto) throws SQLException {
        return false;
    }

    /**
     * @param dto
     * @return
     * @throws SQLException
     */
    @Override
    public boolean update(VetDto dto) throws SQLException {
        return false;
    }

    /**
     * @param dto
     * @return
     * @throws SQLException
     */
    @Override
    public boolean delete(VetDto dto) throws SQLException {
        return false;
    }

    /**
     * @return
     * @throws SQLException
     */
    @Override
    public ArrayList<VetDto> getAll() throws SQLException {
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
