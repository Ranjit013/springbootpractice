package org.main.service;

import org.apache.commons.collections4.map.MultiKeyMap;
import org.main.dao.EmployeeDao;
import org.main.model.Employee;
import org.main.model.Student;
import org.main.tranformers.GenericsTest;
import org.main.tranformers.GenericsTestImpl;
import org.main.tranformers.Transformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;




@Service
public class EmployeeService {



    @Autowired
    @Qualifier(value = "csvTransformer")
    Transformer<String, List<? extends Object>> csvTransformer1;
    private Field[] fieldsWithAnnotation;



    GenericsTest<String, String>genericsTest = new GenericsTestImpl();


    public EmployeeDao employeeDao;

    public static String test(String name) {
        System.out.println("fuck you");
        System.out.println(name);
        return "Hello World";
    }

    public static void multiKeyMap() {
        MultiKeyMap<String, String> map = new MultiKeyMap();
        map.put("Test1", "Test2", "Test3");
        final String s = map.get("Test1", "Test2");
        System.out.println(s);
    }

    //Added Comments to my code
    public static void main(String[] args) {
        multiKeyMap();
        System.out.println("It is very helpful in cherry picking this branch");
    }

    public void test1() {
        testThisMethod();
        testThisMethod01("Test1", "Test2", null, new Employee());
        System.out.println("Hello World Fuck the world");
    }

    private String testThisMethod01(String string, String string2, Object object, Employee employee) {
        System.out.println("I am good enough for god Sake");
        testThisMethod();
        return "I am good enough";
    }

    private void testThisMethod() {
        System.out.println("Hello World");
        List<String> strings = Arrays.asList("A", "B");
    }

    public String test4() {
        return "hello World";
    }

    public void employeeVariableSwitch(String str1, Employee emp, String str3, String test) {
        System.out.println("str1 = " + str1 + ", emp = " + emp + ", str3 = " + str3 + ", test = " + test);
    }


    public String mulitkeyMapTest() {
        MultiKeyMap<String, String> multiKeyMap = new MultiKeyMap<>();
        multiKeyMap.put("TEST1", "TEST2", "VALUE1");
        return multiKeyMap.get("TEST1", "TEST2");


    }

    public List<String> generateObjectFromCSV() throws IOException, IllegalAccessException {
        String employeepath = "C:\\Users\\Ranjit\\Documents\\Employee.csv";
        String studentpath = "C:\\Users\\Ranjit\\Documents\\Student.csv";
        List<Employee> employeeList = (List<Employee>) csvTransformer1.transform(employeepath, Employee.class);
        final List<Student> studentList = (List<Student>) csvTransformer1.transform(studentpath, Student.class);
        System.out.println("I am good with the patching the file and will be very comfortable with it");
        return null;
    }


    public void test() {
        System.out.println("EmployeeService.test");
    }

    public String tesMyStringjava8(EmployeeService h) {
        return "helloWorld!";
    }





}