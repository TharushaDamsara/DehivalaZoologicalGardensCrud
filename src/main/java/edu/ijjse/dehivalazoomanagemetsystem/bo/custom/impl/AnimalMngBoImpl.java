package edu.ijjse.dehivalazoomanagemetsystem.bo.custom.impl;

import edu.ijjse.dehivalazoomanagemetsystem.bo.custom.AnimalMngBo;
import edu.ijjse.dehivalazoomanagemetsystem.dao.DaoFactory;
import edu.ijjse.dehivalazoomanagemetsystem.dao.custom.AnimalMngDao;
import edu.ijjse.dehivalazoomanagemetsystem.entity.dto.Animal;

import java.sql.SQLException;
import java.util.ArrayList;

public class AnimalMngBoImpl implements AnimalMngBo {
    AnimalMngDao dao = (AnimalMngDao) DaoFactory.getInstance().getSuperDao(DaoFactory.daoType.Animal);
    /**
     * @param dto
     * @return
     * @throws SQLException
     */
    @Override
    public boolean add(Animal dto) throws SQLException {
        return dao.add(dto);
    }

    /**
     * @param dto
     * @return
     * @throws SQLException
     */
    @Override
    public boolean update(Animal dto) throws SQLException {
        return dao.update(dto);
    }

    /**
     * @param dto
     * @return
     * @throws SQLException
     */
    @Override
    public boolean delete(Animal dto) throws SQLException {
        return dao.delete(dto);
    }

    /**
     * @return
     * @throws SQLException
     */
    @Override
    public ArrayList<Animal> getAll() throws SQLException {
        return dao.getAll();
    }

    /**
     * @return
     * @throws SQLException
     */
    @Override
    public String getNextId() throws SQLException {
        return dao.getNextId();
    }
}
