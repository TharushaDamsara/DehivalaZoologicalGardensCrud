package edu.ijjse.dehivalazoomanagemetsystem.dao;

import edu.ijjse.dehivalazoomanagemetsystem.dao.custom.impl.*;

public class DaoFactory {
    private static DaoFactory daoFactory;
    private DaoFactory() {}
    public static DaoFactory getInstance() {
        if (daoFactory == null) {
            daoFactory = new DaoFactory();
        }
        return daoFactory;
    }
    public enum daoType {
        Admin,User,AnimalExpencess,Animal,Devision,EmpExpencess,Emp,Encloser,Event,HelthReport,Task,TicketDetails,Ticket,UserDetails,Vet,Visitor
    }
    public SuperDao getSuperDao(daoType daoType) {
        switch (daoType) {
            case Admin: new AdminDaoImpl();
            case User:new UserDaoImpl();
            case Emp:new EmpMngDaoImpl();
            case AnimalExpencess:new AnimalExpencessDaoImpl();
            case Devision:new DevisionDaoImpl();
            case EmpExpencess:new EmpExpencessDaoImpl();
            case Encloser:new EncloserDaoImpl();
            case Event:new EventDaoImpl();
            case HelthReport:new HelthReportDaoImpl();
            case Task:new TaskDaoImpl();
            case Ticket:new TicketDaoImpl();
            case Vet:new VetDaoImpl();
            case Visitor:new VisitorDaoImpl();
            case Animal:new AnimalMngDaoImpl();
            case UserDetails:new UserDetailsDaoImpl();
            case TicketDetails:new TickDetailsDaoImpl();
        }
        return null;
    }
}
