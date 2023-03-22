package org.main.model;


import com.opencsv.bean.CsvBindByPosition;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Employee {

    @CsvBindByPosition(position = 0)
    private String employeeId;
    @CsvBindByPosition(position = 1)
    private String employeeName;
    @CsvBindByPosition(position = 2)
    private String address;

    private List<Pet> pets;



    @Override
    public String toString() {
        return String.format("%s%s%s", employeeId, employeeName, address);
    }
}