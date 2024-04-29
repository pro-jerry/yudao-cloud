package cn.iocoder.yudao.module.autopart.controller.admin.storage.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import java.util.*;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;
import com.alibaba.excel.annotation.*;
import cn.iocoder.yudao.framework.excel.core.annotations.DictFormat;
import cn.iocoder.yudao.framework.excel.core.convert.DictConvert;

@Schema(description = "管理后台 - 汽配仓库 Response VO")
@Data
@ExcelIgnoreUnannotated
public class StorageRespVO {

    @Schema(description = "仓库名字", requiredMode = Schema.RequiredMode.REQUIRED, example = "张三")
    @ExcelProperty("仓库名字")
    private String name;

    @Schema(description = "仓库编号", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("仓库编号")
    private String num;

    @Schema(description = "库存容量(立方米)")
    @ExcelProperty("库存容量(立方米)")
    private Long capacity;

    @Schema(description = "仓库地址")
    @ExcelProperty("仓库地址")
    private String address;

    @Schema(description = "排序序号")
    @ExcelProperty("排序序号")
    private Integer sort;

    @Schema(description = "仓库状态 0=关闭 1=开启", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @ExcelProperty(value = "仓库状态 0=关闭 1=开启", converter = DictConvert.class)
    @DictFormat("autopart_storage_status") // TODO 代码优化：建议设置到对应的 DictTypeConstants 枚举类中
    private Integer status;

    @Schema(description = "是否锁定 0=未锁定 1=已锁定", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    @ExcelProperty(value = "是否锁定 0=未锁定 1=已锁定", converter = DictConvert.class)
    @DictFormat("autopart_storage_locked") // TODO 代码优化：建议设置到对应的 DictTypeConstants 枚举类中
    private Integer lock;

    @Schema(description = "备注", example = "你说的对")
    @ExcelProperty("备注")
    private String remark;

    @Schema(description = "仓库主管ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "19443")
    @ExcelProperty("仓库主管ID")
    private Long userId;

    @Schema(description = "创建者")
    @ExcelProperty("创建者")
    private String creator;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

}