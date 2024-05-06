package cn.iocoder.yudao.module.autopart.service.storage;

import javax.validation.*;
import cn.iocoder.yudao.module.autopart.controller.admin.storage.vo.*;
import cn.iocoder.yudao.module.autopart.dal.dataobject.storage.StorageDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.module.autopart.dal.dataobject.storage.StorageLocationDO;

/**
 * 汽配仓库 Service 接口
 *
 * @author 芋道源码
 */
public interface StorageService {

    /**
     * 创建汽配仓库
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createStorage(@Valid StorageSaveReqVO createReqVO);

    /**
     * 更新汽配仓库
     *
     * @param updateReqVO 更新信息
     */
    void updateStorage(@Valid StorageSaveReqVO updateReqVO);

    /**
     * 删除汽配仓库
     *
     * @param id 编号
     */
    void deleteStorage(Long id);

    /**
     * 获得汽配仓库
     *
     * @param id 编号
     * @return 汽配仓库
     */
    StorageDO getStorage(Long id);

    /**
     * 获得汽配仓库分页
     *
     * @param pageReqVO 分页查询
     * @return 汽配仓库分页
     */
    PageResult<StorageDO> getStoragePage(StoragePageReqVO pageReqVO);

    // ==================== 子表（仓库库位） ====================

    /**
     * 获得仓库库位分页
     *
     * @param pageReqVO 分页查询
     * @param storageId 仓库ID
     * @return 仓库库位分页
     */
    PageResult<StorageLocationDO> getStorageLocationPage(PageParam pageReqVO, Long storageId);

    /**
     * 创建仓库库位
     *
     * @param storageLocation 创建信息
     * @return 编号
     */
    Long createStorageLocation(@Valid StorageLocationDO storageLocation);

    /**
     * 更新仓库库位
     *
     * @param storageLocation 更新信息
     */
    void updateStorageLocation(@Valid StorageLocationDO storageLocation);

    /**
     * 删除仓库库位
     *
     * @param id 编号
     */
    void deleteStorageLocation(Long id);

    /**
     * 获得仓库库位
     *
     * @param id 编号
     * @return 仓库库位
     */
    StorageLocationDO getStorageLocation(Long id);

    /**
     * 获取库位数量.
     *
     * @param id 仓库ID
     * @return 库位总数
     */
    Long locationCount(Long id);

}