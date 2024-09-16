package com.chi.shortlink.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chi.shortlink.admin.dao.entity.GroupDO;
import com.chi.shortlink.admin.dao.mapper.GroupMapper;
import com.chi.shortlink.admin.service.GroupService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * short link group interface implement layer
 */
@Slf4j
@Service
public class GroupServiceImpl  extends ServiceImpl<GroupMapper, GroupDO> implements GroupService {
}
