package edu.ijjse.dehivalazoomanagemetsystem.bo.custom.impl;

import edu.ijjse.dehivalazoomanagemetsystem.bo.custom.UserDetailsBo;
import edu.ijjse.dehivalazoomanagemetsystem.dao.DaoFactory;
import edu.ijjse.dehivalazoomanagemetsystem.dao.custom.UserDetailsDao;
import edu.ijjse.dehivalazoomanagemetsystem.dto.UserDetailsDto;
import edu.ijjse.dehivalazoomanagemetsystem.entity.UserDetails;

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
        return userDetailsDao.add(new UserDetails(dto.getUserId(),dto.getEmpId(),dto.getUserName(),dto.getPassword()));
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
        return userDetailsDao.update(new UserDetails(dto.getUserId(),dto.getEmpId(),dto.getUserName(),dto.getPassword()));
    }

    /**
     * @param dto
     * @return
     * @throws SQLException
     */
    @Override
    public boolean delete(UserDetailsDto dto) throws SQLException {
        return userDetailsDao.delete(new UserDetails(dto.getUserId(),dto.getEmpId(),dto.getUserName(),dto.getPassword()));
    }

    /**
     * @return
     * @throws SQLException
     */
    @Override
    public ArrayList<UserDetailsDto> getAll() throws SQLException {
        ArrayList<UserDetailsDto> userDetailsDtos = new ArrayList<>();
        ArrayList<UserDetails> userDetails = userDetailsDao.getAll();
        for (UserDetails userDetail : userDetails) {
            userDetailsDtos.add(new UserDetailsDto(userDetail.getUserId(),userDetail.getEmpId(),userDetail.getUserName(),userDetail.getPassword()));
        }
        return userDetailsDtos;
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
