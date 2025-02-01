package edu.ijjse.dehivalazoomanagemetsystem.dao.custom.impl;

import edu.ijjse.dehivalazoomanagemetsystem.dao.custom.VetDao;
import edu.ijjse.dehivalazoomanagemetsystem.entity.dto.Vet;
import edu.ijjse.dehivalazoomanagemetsystem.dao.utill.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class VetDaoImpl implements VetDao {
    public boolean add(Vet dto) throws SQLException {
    String sql = "insert into vet values(?,?,?,?)";
        return CrudUtil.execute(sql,dto.getVetId(),dto.getVetName(),dto.getVetAddress(),dto.getVetPhone());
    }
    public boolean update(Vet dto) throws SQLException {
        String sql ="update vet set vetName =?,address=?,tp=? where vetId =?";
        return CrudUtil.execute(sql,dto.getVetName(),dto.getVetAddress(),dto.getVetPhone(),dto.getVetId());
    }
    public boolean delete(Vet dto) throws SQLException {
        String sql = "delete from vet where vetId =?";
        return CrudUtil.execute(sql,dto.getVetId());
    }
    public ArrayList<Vet> getAll() throws SQLException {
        String sql = "select * from vet";
       ResultSet rst = CrudUtil.execute(sql);
       ArrayList<Vet> vets = new ArrayList<>();
       while(rst.next()){
           Vet vet = new Vet(
                   rst.getString(1),
                   rst.getString(2),
                   rst.getString(3),
                   rst.getString(4)
           );
           vets.add(vet);
       }
       return vets;
    }
    public String getNextId() throws SQLException {
    String sql = "select vetId from vet order by vetId desc limit 1";
    ResultSet rst = CrudUtil.execute(sql);
    if(rst.next()){
        String index = rst.getString(1);
        String substring = index.substring(1);
        int i = Integer.parseInt(substring);
        int newId = i + 1;
        return String.format("V%03d", newId);
    }
        return "V001";
    }

}
