package edu.ijjse.dehivalazoomanagemetsystem.model;

import edu.ijjse.dehivalazoomanagemetsystem.dto.EmployeeExpencesDto;
import edu.ijjse.dehivalazoomanagemetsystem.utill.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmpExpencessModel {
    public boolean save(EmployeeExpencesDto dto) throws SQLException {
        String sql = "INSERT INTO payment VALUES (?,?,?,?,?,?,?)";
        return CrudUtil.execute(sql,
                dto.getPaymentId(),
                dto.getEmployeeId(),
                dto.getDate(),
                dto.getBasicSalary(),
                dto.getAddonSalary(),
                dto.getCutOffSalary(),
                dto.getTotalSalary()

        );
    }
    public boolean update(EmployeeExpencesDto dto) throws SQLException {
    String sql ="UPDATE payment SET date=?,totalSalary=?,basic=?,addons=?,cutoffs=?,emold=? WHERE paymetld=?";
        return CrudUtil.execute(sql,
                dto.getDate(),
                dto.getTotalSalary(),
                dto.getBasicSalary(),
                dto.getAddonSalary(),
                dto.getCutOffSalary(),
                dto.getEmployeeId(),
                dto.getPaymentId()
                );
    }
    public boolean delete(EmployeeExpencesDto dto) throws SQLException {
        String sql = "delete from payment  where paymetld = ? ";
        return CrudUtil.execute(sql,dto.getPaymentId());
    }
    public ArrayList<EmployeeExpencesDto> viewAll() throws SQLException {

        String sql = "select * from payment ";
        ResultSet rst = CrudUtil.execute(sql);
        ArrayList<EmployeeExpencesDto> employees = new ArrayList<>();
        while (rst.next()) {
            EmployeeExpencesDto dto = new EmployeeExpencesDto(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getDouble(4),
                    rst.getDouble(5),
                    rst.getDouble(6),
                    rst.getDouble(7)
            );
            employees.add(dto);
        }
        return employees;
    }
    public String getnextId() throws SQLException {
        String sql = "select paymetld from payment order by paymetld desc limit 1";
        ResultSet rst = CrudUtil.execute(sql);
        if (rst.next()) {
            String payId = rst.getString(1);
            String substring = payId.substring(1);
            int i = Integer.parseInt(substring);
            int newId = i + 1;
            return String.format("P%03d", newId);
        }
        return "P001";
    }
}
