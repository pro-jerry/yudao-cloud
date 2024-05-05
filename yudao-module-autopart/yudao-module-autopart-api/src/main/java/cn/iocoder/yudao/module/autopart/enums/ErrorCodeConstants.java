package cn.iocoder.yudao.module.autopart.enums;// TODO 待办：请将下面的错误码复制到 yudao-module-autopart-api 模块的 ErrorCodeConstants 类中。注意，请给“TODO 补充编号”设置一个错误码编号！！！

import cn.iocoder.yudao.framework.common.exception.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;

// ========== 汽配仓库 TODO 补充编号 ==========
//ErrorCode STORAGE_NOT_EXISTS = new ErrorCode(TODO 补充编号, "汽配仓库不存在");
public interface ErrorCodeConstants {

    ErrorCode STORAGE_NOT_EXISTS = new ErrorCode(1_023_000_001, "汽配仓库不存在");
    ErrorCode STORAGE_LOCATION_NOT_EXISTS = new ErrorCode(1_023_000_002, "仓库库位不存在");

}