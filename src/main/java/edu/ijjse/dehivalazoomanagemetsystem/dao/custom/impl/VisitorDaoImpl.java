package edu.ijjse.dehivalazoomanagemetsystem.dao.custom.impl;

import edu.ijjse.dehivalazoomanagemetsystem.dao.custom.VisitorDao;
import edu.ijjse.dehivalazoomanagemetsystem.entity.dto.Visitor;
import edu.ijjse.dehivalazoomanagemetsystem.dao.utill.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class VisitorDaoImpl implements VisitorDao {
    public boolean add(Visitor dto) throws SQLException {
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
    public boolean update(Visitor dto) throws SQLException {
        String sql ="UPDATE visitor SET name=? ,address=?,date=?,nic=?,ticketId =? WHERE visitorId =?";
        return CrudUtil.execute(sql,
                dto.getVisitorName(),
                dto.getVisitorAddress(),
                dto.getVisitDate(),
                dto.getVisitNic(),
                dto.getTicketId(),
                dto.getVisitorId());
    }
    public boolean delete(Visitor dto) throws SQLException {
        String sql ="DELETE FROM visitor WHERE visitorId =?";
        return CrudUtil.execute(sql,dto.getVisitorId());
    }
    public ArrayList<Visitor> getAll() throws SQLException {
        ArrayList<Visitor> visitors = new ArrayList<>();
        String sql ="select * from visitor";
        ResultSet rst  = CrudUtil.execute(sql);
        while (rst.next()) {
            Visitor visitor = new Visitor(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getString(5),
                    rst.getString(6)
            );
            visitors.add(visitor);
        }
        return visitors;
    }
    public String getNextId() throws SQLException {
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
