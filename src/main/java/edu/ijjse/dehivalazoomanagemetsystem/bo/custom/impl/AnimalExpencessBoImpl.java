package edu.ijjse.dehivalazoomanagemetsystem.bo.custom.impl;

import edu.ijjse.dehivalazoomanagemetsystem.bo.custom.AnimalExpencessBo;
import edu.ijjse.dehivalazoomanagemetsystem.dao.DaoFactory;
import edu.ijjse.dehivalazoomanagemetsystem.dao.custom.AnimalExpencessDao;
import edu.ijjse.dehivalazoomanagemetsystem.dto.AnimalExpencesDto;
import edu.ijjse.dehivalazoomanagemetsystem.entity.AnimalExpences;

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
    public boolean add(AnimalExpencesDto dto) throws SQLException {
        return animalExpencessDao.add(new AnimalExpences(dto.getAnimalExpencesId(),dto.getAnimalId(), dto.getAmount(),dto.getDiscription(),dto.getDate()));
    }

    /**
     * @param dto
     * @return
     * @throws SQLException
     */
    @Override
    public boolean update(AnimalExpencesDto dto) throws SQLException {
        return animalExpencessDao.update(new AnimalExpences(dto.getAnimalExpencesId(),dto.getAnimalId(), dto.getAmount(),dto.getDiscription(),dto.getDate()));
    }

    /**
     * @param dto
     * @return
     * @throws SQLException
     */
    @Override
    public boolean delete(AnimalExpencesDto dto) throws SQLException {
        return animalExpencessDao.delete(new AnimalExpences(dto.getAnimalExpencesId(),dto.getAnimalId(), dto.getAmount(),dto.getDiscription(),dto.getDate()));
    }

    /**
     * @return
     * @throws SQLException
     */
    @Override
    public ArrayList<AnimalExpencesDto> getAll() throws SQLException {
        ArrayList<AnimalExpencesDto> animalExpencesDtos = new ArrayList<>();
        ArrayList<AnimalExpences> animalExpences = animalExpencessDao.getAll();
        for (AnimalExpences animalExpence : animalExpences) {
            animalExpencesDtos.add(new AnimalExpencesDto(animalExpence.getAnimalExpencesId(),animalExpence.getAnimalId(),animalExpence.getAmount(),animalExpence.getDiscription(),animalExpence.getDate()));
        }
        return animalExpencesDtos;
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
