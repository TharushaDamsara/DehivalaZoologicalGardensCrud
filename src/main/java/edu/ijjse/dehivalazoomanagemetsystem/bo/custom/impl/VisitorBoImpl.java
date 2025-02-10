package edu.ijjse.dehivalazoomanagemetsystem.bo.custom.impl;

import edu.ijjse.dehivalazoomanagemetsystem.bo.custom.VisitorBo;
import edu.ijjse.dehivalazoomanagemetsystem.dao.DaoFactory;
import edu.ijjse.dehivalazoomanagemetsystem.dao.custom.VisitorDao;
import edu.ijjse.dehivalazoomanagemetsystem.dto.VisitorDto;

import java.sql.SQLException;
import java.util.ArrayList;

public class VisitorBoImpl implements VisitorBo {
    VisitorDao visitorDao = (VisitorDao) DaoFactory.getInstance().getSuperDao(DaoFactory.daoType.Visitor);

    /**
     * @param dto
     * @return
     * @throws SQLException
     */
    @Override
    public boolean add(VisitorDto dto) throws SQLException {
        return visitorDao.add(dto);
    }

    /**
     * @param dto
     * @return
     * @throws SQLException
     */
    @Override
    public boolean update(VisitorDto dto) throws SQLException {
        return visitorDao.update(dto);
    }

    /**
     * @param dto
     * @return
     * @throws SQLException
     */
    @Override
    public boolean delete(VisitorDto dto) throws SQLException {
        return visitorDao.delete(dto);
    }

    /**
     * @return
     * @throws SQLException
     */
    @Override
    public ArrayList<VisitorDto> getAll() throws SQLException {
        return visitorDao.getAll();
    }

    /**
     * @return
     * @throws SQLException
     */
    @Override
    public String getNextId() throws SQLException {
        return visitorDao.getNextId();
    }
}
