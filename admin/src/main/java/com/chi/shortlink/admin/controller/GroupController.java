package com.chi.shortlink.admin.controller;

import com.chi.shortlink.admin.common.convention.result.Result;
import com.chi.shortlink.admin.common.convention.result.Results;
import com.chi.shortlink.admin.dto.req.ShortLinkGroupSaveReqDTO;
import com.chi.shortlink.admin.dto.req.ShortLinkGroupUpdateReqDTO;
import com.chi.shortlink.admin.dto.resp.ShortLinkGroupRespDTO;
import com.chi.shortlink.admin.service.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * short link group controller
 */
@RestController
@RequiredArgsConstructor
public class GroupController {

    private final GroupService groupService;

    /**
     * create short link group
     */
    @PostMapping("/api/short-link/v1/group")
    public Result<Void> save(@RequestBody ShortLinkGroupSaveReqDTO requestParam) {
        groupService.saveGroup(requestParam.getName());
        return Results.success();
    }

    /**
     * query short link group
     */
    @GetMapping("/api/short-link/v1/group")
    public Result<List<ShortLinkGroupRespDTO>> listGroup() {
        return Results.success(groupService.listGroup());
    }

    /**
     * update short link group
     */
    @PutMapping("/api/short-link/v1/group")
    public Result<Void> updateGroup(@RequestBody ShortLinkGroupUpdateReqDTO requestParam) {
        return Results.success(groupService.updateGroup(requestParam));
    }
}
