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
package org.dromara.visor.common.utils;

import cn.orionsec.kit.lang.utils.time.Dates;
import org.dromara.visor.common.constant.Const;

/**
 * 文件名称
 *
 * @author Jiahang Li
 * @version 1.0.0
 * @since 2023/8/31 17:57
 */
public class FileNames {

    private FileNames() {
    }

    /**
     * 导出文件名称
     *
     * @param title title
     * @return name
     */
    public static String exportName(String title) {
        return title + "-" + Dates.current(Dates.YMD_HMS2) + "." + Const.SUFFIX_XLSX;
    }

}
