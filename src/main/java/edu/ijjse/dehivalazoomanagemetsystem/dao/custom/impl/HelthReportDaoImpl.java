package edu.ijjse.dehivalazoomanagemetsystem.dao.custom.impl;

import edu.ijjse.dehivalazoomanagemetsystem.dao.custom.HelthReportDao;
import edu.ijjse.dehivalazoomanagemetsystem.model.dto.HelthReportDto;
import edu.ijjse.dehivalazoomanagemetsystem.dao.utill.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class HelthReportDaoImpl implements HelthReportDao {
    public boolean add(HelthReportDto dto) throws SQLException {
        String sql="INSERT INTO helthreport VALUES (?,?,?,?,?)";
        return CrudUtil.execute(sql,dto.getHelthReportId(),dto.getAnimalId(),dto.getVetId(),dto.getCondition(),dto.getDate());
    }
    public boolean update(HelthReportDto dto) throws SQLException {
        String sql ="UPDATE helthreport Set animald=?,vetId=?,Animalcondition=?,date=? WHERE helthReportid = ?";
        return CrudUtil.execute(sql,dto.getAnimalId(),dto.getVetId(),dto.getCondition(),dto.getDate(),dto.getHelthReportId());
    }
    public boolean delete(HelthReportDto dto) throws SQLException {
        String sql ="DELETE FROM helthreport WHERE helthReportid =?";
        return CrudUtil.execute(sql,dto.getHelthReportId());
    }
    public ArrayList<HelthReportDto> getAll() throws SQLException {
        String sql ="SELECT * FROM helthreport";
        ResultSet rst = CrudUtil.execute(sql);
        ArrayList<HelthReportDto> helthReportDtos = new ArrayList<>();
        while(rst.next()){
            HelthReportDto helthReportDto = new HelthReportDto(
            rst.getString(1),
            rst.getString(2),
            rst.getString(3),
            rst.getString(4),
            rst.getString(5));
            helthReportDtos.add(helthReportDto);
        }
        return helthReportDtos;
    }
    public String getNextId() throws SQLException {
        String sql ="select helthReportid from helthreport order by helthReportid desc limit 1";
        ResultSet rst = CrudUtil.execute(sql);
        if(rst.next()){
            String index = rst.getString(1);
            String substring = index.substring(1);
            int i = Integer.parseInt(substring);
            int newId = i + 1;
            return String.format("H%03d", newId);
        }
        return "H001";
    }
    public ArrayList<String> getAnimalId() throws SQLException {
        String sql ="select animalId from animal";
        ResultSet rst = CrudUtil.execute(sql);
        ArrayList<String> animalIds = new ArrayList<>();
        while(rst.next()){
            animalIds.add(rst.getString(1));

        }
        return animalIds;
    }
    public ArrayList<String> getVetId() throws SQLException {
        String sql ="select vetId from vet";
        ResultSet rst = CrudUtil.execute(sql);
        ArrayList<String> vetIds = new ArrayList<>();
        while(rst.next()){
            vetIds.add(rst.getString(1));
        }
        return vetIds;
    }
}
