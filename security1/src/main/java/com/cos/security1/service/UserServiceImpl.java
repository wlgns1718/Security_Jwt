package com.cos.security1.service;

import com.cos.security1.dto.UserDto;
import com.cos.security1.entity.User;
import com.cos.security1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public long registUser(UserDto userDto) throws Exception{

        String rawPassword = userDto.getPassword();
        String encPassword = bCryptPasswordEncoder.encode(rawPassword);
        userDto.setPassword(encPassword);
        System.out.println(userDto);
        User user = User.toEntity(userDto);
        userRepository.save(user);
        return user.getId();
    }
}
