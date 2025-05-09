/*
 * Copyright (c) 2023 - present Dromara, All rights reserved.
 *
 *   https://visor.dromara.org
 *   https://visor.dromara.org.cn
 *   https://visor.orionsec.cn
 *
 * Members:
 *   Jiahang Li - ljh1553488six@139.com - author
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.dromara.visor.module.infra.api;

import org.dromara.visor.module.infra.entity.dto.data.DataExtraDTO;
import org.dromara.visor.module.infra.entity.dto.data.DataExtraQueryDTO;
import org.dromara.visor.module.infra.entity.dto.data.DataExtraSetDTO;
import org.dromara.visor.module.infra.enums.DataExtraTypeEnum;

import java.util.List;
import java.util.Map;
import java.util.concurrent.Future;

/**
 * 数据拓展信息 对外服务类
 *
 * @author Jiahang Li
 * @version 1.0.0
 * @since 2023-12-19 18:05
 */
public interface DataExtraApi {

    /**
     * 更新数据拓展信息 不存在则新增
     *
     * @param type type
     * @param dto  dto
     * @return effect
     */
    Integer setExtraItem(DataExtraSetDTO dto, DataExtraTypeEnum type);

    /**
     * 新增数据拓展信息
     *
     * @param dto  dto
     * @param type type
     * @return id
     */
    Long addExtraItem(DataExtraSetDTO dto, DataExtraTypeEnum type);

    /**
     * 新增数据拓展信息
     *
     * @param rows rows
     * @param type type
     */
    void addExtraItems(List<DataExtraSetDTO> rows, DataExtraTypeEnum type);

    /**
     * 更新数据拓展信息
     *
     * @param id    id
     * @param value value
     * @return effect
     */
    Integer updateExtraValue(Long id, String value);

    /**
     * 批量更新数据拓展信息
     *
     * @param map map
     */
    void batchUpdateExtraValue(Map<Long, String> map);

    /**
     * 查询额外配置项
     *
     * @param type type
     * @param dto  dto
     * @return item
     */
    String getExtraValue(DataExtraQueryDTO dto, DataExtraTypeEnum type);

    /**
     * 查询额外配置项
     *
     * @param dto  dto
     * @param type type
     * @return item
     */
    Map<Long, String> getExtraItemValues(DataExtraQueryDTO dto, DataExtraTypeEnum type);

    /**
     * 查询额外配置项 (查询缓存)
     *
     * @param userId userId
     * @param type   type
     * @param item   item
     * @param relId  relId
     * @return value
     */
    String getExtraItemValueByCache(Long userId, DataExtraTypeEnum type, String item, Long relId);

    /**
     * 查询额外配置项 (查询缓存)
     *
     * @param userId userId
     * @param type   type
     * @param item   item
     * @return relId:value
     */
    Map<Long, String> getExtraItemValuesByCache(Long userId, DataExtraTypeEnum type, String item);

    /**
     * 异步查询额外配置项 (查询缓存)
     *
     * @param userId userId
     * @param type   type
     * @param item   item
     * @return value
     */
    Future<Map<Long, String>> getExtraItemValuesByCacheAsync(Long userId, DataExtraTypeEnum type, String item);

    /**
     * 异步查询额外配置项 (查询缓存)
     *
     * @param userId userId
     * @param type   type
     * @param items  items
     * @return value
     */
    Future<List<Map<Long, String>>> getExtraItemsValuesByCacheAsync(Long userId, DataExtraTypeEnum type, List<String> items);

    /**
     * 查询额外配置
     *
     * @param dto  dto
     * @param type type
     * @return effect
     */
    DataExtraDTO getExtraItem(DataExtraQueryDTO dto, DataExtraTypeEnum type);

    /**
     * 查询额外配置
     *
     * @param dto  dto
     * @param type type
     * @return effect
     */
    List<DataExtraDTO> getExtraItems(DataExtraQueryDTO dto, DataExtraTypeEnum type);

    /**
     * 通过 relId 删除
     *
     * @param type  type
     * @param relId relId
     * @return effect
     */
    Integer deleteByRelId(DataExtraTypeEnum type, Long relId);

    /**
     * 通过 relId 删除
     *
     * @param type      type
     * @param relIdList relIdList
     * @return effect
     */
    Integer deleteByRelIdList(DataExtraTypeEnum type, List<Long> relIdList);

    /**
     * 删除主机密钥
     *
     * @param keyIdList keyIdList
     * @return effect
     */
    int deleteHostKeyExtra(List<Long> keyIdList);

    /**
     * 删除主机身份
     *
     * @param identityIdList identityIdList
     * @return effect
     */
    int deleteHostIdentityExtra(List<Long> identityIdList);

}
