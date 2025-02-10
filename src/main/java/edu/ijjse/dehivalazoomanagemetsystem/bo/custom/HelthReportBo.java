package edu.ijjse.dehivalazoomanagemetsystem.bo.custom;
import edu.ijjse.dehivalazoomanagemetsystem.bo.SuperBo;
import edu.ijjse.dehivalazoomanagemetsystem.dto.HelthReportDto;

import java.sql.SQLException;
import java.util.ArrayList;

public interface HelthReportBo extends SuperBo {

    public ArrayList<String> getAnimalId() throws SQLException;
    public ArrayList<String> getVetId() throws SQLException;
    public boolean add(HelthReportDto dto) throws SQLException;
    public boolean update(HelthReportDto dto) throws SQLException;
    public boolean delete(HelthReportDto dto) throws SQLException;
    public ArrayList<HelthReportDto> getAll() throws SQLException;
    public String getNextId() throws SQLException;
}

