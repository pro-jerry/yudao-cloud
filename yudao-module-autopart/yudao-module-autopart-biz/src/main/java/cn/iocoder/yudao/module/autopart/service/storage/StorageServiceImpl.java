package cn.iocoder.yudao.module.autopart.service.storage;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.module.autopart.dal.dataobject.storage.StorageLocationDO;
import cn.iocoder.yudao.module.autopart.dal.mysql.storage.StorageLocationMapper;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;

import cn.iocoder.yudao.module.autopart.controller.admin.storage.vo.*;
import cn.iocoder.yudao.module.autopart.dal.dataobject.storage.StorageDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;

import cn.iocoder.yudao.module.autopart.dal.mysql.storage.StorageMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.framework.common.util.snowflake.SnowflakeUtils.to6Num;
import static cn.iocoder.yudao.framework.security.core.util.SecurityFrameworkUtils.getLoginUserId;
import static cn.iocoder.yudao.module.autopart.enums.AutopartCodeConstants.ST;
import static cn.iocoder.yudao.module.autopart.enums.AutopartCodeConstants.STLO;
import static cn.iocoder.yudao.module.autopart.enums.ErrorCodeConstants.*;

/**
 * 汽配仓库 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class StorageServiceImpl implements StorageService {

    @Resource
    private StorageMapper storageMapper;
    @Resource
    private StorageLocationMapper storageLocationMapper;

    @Override
    public Long createStorage(StorageSaveReqVO createReqVO) {
        // 插入
        StorageDO storage = BeanUtils.toBean(createReqVO, StorageDO.class);
        storage.setNum(ST+to6Num());
        storage.setCreatorId(getLoginUserId());
        storageMapper.insert(storage);
        // 返回
        return storage.getId();
    }

    @Override
    public void updateStorage(StorageSaveReqVO updateReqVO) {
        // 校验存在
        validateStorageExists(updateReqVO.getId());
        // 更新
        StorageDO updateObj = BeanUtils.toBean(updateReqVO, StorageDO.class);
        updateObj.setUpdaterId(getLoginUserId());
        storageMapper.updateById(updateObj);
    }

    @Override
    public void deleteStorage(Long id) {
        // 校验存在
        validateStorageExists(id);
        // 删除
        storageMapper.deleteById(id);
    }

    private void validateStorageExists(Long id) {
        if (storageMapper.selectById(id) == null) {
            throw exception(STORAGE_NOT_EXISTS);
        }
    }

    @Override
    public StorageDO getStorage(Long id) {
        return storageMapper.selectById(id);
    }

    @Override
    public PageResult<StorageDO> getStoragePage(StoragePageReqVO pageReqVO) {
        return storageMapper.selectPage(pageReqVO);
    }

    // ==================== 子表（仓库库位） ====================

    @Override
    public PageResult<StorageLocationDO> getStorageLocationPage(PageParam pageReqVO, Long storageId) {
        return storageLocationMapper.selectPage(pageReqVO, storageId);
    }

    @Override
    public Long createStorageLocation(StorageLocationDO storageLocation) {
        storageLocation.setNum(STLO+to6Num());
        storageLocationMapper.insert(storageLocation);
        return storageLocation.getId();
    }

    @Override
    public void updateStorageLocation(StorageLocationDO storageLocation) {
        // 校验存在
        validateStorageLocationExists(storageLocation.getId());
        // 更新
        storageLocationMapper.updateById(storageLocation);
    }

    @Override
    public void deleteStorageLocation(Long id) {
        // 校验存在
        validateStorageLocationExists(id);
        // 删除
        storageLocationMapper.deleteById(id);
    }

    @Override
    public StorageLocationDO getStorageLocation(Long id) {
        return storageLocationMapper.selectById(id);
    }

    @Override
    public Long locationCount(Long id) {
        return storageLocationMapper.getCountByStorageId(id);
    }

    private void validateStorageLocationExists(Long id) {
        if (storageLocationMapper.selectById(id) == null) {
            throw exception(STORAGE_LOCATION_NOT_EXISTS);
        }
    }

    private void deleteStorageLocationByStorageId(Long storageId) {
        storageLocationMapper.deleteByStorageId(storageId);
    }

}