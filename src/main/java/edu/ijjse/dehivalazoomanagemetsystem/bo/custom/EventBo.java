package edu.ijjse.dehivalazoomanagemetsystem.bo.custom;

import edu.ijjse.dehivalazoomanagemetsystem.bo.SuperBo;
import edu.ijjse.dehivalazoomanagemetsystem.entity.dto.Event;

import java.sql.SQLException;
import java.util.ArrayList;

public interface EventBo extends SuperBo {
    public boolean add(Event dto) throws SQLException;
    public boolean update(Event dto) throws SQLException;
    public boolean delete(Event dto) throws SQLException;
    public ArrayList<Event> getAll() throws SQLException;
    public String getNextId() throws SQLException;
}

