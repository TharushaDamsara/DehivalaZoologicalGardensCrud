package edu.ijjse.dehivalazoomanagemetsystem.dao.custom;

import edu.ijjse.dehivalazoomanagemetsystem.dao.CrudDao;
import edu.ijjse.dehivalazoomanagemetsystem.dto.AnimalDto;
import edu.ijjse.dehivalazoomanagemetsystem.entity.Animal;

import java.sql.SQLException;
import java.util.ArrayList;

public interface AnimalMngDao extends CrudDao<Animal>{
    public ArrayList<String> getDivision() throws SQLException;
    public ArrayList<String> getEnclosure() throws SQLException;

}
