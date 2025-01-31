package edu.ijjse.dehivalazoomanagemetsystem.bo.custom;

import edu.ijjse.dehivalazoomanagemetsystem.bo.SuperBo;
import edu.ijjse.dehivalazoomanagemetsystem.dao.CrudDao;
import edu.ijjse.dehivalazoomanagemetsystem.model.dto.AnimalMngDto;

import java.sql.SQLException;
import java.util.ArrayList;

public interface AnimalMngBo extends SuperBo {
    public boolean add(AnimalMngDto dto) throws SQLException;
    public boolean update(AnimalMngDto dto) throws SQLException;
    public boolean delete(AnimalMngDto dto) throws SQLException;
    public ArrayList<AnimalMngDto> getAll() throws SQLException;
    public String getNextId() throws SQLException;
}

