package cn.iocoder.yudao.module.autopart.service.storage;

import java.util.*;
import javax.validation.*;
import cn.iocoder.yudao.module.autopart.controller.admin.storage.vo.*;
import cn.iocoder.yudao.module.autopart.dal.dataobject.storage.StorageDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;

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

}