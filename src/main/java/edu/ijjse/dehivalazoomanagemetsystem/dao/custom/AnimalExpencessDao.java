package edu.ijjse.dehivalazoomanagemetsystem.dao.custom;

import edu.ijjse.dehivalazoomanagemetsystem.dao.CrudDao;
import edu.ijjse.dehivalazoomanagemetsystem.dto.AnimalExpencesDto;

import java.sql.SQLException;
import java.util.ArrayList;

public interface AnimalExpencessDao extends CrudDao<AnimalExpencesDto> {
    public ArrayList<String> getAnimalIds() throws SQLException;
    }
