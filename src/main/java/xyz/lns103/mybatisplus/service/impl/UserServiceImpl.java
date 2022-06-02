package xyz.lns103.mybatisplus.service.impl;

import xyz.lns103.mybatisplus.entity.User;
import xyz.lns103.mybatisplus.mapper.UserMapper;
import xyz.lns103.mybatisplus.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lns103
 * @since 2022-04-16
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
