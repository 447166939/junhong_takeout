package com.junhong.controller.admin;
import com.junhong.dto.EmployeeDTO;
import com.junhong.service.EmployeeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
 public Result save(@RequestBody EmployeeDTO employeeDTO) {
     log.info("新增员工{}",employeeDTO);
     employeeService.save(employeeDTO);
      return Result.success();
   }
}
