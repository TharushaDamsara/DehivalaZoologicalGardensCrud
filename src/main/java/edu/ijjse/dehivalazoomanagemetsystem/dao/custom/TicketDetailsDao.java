package edu.ijjse.dehivalazoomanagemetsystem.dao.custom;

import edu.ijjse.dehivalazoomanagemetsystem.dao.CrudDao;
import edu.ijjse.dehivalazoomanagemetsystem.dto.TickDetailsDto;
import edu.ijjse.dehivalazoomanagemetsystem.dto.TicketDto;

import java.sql.SQLException;

public interface TicketDetailsDao extends CrudDao<TickDetailsDto> {
    public boolean addqty(TicketDto dto) throws SQLException;
    public boolean reduseTicketDetails(TicketDto dto) throws SQLException;
}
