package com.cos.security1.entity;


import com.cos.security1.dto.UserDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.security.Timestamp;


@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID")
    private long id;

    @Column(name = "USER_NAME")
    private String userName;

    private String passWord;

    private String email;

    private Role role;

    @CreationTimestamp
    private Timestamp createDate;

    public static User toEntity(UserDto userDto){
        return User.builder()
                .userName(userDto.getUsername())
                .passWord(userDto.getPassword())
                .email(userDto.getEmail())
                .role(Role.USER)
                .build();
    }
}
