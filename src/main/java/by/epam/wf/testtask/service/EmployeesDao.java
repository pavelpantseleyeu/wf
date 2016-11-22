package by.epam.wf.testtask.service;


import by.epam.wf.testtask.domain.Employee;

import javax.sql.DataSource;
import java.util.Collection;

public interface EmployeesDao {

  public Collection<Employee> getEmployeesBySqlQuery(DataSource db, String sql);
}
