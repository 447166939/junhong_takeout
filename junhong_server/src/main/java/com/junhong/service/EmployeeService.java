package com.junhong.service;


import com.junhong.dto.EmployeeDTO;
import com.junhong.dto.EmployeePageQueryDTO;
import com.junhong.result.PageResult;

public interface EmployeeService {
    /**
     * 新增员工
     * @param employeeDTO
     */
    void save(EmployeeDTO employeeDTO);

    /**
     * 分页查询员工列表
     * @param employeePageQueryDTO
     * @return
     */
    PageResult queryPage(EmployeePageQueryDTO employeePageQueryDTO);

    /**
     * 禁用或者启用员工账号
     * @param status
     * @param id
     */
    void startOrStop(Integer status, long id);
}
