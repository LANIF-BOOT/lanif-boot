package com.lanif.gateway.feign.fallback;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.lanif.common.vo.MenuVO;
import com.lanif.gateway.feign.MenuService;
import com.xiaoleilu.hutool.collection.CollUtil;

import lombok.extern.slf4j.Slf4j;

/**
 * why add @Service when i up version ?
 * https://github.com/spring-cloud/spring-cloud-netflix/issues/762
 */
@Slf4j
@Service
public class MenuServiceFallbackImpl implements MenuService {
    @Override
    public Set<MenuVO> findMenuByRole(String role) {
        log.error("调用{}异常{}","findMenuByRole",role);
        return CollUtil.newHashSet();
    }
}
