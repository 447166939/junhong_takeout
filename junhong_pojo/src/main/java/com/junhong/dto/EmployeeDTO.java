package com.junhong.dto;

import lombok.Data;

import java.io.Serializable;
@Data
public class EmployeeDTO  implements Serializable {
    private static final long serialVersionUID = 1L;
    private long id;
    private String username;
    private String name;
    private String phone;
    private String sex;
    private String idNumber;
}
