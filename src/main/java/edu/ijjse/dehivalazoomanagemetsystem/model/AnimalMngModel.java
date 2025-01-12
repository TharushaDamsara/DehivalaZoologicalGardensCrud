package edu.ijjse.dehivalazoomanagemetsystem.model;

import edu.ijjse.dehivalazoomanagemetsystem.dto.AnimalMngDto;
import edu.ijjse.dehivalazoomanagemetsystem.utill.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AnimalMngModel {
    public boolean add(AnimalMngDto dto) throws SQLException {
    String sql = "insert into animal values(?,?,?,?,?,?,?)";
        return CrudUtil.execute(sql,
                dto.getAnimalId(),
                dto.getAnimalName(),
                dto.getAnimalAge(),
                dto.getAnimalGender(),
                dto.getCatagory(),
                dto.getEnclosureId(),
                dto.getDivisionId()
        );
    }
    public boolean update(AnimalMngDto dto) throws SQLException {
        String sql = "update animal set name=?,age=?,gender=?,category=?,enclosureId=?,divisionId=? where animalId=?";

        return CrudUtil.execute(sql,
                dto.getAnimalName(),
                dto.getAnimalAge(),
                dto.getAnimalGender(),
                dto.getCatagory(),
                dto.getEnclosureId(),
                dto.getDivisionId(),
                dto.getAnimalId()
                );
    }
    public boolean delete(AnimalMngDto dto) throws SQLException {
        String sql = "delete from animal where animalId=?";
        return CrudUtil.execute(sql,dto.getAnimalId());
    }
    public ArrayList<AnimalMngDto> getAll() throws SQLException {
        String sql = "select * from animal";
        ResultSet rst = CrudUtil.execute(sql);
        ArrayList<AnimalMngDto> dtos = new ArrayList<AnimalMngDto>();
        while (rst.next()) {
            AnimalMngDto dto = new AnimalMngDto(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getDouble(3),
                    rst.getString(4),
                    rst.getString(5),
                    rst.getString(6),
                    rst.getString(7)
            );
            dtos.add(dto);
        }
        return dtos;
    }
//    public AnimalMngDto findById(int id) throws SQLException {
//        String sql = "select * from animal where id=?";
//        ResultSet rst = CrudUtil.execute(sql,id);
//        AnimalMngDto dto = new AnimalMngDto(
//                rst.getString(1),
//                rst.getString(2),
//                rst.getDouble(3),
//                rst.getString(4),
//                rst.getString(5),
//                rst.getString(6)
//        );
//        return dto;
//    }

    public String getNextAnimalId() throws SQLException {
        String sql = "select animalId from animal order by animalId desc limit 1";
        ResultSet rst = CrudUtil.execute(sql);
        if (rst.next()) {
            String lastId = rst.getString(1);
            String substring = lastId.substring(1);
            int i = Integer.parseInt(substring);
            int newIndex =i+1;
            return String.format("A%03d", newIndex);

        }
        return "A001";
    }
    public ArrayList<String> getEnclosure() throws SQLException {
        String sql = "select enclosureId from enclosure";
        ResultSet rst = CrudUtil.execute(sql);
        ArrayList<String> enclosures = new ArrayList<>();
        while (rst.next()) {
            enclosures.add(rst.getString(1));
        }
        return enclosures;
    }
    public ArrayList<String> getDivision() throws SQLException {
        String sql = "select divisionId from division";
        ResultSet rst = CrudUtil.execute(sql);
        ArrayList<String> divisions = new ArrayList<>();
        while (rst.next()) {
            divisions.add(rst.getString(1));
        }
        return divisions;
    }
}
