package cn.iocoder.yudao.module.autopart.controller.admin.storage;

import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Operation;

import javax.validation.constraints.*;
import javax.validation.*;
import javax.servlet.http.*;
import java.util.*;
import java.io.IOException;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

import cn.iocoder.yudao.framework.excel.core.util.ExcelUtils;

import cn.iocoder.yudao.framework.apilog.core.annotation.ApiAccessLog;
import static cn.iocoder.yudao.framework.apilog.core.enums.OperateTypeEnum.*;

import cn.iocoder.yudao.module.autopart.controller.admin.storage.vo.*;
import cn.iocoder.yudao.module.autopart.dal.dataobject.storage.StorageDO;
import cn.iocoder.yudao.module.autopart.service.storage.StorageService;

@Tag(name = "管理后台 - 汽配仓库")
@RestController
@RequestMapping("/autopart/storage")
@Validated
public class StorageController {

    @Resource
    private StorageService storageService;

    @PostMapping("/create")
    @Operation(summary = "创建汽配仓库")
    @PreAuthorize("@ss.hasPermission('autopart:storage:create')")
    public CommonResult<Long> createStorage(@Valid @RequestBody StorageSaveReqVO createReqVO) {
        return success(storageService.createStorage(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新汽配仓库")
    @PreAuthorize("@ss.hasPermission('autopart:storage:update')")
    public CommonResult<Boolean> updateStorage(@Valid @RequestBody StorageSaveReqVO updateReqVO) {
        storageService.updateStorage(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除汽配仓库")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('autopart:storage:delete')")
    public CommonResult<Boolean> deleteStorage(@RequestParam("id") Long id) {
        storageService.deleteStorage(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得汽配仓库")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('autopart:storage:query')")
    public CommonResult<StorageRespVO> getStorage(@RequestParam("id") Long id) {
        StorageDO storage = storageService.getStorage(id);
        return success(BeanUtils.toBean(storage, StorageRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得汽配仓库分页")
    @PreAuthorize("@ss.hasPermission('autopart:storage:query')")
    public CommonResult<PageResult<StorageRespVO>> getStoragePage(@Valid StoragePageReqVO pageReqVO) {
        PageResult<StorageDO> pageResult = storageService.getStoragePage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, StorageRespVO.class));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出汽配仓库 Excel")
    @PreAuthorize("@ss.hasPermission('autopart:storage:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportStorageExcel(@Valid StoragePageReqVO pageReqVO,
              HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<StorageDO> list = storageService.getStoragePage(pageReqVO).getList();
        // 导出 Excel
        ExcelUtils.write(response, "汽配仓库.xls", "数据", StorageRespVO.class,
                        BeanUtils.toBean(list, StorageRespVO.class));
    }

}