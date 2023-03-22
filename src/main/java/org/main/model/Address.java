package org.main.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    private String addressId;
    private String landMark;
    private String pinCode;
    private String state;
    private String country;

}
