package singleResponsability.good;

public class EmployeeTimetrackingService {

    public void reportHours(GoodEmployee employee) {
        System.out.println(String.format("%s worked %d hours.\n", employee.getName(), employee.getHours()));
    }
}
