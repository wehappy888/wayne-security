package com.wayne.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;

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
    private String userName;

    @JsonView(UserDetailView.class)
    private String password;

    /**
     * //@DateTimeFormat 注解的 pattern 属性值指定的日期时间格式并不是将要转换成的日期格式，这个指定的格式是和传入的参数对应的
     */
    @JsonView(UserDetailView.class)
    @JsonFormat
    private Date birthday;
}
