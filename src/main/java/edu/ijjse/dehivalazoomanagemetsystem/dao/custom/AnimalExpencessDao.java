package edu.ijjse.dehivalazoomanagemetsystem.dao.custom;

import edu.ijjse.dehivalazoomanagemetsystem.dao.CrudDao;
import edu.ijjse.dehivalazoomanagemetsystem.entity.dto.AnimalExpences;

import java.sql.SQLException;
import java.util.ArrayList;

public interface AnimalExpencessDao extends CrudDao<AnimalExpences> {
    public ArrayList<String> getAnimalIds() throws SQLException;
    }
