package com.wayne.dto;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;

/**
 * @author waynewang
 */
@Data
public class User {

    public interface UserSimpleView {
    }

    public interface UserDetailView extends UserSimpleView {
    }

    @JsonView(UserSimpleView.class)
    private String userName;

    @JsonView(UserDetailView.class)
    private String password;


}
