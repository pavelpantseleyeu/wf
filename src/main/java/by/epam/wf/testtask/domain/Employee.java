package by.epam.wf.testtask.domain;


public class Employee extends DomainObject {

  private Double totalPayments;
  private String name;

  public Employee(){}

  public Employee(String name, Double totalPayments){
    this.getNextId();
    this.name = name;
    this.totalPayments = totalPayments;
  }

  public String getName() { return name; }

  public void setName(String firstName) {
      this.name = firstName;
    }

  public Double getTotalPayments() { return totalPayments; }

  public void setTotalPayments(Double totalPayments) { this.totalPayments = totalPayments; }
}
