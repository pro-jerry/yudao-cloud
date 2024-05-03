package cn.iocoder.yudao.module.autopart.controller.admin.storage.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import javax.validation.constraints.*;

@Schema(description = "管理后台 - 汽配仓库新增/修改 Request VO")
@Data
public class StorageSaveReqVO {

    @Schema(description = "仓库ID", example = "10")
    private Long id;

    @Schema(description = "仓库名字", requiredMode = Schema.RequiredMode.REQUIRED, example = "张三")
    @NotEmpty(message = "仓库名字不能为空")
    private String name;

    @Schema(description = "仓库编号")
    private String num;

    @Schema(description = "库存容量(立方米)")
    private Long capacity;

    @Schema(description = "仓库地址")
    private String address;

    @Schema(description = "排序序号")
    private Integer sort;

    @Schema(description = "仓库状态 0=关闭 1=开启", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "仓库状态 0=关闭 1=开启不能为空")
    private Integer status;

    @Schema(description = "是否锁定 0=未锁定 1=已锁定", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    @NotNull(message = "是否锁定 0=未锁定 1=已锁定不能为空")
    private Integer locked;

    @Schema(description = "备注", example = "你说的对")
    private String remark;

    @Schema(description = "仓库主管ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "19443")
    @NotNull(message = "仓库主管ID不能为空")
    private Long userId;

}