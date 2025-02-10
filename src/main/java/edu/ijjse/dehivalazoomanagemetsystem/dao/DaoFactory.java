package edu.ijjse.dehivalazoomanagemetsystem.dao;

import edu.ijjse.dehivalazoomanagemetsystem.dao.custom.impl.*;

public class DaoFactory {
    private static DaoFactory daoFactory;
    private DaoFactory() {
    }
    public static DaoFactory getInstance() {
        return daoFactory==null?daoFactory=new DaoFactory():daoFactory;
    }
    public enum daoType {
        Admin,User,AnimalExpencess,Animal,Devision,EmpExpencess,Emp,Encloser,Event,HelthReport,Task,TicketDetails,Ticket,UserDetails,Vet,Visitor
    }
    public SuperDao getSuperDao(daoType daoType) {
        switch (daoType) {
            case Admin: return new AdminDaoImpl();
            case User:return new UserDaoImpl();
            case Emp:return new EmpMngDaoImpl();
            case AnimalExpencess:return new AnimalExpencessDaoImpl();
            case Devision:return new DevisionDaoImpl();
            case EmpExpencess:return new EmpExpencessDaoImpl();
            case Encloser:return new EncloserDaoImpl();
            case Event:return new EventDaoImpl();
            case HelthReport:return new HelthReportDaoImpl();
            case Task:return new TaskDaoImpl();
            case Ticket:return new TicketDaoImpl();
            case Vet:return new VetDaoImpl();
            case Visitor:return new VisitorDaoImpl();
            case Animal:return new AnimalMngDaoImpl();
            case UserDetails:return new UserDetailsDaoImpl();
            case TicketDetails:return new TickDetailsDaoImpl();
            default: return null;
        }
    }
}
