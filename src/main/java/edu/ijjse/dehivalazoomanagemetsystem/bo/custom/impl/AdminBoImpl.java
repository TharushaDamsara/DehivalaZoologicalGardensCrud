package edu.ijjse.dehivalazoomanagemetsystem.bo.custom.impl;

import edu.ijjse.dehivalazoomanagemetsystem.bo.custom.AdminBo;
import edu.ijjse.dehivalazoomanagemetsystem.dao.DaoFactory;
import edu.ijjse.dehivalazoomanagemetsystem.dao.custom.AdminDao;
import edu.ijjse.dehivalazoomanagemetsystem.dto.AdminDto;
import edu.ijjse.dehivalazoomanagemetsystem.entity.Admin;

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
        return adminDao.add(new Admin(dto.getUsername(),dto.getPassword()));
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
        return adminDao.update(new Admin(dto.getUsername(),dto.getPassword()));
    }

    /**
     * @param dto
     * @return
     * @throws SQLException
     */
    @Override
    public boolean delete(AdminDto dto) throws SQLException {
        return adminDao.delete(new Admin(dto.getUsername(),dto.getPassword()));
    }

    /**
     * @return
     * @throws SQLException
     */
    @Override
    public ArrayList<AdminDto> getAll() throws SQLException {
        ArrayList<AdminDto> adminDtos = new ArrayList<>();
        ArrayList<Admin> admins = adminDao.getAll();
        for (Admin admin : admins) {
            adminDtos.add(new AdminDto(admin.getUsername(),admin.getPassword()));
        }
        return adminDtos;
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
