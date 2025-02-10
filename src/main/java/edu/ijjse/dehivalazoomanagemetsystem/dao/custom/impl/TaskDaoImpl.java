package edu.ijjse.dehivalazoomanagemetsystem.dao.custom.impl;

import edu.ijjse.dehivalazoomanagemetsystem.dao.custom.TaskDao;
import edu.ijjse.dehivalazoomanagemetsystem.dto.TaskDto;
import edu.ijjse.dehivalazoomanagemetsystem.dao.utill.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TaskDaoImpl implements TaskDao {
    public boolean add(TaskDto dto) throws SQLException {
        String sql = "insert into task values(?,?,?,?)";
        return CrudUtil.execute(sql,dto.getTaskId(),dto.getEmpId(),dto.getTaskName(),dto.getDueDate());
    }
    public boolean update(TaskDto dto) throws SQLException {
        String sql = "update task set empId =?,taskName=?,dueDate=? where taskId=?";
        return CrudUtil.execute(sql,dto.getEmpId(),dto.getTaskName(),dto.getDueDate(),dto.getTaskId());
    }
    public boolean delete(TaskDto dto) throws SQLException {
        String sql = "delete from task where taskId=?";
        return CrudUtil.execute(sql,dto.getTaskId());
    }
    public ArrayList<TaskDto> getAll() throws SQLException {
        String sql = "select * from task";
        ResultSet rst = CrudUtil.execute(sql);
        ArrayList<TaskDto> dtos = new ArrayList<>();
        while (rst.next()) {
            TaskDto dto = new TaskDto(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4)
            );
            dtos.add(dto);
        }
        return dtos;
    }
    public String getNextId() throws SQLException {
        String sql = "select taskId from task order by taskId desc limit 1";
        ResultSet rst = CrudUtil.execute(sql);
        if (rst.next()) {
            String index = rst.getString(1);
            String substring = index.substring(1);
            int i = Integer.parseInt(substring);
            int newId = i + 1;
            return String.format("T%03d", newId);
        }
        return "T001";
    }
    public ArrayList<String> getEmployeeIds() throws SQLException {
        String sql = "select empId from employee";
        ResultSet rst = CrudUtil.execute(sql);
        ArrayList<String> employees = new ArrayList<>();
        while (rst.next()) {
            employees.add(rst.getString(1));
        }
        return employees;
    }
}
