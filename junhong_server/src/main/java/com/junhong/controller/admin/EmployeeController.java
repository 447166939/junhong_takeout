package com.junhong.controller.admin;
import com.junhong.constant.JwtClaimsConstant;
import com.junhong.dto.EmployeeDTO;
import com.junhong.dto.EmployeePageQueryDTO;
import com.junhong.entity.Employee;
import com.junhong.properties.JwtProperties;
import com.junhong.result.PageResult;
import com.junhong.service.EmployeeService;
import com.junhong.utils.JwtUtil;
import com.junhong.validation.AddGroup;
import com.junhong.vo.EmployeeLoginVO;
import com.junhong.vo.UserLoginVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.junhong.result.Result;

import java.util.HashMap;
import java.util.Map;

/*员工管理****
************
 */
@RestController
@RequestMapping("admin/employee")
@Api(tags="员工相关接口")
@Slf4j
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private JwtProperties jwtProperties;

    /**
     * 员工登录
     * @param employeeDTO
     * @return
     */
    @PostMapping("/login")
    @ApiOperation("员工登录接口")
    public Result<EmployeeLoginVO> login(@Valid @RequestBody EmployeeDTO employeeDTO) {
        Employee employee=employeeService.login(employeeDTO);
        //登录成功后，生成jwt令牌
        Map<String, Object> claims = new HashMap<>();
        claims.put(JwtClaimsConstant.EMP_ID, employee.getId());
        String token = JwtUtil.createJWT(
                jwtProperties.getAdminSecretKey(),
                jwtProperties.getAdminTtl(),
                claims);
        EmployeeLoginVO employeeLoginVO = EmployeeLoginVO.builder()
                .id(employee.getId())
                .userName(employee.getUsername())
                .name(employee.getName())
                .token(token)
                .build();
        return Result.success(employeeLoginVO);
    }
    /**
     * 新增员工
     * @param employeeDTO
     * @return
     */
    @PostMapping("/add")
    @ApiOperation("新增员工")
 public Result save(@Validated(AddGroup.class) @RequestBody EmployeeDTO employeeDTO) {
     log.info("新增员工{}",employeeDTO);
     employeeService.save(employeeDTO);
      return Result.success();
   }
    /**
     * 员工分页查询
     * @param employeePageQueryDTO
     * @return
     */
   @GetMapping("/list")
   @ApiOperation("员工分页查询")
   public Result<PageResult> list(EmployeePageQueryDTO employeePageQueryDTO) {
        log.info("分页查询参数为:{}",employeePageQueryDTO);
        PageResult pageResult=employeeService.queryPage(employeePageQueryDTO);
        return Result.success(pageResult);
   }

    /**
     * 启用或者禁用员工
     * @param status
     * @param id
     * @return
     */
    @ApiOperation("启用或者禁用员工")
   @PostMapping("/editStatus/{status}")
   public Result startOrStop(@PathVariable Integer status,long id){
       employeeService.startOrStop(status,id);
       return Result.success();
   }
    /**
     * 根据iD查询用户信息
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    @ApiOperation("根据iD查询用户信息")
    public Result<Employee> getById(@PathVariable Long id) {
        log.info("根据iD查询用户信息：{}", id);
        Employee employee = employeeService.getById(id);
        return Result.success(employee);
    }
}
