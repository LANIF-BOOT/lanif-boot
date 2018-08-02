package com.lanif.common.vo;

import java.io.Serializable;

import com.lanif.common.entity.SysLog;

import lombok.Data;

/**
 * @author lengleng
 * @date 2017/11/20
 */
@Data
public class LogVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private SysLog sysLog;
    private String username;
}
