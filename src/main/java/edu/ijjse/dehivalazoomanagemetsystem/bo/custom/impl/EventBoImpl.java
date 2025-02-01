package edu.ijjse.dehivalazoomanagemetsystem.bo.custom.impl;

import edu.ijjse.dehivalazoomanagemetsystem.bo.custom.EventBo;
import edu.ijjse.dehivalazoomanagemetsystem.dao.DaoFactory;
import edu.ijjse.dehivalazoomanagemetsystem.dao.custom.EventDao;
import edu.ijjse.dehivalazoomanagemetsystem.entity.dto.Event;

import java.sql.SQLException;
import java.util.ArrayList;

public class EventBoImpl implements EventBo {
    EventDao eventDao = (EventDao) DaoFactory.getInstance().getSuperDao(DaoFactory.daoType.Event);
    /**
     * @param dto
     * @return
     * @throws SQLException
     */
    @Override
    public boolean add(Event dto) throws SQLException {
        return eventDao.add(dto);
    }

    /**
     * @param dto
     * @return
     * @throws SQLException
     */
    @Override
    public boolean update(Event dto) throws SQLException {
        return eventDao.update(dto);
    }

    /**
     * @param dto
     * @return
     * @throws SQLException
     */
    @Override
    public boolean delete(Event dto) throws SQLException {
        return eventDao.delete(dto);
    }

    /**
     * @return
     * @throws SQLException
     */
    @Override
    public ArrayList<Event> getAll() throws SQLException {
        return eventDao.getAll();
    }

    /**
     * @return
     * @throws SQLException
     */
    @Override
    public String getNextId() throws SQLException {
        return eventDao.getNextId();
    }
}
