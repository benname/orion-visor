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
package org.dromara.visor.module.infra.entity.request.message;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import org.dromara.visor.common.entity.BaseQueryRequest;

/**
 * 系统消息 查询请求对象
 *
 * @author Jiahang Li
 * @version 1.0.8
 * @since 2024-5-11 16:29
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Schema(name = "SystemMessageQueryRequest", description = "系统消息 查询请求对象")
public class SystemMessageQueryRequest extends BaseQueryRequest {

    @Schema(description = "maxId")
    private Long maxId;

    @Schema(description = "消息分类")
    private String classify;

    @Schema(description = "是否查询未读消息")
    private Boolean queryUnread;

}
