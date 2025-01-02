package com.chi.shortlink.admin.remote.dto.resp;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Short link base information response parameters
 *
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ShortLinkBaseInfoRespDTO {

    /**
     * Description
     */
    @ExcelProperty("Title")
    @ColumnWidth(40)
    private String describe;

    /**
     * Short link
     */
    @ExcelProperty("Short Link")
    @ColumnWidth(40)
    private String fullShortUrl;

    /**
     * Original link
     */
    @ExcelProperty("Original Link")
    @ColumnWidth(80)
    private String originUrl;
}