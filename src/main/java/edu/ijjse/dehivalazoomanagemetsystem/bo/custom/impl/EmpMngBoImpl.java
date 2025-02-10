package edu.ijjse.dehivalazoomanagemetsystem.bo.custom.impl;

import edu.ijjse.dehivalazoomanagemetsystem.bo.custom.EmpMngBo;
import edu.ijjse.dehivalazoomanagemetsystem.dao.DaoFactory;
import edu.ijjse.dehivalazoomanagemetsystem.dao.custom.EmpMngDao;
import edu.ijjse.dehivalazoomanagemetsystem.dto.EmpMngDto;

import java.sql.SQLException;
import java.util.ArrayList;

public class EmpMngBoImpl implements EmpMngBo {
    EmpMngDao empMngDao = (EmpMngDao) DaoFactory.getInstance().getSuperDao(DaoFactory.daoType.Emp);
    /**
     * @param dto
     * @return
     * @throws SQLException
     */
    @Override
    public boolean add(EmpMngDto dto) throws SQLException {
        return empMngDao.add(dto);
    }

    /**
     * @param dto
     * @return
     * @throws SQLException
     */
    @Override
    public boolean update(EmpMngDto dto) throws SQLException {
        return empMngDao.update(dto);
    }

    /**
     * @param dto
     * @return
     * @throws SQLException
     */
    @Override
    public boolean delete(EmpMngDto dto) throws SQLException {
        return empMngDao.delete(dto);
    }

    /**
     * @return
     * @throws SQLException
     */
    @Override
    public ArrayList<EmpMngDto> getAll() throws SQLException {
        return empMngDao.getAll();
    }

    /**
     * @return
     * @throws SQLException
     */
    @Override
    public String getNextId() throws SQLException {
        return empMngDao.getNextId();
    }
}
