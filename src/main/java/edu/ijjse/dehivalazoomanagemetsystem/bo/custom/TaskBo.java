package edu.ijjse.dehivalazoomanagemetsystem.bo.custom;

import edu.ijjse.dehivalazoomanagemetsystem.bo.SuperBo;
import edu.ijjse.dehivalazoomanagemetsystem.dao.CrudDao;
import edu.ijjse.dehivalazoomanagemetsystem.model.dto.TaskDto;

import java.sql.SQLException;
import java.util.ArrayList;

public interface TaskBo extends SuperBo {
    public ArrayList<String> getEmployeeIds() throws SQLException;
    public boolean add(TaskDto dto) throws SQLException;
    public boolean update(TaskDto dto) throws SQLException;
    public boolean delete(TaskDto dto) throws SQLException;
    public ArrayList<TaskDto> getAll() throws SQLException;
    public String getNextId() throws SQLException;
}
