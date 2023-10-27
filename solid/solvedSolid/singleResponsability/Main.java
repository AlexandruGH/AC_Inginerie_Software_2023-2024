package singleResponsability;

import singleResponsability.bad.BadEmployee;
import singleResponsability.good.*;

public class Main {

    public static void main(String[] args) {
        //testBadS();
        testGoodS();
    }

    private static void testBadS() {
        BadEmployee employee = new BadEmployee("1", "BadEmployee", 5);
        employee.calculatePay();
        employee.reportHours();
        employee.save();
    }

    private static void testGoodS() {
        GoodEmployee employee = new GoodEmployee("1", "singleResponsability.good.GoodEmployee!", 42);

        EmployeeAdditionalPaymentService additionalPaymentService = new EmployeeAdditionalPaymentService();
        EmployeePaymentService employeePaymentService = new EmployeePaymentService(additionalPaymentService);
        employeePaymentService.calculatePay(employee);

        EmployeeTimetrackingService employeeTimetrackingService = new EmployeeTimetrackingService();
        employeeTimetrackingService.reportHours(employee);

        EmployeeRepository employeeRepository = new EmployeeRepository();
        employeeRepository.save(employee);
    }
}
