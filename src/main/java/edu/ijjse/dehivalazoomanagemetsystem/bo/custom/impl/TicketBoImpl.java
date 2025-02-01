package edu.ijjse.dehivalazoomanagemetsystem.bo.custom.impl;

import edu.ijjse.dehivalazoomanagemetsystem.bo.custom.TicketBo;
import edu.ijjse.dehivalazoomanagemetsystem.dao.DaoFactory;
import edu.ijjse.dehivalazoomanagemetsystem.dao.custom.TicketDao;
import edu.ijjse.dehivalazoomanagemetsystem.entity.dto.Ticket;

import java.sql.SQLException;
import java.util.ArrayList;

public class TicketBoImpl implements TicketBo {
    TicketDao ticketDao = (TicketDao) DaoFactory.getInstance().getSuperDao(DaoFactory.daoType.Ticket);
    /**
     * @param dto
     * @return
     * @throws SQLException
     */
    @Override
    public boolean add(Ticket dto) throws SQLException {
        return false;
    }

    /**
     * @param dto
     * @return
     * @throws SQLException
     */
    @Override
    public boolean update(Ticket dto) throws SQLException {
        return false;
    }

    /**
     * @param dto
     * @return
     * @throws SQLException
     */
    @Override
    public boolean delete(Ticket dto) throws SQLException {
        return false;
    }

    /**
     * @return
     * @throws SQLException
     */
    @Override
    public ArrayList<Ticket> getAll() throws SQLException {
        return null;
    }

    /**
     * @return
     * @throws SQLException
     */
    @Override
    public String getNextId() throws SQLException {
        return "";
    }
}
