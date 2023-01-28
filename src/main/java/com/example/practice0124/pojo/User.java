package com.example.practice0124.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Formula;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name="userinfo")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "first_name", nullable = false)
    private String first_name;

    @Column(name = "last_name", nullable = false)
    private String last_name;

    @Column(name = "middle_name")
    private String middle_name;

    @Column(name = "dob", nullable = false)
//    @DateTimeFormat(pattern = "yy-MM-dd")
    private Date dob;

    public User(UserDTO userDTO) {
        this.id = userDTO.getId();
        this.first_name = userDTO.getFirst_name();
        this.last_name = userDTO.getLast_name();
        this.middle_name = userDTO.getMiddle_name();
        this.dob = userDTO.getDob();
    }

//    @Override
//    public boolean equals(Object obj) {
//        if (this == obj) {
//            return true;
//        }
//
//        if (!(obj instanceof User)) {
//            return false;
//        }
//
//        User user = (User) obj;
//
//        return Objects.equals(this.id, user.id) &&
//                Objects.equals(this.first_name, user.first_name) &&
//                Objects.equals(this.middle_name, user.middle_name) &&
//                Objects.equals(this.last_name, user.last_name) &&
//                Objects.equals(this.dob, user.dob);
//
//    }

}
