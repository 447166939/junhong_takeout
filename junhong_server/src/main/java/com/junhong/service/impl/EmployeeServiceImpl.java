package com.junhong.service.impl;

import com.junhong.constant.PasswordConstant;
import com.junhong.constant.StatusConstant;
import com.junhong.dto.EmployeeDTO;
import com.junhong.entity.Employee;
import com.junhong.mapper.EmployeeMapper;
import com.junhong.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

@Service
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeMapper employeeMapper;
    public void save(EmployeeDTO employeeDTO) {
        Employee employee=new Employee();
        BeanUtils.copyProperties(employeeDTO,employee);
        employee.setStatus(StatusConstant.ENABLE);
        employee.setPassword(DigestUtils.md5DigestAsHex(PasswordConstant.DEFAULT_PASSWORD.getBytes()));
        employeeMapper.insert(employee);
    }

}
