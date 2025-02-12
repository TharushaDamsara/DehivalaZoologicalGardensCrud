package edu.ijjse.dehivalazoomanagemetsystem.dao.custom.impl;

import edu.ijjse.dehivalazoomanagemetsystem.dao.custom.TicketDetailsDao;
import edu.ijjse.dehivalazoomanagemetsystem.dto.TickDetailsDto;
import edu.ijjse.dehivalazoomanagemetsystem.dao.utill.CrudUtil;
import edu.ijjse.dehivalazoomanagemetsystem.dto.TicketDto;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TickDetailsDaoImpl implements TicketDetailsDao {
    public boolean add(TickDetailsDto dto) throws SQLException {
        String sql ="INSERT INTO ticketdetails VALUES (?,?,?,?)";
        return CrudUtil.execute(sql,dto.getId(),dto.getType(),dto.getQty(),dto.getPrice());
    }
    public boolean update(TickDetailsDto dto) throws SQLException {
        String sql ="UPDATE ticketdetails SET type=?,qty=?,price=? WHERE id =?";
        return  CrudUtil.execute(sql,dto.getType(),dto.getQty(),dto.getPrice(),dto.getId());
    }
    public boolean delete(TickDetailsDto dto) throws SQLException {
        String sql ="DELETE FROM ticketdetails WHERE id =?";
        return CrudUtil.execute(sql,dto.getId());
    }
    public ArrayList<TickDetailsDto> getAll() throws SQLException {
        String sql ="SELECT * FROM ticketdetails";
        ResultSet rst = CrudUtil.execute(sql);
        ArrayList<TickDetailsDto> dtos = new ArrayList<>();
        while(rst.next()){
            TickDetailsDto dto = new TickDetailsDto(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getInt(3),
                    rst.getDouble(4)
            );
            dtos.add(dto);
        }
        return dtos;
    }
    public boolean addqty(TicketDto dto) throws SQLException {

        String sql2 ="update ticketdetails set qty = qty + ? where id = ?";
        boolean ismaxing = CrudUtil.execute(sql2, dto.getQty(),dto.getType());

        //        if(!ismaxing) {
//            throw new SQLException("delete ticket failed");
//        }
//        connection.commit();
//        result = true;
//        if (connection != null) {
//            connection.setAutoCommit(true);
//        }
        return ismaxing;
    }
    public boolean reduseTicketDetails(TicketDto dto) throws SQLException {

        String sql2 ="update ticketdetails set qty = qty - ? where id = ?";
        boolean isReduce =   CrudUtil.execute(sql2, dto.getQty(),dto.getType());
        return isReduce;
    }
    public String getNextId() throws SQLException {
        String sql ="SELECT id FROM ticketdetails ORDER BY id DESC LIMIT 1";
        ResultSet rst = CrudUtil.execute(sql);
        if(rst.next()){
            String index = rst.getString(1);
            String substring = index.substring(1);
            int i = Integer.parseInt(substring);
            int newIndex = i + 1;
            return String.format("N%03d", newIndex);

        }
        return "N001";
    }
}
