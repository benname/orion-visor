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
package org.dromara.visor.module.asset.handler.host.terminal.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.dromara.visor.module.asset.handler.host.terminal.model.TerminalBasePayload;

/**
 * 终端连接检查请求 实体对象
 * <p>
 * ck|eff00a1|1
 *
 * @author Jiahang Li
 * @version 1.0.0
 * @since 2023/12/29 16:20
 */
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class TerminalCheckRequest extends TerminalBasePayload {

    /**
     * 主机id
     */
    private Long hostId;

    /**
     * 连接类型
     */
    private String connectType;

}