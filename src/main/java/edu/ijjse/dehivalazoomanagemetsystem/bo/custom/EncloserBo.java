package edu.ijjse.dehivalazoomanagemetsystem.bo.custom;

import edu.ijjse.dehivalazoomanagemetsystem.bo.SuperBo;
import edu.ijjse.dehivalazoomanagemetsystem.dao.CrudDao;
import edu.ijjse.dehivalazoomanagemetsystem.model.dto.EncloserDto;

import java.sql.SQLException;
import java.util.ArrayList;

public interface EncloserBo extends SuperBo {

    public boolean add(EncloserDto dto) throws SQLException;
    public boolean update(EncloserDto dto) throws SQLException;
    public boolean delete(EncloserDto dto) throws SQLException;
    public ArrayList<EncloserDto> getAll() throws SQLException;
    public String getNextId() throws SQLException;
}

