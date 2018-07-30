package com.lanif.auth.server.mapper;

import com.lanif.auth.server.entity.ClientService;

import tk.mybatis.mapper.common.Mapper;

public interface ClientServiceMapper extends Mapper<ClientService> {
    void deleteByServiceId(int id);
}