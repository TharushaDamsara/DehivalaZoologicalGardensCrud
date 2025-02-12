package edu.ijjse.dehivalazoomanagemetsystem.dao.custom;

import edu.ijjse.dehivalazoomanagemetsystem.dao.CrudDao;
import edu.ijjse.dehivalazoomanagemetsystem.dto.TickDetailsDto;
import edu.ijjse.dehivalazoomanagemetsystem.dto.TicketDto;

import java.sql.SQLException;
import java.util.ArrayList;

public interface TicketDao extends CrudDao<TicketDto> {
    public TickDetailsDto findById(String id) throws SQLException;
    public ArrayList<String> getVisitorId() throws SQLException;
    public ArrayList<String> getTypeIds() throws SQLException;
}
