package edu.ijjse.dehivalazoomanagemetsystem.bo.custom;

import edu.ijjse.dehivalazoomanagemetsystem.bo.SuperBo;
import edu.ijjse.dehivalazoomanagemetsystem.entity.dto.Task;

import java.sql.SQLException;
import java.util.ArrayList;

public interface TaskBo extends SuperBo {
    public ArrayList<String> getEmployeeIds() throws SQLException;
    public boolean add(Task dto) throws SQLException;
    public boolean update(Task dto) throws SQLException;
    public boolean delete(Task dto) throws SQLException;
    public ArrayList<Task> getAll() throws SQLException;
    public String getNextId() throws SQLException;
}
