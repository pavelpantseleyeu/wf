package by.epam.wf.testtask.util;

import by.epam.wf.testtask.domain.Employee;
import by.epam.wf.testtask.service.impl.EmployeesDaoImpl;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import java.util.*;


public class DBTest {

  private static EmbeddedDatabase db;

  @BeforeClass
  public static void setUp() {
    db = new EmbeddedDatabaseBuilder()
        .setType(EmbeddedDatabaseType.DERBY)
        .addScript("create-db.sql")
        .addScript("insert-data.sql")
        .build();
  }

  @AfterClass
  public static void tearDown() { db.shutdown(); }

  @Test
  public void selectEmployeesTest() {
    String sql = "SELECT name, sum(payment) as summ FROM employees GROUP by name HAVING sum(payment) < 5000";
    Collection<Employee> employees = new EmployeesDaoImpl().getEmployeesBySqlQuery(db, sql);
    assert employees.size() == 2;
    List expected = Arrays.asList("emp2", "emp3");
    List actual = new ArrayList();
    for (Employee emp: employees){
      assert emp.getTotalPayments() == 800.0 || emp.getTotalPayments() == 100.0;
      actual.add(emp.getName());
    }
    Assert.assertEquals(expected, actual);
  }
}
