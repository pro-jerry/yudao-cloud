package cn.iocoder.yudao.module.autopart.dal.mysql.storage;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.autopart.dal.dataobject.storage.StorageLocationDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 仓库库位 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface StorageLocationMapper extends BaseMapperX<StorageLocationDO> {

    default PageResult<StorageLocationDO> selectPage(PageParam reqVO, Long storageId) {
        return selectPage(reqVO, new LambdaQueryWrapperX<StorageLocationDO>()
                .eq(StorageLocationDO::getStorageId, storageId)
                .orderByDesc(StorageLocationDO::getSort));
    }

    default int deleteByStorageId(Long storageId) {
        return delete(StorageLocationDO::getStorageId, storageId);
    }

    Long getCountByStorageId(@Param("storageId") Long id);
}