package org.main.service;

import org.main.dao.AddressDao;
import org.main.dao.EmployeeDao;
import org.main.dao.StudentDao;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    private final AddressDao addressDao;
    private final StudentDao studentDao;
    private final EmployeeDao employeeDao;


    public StudentService(AddressDao addressDao, StudentDao studentDao, EmployeeDao employeeDao) {
        this.addressDao = addressDao;
        this.studentDao = studentDao;
        this.employeeDao = employeeDao;
    }

    public void saveStudent() {
        final boolean success = studentDao.saveStudent();
    }

    public boolean saveAddress() {
        return addressDao.saveAddress();
    }

    public boolean saveEmployee(String location, String pincode)  {
        System.out.println("location = " + location + ", pincode = " + pincode);
        return employeeDao.saveEmployee();
    }

    public void testEmployee(String hello) {
        System.out.println(hello);
    }
}
