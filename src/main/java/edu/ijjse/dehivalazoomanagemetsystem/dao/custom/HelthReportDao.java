package edu.ijjse.dehivalazoomanagemetsystem.dao.custom;
import edu.ijjse.dehivalazoomanagemetsystem.dao.CrudDao;
import edu.ijjse.dehivalazoomanagemetsystem.entity.dto.HelthReport;

import java.sql.SQLException;
import java.util.ArrayList;

public interface HelthReportDao extends CrudDao<HelthReport> {
    public ArrayList<String> getAnimalId() throws SQLException;
    public ArrayList<String> getVetId() throws SQLException;
}
