package edu.ijjse.dehivalazoomanagemetsystem.bo.custom.impl;

import edu.ijjse.dehivalazoomanagemetsystem.bo.custom.DevisionBo;
import edu.ijjse.dehivalazoomanagemetsystem.dao.DaoFactory;
import edu.ijjse.dehivalazoomanagemetsystem.dao.custom.DevisionDao;
import edu.ijjse.dehivalazoomanagemetsystem.dto.DevisionDto;
import edu.ijjse.dehivalazoomanagemetsystem.entity.Devision;

import java.sql.SQLException;
import java.util.ArrayList;

public class DevisionBoImpl implements DevisionBo {
     DevisionDao devisionDao = (DevisionDao) DaoFactory.getInstance().getSuperDao(DaoFactory.daoType.Devision);
    /**
     * @param dto
     * @return
     * @throws SQLException
     */
    @Override
    public boolean add(DevisionDto dto) throws SQLException {
        return devisionDao.add(new Devision(dto.getDevisionId(),dto.getDevisionName(),dto.getDevisionDescription()));
    }

    /**
     * @param dto
     * @return
     * @throws SQLException
     */
    @Override
    public boolean update(DevisionDto dto) throws SQLException {
        return devisionDao.update(new Devision(dto.getDevisionId(),dto.getDevisionName(),dto.getDevisionDescription()));
    }

    /**
     * @param dto
     * @return
     * @throws SQLException
     */
    @Override
    public boolean delete(DevisionDto dto) throws SQLException {
        return devisionDao.delete(new Devision(dto.getDevisionId(),dto.getDevisionName(),dto.getDevisionDescription()));
    }

    /**
     * @return
     * @throws SQLException
     */
    @Override
    public ArrayList<DevisionDto> getAll() throws SQLException {
        ArrayList<DevisionDto> dtos = new ArrayList<>();
        ArrayList<Devision> devisions = devisionDao.getAll();
        for (Devision devision : devisions) {
            dtos.add(new DevisionDto(devision.getDevisionId(),devision.getDevisionName(),devision.getDevisionDescription()));
        }
        return dtos;
    }


    /**
     * @return
     * @throws SQLException
     */
    @Override
    public String getNextId() throws SQLException {
        return devisionDao.getNextId();
    }
}
