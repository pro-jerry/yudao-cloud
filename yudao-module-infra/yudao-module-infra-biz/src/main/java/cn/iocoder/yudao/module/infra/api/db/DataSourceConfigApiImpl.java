package cn.iocoder.yudao.module.infra.api.db;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.module.infra.api.db.dto.DataSourceConfigDTO;
import cn.iocoder.yudao.module.infra.service.db.DataSourceConfigService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController // 提供 RESTful API 接口，给 Feign 调用
@Validated
public class DataSourceConfigApiImpl implements DataSourceConfigApi{

    @Resource
    private DataSourceConfigService dataSourceConfigService;

    @Override
    public CommonResult<Long> createDataSourceConfig(DataSourceConfigDTO createReqDTO) {
        Long id = dataSourceConfigService.createDataSourceConfig(createReqDTO);
        return CommonResult.success(id);
    }
}
