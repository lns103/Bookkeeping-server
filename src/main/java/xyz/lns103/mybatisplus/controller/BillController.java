package xyz.lns103.mybatisplus.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import xyz.lns103.mybatisplus.entity.Bill;
import xyz.lns103.mybatisplus.entity.User;
import xyz.lns103.mybatisplus.mapper.UserMapper;
import xyz.lns103.mybatisplus.service.BillService;
import xyz.lns103.mybatisplus.service.UserService;

import java.util.ArrayList;
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
@RequestMapping("/bill")
public class BillController {
    @Autowired
    private BillService billService;
    @Autowired
    private UserService userService;


//    @GetMapping("/list/user={user}/password={password}")
//    public List<Bill> list(@PathVariable("user")String user, @PathVariable("password")String password){
//        List<User> users = userService.list();
//        List<Bill> all = new ArrayList<Bill>()
//                ,select = new ArrayList<Bill>();
//        for(int i=0;i<users.size();i++){
//            if(users.get(i).getUserId().equals(user)) {
//                if(users.get(i).getPassword().equals(password)) all = this.billService.list();
//            }
//        }
//        if(all.isEmpty()) return null;
//        for(int i=0;i<all.size();i++){
//            if(all.get(i).getUserId().equals(user)) {
//                select.add(all.get(i));
//            }
//        }
//        if(select.isEmpty()) return null;
//        return select;
//    }
    @GetMapping("/list/user={user}/password={password}")
    public List<Bill> list(@PathVariable("user")String user, @PathVariable("password")String password){
        QueryWrapper<Bill> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id" , user);
        QueryWrapper<User> wrapper2 = new QueryWrapper<>();
        wrapper2.eq("user_id" , user);

        User userGet = this.userService.getOne(wrapper2);
        if(userGet!=null) {
            if (userGet.getPassword().equals(password))
                return this.billService.list(wrapper);
        }
        return null;
    }

//    @DeleteMapping("/delete/id/{id}/user={user}/password={password}")
//    public boolean delete(@PathVariable("id") Long id,@PathVariable("user")String user, @PathVariable("password")String password){
//        List<User> users = userService.list();
//        for(int i=0;i<users.size();i++){
//            if(users.get(i).getUserId().equals(user)) {
//                if(users.get(i).getPassword().equals(password))
//                    if(billService.getById(id).getUserId().equals(user))
//                        return this.billService.removeById(id);
//            }
//        }
//        return false;
//    }

    @DeleteMapping("/delete/id/{id}/user={user}/password={password}")
    public boolean delete(@PathVariable("id") Long id,@PathVariable("user")String user, @PathVariable("password")String password){

        QueryWrapper<User> wrapper2 = new QueryWrapper<>();
        wrapper2.eq("user_id" , user);

        User userGet = this.userService.getOne(wrapper2);
        if(userGet!=null) {
            if (userGet.getPassword().equals(password))
                return this.billService.removeById(id);
        }
        return false;
    }


    @GetMapping ("/list/id/{id}/user={user}/password={password}")
    public Bill get(@PathVariable("id") Long id,@PathVariable("user")String user,@PathVariable("password")String password){
        QueryWrapper<User> wrapper2 = new QueryWrapper<>();
        wrapper2.eq("user_id" , user);

        User userGet = this.userService.getOne(wrapper2);
        if(userGet!=null) {
            if (userGet.getPassword().equals(password))
                return this.billService.getById(id);
        }
        return null;
    }

    @PutMapping ("/update/user={user}/password={password}")
    public boolean update(@RequestBody Bill bill,@PathVariable("user")String user, @PathVariable("password")String password){
        QueryWrapper<User> wrapper2 = new QueryWrapper<>();
        wrapper2.eq("user_id" , user);

        User userGet = this.userService.getOne(wrapper2);
        if(userGet!=null) {
            if (userGet.getPassword().equals(password))
                return this.billService.updateById(bill);
        }
        return false;
    }

    @PostMapping ("/add/user={user}/password={password}")
    public boolean add(@RequestBody Bill bill,@PathVariable("user")String user, @PathVariable("password")String password){
        QueryWrapper<User> wrapper2 = new QueryWrapper<>();
        wrapper2.eq("user_id" , user);

        User userGet = this.userService.getOne(wrapper2);
        if(userGet!=null) {
            if (userGet.getPassword().equals(password)){
                bill.setUserId(user);
                return this.billService.save(bill);
            }
        }
        return false;
    }
}

