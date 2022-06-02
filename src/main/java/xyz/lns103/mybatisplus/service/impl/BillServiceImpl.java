package xyz.lns103.mybatisplus.service.impl;

import xyz.lns103.mybatisplus.entity.Bill;
import xyz.lns103.mybatisplus.mapper.BillMapper;
import xyz.lns103.mybatisplus.service.BillService;
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
public class BillServiceImpl extends ServiceImpl<BillMapper, Bill> implements BillService {

}
