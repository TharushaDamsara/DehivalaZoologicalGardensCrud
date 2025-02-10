package edu.ijjse.dehivalazoomanagemetsystem.bo.custom;

import edu.ijjse.dehivalazoomanagemetsystem.bo.SuperBo;
import edu.ijjse.dehivalazoomanagemetsystem.dto.TickDetailsDto;
import edu.ijjse.dehivalazoomanagemetsystem.dto.TicketDto;

import java.sql.SQLException;
import java.util.ArrayList;

public interface TicketBo extends SuperBo {
    public boolean add(TicketDto dto) throws SQLException;
    public boolean update(TicketDto dto) throws SQLException;
    public boolean delete(TicketDto dto) throws SQLException;
    public ArrayList<TicketDto> getAll() throws SQLException;
    public String getNextId() throws SQLException;
    public TickDetailsDto findById(String id) throws SQLException;
    public ArrayList<String> getVisitorId() throws SQLException;
    public ArrayList<String> getTypeIds() throws SQLException;
}
