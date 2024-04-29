package cn.iocoder.yudao.module.autopart.service.storage;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import cn.iocoder.yudao.module.autopart.controller.admin.storage.vo.*;
import cn.iocoder.yudao.module.autopart.dal.dataobject.storage.StorageDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;

import cn.iocoder.yudao.module.autopart.dal.mysql.storage.StorageMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
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

    @Override
    public Long createStorage(StorageSaveReqVO createReqVO) {
        // 插入
        StorageDO storage = BeanUtils.toBean(createReqVO, StorageDO.class);
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

}