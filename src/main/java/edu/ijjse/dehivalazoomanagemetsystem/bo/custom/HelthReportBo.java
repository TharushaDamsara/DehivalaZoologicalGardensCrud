package edu.ijjse.dehivalazoomanagemetsystem.bo.custom;
import edu.ijjse.dehivalazoomanagemetsystem.bo.SuperBo;
import edu.ijjse.dehivalazoomanagemetsystem.entity.dto.HelthReport;

import java.sql.SQLException;
import java.util.ArrayList;

public interface HelthReportBo extends SuperBo {

    public ArrayList<String> getAnimalId() throws SQLException;
    public ArrayList<String> getVetId() throws SQLException;
    public boolean add(HelthReport dto) throws SQLException;
    public boolean update(HelthReport dto) throws SQLException;
    public boolean delete(HelthReport dto) throws SQLException;
    public ArrayList<HelthReport> getAll() throws SQLException;
    public String getNextId() throws SQLException;
}

