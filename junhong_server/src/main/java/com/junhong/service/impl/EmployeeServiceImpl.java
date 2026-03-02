package com.junhong.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.junhong.constant.PasswordConstant;
import com.junhong.constant.StatusConstant;
import com.junhong.dto.EmployeeDTO;
import com.junhong.dto.EmployeePageQueryDTO;
import com.junhong.entity.Employee;
import com.junhong.mapper.EmployeeMapper;
import com.junhong.result.PageResult;
import com.junhong.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.List;

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
    public PageResult queryPage(EmployeePageQueryDTO employeePageQueryDTO) {
        PageHelper.startPage(employeePageQueryDTO.getPage(),employeePageQueryDTO.getPageSize());
        Page<Employee> page=employeeMapper.pageQuery(employeePageQueryDTO);
        long total=page.getTotal();
        List<Employee> records=page.getResult();
        return new PageResult(total,records);
    }

}
