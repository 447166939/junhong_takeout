package com.junhong.dto;

import com.junhong.validation.LoginGroup;
import com.junhong.validation.UpdateGroup;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeDTO  implements Serializable {
    private static final long serialVersionUID = 1L;
    @NotNull(groups = UpdateGroup.class, message = "更新时ID不能为空")
    private long id;
    private String username;
    private String name;
    private String phone;
    private String sex;
    private String idNumber;
    @NotNull(groups = LoginGroup.class,message = "密码不能为空")
    private String password;
}
