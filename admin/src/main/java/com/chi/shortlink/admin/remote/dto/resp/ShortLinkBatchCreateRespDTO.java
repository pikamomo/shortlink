package com.chi.shortlink.admin.remote.dto.resp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Short link batch creation response object
 *
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ShortLinkBatchCreateRespDTO {

    /**
     * Number of successful creations
     */
    private Integer total;

    /**
     * Batch creation return parameters
     */
    private List<ShortLinkBaseInfoRespDTO> baseLinkInfos;
}