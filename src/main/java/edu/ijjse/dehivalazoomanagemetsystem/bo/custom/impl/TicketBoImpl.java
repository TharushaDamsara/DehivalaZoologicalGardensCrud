package edu.ijjse.dehivalazoomanagemetsystem.bo.custom.impl;

import edu.ijjse.dehivalazoomanagemetsystem.bo.custom.TicketBo;
import edu.ijjse.dehivalazoomanagemetsystem.controller.TicketDetails;
import edu.ijjse.dehivalazoomanagemetsystem.dao.DaoFactory;
import edu.ijjse.dehivalazoomanagemetsystem.dao.custom.TicketDao;
import edu.ijjse.dehivalazoomanagemetsystem.dao.custom.TicketDetailsDao;
import edu.ijjse.dehivalazoomanagemetsystem.db.DBConnection;
import edu.ijjse.dehivalazoomanagemetsystem.dto.TickDetailsDto;
import edu.ijjse.dehivalazoomanagemetsystem.dto.TicketDto;
import edu.ijjse.dehivalazoomanagemetsystem.entity.TickDetails;
import edu.ijjse.dehivalazoomanagemetsystem.entity.Ticket;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class TicketBoImpl implements TicketBo {
    /**
     * @param id
     * @return
     * @throws SQLException
     */
    @Override
    public TickDetailsDto findById(String id) throws SQLException {
        ArrayList<TickDetailsDto> tickets = new ArrayList<>();
        TickDetails byId = ticketDao.findById(id);
        for (TickDetailsDto dto : tickets) {
            if (dto.getId().equals(id)) {
                return dto;
            }
        }
        return null;
    }

    /**
     * @return
     * @throws SQLException
     */
    @Override
    public ArrayList<String> getVisitorId() throws SQLException {
        return ticketDao.getVisitorId();
    }

    /**
     * @return
     * @throws SQLException
     */
    @Override
    public ArrayList<String> getTypeIds() throws SQLException {
        return ticketDao.getTypeIds();
    }

    TicketDao ticketDao = (TicketDao) DaoFactory.getInstance().getSuperDao(DaoFactory.daoType.Ticket);
    TicketDetailsDao ticketDetailsDao = (TicketDetailsDao) DaoFactory.getInstance().getSuperDao(DaoFactory.daoType.TicketDetails);
    /**
     * @param dto
     * @return
     * @throws SQLException
     */
    @Override
    public boolean add(TicketDto dto) throws SQLException {
        Connection connection = null;
        boolean result = false;
        connection = DBConnection.getInstance().getConnection();
        connection.setAutoCommit(false);

        boolean isadd = ticketDao.add(new Ticket(dto.getTicketCode(),dto.getVisitorId(),dto.getType(),dto.getDate(),dto.getQty(),dto.getAmount(),dto.getPaymentType()));
        if (!isadd) {
            throw new SQLException("create ticket failed");
        }
        boolean isReduse = ticketDetailsDao.reduseTicketDetails(new Ticket(dto.getTicketCode(),dto.getVisitorId(),dto.getType(),dto.getDate(),dto.getQty(),dto.getAmount(),dto.getPaymentType()));
        if (!isReduse) {
            throw new SQLException("reduse ticket failed");
        }

        connection.commit();
        result = true;

        if (connection != null) {
            connection.setAutoCommit(true);
        }

        return result;
    }

    /**
     * @param dto
     * @return
     * @throws SQLException
     */
    @Override
    public boolean update(TicketDto dto) throws SQLException {

    return ticketDao.update(new Ticket(dto.getTicketCode(),dto.getVisitorId(),dto.getType(),dto.getDate(),dto.getQty(),dto.getAmount(),dto.getPaymentType()));}

    /**
     * @param dto
     * @return
     * @throws SQLException
     */
    @Override
    public boolean delete(TicketDto dto) throws SQLException {
        Connection connection = null;
        boolean result = false;
        connection = DBConnection.getInstance().getConnection();
        connection.setAutoCommit(false);

        boolean isdelete = ticketDao.delete(new Ticket(dto.getTicketCode(),dto.getVisitorId(),dto.getType(),dto.getDate(),dto.getQty(),dto.getAmount(),dto.getPaymentType()));
        if (!isdelete) {
            throw new SQLException("delete ticket failed");
        }
        boolean isaddqty = ticketDetailsDao.addqty(new Ticket(dto.getTicketCode(),dto.getVisitorId(),dto.getType(),dto.getDate(),dto.getQty(),dto.getAmount(),dto.getPaymentType()));
        if (!isaddqty) {
            throw new SQLException("add qty failed");
        }

        connection.commit();
        result = true;

        if (connection != null) {
            connection.setAutoCommit(true);
        }
        return result;
    }

    /**
     * @return
     * @throws SQLException
     */
    @Override
    public ArrayList<TicketDto> getAll() throws SQLException {
        ArrayList<TicketDto> tickets = new ArrayList<>();
        ArrayList<Ticket> all = ticketDao.getAll();
        for (Ticket ticket : all) {
            tickets.add(new TicketDto(ticket.getTicketCode(),ticket.getVisitorId(),ticket.getType(),ticket.getDate(),ticket.getQty(),ticket.getAmount(),ticket.getPaymentType()));
        }
        return tickets;
    }

    /**
     * @return
     * @throws SQLException
     */
    @Override
    public String getNextId() throws SQLException {
        return ticketDao.getNextId();
    }
}
