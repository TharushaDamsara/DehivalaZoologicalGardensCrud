package edu.ijjse.dehivalazoomanagemetsystem.bo.custom;

import edu.ijjse.dehivalazoomanagemetsystem.bo.SuperBo;
import edu.ijjse.dehivalazoomanagemetsystem.entity.dto.Animal;

import java.sql.SQLException;
import java.util.ArrayList;

public interface AnimalMngBo extends SuperBo {
    public boolean add(Animal dto) throws SQLException;
    public boolean update(Animal dto) throws SQLException;
    public boolean delete(Animal dto) throws SQLException;
    public ArrayList<Animal> getAll() throws SQLException;
    public String getNextId() throws SQLException;
}

