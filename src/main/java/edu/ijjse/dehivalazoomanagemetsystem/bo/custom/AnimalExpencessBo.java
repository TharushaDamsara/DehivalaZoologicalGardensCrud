package edu.ijjse.dehivalazoomanagemetsystem.bo.custom;

import edu.ijjse.dehivalazoomanagemetsystem.bo.SuperBo;
import edu.ijjse.dehivalazoomanagemetsystem.entity.dto.AnimalExpences;

import java.sql.SQLException;
import java.util.ArrayList;

public interface AnimalExpencessBo extends SuperBo {
    public ArrayList<String> getAnimalIds() throws SQLException;
    public boolean add(AnimalExpences dto) throws SQLException;
    public boolean update(AnimalExpences dto) throws SQLException;
    public boolean delete(AnimalExpences dto) throws SQLException;
    public ArrayList<AnimalExpences> getAll() throws SQLException;
    public String getNextId() throws SQLException;
}
