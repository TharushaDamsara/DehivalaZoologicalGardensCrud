package edu.ijjse.dehivalazoomanagemetsystem.bo.custom;

import edu.ijjse.dehivalazoomanagemetsystem.bo.SuperBo;
import edu.ijjse.dehivalazoomanagemetsystem.entity.dto.Vet;

import java.sql.SQLException;
import java.util.ArrayList;

public interface VetBo extends SuperBo {

    public boolean add(Vet dto) throws SQLException;
    public boolean update(Vet dto) throws SQLException;
    public boolean delete(Vet dto) throws SQLException;
    public ArrayList<Vet> getAll() throws SQLException;
    public String getNextId() throws SQLException;
}
