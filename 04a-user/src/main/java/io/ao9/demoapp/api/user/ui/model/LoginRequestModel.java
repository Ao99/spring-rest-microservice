package io.ao9.demoapp.api.user.ui.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginRequestModel {

    private String email;
    private String password;

}