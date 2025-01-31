package edu.ijjse.dehivalazoomanagemetsystem.dao.custom;
import edu.ijjse.dehivalazoomanagemetsystem.dao.CrudDao;
import edu.ijjse.dehivalazoomanagemetsystem.dao.utill.CrudUtil;
import edu.ijjse.dehivalazoomanagemetsystem.model.dto.HelthReportDto;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public interface HelthReportDao extends CrudDao<HelthReportDto> {
    public ArrayList<String> getAnimalId() throws SQLException;
    public ArrayList<String> getVetId() throws SQLException;
}
