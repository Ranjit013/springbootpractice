package org.main.dao;

import org.springframework.stereotype.Repository;

@Repository
public class StudentDao {

    public boolean saveStudent() {

        System.out.println("StudentDao.saveStudent");

        return true;
    }
}
