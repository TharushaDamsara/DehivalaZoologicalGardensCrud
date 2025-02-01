package edu.ijjse.dehivalazoomanagemetsystem.bo.custom.impl;

import edu.ijjse.dehivalazoomanagemetsystem.bo.custom.AnimalExpencessBo;
import edu.ijjse.dehivalazoomanagemetsystem.dao.DaoFactory;
import edu.ijjse.dehivalazoomanagemetsystem.dao.custom.AnimalExpencessDao;
import edu.ijjse.dehivalazoomanagemetsystem.entity.dto.AnimalExpences;

import java.sql.SQLException;
import java.util.ArrayList;

public class AnimalExpencessBoImpl implements AnimalExpencessBo {
    AnimalExpencessDao animalExpencessDao = (AnimalExpencessDao) DaoFactory.getInstance().getSuperDao(DaoFactory.daoType.AnimalExpencess);
    /**
     * @return
     * @throws SQLException
     */
    @Override
    public ArrayList<String> getAnimalIds() throws SQLException {
        return animalExpencessDao.getAnimalIds();
    }

    /**
     * @param dto
     * @return
     * @throws SQLException
     */
    @Override
    public boolean add(AnimalExpences dto) throws SQLException {
        return animalExpencessDao.add(dto);
    }

    /**
     * @param dto
     * @return
     * @throws SQLException
     */
    @Override
    public boolean update(AnimalExpences dto) throws SQLException {
        return animalExpencessDao.update(dto);
    }

    /**
     * @param dto
     * @return
     * @throws SQLException
     */
    @Override
    public boolean delete(AnimalExpences dto) throws SQLException {
        return animalExpencessDao.delete(dto);
    }

    /**
     * @return
     * @throws SQLException
     */
    @Override
    public ArrayList<AnimalExpences> getAll() throws SQLException {
        return animalExpencessDao.getAll();
    }

    /**
     * @return
     * @throws SQLException
     */
    @Override
    public String getNextId() throws SQLException {
        return animalExpencessDao.getNextId()   ;
    }
}
