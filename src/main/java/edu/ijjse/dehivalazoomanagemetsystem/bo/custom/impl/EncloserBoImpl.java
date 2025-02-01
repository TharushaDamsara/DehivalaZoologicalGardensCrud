package edu.ijjse.dehivalazoomanagemetsystem.bo.custom.impl;

import edu.ijjse.dehivalazoomanagemetsystem.bo.custom.EncloserBo;
import edu.ijjse.dehivalazoomanagemetsystem.dao.DaoFactory;
import edu.ijjse.dehivalazoomanagemetsystem.dao.custom.EncloserDao;
import edu.ijjse.dehivalazoomanagemetsystem.entity.dto.Encloser;

import java.sql.SQLException;
import java.util.ArrayList;

public class EncloserBoImpl implements EncloserBo {
    EncloserDao encloserDao = (EncloserDao) DaoFactory.getInstance().getSuperDao(DaoFactory.daoType.Encloser);
    /**
     * @param dto
     * @return
     * @throws SQLException
     */
    @Override
    public boolean add(Encloser dto) throws SQLException {
        return encloserDao.add(dto);
    }

    /**
     * @param dto
     * @return
     * @throws SQLException
     */
    @Override
    public boolean update(Encloser dto) throws SQLException {
        return encloserDao.update(dto);
    }

    /**
     * @param dto
     * @return
     * @throws SQLException
     */
    @Override
    public boolean delete(Encloser dto) throws SQLException {
        return encloserDao.delete(dto);
    }

    /**
     * @return
     * @throws SQLException
     */
    @Override
    public ArrayList<Encloser> getAll() throws SQLException {
        return encloserDao.getAll();
    }

    /**
     * @return
     * @throws SQLException
     */
    @Override
    public String getNextId() throws SQLException {
        return encloserDao.getNextId();
    }
}
