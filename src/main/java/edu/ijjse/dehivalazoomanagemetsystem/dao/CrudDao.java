package edu.ijjse.dehivalazoomanagemetsystem.dao;

import java.sql.SQLException;
import java.util.ArrayList;

public interface

CrudDao <T> extends SuperDao{
    public boolean add(T dto) throws SQLException;

    public boolean update(T dto) throws SQLException;

    public boolean delete(T dto) throws SQLException;

    public ArrayList<T> getAll() throws SQLException;

    public String getNextId() throws SQLException;
}
