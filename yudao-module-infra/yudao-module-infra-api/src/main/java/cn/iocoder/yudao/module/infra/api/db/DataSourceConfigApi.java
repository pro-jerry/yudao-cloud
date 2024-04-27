package cn.iocoder.yudao.module.infra.api.db;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.module.infra.api.db.dto.DataSourceConfigDTO;
import cn.iocoder.yudao.module.infra.enums.ApiConstants;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

@FeignClient(name = ApiConstants.NAME) // TODO 芋艿：fallbackFactory =
@Tag(name = "RPC 服务 - 数据源配置")
@Component
public interface DataSourceConfigApi {

    String PREFIX = ApiConstants.PREFIX + "/dataSourceConfig";

    @PostMapping(PREFIX + "/create")
    @Operation(summary = "创建数据源")
    CommonResult<Long> createDataSourceConfig(@Valid @RequestBody DataSourceConfigDTO createReqDTO);
}
