package edu.ijjse.dehivalazoomanagemetsystem.bo.custom.impl;

import edu.ijjse.dehivalazoomanagemetsystem.bo.custom.UserBo;
import edu.ijjse.dehivalazoomanagemetsystem.dao.DaoFactory;
import edu.ijjse.dehivalazoomanagemetsystem.dao.custom.UserDao;
import edu.ijjse.dehivalazoomanagemetsystem.dto.UserDto;

import java.sql.SQLException;
import java.util.ArrayList;

public class UserBoImpl implements UserBo {
    UserDao userDao = (UserDao) DaoFactory.getInstance().getSuperDao(DaoFactory.daoType.User);

    /**
     * @param dto
     * @return
     * @throws SQLException
     */
    @Override
    public boolean add(UserDto dto) throws SQLException {
        return userDao.add(dto);
    }

    /**
     * @param userName
     * @param pwd
     * @return
     * @throws SQLException
     */
    @Override
    public boolean getUserCredential(String userName, String pwd) throws SQLException {
        return userDao.getUserCredential(userName, pwd);
    }

    /**
     * @param dto
     * @return
     * @throws SQLException
     */
    @Override
    public boolean update(UserDto dto) throws SQLException {
        return userDao.update(dto);
    }

    /**
     * @param dto
     * @return
     * @throws SQLException
     */
    @Override
    public boolean delete(UserDto dto) throws SQLException {
        return userDao.delete(dto);
    }

    /**
     * @return
     * @throws SQLException
     */
    @Override
    public ArrayList<UserDto> getAll() throws SQLException {
        return userDao.getAll();
    }

    /**
     * @return
     * @throws SQLException
     */
    @Override
    public String getNextId() throws SQLException {
        return userDao.getNextId();
    }
}
