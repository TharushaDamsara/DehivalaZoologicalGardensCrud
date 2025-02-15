package edu.ijjse.dehivalazoomanagemetsystem.bo.custom.impl;

import edu.ijjse.dehivalazoomanagemetsystem.bo.custom.TaskBo;
import edu.ijjse.dehivalazoomanagemetsystem.dao.DaoFactory;
import edu.ijjse.dehivalazoomanagemetsystem.dao.custom.TaskDao;
import edu.ijjse.dehivalazoomanagemetsystem.dto.TaskDto;
import edu.ijjse.dehivalazoomanagemetsystem.entity.Task;

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
    public boolean add(TaskDto dto) throws SQLException {
        return taskDao.add(new Task(dto.getTaskId(),dto.getEmpId(),dto.getTaskName(),dto.getDueDate()));
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
    public boolean update(TaskDto dto) throws SQLException {
        return taskDao.update(new Task(dto.getTaskId(),dto.getEmpId(),dto.getTaskName(),dto.getDueDate()));
    }

    /**
     * @param dto
     * @return
     * @throws SQLException
     */
    @Override
    public boolean delete(TaskDto dto) throws SQLException {
        return taskDao.delete(new Task(dto.getTaskId(),dto.getEmpId(),dto.getTaskName(),dto.getDueDate()));
    }

    /**
     * @return
     * @throws SQLException
     */
    @Override
    public ArrayList<TaskDto> getAll() throws SQLException {
        ArrayList<TaskDto> taskDtos = new ArrayList<>();
        ArrayList<Task> tasks = taskDao.getAll();
        for (Task task : tasks) {
            taskDtos.add(new TaskDto(task.getTaskId(),task.getEmpId(),task.getTaskName(),task.getDueDate()));
        }
        return taskDtos;
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
