// 终端协议
export interface Protocol {
  type: string;
  template: string[];

  [key: string]: unknown;
}

// 终端输入消息内容
export interface InputPayload {
  type?: string;
  sessionId?: string;

  [key: string]: unknown;
}

// 终端输出消息内容
export interface OutputPayload {
  type: string;
  sessionId: string;

  [key: string]: string;
}

// 分隔符
export const SEPARATOR = '|';

// 输入协议
export const InputProtocol = {
  // 主机连接检查
  CHECK: {
    type: 'ck',
    template: ['type', 'sessionId', 'hostId', 'connectType']
  },
  // 连接主机
  CONNECT: {
    type: 'co',
    template: ['type', 'sessionId', 'terminalType', 'cols', 'rows']
  },
  // 关闭连接
  CLOSE: {
    type: 'cl',
    template: ['type', 'sessionId']
  },
  // ping
  PING: {
    type: 'p',
    template: ['type']
  },
  // SSH 修改大小
  SSH_RESIZE: {
    type: 'rs',
    template: ['type', 'sessionId', 'cols', 'rows']
  },
  // SSH 输入
  SSH_INPUT: {
    type: 'i',
    template: ['type', 'sessionId', 'command']
  },
  // SFTP 文件列表
  SFTP_LIST: {
    type: 'ls',
    template: ['type', 'sessionId', 'showHiddenFile', 'path']
  },
  // SFTP 创建文件夹
  SFTP_MKDIR: {
    type: 'mk',
    template: ['type', 'sessionId', 'path']
  },
  // SFTP 创建文件
  SFTP_TOUCH: {
    type: 'to',
    template: ['type', 'sessionId', 'path']
  },
  // SFTP 移动文件
  SFTP_MOVE: {
    type: 'mv',
    template: ['type', 'sessionId', 'path', 'target']
  },
  // SFTP 删除文件
  SFTP_REMOVE: {
    type: 'rm',
    template: ['type', 'sessionId', 'path']
  },
  // SFTP 修改文件权限
  SFTP_CHMOD: {
    type: 'cm',
    template: ['type', 'sessionId', 'path', 'mod']
  },
  // SFTP 修改文件权限
  SFTP_DOWNLOAD_FLAT_DIRECTORY: {
    type: 'df',
    template: ['type', 'sessionId', 'currentPath', 'path']
  },
  // SFTP 获取内容
  SFTP_GET_CONTENT: {
    type: 'gc',
    template: ['type', 'sessionId', 'path']
  },
  // SFTP 修改内容
  SFTP_SET_CONTENT: {
    type: 'sc',
    template: ['type', 'sessionId', 'path']
  },
};

// 输出协议
export const OutputProtocol = {
  // 主机连接检查
  CHECK: {
    type: 'ck',
    template: ['type', 'sessionId', 'result', 'msg'],
    processMethod: 'processCheck'
  },
  // 主机连接
  CONNECT: {
    type: 'co',
    template: ['type', 'sessionId', 'result', 'msg'],
    processMethod: 'processConnect'
  },
  // 主机连接关闭
  CLOSE: {
    type: 'cl',
    template: ['type', 'sessionId', 'forceClose', 'msg'],
    processMethod: 'processClose'
  },
  // pong
  PONG: {
    type: 'p',
    template: ['type'],
    processMethod: 'processPong'
  },
  // SSH 输出
  SSH_OUTPUT: {
    type: 'o',
    template: ['type', 'sessionId', 'body'],
    processMethod: 'processSshOutput'
  },
  // SFTP 文件列表
  SFTP_LIST: {
    type: 'ls',
    template: ['type', 'sessionId', 'path', 'result', 'msg', 'body'],
    processMethod: 'processSftpList'
  },
  // SFTP 创建文件夹
  SFTP_MKDIR: {
    type: 'mk',
    template: ['type', 'sessionId', 'result', 'msg'],
    processMethod: 'processSftpMkdir'
  },
  // SFTP 创建文件
  SFTP_TOUCH: {
    type: 'to',
    template: ['type', 'sessionId', 'result', 'msg'],
    processMethod: 'processSftpTouch'
  },
  // SFTP 移动文件
  SFTP_MOVE: {
    type: 'mv',
    template: ['type', 'sessionId', 'result', 'msg'],
    processMethod: 'processSftpMove'
  },
  // SFTP 删除文件
  SFTP_REMOVE: {
    type: 'rm',
    template: ['type', 'sessionId', 'result', 'msg'],
    processMethod: 'processSftpRemove'
  },
  // SFTP 修改文件权限
  SFTP_CHMOD: {
    type: 'cm',
    template: ['type', 'sessionId', 'result', 'msg'],
    processMethod: 'processSftpChmod'
  },
  // SFTP 修改文件权限
  SFTP_DOWNLOAD_FLAT_DIRECTORY: {
    type: 'df',
    template: ['type', 'sessionId', 'currentPath', 'result', 'msg', 'body'],
    processMethod: 'processDownloadFlatDirectory'
  },
  // SFTP 获取文件内容
  SFTP_GET_CONTENT: {
    type: 'gc',
    template: ['type', 'sessionId', 'result', 'msg', 'token'],
    processMethod: 'processSftpGetContent'
  },
  // SFTP 修改文件内容
  SFTP_SET_CONTENT: {
    type: 'sc',
    template: ['type', 'sessionId', 'result', 'msg', 'token'],
    processMethod: 'processSftpSetContent'
  },
};

// 解析参数
export const parse = (payload: string) => {
  const protocols = Object.values(OutputProtocol);
  const useProtocol = protocols.find(p => payload.startsWith(p.type + SEPARATOR) || p.type === payload);
  if (!useProtocol) {
    return undefined;
  }
  const template = useProtocol.template;
  const res = {} as OutputPayload;
  let curr = 0;
  let len = payload.length;
  for (let i = 0, pl = template.length; i < pl; i++) {
    if (i == pl - 1) {
      // 最后一次
      res[template[i]] = payload.substring(curr, len);
    } else {
      // 非最后一次
      let tmp = '';
      for (; curr < len; curr++) {
        const c = payload.charAt(curr);
        if (c == SEPARATOR) {
          res[template[i]] = tmp;
          curr++;
          break;
        } else {
          tmp += c;
        }
      }
    }
  }
  return res;
};

// 格式化参数
export const format = (protocol: Protocol, payload: InputPayload | OutputPayload) => {
  payload.type = protocol.type;
  return protocol.template
    .map(i => getPayloadValueString(payload[i]))
    .join(SEPARATOR);
};

// 获取默认值
export const getPayloadValueString = (value: unknown): any => {
  if (value === undefined || value === null) {
    return '';
  }
  return value;
};
