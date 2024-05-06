package cn.iocoder.yudao.module.autopart.dal.mysql.storage;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.autopart.dal.dataobject.storage.StorageDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.autopart.controller.admin.storage.vo.*;

/**
 * 汽配仓库 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface StorageMapper extends BaseMapperX<StorageDO> {

    default PageResult<StorageDO> selectPage(StoragePageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<StorageDO>()
                .likeIfPresent(StorageDO::getName, reqVO.getName())
                .likeIfPresent(StorageDO::getNum, reqVO.getNum())
                .eqIfPresent(StorageDO::getCapacity, reqVO.getCapacity())
                .eqIfPresent(StorageDO::getStatus, reqVO.getStatus())
                .eqIfPresent(StorageDO::getLocked, reqVO.getLock())
                .orderByDesc(StorageDO::getSort));
    }

}