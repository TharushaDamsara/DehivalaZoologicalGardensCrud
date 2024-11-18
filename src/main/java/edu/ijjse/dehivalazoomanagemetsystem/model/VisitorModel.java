package edu.ijjse.dehivalazoomanagemetsystem.model;

import edu.ijjse.dehivalazoomanagemetsystem.dto.VisitorDto;
import edu.ijjse.dehivalazoomanagemetsystem.utill.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class VisitorModel {
    public boolean add(VisitorDto dto) throws SQLException {
        String sql ="insert into visitor values(?,?,?,?,?,?)";
        return CrudUtil.execute(sql,
                dto.getVisitorId(),
                dto.getVisitorName(),
                dto.getVisitorAddress(),
                dto.getVisitDate(),
                dto.getVisitNic(),
                dto.getTicketId()
        );
    }
    public boolean update(VisitorDto dto) throws SQLException {
        String sql ="UPDATE visitor SET name=? ,address=?,date=?,nic=?,ticketId =? WHERE visitorId =?";
        return CrudUtil.execute(sql,
                dto.getVisitorName(),
                dto.getVisitorAddress(),
                dto.getVisitDate(),
                dto.getVisitNic(),
                dto.getVisitorId(),
                dto.getTicketId());
    }
    public boolean delete(VisitorDto dto) throws SQLException {
        String sql ="DELETE FROM visitor WHERE visitorId =?";
        return CrudUtil.execute(sql,dto.getVisitorId());
    }
    public ArrayList<VisitorDto> getAll() throws SQLException {
        ArrayList<VisitorDto> visitorDtos = new ArrayList<>();
        String sql ="select * from visitor";
        ResultSet rst  = CrudUtil.execute(sql);
        while (rst.next()) {
            VisitorDto visitorDto = new VisitorDto(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getString(5),
                    rst.getString(6)
            );
            visitorDtos.add(visitorDto);
        }
        return visitorDtos;
    }
    public String getnextId() throws SQLException {
    String sql ="select visitorId from visitor order by visitorId desc limit 1";
    ResultSet rst = CrudUtil.execute(sql);
    if (rst.next()) {
        String index = rst.getString(1);
        String substring = index.substring(1);
        int i = Integer.parseInt(substring);
        int newId = i + 1;
        return String.format("V%03d", newId);
    }
        return "V001";
    }

}
