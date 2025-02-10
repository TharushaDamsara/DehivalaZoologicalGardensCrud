package edu.ijjse.dehivalazoomanagemetsystem.bo.custom;

import edu.ijjse.dehivalazoomanagemetsystem.bo.SuperBo;
import edu.ijjse.dehivalazoomanagemetsystem.dto.TickDetailsDto;

import java.sql.SQLException;
import java.util.ArrayList;

public interface TicketDetailsBo extends SuperBo {

    public boolean add(TickDetailsDto dto) throws SQLException;
    public boolean update(TickDetailsDto dto) throws SQLException;
    public boolean delete(TickDetailsDto dto) throws SQLException;
    public ArrayList<TickDetailsDto> getAll() throws SQLException;
    public String getNextId() throws SQLException;
}
