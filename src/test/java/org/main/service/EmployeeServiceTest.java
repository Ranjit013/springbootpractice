package org.main.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.main.model.Employee;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.modules.junit4.PowerMockRunnerDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.powermock.api.mockito.PowerMockito.*;


@RunWith(PowerMockRunner.class)
@PowerMockIgnore("javax.management.*")
@PowerMockRunnerDelegate(SpringJUnit4ClassRunner.class)
@SpringBootTest
@PrepareForTest({EmployeeService.class})
public class EmployeeServiceTest {

    @Autowired
    private EmployeeService emloyeeService;

    @Autowired
    private ObjectMapper objectMapper;

    @Before
    public void setUp() {
        System.out.println(objectMapper.toString());
    }

    @Test
    public void testMymethod() {
        mockStatic(EmployeeService.class);
        when(EmployeeService.test(anyString())).thenCallRealMethod();

    }

    @Test
    public void testMymethod01() throws Exception {
        EmployeeService spy = spy(emloyeeService);
        doNothing().when(spy, "testThisMethod");
        spy.test1();
    }


    //To Test private methods for number of invocation
    @Test
    public void testMymethod02() throws Exception {
        EmployeeService spy = spy(emloyeeService);
        doReturn("hello World").when(spy, "testThisMethod01", anyString(), anyString(), any(), any(Employee.class));
        spy.test1();
        verifyPrivate(spy, times(1)).invoke("testThisMethod");
    }


    //To test a private method
    @Test
    public void testMymethod03() throws Exception {
        EmployeeService spy = spy(emloyeeService);
        doNothing().when(spy, "testThisMethod");
        spy.test1();
        verifyPrivate(spy, times(2)).invoke("testThisMethod");
    }

    @Test
    public void testMymethod04() throws Exception {
        EmployeeService spy = spy(emloyeeService);
        doNothing().when(spy, "testThisMethod");
        verifyPrivate(spy, times(0)).invoke("testThisMethod");
    }

    @Test
    public void test1() {
        spy(EmployeeService.class);
        Assert.assertEquals("Hello World", EmployeeService.test("hello"));
    }

    @Test
    public void testMultikeyMap() {
        Assert.assertEquals("VALUE1", emloyeeService.mulitkeyMapTest());
    }

    @Test
    public void generateObjectFromCSVTest() throws IOException, IllegalAccessException {
        Assert.assertEquals(null, emloyeeService.generateObjectFromCSV());
    }
}