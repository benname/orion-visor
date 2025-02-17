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
package org.dromara.visor.common.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * 请求留痕模型
 *
 * @author Jiahang Li
 * @version 1.0.0
 * @since 2023/12/29 11:57
 */
@Data
@Schema(name = "RequestIdentityModel", description = "请求留痕模型")
public class RequestIdentityModel implements RequestIdentity {

    @Schema(description = "请求地址")
    private String address;

    @Schema(description = "请求位置")
    private String location;

    @Schema(description = "userAgent")
    private String userAgent;

}
