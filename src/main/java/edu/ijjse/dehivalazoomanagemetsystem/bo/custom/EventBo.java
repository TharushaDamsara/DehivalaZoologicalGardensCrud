package edu.ijjse.dehivalazoomanagemetsystem.bo.custom;

import edu.ijjse.dehivalazoomanagemetsystem.bo.SuperBo;
import edu.ijjse.dehivalazoomanagemetsystem.dto.EventDto;

import java.sql.SQLException;
import java.util.ArrayList;

public interface EventBo extends SuperBo {
    public boolean add(EventDto dto) throws SQLException;
    public boolean update(EventDto dto) throws SQLException;
    public boolean delete(EventDto dto) throws SQLException;
    public ArrayList<EventDto> getAll() throws SQLException;
    public String getNextId() throws SQLException;
}

