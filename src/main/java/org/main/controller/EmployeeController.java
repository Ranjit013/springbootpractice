package org.main.controller;

import org.main.model.Employee;
import org.main.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    EmployeeService employeeService = new EmployeeService();

    @GetMapping("/test")
    public String gettingStarted() {
        return "Hello World";
    }

    @PutMapping("/puttest/id/{id}")
    public String gettingStartedWithPut(@PathVariable(value = "id", required = false) String id, @RequestParam("name") String name, @RequestParam("age") String age) {
        System.out.println("EmployeeController.gettingStartedWithPut");
        System.out.println("id = [" + id + "], name = [" + name + "], age = [" + age + "]");

        return null;
    }

    public void testMethodParametersSwitch() {
        List<String> list = new ArrayList<>();
        employeeService.employeeVariableSwitch("Test2", new Employee(), "Test3", null);


    }

    private  class Inner_Demo {
        private String test1;
        private String test2;


        public String getTest1() {
            return test1;
        }

        public void setTest1(String test1) {
            this.test1 = test1;
        }

        public String getTest2() {
            return test2;
        }

        public void setTest2(String test2) {
            this.test2 = test2;
        }

        public void print() {
            System.out.println("This is an inner class");
        }
    }

}
