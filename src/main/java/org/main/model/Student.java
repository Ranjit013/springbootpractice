package org.main.model;

import com.opencsv.bean.CsvBindByPosition;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Student  extends Employee{
    @CsvBindByPosition(position = 0)
    private String id;
    @CsvBindByPosition(position = 1)
    private String name;
    @CsvBindByPosition(position = 2)
    private String address;



    public Student(Employee employee, String id, String name, String address1) {
        super(employee.getEmployeeId(), employee.getEmployeeName(), employee.getAddress(), employee.getPets());
        this.id = id;
        this.name = name;
        this.address = address1;
    }
}
