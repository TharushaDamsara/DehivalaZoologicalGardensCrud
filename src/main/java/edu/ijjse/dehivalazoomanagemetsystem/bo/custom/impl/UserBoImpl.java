package edu.ijjse.dehivalazoomanagemetsystem.bo.custom.impl;

import edu.ijjse.dehivalazoomanagemetsystem.bo.custom.UserBo;
import edu.ijjse.dehivalazoomanagemetsystem.dao.DaoFactory;
import edu.ijjse.dehivalazoomanagemetsystem.dao.custom.UserDao;
import edu.ijjse.dehivalazoomanagemetsystem.dto.UserDto;
import edu.ijjse.dehivalazoomanagemetsystem.entity.User;

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
        return userDao.add(new User(dto.getUsername(),dto.getPassword()));
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
        return userDao.update(new User(dto.getUsername(),dto.getPassword()));
    }

    /**
     * @param dto
     * @return
     * @throws SQLException
     */
    @Override
    public boolean delete(UserDto dto) throws SQLException {
        return userDao.delete(new User(dto.getUsername(),dto.getPassword()));
    }

    /**
     * @return
     * @throws SQLException
     */
    @Override
    public ArrayList<UserDto> getAll() throws SQLException {
        ArrayList<UserDto> dtos = new ArrayList<>();
        ArrayList<User> users = userDao.getAll();
        for (User user : users) {
            dtos.add(new UserDto(user.getUsername(),user.getPassword()));
        }
        return dtos;
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
