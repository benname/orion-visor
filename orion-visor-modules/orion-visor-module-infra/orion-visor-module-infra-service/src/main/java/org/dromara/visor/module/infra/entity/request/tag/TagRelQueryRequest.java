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
package org.dromara.visor.module.infra.entity.request.tag;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import org.dromara.visor.common.entity.BaseQueryRequest;

import javax.validation.constraints.Size;
import java.util.Collection;

/**
 * 标签引用 查询请求对象
 *
 * @author Jiahang Li
 * @version 1.0.0
 * @since 2023-9-6 16:54
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Schema(name = "TagRelQueryRequest", description = "标签引用 查询请求对象")
public class TagRelQueryRequest extends BaseQueryRequest {

    @Schema(description = "id")
    private Long id;

    @Schema(description = "标签id")
    private Long tagId;

    @Size(max = 32)
    @Schema(description = "标签名称")
    private String tagName;

    @Size(max = 12)
    @Schema(description = "标签类型")
    private String tagType;

    @Schema(description = "关联id")
    private Long relId;

    @Schema(description = "关联id")
    private Collection<Long> relIdList;

}
