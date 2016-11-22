package by.epam.wf.testtask.service.impl;

import by.epam.wf.testtask.domain.Employee;
import by.epam.wf.testtask.service.EmployeesDao;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;


public class EmployeesDaoImpl implements EmployeesDao{
  private JdbcTemplate jdbcTemplateObject;

  private DataSource dataSource;

  public void setDataSource(DataSource dataSource) {
    this.dataSource = dataSource;
    this.jdbcTemplateObject = new JdbcTemplate(dataSource);
  }

  public Collection<Employee> getEmployeesBySqlQuery(DataSource db, String sql) {
    Map<Double, Employee> employees = new HashMap<>();
    setDataSource(db);
    List<Employee> us = this.jdbcTemplateObject.query(sql, new RowMapper<Employee>() {
      @Override
      public Employee mapRow(ResultSet resultSet, int i) throws SQLException {
        Employee employee = new Employee();
        employee.setName(resultSet.getString("NAME"));
        employee.setTotalPayments(resultSet.getDouble("SUMM"));
        return employee;
      }
    });
    Iterator it = us.iterator();
    while (it.hasNext()){
      Employee employee = (Employee) it.next();
      employees.put(employee.getTotalPayments(), employee);
    }
    return employees.values();
  }
}
