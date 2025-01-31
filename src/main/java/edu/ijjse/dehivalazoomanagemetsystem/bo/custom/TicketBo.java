package edu.ijjse.dehivalazoomanagemetsystem.bo.custom;

import edu.ijjse.dehivalazoomanagemetsystem.bo.SuperBo;
import edu.ijjse.dehivalazoomanagemetsystem.dao.CrudDao;
import edu.ijjse.dehivalazoomanagemetsystem.model.dto.TicketDto;

import java.sql.SQLException;
import java.util.ArrayList;

public interface TicketBo extends SuperBo {
    public boolean add(TicketDto dto) throws SQLException;
    public boolean update(TicketDto dto) throws SQLException;
    public boolean delete(TicketDto dto) throws SQLException;
    public ArrayList<TicketDto> getAll() throws SQLException;
    public String getNextId() throws SQLException;
}
