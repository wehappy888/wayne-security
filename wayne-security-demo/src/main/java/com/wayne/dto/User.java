package com.wayne.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonView;
import com.wayne.validator.MyConstraint;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import java.util.Date;

/**
 * @author waynewang
 */
@Data
public class User {

    public interface UserSimpleView {
    }

    public interface UserDetailView extends UserSimpleView {
    }

    private String id;

    @JsonView(UserSimpleView.class)
    @NotBlank(message = "用户名不能为空")
    @Pattern(regexp = "\\d+",message = "用户名格式不正确")
    @MyConstraint(message = "这是一个测试的注解")
    @ApiModelProperty(value = "用户名")
    private String userName;

    @JsonView(UserDetailView.class)
    @NotBlank(message = "密码不能为空")
    @ApiModelProperty(value = "密码")
    private String password;

    /**
     * //@DateTimeFormat 注解的 pattern 属性值指定的日期时间格式并不是将要转换成的日期格式，这个指定的格式是和传入的参数对应的
     */
    @JsonView(UserDetailView.class)
    @JsonFormat
    @Past(message = "生日必须是过去的时间")
    private Date birthday;
}
