package edu.ijjse.dehivalazoomanagemetsystem.dao.custom.impl;

import edu.ijjse.dehivalazoomanagemetsystem.dao.custom.EmpMngDao;
import edu.ijjse.dehivalazoomanagemetsystem.dto.EmpMngDto;
import edu.ijjse.dehivalazoomanagemetsystem.dao.utill.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmpMngDaoImpl implements EmpMngDao {
    public boolean add(EmpMngDto dto) throws SQLException {

        String sql = "insert into employee values(?,?,?,?,?,?,?,?,?,?)";
      return   CrudUtil.execute(sql,
                dto.getEmpId(),
                dto.getEmpName(),
                dto.getEmpSalary(),
                dto.getEmpAddress(),
                dto.getDivisionId(),
                dto.getEmpAge(),
                dto.getEmpGender(),
                dto.getEmpBirth(),
                dto.getEmpJob(),
                dto.getEmpPhone()
                );
    }
    public boolean update(EmpMngDto dto) throws SQLException {
String sql ="UPDATE employee SET name =?,salary=?,address=?,divisionId=?,empAge=?,gender=?,empBirth=?,empJob=?,empContact=? WHERE empId=?";
        return CrudUtil.execute(sql,
                dto.getEmpName(),
                dto.getEmpSalary(),
                dto.getEmpAddress(),
                dto.getDivisionId(),
                dto.getEmpAge(),
                dto.getEmpGender(),
                dto.getEmpBirth(),
                dto.getEmpJob(),
                dto.getEmpPhone(),
                dto.getEmpId()
        );
    }
    public boolean delete(EmpMngDto dto) throws SQLException {
        String sql = "delete from employee where empId=?";
        return CrudUtil.execute(sql,dto.getEmpId());
    }
public ArrayList<EmpMngDto> getAll() throws SQLException {
        String sql = "select * from employee order by empId desc";
        ResultSet rst = CrudUtil.execute(sql);
        ArrayList<EmpMngDto> empMngDtos = new ArrayList<EmpMngDto>();
        while (rst.next()) {
            EmpMngDto empMngDto = new EmpMngDto(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getDouble(3),
                    rst.getString(4),
                    rst.getString(5),
                    rst.getInt(6),
                    rst.getString(7),
                    rst.getString(8),
                    rst.getString(9),
                    rst.getString(10)
            );
            empMngDtos.add(empMngDto);
        }
    return empMngDtos;
}
public String getNextId() throws SQLException {
    String sql = "select empId from employee order by empId desc limit 1";
    ResultSet rst =CrudUtil.execute(sql);
    if (rst.next()) {
        String empId = rst.getString(1);
        String substring = empId.substring(1);
        int i = Integer.parseInt(substring);
        int newId = i + 1;

        return String.format("E%03d", newId);
    }
    return "E001";
}
}
