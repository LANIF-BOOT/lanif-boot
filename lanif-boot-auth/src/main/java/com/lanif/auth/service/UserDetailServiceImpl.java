package com.lanif.auth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.lanif.auth.feign.UserService;
import com.lanif.auth.util.UserDetailsImpl;
import com.lanif.common.vo.UserVO;

/**
 */
@Service("userDetailService")
public class UserDetailServiceImpl implements UserDetailsService {
    @Autowired
    private UserService userService;

    @Override
    public UserDetailsImpl loadUserByUsername(String username) throws UsernameNotFoundException {
        UserVO userVo = userService.findUserByUsername(username);
        return new UserDetailsImpl(userVo);
    }
}
