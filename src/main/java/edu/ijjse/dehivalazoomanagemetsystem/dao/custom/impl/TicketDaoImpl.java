package edu.ijjse.dehivalazoomanagemetsystem.dao.custom.impl;

import edu.ijjse.dehivalazoomanagemetsystem.dao.custom.TicketDao;
import edu.ijjse.dehivalazoomanagemetsystem.db.DBConnection;
import edu.ijjse.dehivalazoomanagemetsystem.entity.dto.TickDetails;
import edu.ijjse.dehivalazoomanagemetsystem.entity.dto.Ticket;
import edu.ijjse.dehivalazoomanagemetsystem.dao.utill.CrudUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TicketDaoImpl implements TicketDao {
    public boolean add(Ticket dto) throws SQLException {
        Connection connection = null;
        boolean result = false;
        connection = DBConnection.getInstance().getConnection();
        connection.setAutoCommit(false);

        String sql = "insert into ticket values(?,?,?,?,?,?,?)";
        boolean rst= CrudUtil.execute(sql, dto.getTicketCode(), dto.getVisitorId(),dto.getType(), dto.getDate(),dto.getQty(), dto.getAmount(), dto.getPaymentType());
        if (!rst){
            throw new SQLException("create ticket failed");
        }
       String sql2 ="update ticketdetails set qty = qty - ? where id = ?";
        boolean isReduce =   CrudUtil.execute(sql2, dto.getQty(),dto.getType());
        if(!isReduce) {
            throw new SQLException("reduce qty failed");

        }
        connection.commit();
        result = true;

        if (connection != null) {
            connection.setAutoCommit(true);
        }

        return result;
    }
public TickDetails findById(String id) throws SQLException {
        String sql = "select * from ticketdetails where id = ?";
    ResultSet execute = CrudUtil.execute(sql, id);

    if(execute.next()) {
        TickDetails dto = new TickDetails(
                execute.getString(1),
                execute.getString(2),
                execute.getInt(3),
                execute.getDouble(4)
        );
        return dto;
    }
    return null;
}

    public boolean update(Ticket dto) throws SQLException {
//        Connection connection = null;
//        boolean result = false;
//        connection = DBConnection.getInstance().getConnection();
//        connection.setAutoCommit(false);

        String sql = "UPDATE ticket SET visitorId =?,type =?,date=?,qty=?,amount=?,paymentType=? WHERE ticketCode =?";
        return CrudUtil.execute(sql, dto.getVisitorId(),dto.getType(), dto.getDate(),dto.getQty(), dto.getAmount(), dto.getPaymentType(), dto.getTicketCode());
    }

    public boolean delete(Ticket dto) throws SQLException {
        Connection connection = null;
        boolean result = false;
        connection = DBConnection.getInstance().getConnection();
        connection.setAutoCommit(false);

        String sql = "delete from ticket where ticketCode =?";
        boolean rst = CrudUtil.execute(sql, dto.getTicketCode());
        if (!rst) {
            throw new SQLException("delete ticket failed");
        }
        String sql2 ="update ticketdetails set qty = qty + ? where id = ?";
        boolean ismaxing = CrudUtil.execute(sql2, dto.getQty(),dto.getType());
        if(!ismaxing) {
            throw new SQLException("delete ticket failed");
        }
        connection.commit();
        result = true;
        if (connection != null) {
            connection.setAutoCommit(true);
        }
        return result;
    }

    public ArrayList<Ticket> getAll() throws SQLException {
        String sql = "select * from ticket";
        ResultSet rst = CrudUtil.execute(sql);
        ArrayList<Ticket> dtos = new ArrayList<>();
        while (rst.next()) {
            Ticket dto = new Ticket(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getInt(5),
                    rst.getDouble(6),
                    rst.getString(7)

            );
            dtos.add(dto);
        }
        return dtos;
    }

    public String getNextId() throws SQLException {
    String sql = "select ticketCode from ticket order by ticketCode desc limit 1";
    ResultSet rst = CrudUtil.execute(sql);
    if (rst.next()) {

        String index = rst.getString(1);
        String substring = index.substring(1);
        int i = Integer.parseInt(substring);
        int newId = i + 1;
        return String.format("T%03d", newId);
    }
        return "T001";
    }
    public ArrayList<String> getVisitorId() throws SQLException {
        String sql = "select visitorId from visitor";
        ResultSet rst = CrudUtil.execute(sql);
        ArrayList<String> visitorIds = new ArrayList<>();
        while (rst.next()) {
            visitorIds.add(rst.getString(1));
        }
        return visitorIds;
    }
    public ArrayList<String> getTypeIds() throws SQLException {
        String sql = "select id from ticketdetails";
        ResultSet rst = CrudUtil.execute(sql);
        ArrayList<String> types = new ArrayList<>();
        while (rst.next()) {
            types.add(rst.getString(1));
        }
        return types;
    }
}

