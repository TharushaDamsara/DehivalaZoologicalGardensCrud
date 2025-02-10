package edu.ijjse.dehivalazoomanagemetsystem.bo.custom.impl;

import edu.ijjse.dehivalazoomanagemetsystem.bo.custom.TicketDetailsBo;
import edu.ijjse.dehivalazoomanagemetsystem.dao.DaoFactory;
import edu.ijjse.dehivalazoomanagemetsystem.dao.custom.TicketDetailsDao;
import edu.ijjse.dehivalazoomanagemetsystem.dto.TickDetailsDto;

import java.sql.SQLException;
import java.util.ArrayList;

public class TicketDetailsBoImpl implements TicketDetailsBo {
    TicketDetailsDao ticketDetailsDao = (TicketDetailsDao) DaoFactory.getInstance().getSuperDao(DaoFactory.daoType.TicketDetails);
    /**
     * @param dto
     * @return
     * @throws SQLException
     */
    @Override
    public boolean add(TickDetailsDto dto) throws SQLException {
        return ticketDetailsDao.add(dto);
    }

    /**
     * @param dto
     * @return
     * @throws SQLException
     */
    @Override
    public boolean update(TickDetailsDto dto) throws SQLException {
        return ticketDetailsDao.update(dto);
    }

    /**
     * @param dto
     * @return
     * @throws SQLException
     */
    @Override
    public boolean delete(TickDetailsDto dto) throws SQLException {
        return ticketDetailsDao.delete(dto);
    }

    /**
     * @return
     * @throws SQLException
     */
    @Override
    public ArrayList<TickDetailsDto> getAll() throws SQLException {
        return ticketDetailsDao.getAll();
    }

    /**
     * @return
     * @throws SQLException
     */
    @Override
    public String getNextId() throws SQLException {
        return ticketDetailsDao.getNextId();
    }
}
