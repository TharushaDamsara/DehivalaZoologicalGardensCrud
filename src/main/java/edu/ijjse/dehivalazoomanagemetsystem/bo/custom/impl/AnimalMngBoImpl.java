package edu.ijjse.dehivalazoomanagemetsystem.bo.custom.impl;

import edu.ijjse.dehivalazoomanagemetsystem.bo.custom.AnimalMngBo;
import edu.ijjse.dehivalazoomanagemetsystem.dao.DaoFactory;
import edu.ijjse.dehivalazoomanagemetsystem.dao.custom.AnimalMngDao;
import edu.ijjse.dehivalazoomanagemetsystem.dto.AnimalDto;
import edu.ijjse.dehivalazoomanagemetsystem.entity.Animal;

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
    public boolean add(AnimalDto dto) throws SQLException {
        return dao.add(new Animal(dto.getAnimalId(),dto.getAnimalName(),dto.getAnimalAge(),dto.getAnimalGender(),dto.getCatagory(),dto.getEnclosureId(),dto.getDivisionId()));
    }

    /**
     * @param dto
     * @return
     * @throws SQLException
     */
    @Override
    public boolean update(AnimalDto dto) throws SQLException {
        return dao.update(new Animal(dto.getAnimalId(),dto.getAnimalName(),dto.getAnimalAge(),dto.getAnimalGender(),dto.getCatagory(),dto.getEnclosureId(),dto.getDivisionId()));
    }

    /**
     * @param dto
     * @return
     * @throws SQLException
     */
    @Override
    public boolean delete(AnimalDto dto) throws SQLException {
        return dao.delete(new Animal(dto.getAnimalId(),dto.getAnimalName(),dto.getAnimalAge(),dto.getAnimalGender(),dto.getCatagory(),dto.getEnclosureId(),dto.getDivisionId()));
    }

    /**
     * @return
     * @throws SQLException
     */
    @Override
    public ArrayList<AnimalDto> getAll() throws SQLException {
        ArrayList<AnimalDto> animals = new ArrayList<>();
        ArrayList<Animal> animalList = dao.getAll();
        for (Animal animal : animalList) {
            animals.add(new AnimalDto(animal.getAnimalId(),animal.getAnimalName(),animal.getAnimalAge(),animal.getAnimalGender(),animal.getCatagory(),animal.getEnclosureId(),animal.getDivisionId()));
        }
        return animals;
    }

    /**
     * @return
     * @throws SQLException
     */
    @Override
    public String getNextId() throws SQLException {
        return dao.getNextId();
    }

    /**
     * @return
     * @throws SQLException
     */
    @Override
    public ArrayList<String> getDivision() throws SQLException {
        return dao.getDivision();
    }

    /**
     * @return
     * @throws SQLException
     */
    @Override
    public ArrayList<String> getEnclosure() throws SQLException {
        return dao.getEnclosure();
    }
}
