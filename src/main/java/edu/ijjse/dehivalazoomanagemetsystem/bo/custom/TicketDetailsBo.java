package edu.ijjse.dehivalazoomanagemetsystem.bo.custom;

import edu.ijjse.dehivalazoomanagemetsystem.bo.SuperBo;
import edu.ijjse.dehivalazoomanagemetsystem.entity.dto.TickDetails;

import java.sql.SQLException;
import java.util.ArrayList;

public interface TicketDetailsBo extends SuperBo {

    public boolean add(TickDetails dto) throws SQLException;
    public boolean update(TickDetails dto) throws SQLException;
    public boolean delete(TickDetails dto) throws SQLException;
    public ArrayList<TickDetails> getAll() throws SQLException;
    public String getNextId() throws SQLException;
}
