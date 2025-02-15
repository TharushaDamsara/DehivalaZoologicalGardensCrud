package edu.ijjse.dehivalazoomanagemetsystem.bo.custom.impl;

import edu.ijjse.dehivalazoomanagemetsystem.bo.custom.TicketDetailsBo;
import edu.ijjse.dehivalazoomanagemetsystem.dao.DaoFactory;
import edu.ijjse.dehivalazoomanagemetsystem.dao.custom.TicketDetailsDao;
import edu.ijjse.dehivalazoomanagemetsystem.dto.TickDetailsDto;
import edu.ijjse.dehivalazoomanagemetsystem.entity.TickDetails;

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
        return ticketDetailsDao.add(new TickDetails(dto.getId(),dto.getType(),dto.getQty(),dto.getPrice()));
    }

    /**
     * @param dto
     * @return
     * @throws SQLException
     */
    @Override
    public boolean update(TickDetailsDto dto) throws SQLException {
        return ticketDetailsDao.update(new TickDetails(dto.getId(),dto.getType(),dto.getQty(),dto.getPrice()));
    }

    /**
     * @param dto
     * @return
     * @throws SQLException
     */
    @Override
    public boolean delete(TickDetailsDto dto) throws SQLException {
        return ticketDetailsDao.delete(new TickDetails(dto.getId(),dto.getType(),dto.getQty(),dto.getPrice()));
    }

    /**
     * @return
     * @throws SQLException
     */
    @Override
    public ArrayList<TickDetailsDto> getAll() throws SQLException {
        ArrayList<TickDetailsDto> dtos = new ArrayList<>();
        ArrayList<TickDetails> tickets = ticketDetailsDao.getAll();
        for (TickDetails ticket : tickets) {
            dtos.add(new TickDetailsDto(ticket.getId(),ticket.getType(),ticket.getQty(),ticket.getPrice()));
        }
        return dtos;
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
