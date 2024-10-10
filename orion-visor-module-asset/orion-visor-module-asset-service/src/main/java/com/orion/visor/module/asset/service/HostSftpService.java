package com.orion.visor.module.asset.service;

import com.orion.lang.define.wrapper.DataGrid;
import com.orion.visor.module.asset.entity.request.host.HostSftpLogQueryRequest;
import com.orion.visor.module.asset.entity.vo.HostSftpLogVO;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * SFTP 操作 服务类
 *
 * @author Jiahang Li
 * @version 1.0.0
 * @since 2023-12-26 22:09
 */
public interface HostSftpService {

    /**
     * 分页查询 SFTP 操作日志
     *
     * @param request request
     * @return rows
     */
    DataGrid<HostSftpLogVO> getHostSftpLogPage(HostSftpLogQueryRequest request);

    /**
     * 删除 SFTP 操作日志
     *
     * @param idList idList
     * @return effect
     */
    Integer deleteHostSftpLog(List<Long> idList);

    /**
     * 设置文件内容
     *
     * @param token    token
     * @param response response
     * @throws IOException IOException
     */
    void getFileContentByToken(String token, HttpServletResponse response) throws IOException;

    /**
     * 获取文件内容
     *
     * @param token token
     * @param file  file
     * @throws IOException IOException
     */
    void setFileContentByToken(String token, MultipartFile file) throws IOException;

    /**
     * 通过 transferToken 下载
     *
     * @param channelId     channelId
     * @param transferToken transferToken
     * @param response      response
     * @return body
     */
    StreamingResponseBody downloadWithTransferToken(String channelId,
                                                    String transferToken,
                                                    HttpServletResponse response);

}
