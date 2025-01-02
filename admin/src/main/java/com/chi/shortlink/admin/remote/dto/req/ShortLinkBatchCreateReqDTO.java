package com.chi.shortlink.admin.remote.dto.req;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * Short link batch creation request object
 *
 */
@Data
public class ShortLinkBatchCreateReqDTO {

    /**
     * Original link collection
     */
    private List<String> originUrls;

    /**
     * Description collection
     */
    private List<String> describes;

    /**
     * Group identifier
     */
    private String gid;

    /**
     * Creation type 0: API creation 1: Console creation
     */
    private Integer createdType;

    /**
     * Validity type 0: Permanent 1: Custom
     */
    private Integer validDateType;

    /**
     * Validity date
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date validDate;
}