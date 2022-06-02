package xyz.lns103.mybatisplus.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;
import xyz.lns103.mybatisplus.entity.User;
import xyz.lns103.mybatisplus.service.UserService;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lns103
 * @since 2022-04-16
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    public UserService userService;

//    @GetMapping("/register/user={user}/password={password}")
//    public String register(@PathVariable("user")String user, @PathVariable("password")String password){
//        List<User> users = userService.list();
//        for(int i=0;i<users.size();i++){
//            if(users.get(i).getUserId().equals(user)) return "This name is already registered.";
//        }
//        User newUser = new User(user,password);
//        if(userService.save(newUser)) return "success";
//        else return "Unknown error";
//    }

    @GetMapping("/register/user={user}/password={password}")
    public String register(@PathVariable("user")String user, @PathVariable("password")String password){
        QueryWrapper<User> wrapper2 = new QueryWrapper<>();
        wrapper2.eq("user_id" , user);

        User userGet = this.userService.getOne(wrapper2);
        if(userGet!=null) return "This name is already registered.";

        User newUser = new User(user,password);
        if(userService.save(newUser)) return "success";
        else return "Unknown error";
    }

    @GetMapping("/login/user={user}/password={password}")
    public String login(@PathVariable("user")String user, @PathVariable("password")String password){
        QueryWrapper<User> wrapper2 = new QueryWrapper<>();
        wrapper2.eq("user_id" , user);

        User userGet = this.userService.getOne(wrapper2);
        if(userGet!=null) {
            if(userGet.getPassword().equals(password)) return "success";
            else return "wrong password";
        }
        return "can't find this user";
    }

    @GetMapping("/edit/user={user}/password={password}/new_password={new_password}")
    public String login(@PathVariable("user")String user, @PathVariable("password")String password,@PathVariable("new_password")String new_password){
        QueryWrapper<User> wrapper2 = new QueryWrapper<>();
        wrapper2.eq("user_id" , user);

        User userGet = this.userService.getOne(wrapper2);
        if(userGet!=null) {
            if(userGet.getPassword().equals(password)){
                userGet.setPassword(new_password);
                userService.updateById(userGet);
                return "success";
            }
            else return "wrong password";
        }
        return "can't find this user";
    }
}
