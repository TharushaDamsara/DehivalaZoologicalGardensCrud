package edu.ijjse.dehivalazoomanagemetsystem.bo.custom.impl;

import edu.ijjse.dehivalazoomanagemetsystem.bo.custom.EventBo;
import edu.ijjse.dehivalazoomanagemetsystem.dao.DaoFactory;
import edu.ijjse.dehivalazoomanagemetsystem.dao.custom.EventDao;
import edu.ijjse.dehivalazoomanagemetsystem.dto.EventDto;

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
    public boolean add(EventDto dto) throws SQLException {
        return eventDao.add(dto);
    }

    /**
     * @param dto
     * @return
     * @throws SQLException
     */
    @Override
    public boolean update(EventDto dto) throws SQLException {
        return eventDao.update(dto);
    }

    /**
     * @param dto
     * @return
     * @throws SQLException
     */
    @Override
    public boolean delete(EventDto dto) throws SQLException {
        return eventDao.delete(dto);
    }

    /**
     * @return
     * @throws SQLException
     */
    @Override
    public ArrayList<EventDto> getAll() throws SQLException {
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
