package model;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class Employee {

    int id;
    String name;
    int salary;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    String dept;


    String costCentre;

    public Employee(int id, String name, int salary, String dept ,String costCentre) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.dept = dept;
        this.costCentre = costCentre;
    }


    public void setCostCentre(String costCentre) {
        this.costCentre = costCentre;
    }

    public Optional<String> getCostCentre() {
        return Optional.ofNullable(costCentre);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }
    public List<Student> getInternStudents(){
        List<Student> students = Arrays.asList(
                new Student(1, "Viraj", 17),
                new Student(2, "Krishnanand", 18),
                new Student(3, "Rishi", 16),
                new Student(4, "Suresh", 23),
                new Student(5, "Aditya", 21)
        );

        return students;

    }


}
