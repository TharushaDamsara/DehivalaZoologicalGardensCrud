package edu.ijjse.dehivalazoomanagemetsystem.bo.custom.impl;

import edu.ijjse.dehivalazoomanagemetsystem.bo.custom.VetBo;
import edu.ijjse.dehivalazoomanagemetsystem.dao.DaoFactory;
import edu.ijjse.dehivalazoomanagemetsystem.dao.custom.VetDao;
import edu.ijjse.dehivalazoomanagemetsystem.dto.VetDto;
import edu.ijjse.dehivalazoomanagemetsystem.entity.Vet;

import java.sql.SQLException;
import java.util.ArrayList;

public class VetBoImpl implements VetBo {
    VetDao vetDao = (VetDao) DaoFactory.getInstance().getSuperDao(DaoFactory.daoType.Vet);
    /**
     * @param dto
     * @return
     * @throws SQLException
     */
    @Override
    public boolean add(VetDto dto) throws SQLException {
        return vetDao.add(new Vet(dto.getVetId(),dto.getVetName(),dto.getVetAddress(),dto.getVetPhone()));
    }

    /**
     * @param dto
     * @return
     * @throws SQLException
     */
    @Override
    public boolean update(VetDto dto) throws SQLException {
        return vetDao.update(new Vet(dto.getVetId(),dto.getVetName(),dto.getVetAddress(),dto.getVetPhone()));
    }

    /**
     * @param dto
     * @return
     * @throws SQLException
     */
    @Override
    public boolean delete(VetDto dto) throws SQLException {
        return vetDao.delete(new Vet(dto.getVetId(),dto.getVetName(),dto.getVetAddress(),dto.getVetPhone()));
    }

    /**
     * @return
     * @throws SQLException
     */
    @Override
    public ArrayList<VetDto> getAll() throws SQLException {
        ArrayList<VetDto> vetDtos = new ArrayList<>();
        ArrayList<Vet> vets = vetDao.getAll();
        for (Vet vet : vets) {
            vetDtos.add(new VetDto(vet.getVetId(),vet.getVetName(),vet.getVetAddress(),vet.getVetPhone()));
        }
        return vetDtos;
    }

    /**
     * @return
     * @throws SQLException
     */
    @Override
    public String getNextId() throws SQLException {
        return vetDao.getNextId();
    }
}
