package edu.ijjse.dehivalazoomanagemetsystem.bo.custom.impl;

import edu.ijjse.dehivalazoomanagemetsystem.bo.custom.EmpMngBo;
import edu.ijjse.dehivalazoomanagemetsystem.model.dto.EmpMngDto;

import java.sql.SQLException;
import java.util.ArrayList;

public class EmpMngBoImpl implements EmpMngBo {
    /**
     * @param dto
     * @return
     * @throws SQLException
     */
    @Override
    public boolean add(EmpMngDto dto) throws SQLException {
        return false;
    }

    /**
     * @param dto
     * @return
     * @throws SQLException
     */
    @Override
    public boolean update(EmpMngDto dto) throws SQLException {
        return false;
    }

    /**
     * @param dto
     * @return
     * @throws SQLException
     */
    @Override
    public boolean delete(EmpMngDto dto) throws SQLException {
        return false;
    }

    /**
     * @return
     * @throws SQLException
     */
    @Override
    public ArrayList<EmpMngDto> getAll() throws SQLException {
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
