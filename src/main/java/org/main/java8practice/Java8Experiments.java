package org.main.java8practice;

import org.main.interfaces.MyInterface;
import org.main.service.EmployeeService;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Java8Experiments {

    public static void main(String[] args) {
        transformMethod(Java8Experiments::test);
        transformMethod(Java8Experiments::test01);
        List<String> list = Arrays.asList("a", "b", "c", "d");
        list.stream().map(ReusableTest::getValue).collect(Collectors.toList());
    }

    private static Integer test(Object... objects) {
        return 0;
    }
    private static Integer test01(Object... objects) {
        return 1;
    }
    public static void transformMethod(MyInterface myInterface) {
        List<String> list = Arrays.asList("a", "b", "c", "d");
        list.stream().map(ReusableTest::getValue).collect(Collectors.toList());
        System.out.println(((Integer) myInterface.transform("a", "b", "c")));
    }

    private String transfrom(String a) {
        return a + "Hello";
    }

    public void test() {
        Map<String, String> map = new HashMap<>();
        List<String> list = Arrays.asList("a", "b", "c", "d");
        EmployeeService employeeService = new EmployeeService();
        list.stream().map(this::getEmployeeService).map(employeeService::tesMyStringjava8).forEach(System.out::println);
    }

    public EmployeeService getEmployeeService(String s) {
        return new EmployeeService();
    }

    public void exceptionThrown() {
        int num =4;
        try {
            int i = num / 0;
        } catch (Exception e) {
            throw new RuntimeException("Exception Occured while processing");
        }
    }

    private static class ReusableTest {
        private String a;

        public ReusableTest(String a) {
            this.a = a;
        }

        private static String getValue(String a) {
            return a;
        }

        public String getA() {
            return a;
        }
    }
}
