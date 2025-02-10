package edu.ijjse.dehivalazoomanagemetsystem.bo.custom.impl;

import edu.ijjse.dehivalazoomanagemetsystem.bo.custom.EmpExpencessBo;
import edu.ijjse.dehivalazoomanagemetsystem.dao.DaoFactory;
import edu.ijjse.dehivalazoomanagemetsystem.dao.custom.EmpExpencessDao;
import edu.ijjse.dehivalazoomanagemetsystem.dto.EmployeeExpencesDto;

import java.sql.SQLException;
import java.util.ArrayList;

public class EmpExpencessBoImpl implements EmpExpencessBo {
    EmpExpencessDao empExpencessDao = (EmpExpencessDao) DaoFactory.getInstance().getSuperDao(DaoFactory.daoType.EmpExpencess);
    /**
     * @param dto
     * @return
     * @throws SQLException
     */
    @Override
    public boolean add(EmployeeExpencesDto dto) throws SQLException {
        return empExpencessDao.add(dto);
    }

    /**
     * @return
     * @throws SQLException
     */
    @Override
    public ArrayList<String> getEmployeeIds() throws SQLException {
        return empExpencessDao.getEmployeeIds();
    }

    /**
     * @param dto
     * @return
     * @throws SQLException
     */
    @Override
    public boolean update(EmployeeExpencesDto dto) throws SQLException {
        return empExpencessDao.update(dto);
    }

    /**
     * @param dto
     * @return
     * @throws SQLException
     */
    @Override
    public boolean delete(EmployeeExpencesDto dto) throws SQLException {
        return empExpencessDao.delete(dto);
    }

    /**
     * @return
     * @throws SQLException
     */
    @Override
    public ArrayList<EmployeeExpencesDto> getAll() throws SQLException {
        return null;
    }

    /**
     * @return
     * @throws SQLException
     */
    @Override
    public String getNextId() throws SQLException {
        return empExpencessDao.getNextId();
    }
}
