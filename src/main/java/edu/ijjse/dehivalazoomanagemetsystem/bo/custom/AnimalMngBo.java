package edu.ijjse.dehivalazoomanagemetsystem.bo.custom;

import edu.ijjse.dehivalazoomanagemetsystem.bo.SuperBo;
import edu.ijjse.dehivalazoomanagemetsystem.dto.AnimalDto;

import java.sql.SQLException;
import java.util.ArrayList;

public interface AnimalMngBo extends SuperBo {
    public boolean add(AnimalDto dto) throws SQLException;
    public boolean update(AnimalDto dto) throws SQLException;
    public boolean delete(AnimalDto dto) throws SQLException;
    public ArrayList<AnimalDto> getAll() throws SQLException;
    public String getNextId() throws SQLException;
    public ArrayList<String> getDivision() throws SQLException;
    public ArrayList<String> getEnclosure() throws SQLException;
}

