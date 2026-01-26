package interfaceexample;

public class Manager implements Employee{
    @Override
    public void salaryCalculation() {
        System.out.println(100*1000);
    }

    @Override
    public String designation() {
        return "EM";
    }

    public static void main(String[] args) {
       /* Manager manager = new Manager();
        manager.salaryCalculation();
        System.out.println(manager.designation());*/

        Employee employee = new Manager();
        employee.salaryCalculation();

    }
}
