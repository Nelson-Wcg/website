package cc.xiaoerbi.model;

import lombok.Data;

@Data
public class User {
    private int id;
    private String username;
    private String password;
    private String gender;
    private String profilePicture;
    private String roles;
}
