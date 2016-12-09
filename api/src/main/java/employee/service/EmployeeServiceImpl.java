package employee.service;

import employee.model.Employee;
import employee.repositoroes.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by employee on 12/6/16.
 */
@Service
@Transactional
public class EmployeeServiceImpl {

    @Autowired
    EmployeeRepository employeeRepository;

    public List<Employee> getAll() {
        return employeeRepository.findAll();

    }
}
