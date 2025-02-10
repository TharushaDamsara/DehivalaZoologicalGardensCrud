package edu.ijjse.dehivalazoomanagemetsystem.bo.custom.impl;

import edu.ijjse.dehivalazoomanagemetsystem.bo.custom.TicketBo;
import edu.ijjse.dehivalazoomanagemetsystem.dao.DaoFactory;
import edu.ijjse.dehivalazoomanagemetsystem.dao.custom.TicketDao;
import edu.ijjse.dehivalazoomanagemetsystem.db.DBConnection;
import edu.ijjse.dehivalazoomanagemetsystem.dto.TickDetailsDto;
import edu.ijjse.dehivalazoomanagemetsystem.dto.TicketDto;

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
        return ticketDao.findById(id);
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

        boolean isadd = ticketDao.add(dto);
        if (!isadd) {
            throw new SQLException("create ticket failed");
        }
        boolean isReduse = ticketDao.reduseTicketDetails(dto);
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

    return ticketDao.update(dto);}

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

        boolean isdelete = ticketDao.delete(dto);
        if (!isdelete) {
            throw new SQLException("delete ticket failed");
        }
        boolean isaddqty = ticketDao.addqty(dto);
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
        return ticketDao.getAll();
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
