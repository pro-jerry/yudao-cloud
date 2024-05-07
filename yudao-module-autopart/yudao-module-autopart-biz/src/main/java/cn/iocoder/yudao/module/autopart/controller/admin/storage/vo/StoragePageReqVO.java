package cn.iocoder.yudao.module.autopart.controller.admin.storage.vo;

import lombok.*;
import java.util.*;
import io.swagger.v3.oas.annotations.media.Schema;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "管理后台 - 汽配仓库分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class StoragePageReqVO extends PageParam {

    @Schema(description = "仓库名字", example = "张三")
    private String name;

    @Schema(description = "仓库编号")
    private String num;

    @Schema(description = "库存容量(立方米)")
    private Long capacity;

    @Schema(description = "仓库状态 0=关闭 1=开启", example = "1")
    private Integer status;

    @Schema(description = "是否锁定 0=未锁定 1=已锁定", example = "0")
    private Integer locked;

}