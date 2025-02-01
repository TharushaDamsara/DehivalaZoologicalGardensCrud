package edu.ijjse.dehivalazoomanagemetsystem.dao.custom.impl;

import edu.ijjse.dehivalazoomanagemetsystem.dao.custom.EncloserDao;
import edu.ijjse.dehivalazoomanagemetsystem.entity.dto.Encloser;
import edu.ijjse.dehivalazoomanagemetsystem.dao.utill.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EncloserDaoImpl implements EncloserDao {
    public boolean add(Encloser dto) throws SQLException {
        String sql = "insert into enclosure values(?,?,?)";

        return CrudUtil.execute(sql,dto.getId(),dto.getLocation(),dto.getSize());
    }
    public boolean update(Encloser dto) throws SQLException {
        String sql = "update enclosure set location=?,size=? where enclosureId =?";
        return CrudUtil.execute(sql,dto.getLocation(),dto.getSize(),dto.getId());
    }
    public boolean delete(Encloser dto) throws SQLException {
  String sql = "delete from enclosure where enclosureId =?";
  return CrudUtil.execute(sql,dto.getId());
    }
    public ArrayList<Encloser> getAll() throws SQLException {
        String sql = "select * from enclosure";
        ResultSet rst = CrudUtil.execute(sql);
        ArrayList<Encloser> dtos = new ArrayList<>();
        while (rst.next()) {
            Encloser dto = new Encloser(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3));
                    dtos.add(dto);
        }
        return dtos;
    }
    public String getNextId() throws SQLException {
        String sql = "select enclosureId from enclosure order by enclosureId desc limit 1";
        ResultSet rst = CrudUtil.execute(sql);
        if (rst.next()) {
            String index = rst.getString(1);
            String substring = index.substring(1);
            int i = Integer.parseInt(substring);
            System.out.println(i);
            int newId = i + 1;
            System.out.println(newId);
            return String.format("L%03d", newId);
        }
        return "L001";
    }
}
