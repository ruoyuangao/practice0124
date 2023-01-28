package com.example.practice0124.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    private long id;

    private String first_name;

    private String last_name;

    private String middle_name;

    private Date dob;

    public UserDTO(User user) {
        this.id = user.getId();
        this.first_name = user.getFirst_name();
        this.last_name = user.getLast_name();
        this.middle_name = user.getMiddle_name();
        this.dob = user.getDob();
    }

}
