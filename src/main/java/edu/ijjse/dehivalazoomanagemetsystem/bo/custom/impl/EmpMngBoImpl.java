package edu.ijjse.dehivalazoomanagemetsystem.bo.custom.impl;

import edu.ijjse.dehivalazoomanagemetsystem.bo.custom.EmpMngBo;
import edu.ijjse.dehivalazoomanagemetsystem.dao.DaoFactory;
import edu.ijjse.dehivalazoomanagemetsystem.dao.custom.EmpMngDao;
import edu.ijjse.dehivalazoomanagemetsystem.entity.dto.EmpMng;

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
    public boolean add(EmpMng dto) throws SQLException {
        return empMngDao.add(dto);
    }

    /**
     * @param dto
     * @return
     * @throws SQLException
     */
    @Override
    public boolean update(EmpMng dto) throws SQLException {
        return empMngDao.update(dto);
    }

    /**
     * @param dto
     * @return
     * @throws SQLException
     */
    @Override
    public boolean delete(EmpMng dto) throws SQLException {
        return empMngDao.delete(dto);
    }

    /**
     * @return
     * @throws SQLException
     */
    @Override
    public ArrayList<EmpMng> getAll() throws SQLException {
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
