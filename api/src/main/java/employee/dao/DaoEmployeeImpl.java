package employee.dao;

import employee.model.Employee;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by employee on 12/6/16.
 */
@Repository
public class DaoEmployeeImpl implements DaoEmployee {

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public List<Employee> getAll() {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Employee.class);
        List<Employee> result = criteria.list();
        return  result;
    }

    @Override
    public void add(Employee employee) {

    }
}
