/*
 * Copyright (c) 2023 - present Jiahang Li (visor.orionsec.cn ljh1553488six@139.com).
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
package org.dromara.visor.module.infra.entity.request.menu;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 菜单 创建请求对象
 *
 * @author Jiahang Li
 * @version 1.0.0
 * @since 2023-7-18 10:18
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(name = "SystemMenuCreateRequest", description = "菜单 创建请求对象")
public class SystemMenuCreateRequest implements Serializable {

    @Schema(description = "父id")
    private Long parentId;

    @Schema(description = "菜单名称")
    private String name;

    @Schema(description = "菜单权限")
    private String permission;

    @Schema(description = "菜单类型 1父菜单 2子菜单 3功能")
    private Integer type;

    @Schema(description = "排序")
    private Integer sort;

    @Schema(description = "是否可见 0不可见 1可见")
    private Integer visible;

    @Schema(description = "菜单状态 0停用 1启用")
    private Integer status;

    @Schema(description = "菜单缓存 0不缓存 1缓存")
    private Integer cache;

    @Schema(description = "新窗口打开 0关闭 1开启")
    private Integer newWindow;

    @Schema(description = "菜单图标")
    private String icon;

    @Schema(description = "链接地址")
    private String path;

    @Schema(description = "组件名称")
    private String component;

}