package edu.ijjse.dehivalazoomanagemetsystem.bo.custom;

import edu.ijjse.dehivalazoomanagemetsystem.bo.SuperBo;
import edu.ijjse.dehivalazoomanagemetsystem.dto.AnimalExpencesDto;

import java.sql.SQLException;
import java.util.ArrayList;

public interface AnimalExpencessBo extends SuperBo {
    public ArrayList<String> getAnimalIds() throws SQLException;
    public boolean add(AnimalExpencesDto dto) throws SQLException;
    public boolean update(AnimalExpencesDto dto) throws SQLException;
    public boolean delete(AnimalExpencesDto dto) throws SQLException;
    public ArrayList<AnimalExpencesDto> getAll() throws SQLException;
    public String getNextId() throws SQLException;
}
