package cn.iocoder.yudao.module.infra.api.db.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Schema(description = "RPC 服务 - 数据源配置创建 Request DTO")
@Data
@AllArgsConstructor
public class DataSourceConfigDTO {

    @NotNull(message = "租户编号不能为空")
    private Long tenantId;

    @NotNull(message = "数据源(租户码)名称不能为空")
    private String name;
}
