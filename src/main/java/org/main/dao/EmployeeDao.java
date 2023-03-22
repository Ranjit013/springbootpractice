package org.main.dao;

import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDao {

    public boolean saveEmployee() {
        System.out.println("EmployeeDao.saveEmployee");
        return true;
    }
}
