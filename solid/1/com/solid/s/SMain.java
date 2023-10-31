package com.solid.s;

import com.solid.s.bad.BadEmployee;
import com.solid.s.good.*;

public class SMain {

    public static void main(String[] args) {
        testBadS();
        testGoodS();
    }

    private static void testBadS() {
        BadEmployee employee = new BadEmployee("1", "BadEmployee", 5);
        employee.calculatePay();
        employee.reportHours();
        employee.save();
    }

    private static void testGoodS() {
        GoodEmployee employee = new GoodEmployee("1", "GoodEmployee!", 42);

        EmployeeAdditionalPaymentService additionalPaymentService = new EmployeeAdditionalPaymentService();
        EmployeePaymentService employeePaymentService = new EmployeePaymentService(additionalPaymentService);
        employeePaymentService.calculatePay(employee);

        EmployeeTimetrackingService employeeTimetrackingService = new EmployeeTimetrackingService();
        employeeTimetrackingService.reportHours(employee);

        EmployeeRepository employeeRepository = new EmployeeRepository();
        employeeRepository.save(employee);
    }

}
