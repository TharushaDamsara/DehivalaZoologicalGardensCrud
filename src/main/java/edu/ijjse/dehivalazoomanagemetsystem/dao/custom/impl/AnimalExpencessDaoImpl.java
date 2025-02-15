package edu.ijjse.dehivalazoomanagemetsystem.dao.custom.impl;

import edu.ijjse.dehivalazoomanagemetsystem.dao.custom.AnimalExpencessDao;
import edu.ijjse.dehivalazoomanagemetsystem.dto.AnimalExpencesDto;
import edu.ijjse.dehivalazoomanagemetsystem.dao.utill.CrudUtil;
import edu.ijjse.dehivalazoomanagemetsystem.entity.AnimalExpences;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AnimalExpencessDaoImpl implements AnimalExpencessDao {

    @Override
    public boolean add(AnimalExpences dto) throws SQLException {
        String sql = "insert into animalexpencess values(?,?,?,?,?)";
        return CrudUtil.execute(sql,dto.getAnimalExpencesId(),dto.getAnimalId(),dto.getAmount(),dto.getDiscription(),dto.getDate());
    }
    @Override
    public boolean update(AnimalExpences dto) throws SQLException {
        String sql ="UPDATE animalexpencess SET animalId =?, amount=?,description=?,date=? WHERE expenceld =?";
        return CrudUtil.execute(sql,dto.getAnimalId(),dto.getAmount(),dto.getDiscription(),dto.getDate(),dto.getAnimalExpencesId());
    }
    @Override
    public boolean delete(AnimalExpences dto) throws SQLException {
        String sql = "delete from animalexpencess where expenceld =?";
        return CrudUtil.execute(sql,dto.getAnimalExpencesId());
    }
    @Override
    public ArrayList<AnimalExpences> getAll() throws SQLException {
        String sql = "select * from animalexpencess";
        ResultSet rst = CrudUtil.execute(sql);

        ArrayList<AnimalExpences> animalExpenceDtos = new ArrayList<>();
        while(rst.next()){
            AnimalExpences dto = new AnimalExpences(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getDouble(3),
                    rst.getString(4),
                    rst.getString(5)
            );
            animalExpenceDtos.add(dto);
        }

        return animalExpenceDtos;
    }
@Override
    public String getNextId() throws SQLException {
        String sql= "select expenceld from animalexpencess order by expenceld desc limit 1";
       ResultSet rst = CrudUtil.execute(sql);
       if(rst.next()){
           String lastId = rst.getString(1);
           String substring = lastId.substring(1);
           int i = Integer.parseInt(substring);
           int newIndex = i + 1;
           return String.format("X%03d", newIndex);
       }
        return "X001";
    }
    @Override
    public ArrayList<String> getAnimalIds() throws SQLException{
        String sql = "select animalId from animal";
        ResultSet rst = CrudUtil.execute(sql);
        ArrayList<String> animalIds = new ArrayList<>();
        while(rst.next()){
            animalIds.add(rst.getString(1));
        }
        return animalIds;
    }
}
