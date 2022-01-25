package com.pjf.server.service.impl;

import com.pjf.server.entity.Oplog;
import com.pjf.server.mapper.OplogMapper;
import com.pjf.server.service.IOplogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author pjf
 * @since 2021-12-17
 */
@Service
public class OplogServiceImpl extends ServiceImpl<OplogMapper, Oplog> implements IOplogService {

}
