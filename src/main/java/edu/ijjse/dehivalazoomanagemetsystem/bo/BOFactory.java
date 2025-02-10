package edu.ijjse.dehivalazoomanagemetsystem.bo;

import edu.ijjse.dehivalazoomanagemetsystem.bo.custom.UserDetailsBo;
import edu.ijjse.dehivalazoomanagemetsystem.bo.custom.impl.*;
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
        Admin, User, AnimalExpencess, Animal, Devision, EmpExpencess, Emp, Encloser, Event, HelthReport, Task, TicketDetails, Ticket, UserDetails, Vet, Visitor;
    }

        public SuperBo getBOType(BOType type) {
            switch (type) {
                case Admin:
                    return new AdminBoImpl();
                case User:
                    return new UserBoImpl();
                case Emp:
                    return new EmpMngBoImpl();
                case AnimalExpencess:
                    return new AnimalExpencessBoImpl();
                case Devision:
                    return new DevisionBoImpl();
                case EmpExpencess:
                    return new EmpExpencessBoImpl();
                case Encloser:
                    return new EncloserBoImpl();
                case Event:
                    return new EventBoImpl();
                case HelthReport:
                    return new HelthReportBoImpl();
                case Task:
                    return new TaskBoImpl();
                case Ticket:
                    return new TicketBoImpl();
                case Vet:
                    return new VetBoImpl();
                case Visitor:
                    return new VisitorBoImpl();
                case Animal:
                    return new AnimalMngBoImpl();
                case UserDetails:
                    return new UserDetailsBoImpl();
                case TicketDetails:
                    return new TicketDetailsBoImpl();
                default:
                    return null;
            }
        }
        }


