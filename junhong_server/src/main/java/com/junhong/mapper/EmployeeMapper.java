package com.junhong.mapper;
import com.github.pagehelper.Page;
import com.junhong.annotation.AutoFill;
import com.junhong.dto.EmployeePageQueryDTO;
import com.junhong.entity.Employee;
import com.junhong.enumeration.OperationType;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface EmployeeMapper {



    /**
     * 插入员工数据
     * @param employee
     */
    @Insert("insert into employee (name, username, password, phone, sex, id_number, create_time, update_time, create_user, update_user,status) " +
            "values " +
            "(#{name},#{username},#{password},#{phone},#{sex},#{idNumber},#{createTime},#{updateTime},#{createUser},#{updateUser},#{status})")
    @AutoFill(value = OperationType.INSERT)
    void insert(Employee employee);
    Page<Employee> pageQuery(EmployeePageQueryDTO employeePageQueryDTO);
}
