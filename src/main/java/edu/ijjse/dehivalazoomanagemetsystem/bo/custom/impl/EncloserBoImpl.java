package edu.ijjse.dehivalazoomanagemetsystem.bo.custom.impl;

import edu.ijjse.dehivalazoomanagemetsystem.bo.custom.EncloserBo;
import edu.ijjse.dehivalazoomanagemetsystem.model.dto.EncloserDto;

import java.sql.SQLException;
import java.util.ArrayList;

public class EncloserBoImpl implements EncloserBo {
    /**
     * @param dto
     * @return
     * @throws SQLException
     */
    @Override
    public boolean add(EncloserDto dto) throws SQLException {
        return false;
    }

    /**
     * @param dto
     * @return
     * @throws SQLException
     */
    @Override
    public boolean update(EncloserDto dto) throws SQLException {
        return false;
    }

    /**
     * @param dto
     * @return
     * @throws SQLException
     */
    @Override
    public boolean delete(EncloserDto dto) throws SQLException {
        return false;
    }

    /**
     * @return
     * @throws SQLException
     */
    @Override
    public ArrayList<EncloserDto> getAll() throws SQLException {
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
