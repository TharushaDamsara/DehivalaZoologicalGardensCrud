package edu.ijjse.dehivalazoomanagemetsystem.bo.custom.impl;

import edu.ijjse.dehivalazoomanagemetsystem.bo.custom.EventBo;
import edu.ijjse.dehivalazoomanagemetsystem.dao.DaoFactory;
import edu.ijjse.dehivalazoomanagemetsystem.dao.custom.EventDao;
import edu.ijjse.dehivalazoomanagemetsystem.dto.EventDto;
import edu.ijjse.dehivalazoomanagemetsystem.entity.Event;

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
        return eventDao.add(new Event(dto.getEventId(),dto.getEventName(),dto.getEventLocation(),dto.getEventDate()));
    }

    /**
     * @param dto
     * @return
     * @throws SQLException
     */
    @Override
    public boolean update(EventDto dto) throws SQLException {
        return eventDao.update(new Event(dto.getEventId(),dto.getEventName(),dto.getEventLocation(),dto.getEventDate()));
    }

    /**
     * @param dto
     * @return
     * @throws SQLException
     */
    @Override
    public boolean delete(EventDto dto) throws SQLException {
        return eventDao.delete(new Event(dto.getEventId(),dto.getEventName(),dto.getEventLocation(),dto.getEventDate()));
    }

    /**
     * @return
     * @throws SQLException
     */
    @Override
    public ArrayList<EventDto> getAll() throws SQLException {
     ArrayList<EventDto> eventDtos = new ArrayList<>();
     ArrayList<Event> events = eventDao.getAll();
     for (Event event : events) {
         eventDtos.add(new EventDto(event.getEventId(),event.getEventName(),event.getEventLocation(),event.getEventDate()));
     }
        return eventDtos;
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
