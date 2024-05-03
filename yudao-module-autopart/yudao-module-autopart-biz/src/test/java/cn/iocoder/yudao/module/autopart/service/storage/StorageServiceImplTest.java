package cn.iocoder.yudao.module.autopart.service.storage;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import javax.annotation.Resource;

import cn.iocoder.yudao.framework.test.core.ut.BaseDbUnitTest;

import cn.iocoder.yudao.module.autopart.controller.admin.storage.vo.*;
import cn.iocoder.yudao.module.autopart.dal.dataobject.storage.StorageDO;
import cn.iocoder.yudao.module.autopart.dal.mysql.storage.StorageMapper;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import javax.annotation.Resource;
import org.springframework.context.annotation.Import;
import java.util.*;
import java.time.LocalDateTime;

import static cn.hutool.core.util.RandomUtil.*;
import static cn.iocoder.yudao.module.autopart.enums.ErrorCodeConstants.*;
import static cn.iocoder.yudao.framework.test.core.util.AssertUtils.*;
import static cn.iocoder.yudao.framework.test.core.util.RandomUtils.*;
import static cn.iocoder.yudao.framework.common.util.date.LocalDateTimeUtils.*;
import static cn.iocoder.yudao.framework.common.util.object.ObjectUtils.*;
import static cn.iocoder.yudao.framework.common.util.date.DateUtils.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * {@link StorageServiceImpl} 的单元测试类
 *
 * @author 芋道源码
 */
@Import(StorageServiceImpl.class)
public class StorageServiceImplTest extends BaseDbUnitTest {

    @Resource
    private StorageServiceImpl storageService;

    @Resource
    private StorageMapper storageMapper;

    @Test
    public void testCreateStorage_success() {
        // 准备参数
        StorageSaveReqVO createReqVO = randomPojo(StorageSaveReqVO.class).setId(null);

        // 调用
        Long storageId = storageService.createStorage(createReqVO);
        // 断言
        assertNotNull(storageId);
        // 校验记录的属性是否正确
        StorageDO storage = storageMapper.selectById(storageId);
        assertPojoEquals(createReqVO, storage, "id");
    }

    @Test
    public void testUpdateStorage_success() {
        // mock 数据
        StorageDO dbStorage = randomPojo(StorageDO.class);
        storageMapper.insert(dbStorage);// @Sql: 先插入出一条存在的数据
        // 准备参数
        StorageSaveReqVO updateReqVO = randomPojo(StorageSaveReqVO.class, o -> {
            o.setId(dbStorage.getId()); // 设置更新的 ID
        });

        // 调用
        storageService.updateStorage(updateReqVO);
        // 校验是否更新正确
        StorageDO storage = storageMapper.selectById(updateReqVO.getId()); // 获取最新的
        assertPojoEquals(updateReqVO, storage);
    }

    @Test
    public void testUpdateStorage_notExists() {
        // 准备参数
        StorageSaveReqVO updateReqVO = randomPojo(StorageSaveReqVO.class);

        // 调用, 并断言异常
        assertServiceException(() -> storageService.updateStorage(updateReqVO), STORAGE_NOT_EXISTS);
    }

    @Test
    public void testDeleteStorage_success() {
        // mock 数据
        StorageDO dbStorage = randomPojo(StorageDO.class);
        storageMapper.insert(dbStorage);// @Sql: 先插入出一条存在的数据
        // 准备参数
        Long id = dbStorage.getId();

        // 调用
        storageService.deleteStorage(id);
       // 校验数据不存在了
       assertNull(storageMapper.selectById(id));
    }

    @Test
    public void testDeleteStorage_notExists() {
        // 准备参数
        Long id = randomLongId();

        // 调用, 并断言异常
        assertServiceException(() -> storageService.deleteStorage(id), STORAGE_NOT_EXISTS);
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetStoragePage() {
       // mock 数据
       StorageDO dbStorage = randomPojo(StorageDO.class, o -> { // 等会查询到
           o.setName(null);
           o.setNum(null);
           o.setCapacity(null);
           o.setStatus(null);
           o.setLocked(null);
       });
       storageMapper.insert(dbStorage);
       // 测试 name 不匹配
       storageMapper.insert(cloneIgnoreId(dbStorage, o -> o.setName(null)));
       // 测试 num 不匹配
       storageMapper.insert(cloneIgnoreId(dbStorage, o -> o.setNum(null)));
       // 测试 capacity 不匹配
       storageMapper.insert(cloneIgnoreId(dbStorage, o -> o.setCapacity(null)));
       // 测试 status 不匹配
       storageMapper.insert(cloneIgnoreId(dbStorage, o -> o.setStatus(null)));
       // 测试 lock 不匹配
       storageMapper.insert(cloneIgnoreId(dbStorage, o -> o.setLocked(null)));
       // 准备参数
       StoragePageReqVO reqVO = new StoragePageReqVO();
       reqVO.setName(null);
       reqVO.setNum(null);
       reqVO.setCapacity(null);
       reqVO.setStatus(null);
       reqVO.setLock(null);

       // 调用
       PageResult<StorageDO> pageResult = storageService.getStoragePage(reqVO);
       // 断言
       assertEquals(1, pageResult.getTotal());
       assertEquals(1, pageResult.getList().size());
       assertPojoEquals(dbStorage, pageResult.getList().get(0));
    }

}