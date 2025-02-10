package edu.ijjse.dehivalazoomanagemetsystem.bo.custom.impl;

import edu.ijjse.dehivalazoomanagemetsystem.bo.custom.UserDetailsBo;
import edu.ijjse.dehivalazoomanagemetsystem.dao.DaoFactory;
import edu.ijjse.dehivalazoomanagemetsystem.dao.custom.UserDetailsDao;
import edu.ijjse.dehivalazoomanagemetsystem.dto.UserDetailsDto;

import java.sql.SQLException;
import java.util.ArrayList;

public class UserDetailsBoImpl implements UserDetailsBo {
    UserDetailsDao userDetailsDao = (UserDetailsDao) DaoFactory.getInstance().getSuperDao(DaoFactory.daoType.UserDetails);
    /**
     * @param dto
     * @return
     * @throws SQLException
     */
    @Override
    public boolean add(UserDetailsDto dto) throws SQLException {
        return userDetailsDao.add(dto);
    }

    /**
     * @return
     * @throws SQLException
     */
    @Override
    public ArrayList<String> getEmployeeIds() throws SQLException {
        return userDetailsDao.getEmployeeIds();
    }

    /**
     * @param dto
     * @return
     * @throws SQLException
     */
    @Override
    public boolean update(UserDetailsDto dto) throws SQLException {
        return userDetailsDao.update(dto);
    }

    /**
     * @param dto
     * @return
     * @throws SQLException
     */
    @Override
    public boolean delete(UserDetailsDto dto) throws SQLException {
        return userDetailsDao.delete(dto);
    }

    /**
     * @return
     * @throws SQLException
     */
    @Override
    public ArrayList<UserDetailsDto> getAll() throws SQLException {
        return userDetailsDao.getAll();
    }

    /**
     * @return
     * @throws SQLException
     */
    @Override
    public String getNextId() throws SQLException {
        return userDetailsDao.getNextId();
    }
}
