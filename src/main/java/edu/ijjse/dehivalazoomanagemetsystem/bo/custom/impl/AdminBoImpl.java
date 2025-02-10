package edu.ijjse.dehivalazoomanagemetsystem.bo.custom.impl;

import edu.ijjse.dehivalazoomanagemetsystem.bo.custom.AdminBo;
import edu.ijjse.dehivalazoomanagemetsystem.dao.DaoFactory;
import edu.ijjse.dehivalazoomanagemetsystem.dao.custom.AdminDao;
import edu.ijjse.dehivalazoomanagemetsystem.dto.AdminDto;

import java.sql.SQLException;
import java.util.ArrayList;


public class AdminBoImpl implements AdminBo {
    AdminDao adminDao = (AdminDao) DaoFactory.getInstance().getSuperDao(DaoFactory.daoType.Admin);
    /**
     * @param dto
     * @return
     * @throws SQLException
     */
    @Override
    public boolean add(AdminDto dto) throws SQLException {
        return adminDao.add(dto);
    }

    /**
     * @param userName
     * @param pwd
     * @return
     * @throws SQLException
     */
    @Override
    public boolean getAdmin(String userName, String pwd) throws SQLException {
    adminDao.getAdmin(userName, pwd);
        System.out.println(userName);
        System.out.println(pwd);

        return adminDao.getAdmin(userName, pwd);
    }

    /**
     * @param dto
     * @return
     * @throws SQLException
     */
    @Override
    public boolean update(AdminDto dto) throws SQLException {
        return adminDao.update(dto);
    }

    /**
     * @param dto
     * @return
     * @throws SQLException
     */
    @Override
    public boolean delete(AdminDto dto) throws SQLException {
        return adminDao.delete(dto);
    }

    /**
     * @return
     * @throws SQLException
     */
    @Override
    public ArrayList<AdminDto> getAll() throws SQLException {
        return adminDao.getAll();
    }

    /**
     * @return
     * @throws SQLException
     */
    @Override
    public String getNextId() throws SQLException {
        return adminDao.getNextId();
    }
}
