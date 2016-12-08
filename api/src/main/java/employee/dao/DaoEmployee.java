package employee.dao;

import employee.model.Employee;

import java.util.List;

/**
 * Created by employee on 12/6/16.
 */
public interface DaoEmployee {
    public List<Employee> getAll();
    public void add(Employee employee);
}
