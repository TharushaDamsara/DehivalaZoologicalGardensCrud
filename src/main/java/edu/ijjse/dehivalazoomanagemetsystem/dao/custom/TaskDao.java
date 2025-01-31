package edu.ijjse.dehivalazoomanagemetsystem.dao.custom;

import edu.ijjse.dehivalazoomanagemetsystem.dao.CrudDao;
import edu.ijjse.dehivalazoomanagemetsystem.model.dto.TaskDto;

import java.sql.SQLException;
import java.util.ArrayList;

public interface TaskDao extends CrudDao<TaskDto> {
    public ArrayList<String> getEmployeeIds() throws SQLException;
}
