package edu.ijjse.dehivalazoomanagemetsystem.bo;

import edu.ijjse.dehivalazoomanagemetsystem.dao.SuperDao;
import edu.ijjse.dehivalazoomanagemetsystem.dao.custom.impl.*;

public class BOFactory {
    private static BOFactory boFactory;
    private BOFactory() {}
    public static BOFactory getInstance() {
        if (boFactory == null) {
            boFactory = new BOFactory();
        }
        return boFactory;
    }
    public enum BOType {
        Admin,User,AnimalExpencess,Animal,Devision,EmpExpencess,Emp,Encloser,Event,HelthReport,Task,TicketDetails,Ticket,UserDetails,Vet,Visitor
    }
public SuperDao getBOType(BOType type) {
 switch (type) {
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
