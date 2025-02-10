package edu.ijjse.dehivalazoomanagemetsystem.bo.custom.impl;

import edu.ijjse.dehivalazoomanagemetsystem.bo.custom.VetBo;
import edu.ijjse.dehivalazoomanagemetsystem.dao.DaoFactory;
import edu.ijjse.dehivalazoomanagemetsystem.dao.custom.VetDao;
import edu.ijjse.dehivalazoomanagemetsystem.dto.VetDto;

import java.sql.SQLException;
import java.util.ArrayList;

public class VetBoImpl implements VetBo {
    VetDao vetDao = (VetDao) DaoFactory.getInstance().getSuperDao(DaoFactory.daoType.Vet);
    /**
     * @param dto
     * @return
     * @throws SQLException
     */
    @Override
    public boolean add(VetDto dto) throws SQLException {
        return vetDao.add(dto);
    }

    /**
     * @param dto
     * @return
     * @throws SQLException
     */
    @Override
    public boolean update(VetDto dto) throws SQLException {
        return vetDao.update(dto);
    }

    /**
     * @param dto
     * @return
     * @throws SQLException
     */
    @Override
    public boolean delete(VetDto dto) throws SQLException {
        return vetDao.delete(dto);
    }

    /**
     * @return
     * @throws SQLException
     */
    @Override
    public ArrayList<VetDto> getAll() throws SQLException {
        return vetDao.getAll();
    }

    /**
     * @return
     * @throws SQLException
     */
    @Override
    public String getNextId() throws SQLException {
        return vetDao.getNextId();
    }
}
