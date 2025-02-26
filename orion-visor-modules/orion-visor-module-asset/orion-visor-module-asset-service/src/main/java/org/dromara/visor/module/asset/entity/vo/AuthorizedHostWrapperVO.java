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
package org.dromara.visor.module.asset.entity.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 已授权的主机分组 视图响应对象
 *
 * @author Jiahang Li
 * @version 1.0.0
 * @since 2023/11/30 21:37
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(name = "AuthorizedHostWrapperVO", description = "已授权的主机分组 视图响应对象")
public class AuthorizedHostWrapperVO {

    @Schema(description = "授权的主机分组")
    private List<HostGroupTreeVO> groupTree;

    @Schema(description = "授权的主机列表")
    private List<HostVO> hostList;

    @Schema(description = "分组树节点映射 groupId:hostIdList")
    private Map<String, Set<Long>> treeNodes;

}
