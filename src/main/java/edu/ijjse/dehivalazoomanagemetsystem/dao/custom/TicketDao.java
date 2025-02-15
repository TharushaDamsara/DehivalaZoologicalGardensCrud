package edu.ijjse.dehivalazoomanagemetsystem.dao.custom;

import edu.ijjse.dehivalazoomanagemetsystem.dao.CrudDao;
import edu.ijjse.dehivalazoomanagemetsystem.dto.TickDetailsDto;
import edu.ijjse.dehivalazoomanagemetsystem.dto.TicketDto;
import edu.ijjse.dehivalazoomanagemetsystem.entity.TickDetails;
import edu.ijjse.dehivalazoomanagemetsystem.entity.Ticket;

import java.sql.SQLException;
import java.util.ArrayList;

public interface TicketDao extends CrudDao<Ticket> {
    public TickDetails findById(String id) throws SQLException;
    public ArrayList<String> getVisitorId() throws SQLException;
    public ArrayList<String> getTypeIds() throws SQLException;
}
