package com.junhong.service;


import com.junhong.dto.EmployeeDTO;

public interface EmployeeService {
    /**
     * 新增员工
     * @param employeeDTO
     */
    void save(EmployeeDTO employeeDTO);
}
