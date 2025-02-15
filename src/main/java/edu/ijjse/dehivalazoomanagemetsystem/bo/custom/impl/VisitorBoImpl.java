package edu.ijjse.dehivalazoomanagemetsystem.bo.custom.impl;

import edu.ijjse.dehivalazoomanagemetsystem.bo.custom.VisitorBo;
import edu.ijjse.dehivalazoomanagemetsystem.dao.DaoFactory;
import edu.ijjse.dehivalazoomanagemetsystem.dao.custom.VisitorDao;
import edu.ijjse.dehivalazoomanagemetsystem.dto.VisitorDto;
import edu.ijjse.dehivalazoomanagemetsystem.entity.Visitor;

import java.sql.SQLException;
import java.util.ArrayList;

public class VisitorBoImpl implements VisitorBo {
    VisitorDao visitorDao = (VisitorDao) DaoFactory.getInstance().getSuperDao(DaoFactory.daoType.Visitor);

    /**
     * @param dto
     * @return
     * @throws SQLException
     */
    @Override
    public boolean add(VisitorDto dto) throws SQLException {
        return visitorDao.add(new Visitor(dto.getVisitorId(),dto.getVisitorName(),dto.getVisitorAddress(),dto.getVisitDate(),dto.getVisitNic(),dto.getTicketId()));
    }

    /**
     * @param dto
     * @return
     * @throws SQLException
     */
    @Override
    public boolean update(VisitorDto dto) throws SQLException {
        return visitorDao.update(new Visitor(dto.getVisitorId(),dto.getVisitorName(),dto.getVisitorAddress(),dto.getVisitDate(),dto.getVisitNic(),dto.getTicketId()));
    }

    /**
     * @param dto
     * @return
     * @throws SQLException
     */
    @Override
    public boolean delete(VisitorDto dto) throws SQLException {
        return visitorDao.delete(new Visitor(dto.getVisitorId(),dto.getVisitorName(),dto.getVisitorAddress(),dto.getVisitDate(),dto.getVisitNic(),dto.getTicketId()));
    }

    /**
     * @return
     * @throws SQLException
     */
    @Override
    public ArrayList<VisitorDto> getAll() throws SQLException {
        ArrayList<VisitorDto> dtos = new ArrayList<>();
        ArrayList<Visitor> visitors = visitorDao.getAll();
        for (Visitor visitor : visitors) {
            dtos.add(new VisitorDto(visitor.getVisitorId(),visitor.getVisitorName(),visitor.getVisitorAddress(),visitor.getVisitDate(),visitor.getVisitNic(),visitor.getTicketId()));
        }
        return dtos;
    }

    /**
     * @return
     * @throws SQLException
     */
    @Override
    public String getNextId() throws SQLException {
        return visitorDao.getNextId();
    }
}
