package com.junhong.controller.admin;
import com.junhong.dto.EmployeeDTO;
import com.junhong.dto.EmployeePageQueryDTO;
import com.junhong.result.PageResult;
import com.junhong.service.EmployeeService;
import com.junhong.validation.AddGroup;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.junhong.result.Result;

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
}
