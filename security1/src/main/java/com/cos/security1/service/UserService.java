package com.cos.security1.service;


import com.cos.security1.dto.UserDto;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    public long registUser(UserDto userDto) throws Exception;

}
