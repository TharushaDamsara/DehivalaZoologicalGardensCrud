package edu.ijjse.dehivalazoomanagemetsystem.dao.custom.impl;

import edu.ijjse.dehivalazoomanagemetsystem.dao.custom.DevisionDao;
import edu.ijjse.dehivalazoomanagemetsystem.model.dto.DevisionDto;
import edu.ijjse.dehivalazoomanagemetsystem.dao.utill.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DevisionDaoImpl implements DevisionDao {
    public boolean add(DevisionDto dto) throws SQLException {
        String sql = "insert into division values(?,?,?)";
        return CrudUtil.execute(sql,dto.getDevisionId(),dto.getDevisionName(),dto.getDevisionDescription());
    }
    public boolean update(DevisionDto dto) throws SQLException {
        String sql ="UPDATE division SET name=?,description=? WHERE divisionId=?";
        return CrudUtil.execute(sql,dto.getDevisionName(),dto.getDevisionDescription(),dto.getDevisionId());
    }
    public boolean delete(DevisionDto dto) throws SQLException {
        String sql = "delete from division where divisionId=?";
        return CrudUtil.execute(sql,dto.getDevisionId());
    }
    public ArrayList<DevisionDto> getAll() throws SQLException {
        String sql = "select * from division";
        ResultSet rst = CrudUtil.execute(sql);
        ArrayList<DevisionDto> dtos = new ArrayList<>();
        while (rst.next()) {
            DevisionDto dto = new DevisionDto(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3)
            );
            dtos.add(dto);
        }
        return dtos;
    }
    public String getNextId() throws SQLException {
        String sql = "select divisionId from division order by divisionId desc limit 1";
        ResultSet rst = CrudUtil.execute(sql);
        if (rst.next()) {
            String index = rst.getString(1);
            String substring = index.substring(1);
            int i = Integer.parseInt(substring);
            int newId = i + 1;
            return String.format("D%03d", newId);

        }
        return "D001";
    }
}
