package com.lanif.auth.server.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lanif.api.vo.user.UserInfo;
import com.lanif.auth.server.configuration.FeignConfiguration;
import com.lanif.auth.server.util.user.JwtAuthenticationRequest;


/**
 */
@FeignClient(value = "ace-admin",configuration = FeignConfiguration.class)
public interface IUserService {
  @RequestMapping(value = "/api/user/validate", method = RequestMethod.POST)
  public UserInfo validate(@RequestBody JwtAuthenticationRequest authenticationRequest);
}
