package cn.iocoder.yudao.module.autopart.dal.dataobject.storage;

import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 汽配仓库 DO
 *
 * @author 芋道源码
 */
@TableName("autopart_storage")
@KeySequence("autopart_storage_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StorageDO extends BaseDO {

    /**
     * ID
     */
    @TableId
    private Long id;
    /**
     * 仓库名字
     */
    private String name;
    /**
     * 仓库编号
     */
    private String num;
    /**
     * 库存容量(立方米)
     */
    private Long capacity;
    /**
     * 仓库地址
     */
    private String address;
    /**
     * 排序序号
     */
    private Integer sort;
    /**
     * 仓库状态 0=关闭 1=开启
     *
     * 枚举 {@link TODO autopart_storage_status 对应的类}
     */
    private Integer status;
    /**
     * 是否锁定 0=未锁定 1=已锁定
     *
     * 枚举 {@link TODO autopart_storage_locked 对应的类}
     */
    private Integer locked;
    /**
     * 备注
     */
    private String remark;
    /**
     * 仓库主管ID
     */
    private Long userId;

    private Long creatorId;

    private Long updaterId;

}