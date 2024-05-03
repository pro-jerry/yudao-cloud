package cn.iocoder.yudao.framework.common.util.snowflake;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;

/**
 * @author Hejun @Description 雪花算法
 * @createTime 2024年05月03日
 */
public class SnowflakeUtils {

    private static final Snowflake numRamdom = IdUtil.getSnowflake();

    public static String to6Num(){
        String nextIdStr = numRamdom.nextIdStr();
        Integer length = nextIdStr.length();
        return nextIdStr.substring(length-6,length);
    }
}
