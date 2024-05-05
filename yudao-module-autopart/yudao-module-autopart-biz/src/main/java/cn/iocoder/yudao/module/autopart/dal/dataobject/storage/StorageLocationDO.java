package cn.iocoder.yudao.module.autopart.dal.dataobject.storage;

import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 仓库库位 DO
 *
 * @author 芋道源码
 */
@TableName("autopart_storage_location")
@KeySequence("autopart_storage_location_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StorageLocationDO extends BaseDO {

    /**
     * ID
     */
    @TableId
    private Long id;
    /**
     * 库位名字
     */
    private String name;
    /**
     * 仓库ID
     */
    private Long storageId;
    /**
     * 库位编号
     */
    private String num;
    /**
     * 库位容量(立方米)
     */
    private Integer capacity;
    /**
     * 仓位主管ID
     */
    private Long userId;
    /**
     * 库位状态 0=关闭 1=开启
     */
    private Integer status;
    /**
     * 排序序号
     */
    private Integer sort;
    /**
     * 备注
     */
    private String remark;
    /**
     * 创建者ID
     */
    private Long creatorId;
    /**
     * 更新者ID
     */
    private Long updaterId;

}