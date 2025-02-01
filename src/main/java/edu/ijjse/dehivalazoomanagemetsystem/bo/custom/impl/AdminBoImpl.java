package edu.ijjse.dehivalazoomanagemetsystem.bo.custom.impl;

import edu.ijjse.dehivalazoomanagemetsystem.bo.custom.AdminBo;
import edu.ijjse.dehivalazoomanagemetsystem.dao.DaoFactory;
import edu.ijjse.dehivalazoomanagemetsystem.dao.custom.AdminDao;
import edu.ijjse.dehivalazoomanagemetsystem.entity.dto.Admin;

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
    public boolean add(Admin dto) throws SQLException {
        return adminDao.add(dto);
    }

    /**
     * @param userName
     * @param pwd
     * @throws SQLException
     */
    @Override
    public void getAdmin(String userName, String pwd) throws SQLException {
    adminDao.getAdmin(userName, pwd);
    }

    /**
     * @param dto
     * @return
     * @throws SQLException
     */
    @Override
    public boolean update(Admin dto) throws SQLException {
        return adminDao.update(dto);
    }

    /**
     * @param dto
     * @return
     * @throws SQLException
     */
    @Override
    public boolean delete(Admin dto) throws SQLException {
        return adminDao.delete(dto);
    }

    /**
     * @return
     * @throws SQLException
     */
    @Override
    public ArrayList<Admin> getAll() throws SQLException {
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
