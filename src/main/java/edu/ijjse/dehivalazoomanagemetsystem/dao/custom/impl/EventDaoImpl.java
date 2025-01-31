package edu.ijjse.dehivalazoomanagemetsystem.dao.custom.impl;

import edu.ijjse.dehivalazoomanagemetsystem.dao.custom.EventDao;
import edu.ijjse.dehivalazoomanagemetsystem.model.dto.EventDto;
import edu.ijjse.dehivalazoomanagemetsystem.dao.utill.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EventDaoImpl implements EventDao {
public boolean add(EventDto dto) throws SQLException {
    String sql = "insert into event values(?,?,?,?)";

    return CrudUtil.execute(sql,
            dto.getEventId(),
            dto.getEventName(),
            dto.getEventLocation(),
            dto.getEventDate()
        );
    }
    public boolean update(EventDto dto) throws SQLException {
    String sql ="update event set name=?,location=?,date=? where eventId=?";
        return CrudUtil.execute(sql,
                dto.getEventName(),
                dto.getEventLocation(),
                dto.getEventDate(),
                dto.getEventId()
        );
    }
    public boolean delete(EventDto dto) throws SQLException {
    String sql = "delete from event where eventId=?";
        return CrudUtil.execute(sql, dto.getEventId());
    }
    public ArrayList<EventDto> getAll() throws SQLException {
    String sql = "select * from event";
    ResultSet rst = CrudUtil.execute(sql);
    ArrayList<EventDto> dtos = new ArrayList<>();
    while (rst.next()) {
        EventDto dto = new EventDto(
                rst.getString(1),
                rst.getString(2),
                rst.getString(3),
                rst.getString(4)
        );
        dtos.add(dto);
    }
    return dtos;
    }
    public String getNextId() throws SQLException {
        String sql = "select eventid from event order by eventid desc limit 1";
        ResultSet rst = CrudUtil.execute(sql);
        if (rst.next()) {
            String index = rst.getString(1);
            String substring = index.substring(1);
            int i = Integer.parseInt(substring);
            int newId = i + 1;
            System.out.println(newId);
            return String.format("EV%03d", newId);
        }
        return "EV001";
    }

}
