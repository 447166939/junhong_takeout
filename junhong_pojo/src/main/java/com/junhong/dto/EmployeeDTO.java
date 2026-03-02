package com.junhong.dto;

import com.junhong.validation.UpdateGroup;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.io.Serializable;
@Data
public class EmployeeDTO  implements Serializable {
    private static final long serialVersionUID = 1L;
    @NotNull(groups = UpdateGroup.class, message = "更新时ID不能为空")
    private long id;
    private String username;
    private String name;
    private String phone;
    private String sex;
    private String idNumber;
}
