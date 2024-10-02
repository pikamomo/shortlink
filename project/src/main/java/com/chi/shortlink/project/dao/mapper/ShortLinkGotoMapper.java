package com.chi.shortlink.project.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chi.shortlink.project.dao.entity.ShortLinkGotoDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * short link redirect Persistence Layer
 */
@Mapper
public interface ShortLinkGotoMapper extends BaseMapper<ShortLinkGotoDO> {

}
