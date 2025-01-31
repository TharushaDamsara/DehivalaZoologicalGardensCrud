package edu.ijjse.dehivalazoomanagemetsystem.bo.custom.impl;

import edu.ijjse.dehivalazoomanagemetsystem.bo.custom.TaskBo;
import edu.ijjse.dehivalazoomanagemetsystem.model.dto.TaskDto;

import java.sql.SQLException;
import java.util.ArrayList;

public class TaskBoImpl implements TaskBo {
    /**
     * @param dto
     * @return
     * @throws SQLException
     */
    @Override
    public boolean add(TaskDto dto) throws SQLException {
        return false;
    }

    /**
     * @return
     * @throws SQLException
     */
    @Override
    public ArrayList<String> getEmployeeIds() throws SQLException {
        return null;
    }

    /**
     * @param dto
     * @return
     * @throws SQLException
     */
    @Override
    public boolean update(TaskDto dto) throws SQLException {
        return false;
    }

    /**
     * @param dto
     * @return
     * @throws SQLException
     */
    @Override
    public boolean delete(TaskDto dto) throws SQLException {
        return false;
    }

    /**
     * @return
     * @throws SQLException
     */
    @Override
    public ArrayList<TaskDto> getAll() throws SQLException {
        return null;
    }

    /**
     * @return
     * @throws SQLException
     */
    @Override
    public String getNextId() throws SQLException {
        return "";
    }
}
