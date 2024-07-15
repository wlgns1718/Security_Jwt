package com.cos.security1.controller;


import com.cos.security1.dto.UserDto;
import com.cos.security1.entity.User;
import com.cos.security1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {

    @Autowired
    private UserService userService;

    @GetMapping({"","/"})
    public String index(){
        //머스태치 기본폴더 src/main/resources/
        //뷰리졸버 설정 : templates(prefix), mustache (suffix) 생략가능
        return "index";
    }

    @GetMapping("/user")
    public @ResponseBody String user(){
        return "user";
    }
    @GetMapping("/admin")
    public @ResponseBody String admin(){
        return "user";
    }

    @GetMapping("/manager")
    public @ResponseBody String manager(){
        return "manager";
    }

    @GetMapping("/loginForm")
    public String loginForm(){
        return "loginForm";
    }

    @GetMapping("/joinForm")
    public String joinForm(){
        return "joinForm";
    }

    @PostMapping("/join")
    public String join(UserDto userDto) throws Exception {
        System.out.println(userDto);

        System.out.println(userService.registUser(userDto));
        return "redirect:/loginForm";
    }
}
