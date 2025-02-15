package edu.ijjse.dehivalazoomanagemetsystem.dao.custom;

import edu.ijjse.dehivalazoomanagemetsystem.dao.CrudDao;
import edu.ijjse.dehivalazoomanagemetsystem.dto.TickDetailsDto;
import edu.ijjse.dehivalazoomanagemetsystem.dto.TicketDto;
import edu.ijjse.dehivalazoomanagemetsystem.entity.TickDetails;
import edu.ijjse.dehivalazoomanagemetsystem.entity.Ticket;

import java.sql.SQLException;

public interface TicketDetailsDao extends CrudDao<TickDetails> {
    public boolean addqty(Ticket dto) throws SQLException;
    public boolean reduseTicketDetails(Ticket dto) throws SQLException;
}
