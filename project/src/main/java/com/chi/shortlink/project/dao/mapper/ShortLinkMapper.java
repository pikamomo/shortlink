package com.chi.shortlink.project.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chi.shortlink.project.dao.entity.ShortLinkDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * short link Persistence Layer
 */
@Mapper
public interface ShortLinkMapper extends BaseMapper<ShortLinkDO> {
}
