package com.orion.ops.module.asset.define.cache;

import com.orion.lang.define.cache.key.CacheKeyBuilder;
import com.orion.lang.define.cache.key.CacheKeyDefine;
import com.orion.lang.define.cache.key.struct.RedisCacheStruct;
import com.orion.ops.module.asset.entity.dto.HostSshConnectDTO;

import java.util.concurrent.TimeUnit;

/**
 * 主机终端服务缓存 key
 *
 * @author Jiahang Li
 * @version 1.0.0
 * @since 2023/12/27 18:13
 */
public interface HostTerminalCacheKeyDefine {

    CacheKeyDefine HOST_TERMINAL_CONNECT = new CacheKeyBuilder()
            .key("host:terminal:connect:{}")
            .desc("主机终端连接信息 ${token}")
            .type(HostSshConnectDTO.class)
            .struct(RedisCacheStruct.STRING)
            .timeout(3, TimeUnit.MINUTES)
            .build();

}