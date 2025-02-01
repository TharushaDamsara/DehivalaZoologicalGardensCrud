package edu.ijjse.dehivalazoomanagemetsystem.bo.custom.impl;

import edu.ijjse.dehivalazoomanagemetsystem.bo.custom.DevisionBo;
import edu.ijjse.dehivalazoomanagemetsystem.dao.DaoFactory;
import edu.ijjse.dehivalazoomanagemetsystem.dao.custom.DevisionDao;
import edu.ijjse.dehivalazoomanagemetsystem.entity.dto.Devision;

import java.sql.SQLException;
import java.util.ArrayList;

public class DevisionBoImpl implements DevisionBo {
     DevisionDao devisionDao = (DevisionDao) DaoFactory.getInstance().getSuperDao(DaoFactory.daoType.Devision);
    /**
     * @param dto
     * @return
     * @throws SQLException
     */
    @Override
    public boolean add(Devision dto) throws SQLException {
        return devisionDao.add(dto);
    }

    /**
     * @param dto
     * @return
     * @throws SQLException
     */
    @Override
    public boolean update(Devision dto) throws SQLException {
        return devisionDao.update(dto);
    }

    /**
     * @param dto
     * @return
     * @throws SQLException
     */
    @Override
    public boolean delete(Devision dto) throws SQLException {
        return devisionDao.delete(dto);
    }

    /**
     * @return
     * @throws SQLException
     */
    @Override
    public ArrayList<Devision> getAll() throws SQLException {
        return devisionDao.getAll();
    }

    /**
     * @return
     * @throws SQLException
     */
    @Override
    public String getNextId() throws SQLException {
        return devisionDao.getNextId();
    }
}
