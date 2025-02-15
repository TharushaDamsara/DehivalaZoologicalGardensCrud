package edu.ijjse.dehivalazoomanagemetsystem.bo.custom.impl;

import edu.ijjse.dehivalazoomanagemetsystem.bo.custom.EncloserBo;
import edu.ijjse.dehivalazoomanagemetsystem.dao.DaoFactory;
import edu.ijjse.dehivalazoomanagemetsystem.dao.custom.EncloserDao;
import edu.ijjse.dehivalazoomanagemetsystem.dto.EncloserDto;
import edu.ijjse.dehivalazoomanagemetsystem.entity.Encloser;

import java.sql.SQLException;
import java.util.ArrayList;

public class EncloserBoImpl implements EncloserBo {
    EncloserDao encloserDao = (EncloserDao) DaoFactory.getInstance().getSuperDao(DaoFactory.daoType.Encloser);
    /**
     * @param dto
     * @return
     * @throws SQLException
     */
    @Override
    public boolean add(EncloserDto dto) throws SQLException {
        return encloserDao.add(new Encloser(dto.getId(),dto.getLocation(),dto.getSize()));
    }

    /**
     * @param dto
     * @return
     * @throws SQLException
     */
    @Override
    public boolean update(EncloserDto dto) throws SQLException {
        return encloserDao.update(new Encloser(dto.getId(),dto.getLocation(),dto.getSize()));
    }

    /**
     * @param dto
     * @return
     * @throws SQLException
     */
    @Override
    public boolean delete(EncloserDto dto) throws SQLException {
        return encloserDao.delete(new Encloser(dto.getId(),dto.getLocation(),dto.getSize()));
    }

    /**
     * @return
     * @throws SQLException
     */
    @Override
    public ArrayList<EncloserDto> getAll() throws SQLException {
        ArrayList<EncloserDto> encloserDtos = new ArrayList<>();
        ArrayList<Encloser> enclosers = encloserDao.getAll();
        for (Encloser encloser : enclosers) {
            encloserDtos.add(new EncloserDto(encloser.getId(),encloser.getLocation(),encloser.getSize()));
        }
        return encloserDtos;
    }

    /**
     * @return
     * @throws SQLException
     */
    @Override
    public String getNextId() throws SQLException {
        return encloserDao.getNextId();
    }
}
