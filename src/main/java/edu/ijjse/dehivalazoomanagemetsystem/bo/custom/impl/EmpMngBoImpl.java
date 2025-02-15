package edu.ijjse.dehivalazoomanagemetsystem.bo.custom.impl;

import edu.ijjse.dehivalazoomanagemetsystem.bo.custom.EmpMngBo;
import edu.ijjse.dehivalazoomanagemetsystem.dao.DaoFactory;
import edu.ijjse.dehivalazoomanagemetsystem.dao.custom.EmpMngDao;
import edu.ijjse.dehivalazoomanagemetsystem.dto.EmpMngDto;
import edu.ijjse.dehivalazoomanagemetsystem.entity.EmpMng;

import java.sql.SQLException;
import java.util.ArrayList;

public class EmpMngBoImpl implements EmpMngBo {
    EmpMngDao empMngDao = (EmpMngDao) DaoFactory.getInstance().getSuperDao(DaoFactory.daoType.Emp);
    /**
     * @param dto
     * @return
     * @throws SQLException
     */
    @Override
    public boolean add(EmpMngDto dto) throws SQLException {
        return empMngDao.add(new EmpMng(dto.getEmpId(),dto.getEmpName(),dto.getEmpSalary(),dto.getEmpAddress(),dto.getDivisionId(),dto.getEmpAge(),dto.getEmpGender(),dto.getEmpBirth(),dto.getEmpJob(),dto.getEmpPhone()));
    }

    /**
     * @param dto
     * @return
     * @throws SQLException
     */
    @Override
    public boolean update(EmpMngDto dto) throws SQLException {
        return empMngDao.update(new EmpMng(dto.getEmpId(),dto.getEmpName(),dto.getEmpSalary(),dto.getEmpAddress(),dto.getDivisionId(),dto.getEmpAge(),dto.getEmpGender(),dto.getEmpBirth(),dto.getEmpJob(),dto.getEmpPhone()));
    }

    /**
     * @param dto
     * @return
     * @throws SQLException
     */
    @Override
    public boolean delete(EmpMngDto dto) throws SQLException {
        return empMngDao.delete(new EmpMng(dto.getEmpId(),dto.getEmpName(),dto.getEmpSalary(),dto.getEmpAddress(),dto.getDivisionId(),dto.getEmpAge(),dto.getEmpGender(),dto.getEmpBirth(),dto.getEmpJob(),dto.getEmpPhone()));
    }

    /**
     * @return
     * @throws SQLException
     */
    @Override
    public ArrayList<EmpMngDto> getAll() throws SQLException {
        ArrayList<EmpMngDto> empMngDtos = new ArrayList<>();
        ArrayList<EmpMng> empMngs = empMngDao.getAll();
        for (EmpMng empMng : empMngs) {
            empMngDtos.add(new EmpMngDto(empMng.getEmpId(),empMng.getEmpName(),empMng.getEmpSalary(),empMng.getEmpAddress(),empMng.getDivisionId(),empMng.getEmpAge(),empMng.getEmpGender(),empMng.getEmpBirth(),empMng.getEmpJob(),empMng.getEmpPhone()));
        }
        return empMngDtos;
    }

    /**
     * @return
     * @throws SQLException
     */
    @Override
    public String getNextId() throws SQLException {
        return empMngDao.getNextId();
    }
}
