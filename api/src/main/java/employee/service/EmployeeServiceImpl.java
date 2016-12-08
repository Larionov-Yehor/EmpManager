package employee.service;

import employee.dao.DaoEmployee;
import employee.dao.DaoEmployeeImpl;
import employee.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by employee on 12/6/16.
 */
@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    DaoEmployeeImpl dao;

    @Override
    public List<Employee> getAll() {
        List<Employee> result = dao.getAll();

        return result;
    }
}
