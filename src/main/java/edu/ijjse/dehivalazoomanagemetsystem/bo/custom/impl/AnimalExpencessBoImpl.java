package edu.ijjse.dehivalazoomanagemetsystem.bo.custom.impl;

import edu.ijjse.dehivalazoomanagemetsystem.bo.custom.AnimalExpencessBo;
import edu.ijjse.dehivalazoomanagemetsystem.model.dto.AnimalExpencesDto;

import java.sql.SQLException;
import java.util.ArrayList;

public class AnimalExpencessBoImpl implements AnimalExpencessBo {
    /**
     * @return
     * @throws SQLException
     */
    @Override
    public ArrayList<String> getAnimalIds() throws SQLException {
        return null;
    }

    /**
     * @param dto
     * @return
     * @throws SQLException
     */
    @Override
    public boolean add(AnimalExpencesDto dto) throws SQLException {
        return false;
    }

    /**
     * @param dto
     * @return
     * @throws SQLException
     */
    @Override
    public boolean update(AnimalExpencesDto dto) throws SQLException {
        return false;
    }

    /**
     * @param dto
     * @return
     * @throws SQLException
     */
    @Override
    public boolean delete(AnimalExpencesDto dto) throws SQLException {
        return false;
    }

    /**
     * @return
     * @throws SQLException
     */
    @Override
    public ArrayList<AnimalExpencesDto> getAll() throws SQLException {
        return null;
    }

    /**
     * @return
     * @throws SQLException
     */
    @Override
    public String getNextId() throws SQLException {
        return "";
    }
}
