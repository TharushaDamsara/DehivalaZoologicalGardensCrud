package edu.ijjse.dehivalazoomanagemetsystem.bo.custom.impl;

import edu.ijjse.dehivalazoomanagemetsystem.bo.custom.HelthReportBo;
import edu.ijjse.dehivalazoomanagemetsystem.dao.DaoFactory;
import edu.ijjse.dehivalazoomanagemetsystem.dao.custom.HelthReportDao;
import edu.ijjse.dehivalazoomanagemetsystem.dto.HelthReportDto;

import java.sql.SQLException;
import java.util.ArrayList;

public class HelthReportBoImpl implements HelthReportBo {
    HelthReportDao helthReportDao = (HelthReportDao) DaoFactory.getInstance().getSuperDao(DaoFactory.daoType.HelthReport);
    /**
     * @param dto
     * @return
     * @throws SQLException
     */
    @Override
    public boolean add(HelthReportDto dto) throws SQLException {
        return helthReportDao.add(dto);
    }

    /**
     * @return
     * @throws SQLException
     */
    @Override
    public ArrayList<String> getAnimalId() throws SQLException {
        return helthReportDao.getAnimalId();
    }

    /**
     * @return
     * @throws SQLException
     */
    @Override
    public ArrayList<String> getVetId() throws SQLException {
        return helthReportDao.getVetId();
    }

    /**
     * @param dto
     * @return
     * @throws SQLException
     */
    @Override
    public boolean update(HelthReportDto dto) throws SQLException {
        return helthReportDao.update(dto);
    }

    /**
     * @param dto
     * @return
     * @throws SQLException
     */
    @Override
    public boolean delete(HelthReportDto dto) throws SQLException {
        return helthReportDao.delete(dto);
    }

    /**
     * @return
     * @throws SQLException
     */
    @Override
    public ArrayList<HelthReportDto> getAll() throws SQLException {
        return helthReportDao.getAll();
    }

    /**
     * @return
     * @throws SQLException
     */
    @Override
    public String getNextId() throws SQLException {
        return helthReportDao.getNextId();
    }
}
