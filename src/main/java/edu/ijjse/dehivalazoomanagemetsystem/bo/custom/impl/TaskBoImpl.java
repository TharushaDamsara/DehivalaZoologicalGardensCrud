package edu.ijjse.dehivalazoomanagemetsystem.bo.custom.impl;

import edu.ijjse.dehivalazoomanagemetsystem.bo.custom.TaskBo;
import edu.ijjse.dehivalazoomanagemetsystem.dao.DaoFactory;
import edu.ijjse.dehivalazoomanagemetsystem.dao.custom.TaskDao;
import edu.ijjse.dehivalazoomanagemetsystem.entity.dto.Task;

import java.sql.SQLException;
import java.util.ArrayList;

public class TaskBoImpl implements TaskBo {
    TaskDao taskDao = (TaskDao) DaoFactory.getInstance().getSuperDao(DaoFactory.daoType.Task);
    /**
     * @param dto
     * @return
     * @throws SQLException
     */
    @Override
    public boolean add(Task dto) throws SQLException {
        return taskDao.add(dto);
    }

    /**
     * @return
     * @throws SQLException
     */
    @Override
    public ArrayList<String> getEmployeeIds() throws SQLException {
        return taskDao.getEmployeeIds();
    }

    /**
     * @param dto
     * @return
     * @throws SQLException
     */
    @Override
    public boolean update(Task dto) throws SQLException {
        return taskDao.update(dto);
    }

    /**
     * @param dto
     * @return
     * @throws SQLException
     */
    @Override
    public boolean delete(Task dto) throws SQLException {
        return taskDao.delete(dto);
    }

    /**
     * @return
     * @throws SQLException
     */
    @Override
    public ArrayList<Task> getAll() throws SQLException {
        return taskDao.getAll();
    }

    /**
     * @return
     * @throws SQLException
     */
    @Override
    public String getNextId() throws SQLException {
        return taskDao.getNextId();
    }
}
