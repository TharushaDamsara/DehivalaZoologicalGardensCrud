package edu.ijjse.dehivalazoomanagemetsystem.bo.custom.impl;

import edu.ijjse.dehivalazoomanagemetsystem.bo.custom.EmpExpencessBo;
import edu.ijjse.dehivalazoomanagemetsystem.dao.DaoFactory;
import edu.ijjse.dehivalazoomanagemetsystem.dao.custom.EmpExpencessDao;
import edu.ijjse.dehivalazoomanagemetsystem.dto.EmployeeExpencesDto;
import edu.ijjse.dehivalazoomanagemetsystem.entity.EmployeeExpences;

import java.sql.SQLException;
import java.util.ArrayList;

public class EmpExpencessBoImpl implements EmpExpencessBo {
    EmpExpencessDao empExpencessDao = (EmpExpencessDao) DaoFactory.getInstance().getSuperDao(DaoFactory.daoType.EmpExpencess);

    /**
     * @param dto
     * @return
     * @throws SQLException
     */
    @Override
    public boolean add(EmployeeExpencesDto dto) throws SQLException {
        return empExpencessDao.add(new EmployeeExpences(dto.getPaymentId(),dto.getEmployeeId(),dto.getDate(),dto.getBasicSalary(),dto.getAddonSalary(),dto.getCutOffSalary(),dto.getTotalSalary()));
    }

    /**
     * @return
     * @throws SQLException
     */
    @Override
    public ArrayList<String> getEmployeeIds() throws SQLException {
        return empExpencessDao.getEmployeeIds();
    }

    /**
     * @param dto
     * @return
     * @throws SQLException
     */
    @Override
    public boolean update(EmployeeExpencesDto dto) throws SQLException {
        return empExpencessDao.update(new EmployeeExpences(dto.getPaymentId(),dto.getEmployeeId(),dto.getDate(),dto.getBasicSalary(),dto.getAddonSalary(),dto.getCutOffSalary(),dto.getTotalSalary()));
    }

    /**
     * @param dto
     * @return
     * @throws SQLException
     */
    @Override
    public boolean delete(EmployeeExpencesDto dto) throws SQLException {
        return empExpencessDao.delete( new EmployeeExpences(dto.getPaymentId(),dto.getEmployeeId(),dto.getDate(),dto.getBasicSalary(),dto.getAddonSalary(),dto.getCutOffSalary(),dto.getTotalSalary()));
    }

    /**
     * @return
     * @throws SQLException
     */
    @Override
    public ArrayList<EmployeeExpencesDto> getAll() throws SQLException {
        ArrayList<EmployeeExpencesDto> dtos = new ArrayList<>();
        ArrayList<EmployeeExpences> empExpencessDaoAll = empExpencessDao.getAll();
        for (EmployeeExpences employeeExpences : empExpencessDaoAll) {
            dtos.add(new EmployeeExpencesDto(employeeExpences.getPaymentId(),employeeExpences.getEmployeeId(),employeeExpences.getDate(),employeeExpences.getBasicSalary(),employeeExpences.getAddonSalary(),employeeExpences.getCutOffSalary(),employeeExpences.getTotalSalary()));
        }
        return dtos;
    }

    /**
     * @return
     * @throws SQLException
     */
    @Override
    public String getNextId() throws SQLException {
        return empExpencessDao.getNextId();
    }
}
