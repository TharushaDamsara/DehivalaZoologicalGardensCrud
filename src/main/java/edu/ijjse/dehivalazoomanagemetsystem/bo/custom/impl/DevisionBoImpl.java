package edu.ijjse.dehivalazoomanagemetsystem.bo.custom.impl;

import edu.ijjse.dehivalazoomanagemetsystem.bo.custom.DevisionBo;
import edu.ijjse.dehivalazoomanagemetsystem.dao.DaoFactory;
import edu.ijjse.dehivalazoomanagemetsystem.dao.custom.DevisionDao;
import edu.ijjse.dehivalazoomanagemetsystem.dto.DevisionDto;

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
        return devisionDao.add(dto);
    }

    /**
     * @param dto
     * @return
     * @throws SQLException
     */
    @Override
    public boolean update(DevisionDto dto) throws SQLException {
        return devisionDao.update(dto);
    }

    /**
     * @param dto
     * @return
     * @throws SQLException
     */
    @Override
    public boolean delete(DevisionDto dto) throws SQLException {
        return devisionDao.delete(dto);
    }

    /**
     * @return
     * @throws SQLException
     */
    @Override
    public ArrayList<DevisionDto> getAll() throws SQLException {
        return devisionDao.getAll();
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
