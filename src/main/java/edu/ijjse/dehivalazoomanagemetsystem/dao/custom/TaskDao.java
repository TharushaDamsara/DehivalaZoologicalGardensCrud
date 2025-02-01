package edu.ijjse.dehivalazoomanagemetsystem.dao.custom;

import edu.ijjse.dehivalazoomanagemetsystem.dao.CrudDao;
import edu.ijjse.dehivalazoomanagemetsystem.entity.dto.Task;

import java.sql.SQLException;
import java.util.ArrayList;

public interface TaskDao extends CrudDao<Task> {
    public ArrayList<String> getEmployeeIds() throws SQLException;
}
