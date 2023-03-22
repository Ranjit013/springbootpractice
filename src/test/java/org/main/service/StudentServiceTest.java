package org.main.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.main.dao.AddressDao;
import org.main.dao.EmployeeDao;
import org.main.dao.StudentDao;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.function.Supplier;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

public class StudentServiceTest {

    private StudentService studentService;
    @Mock
    private StudentDao studentDao;
    @Mock
    private EmployeeDao employeeDao;
    @Mock
    private AddressDao addressDao;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        studentService = new StudentService(addressDao, studentDao, employeeDao);
    }

    @Test
    public void saveStudentTest() {
        final StudentService studentService = spy(this.studentService);
        studentService.saveAddress();
        verify(studentService, times(1)).saveAddress();
    }

    @Test
    public void saveAddressTest() {
        when(addressDao.saveAddress()).thenReturn(true);
        Assert.assertTrue(studentService.saveAddress());
    }

    @Test
    public void saveEmployeeTest() {
        final StudentService studentService = spy(this.studentService);
        studentService.saveEmployee("Bangalore", "560068");
        verify(studentService, times(1)).saveEmployee(anyString(), anyString());
    }

    @Test(timeout = 10000)
    public void saveEmployeeTest01() throws InterruptedException {
        measureTime((Supplier<Boolean>) () -> studentService.saveEmployee("GB", "560068"));
        measureTime((Runnable) () -> studentService.testEmployee("Hello"));
    }

    private  <T> void measureTime(T methodToCall) {
        long startTime = System.currentTimeMillis();
        methodtoCall(methodToCall);
        long endTime = System.currentTimeMillis();
        System.out.println(startTime - endTime);
    }

    private <T> void methodtoCall(T methodToCall) {
        if (methodToCall instanceof Runnable) {
            ((Runnable) methodToCall).run();
        } else {
            ((Supplier) methodToCall).get();
        }
    }


}