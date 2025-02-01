package edu.ijjse.dehivalazoomanagemetsystem.bo.custom;

import edu.ijjse.dehivalazoomanagemetsystem.bo.SuperBo;
import edu.ijjse.dehivalazoomanagemetsystem.entity.dto.Ticket;

import java.sql.SQLException;
import java.util.ArrayList;

public interface TicketBo extends SuperBo {
    public boolean add(Ticket dto) throws SQLException;
    public boolean update(Ticket dto) throws SQLException;
    public boolean delete(Ticket dto) throws SQLException;
    public ArrayList<Ticket> getAll() throws SQLException;
    public String getNextId() throws SQLException;
}
