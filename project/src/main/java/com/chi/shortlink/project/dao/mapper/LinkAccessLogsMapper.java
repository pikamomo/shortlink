package com.chi.shortlink.project.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chi.shortlink.project.dao.entity.LinkAccessLogsDO;
import com.chi.shortlink.project.dto.req.ShortLinkStatsAccessRecordReqDTO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface LinkAccessLogsMapper extends BaseMapper<LinkAccessLogsDO> {
    @Select("<script> " +
            "SELECT " +
            "    user, " +
            "    CASE " +
            "        WHEN MIN(create_time) BETWEEN #{startDate} AND #{endDate} THEN 'new' " +
            "        ELSE 'old' " +
            "    END AS uvType " +
            "FROM " +
            "    t_link_access_logs " +
            "WHERE " +
            "    full_short_url = #{fullShortUrl} " +
            "    AND gid = #{gid} " +
            "    AND user IN " +
            "    <foreach item='item' index='index' collection='userAccessLogsList' open='(' separator=',' close=')'> " +
            "        #{item} " +
            "    </foreach> " +
            "GROUP BY " +
            "    user;" +
            "    </script>"
    )
    List<Map<String, Object>> selectUvTypeByUsers(@Param("gid") ShortLinkStatsAccessRecordReqDTO requestParam, @Param("userAccessLogsList") List<String> userAccessLogsList);
}
