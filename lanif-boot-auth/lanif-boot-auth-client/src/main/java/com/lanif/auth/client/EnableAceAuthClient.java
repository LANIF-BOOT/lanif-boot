package com.lanif.auth.client;
	
import org.springframework.context.annotation.Import;

import com.lanif.auth.client.configuration.AutoConfiguration;

import java.lang.annotation.*;

/**
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import(AutoConfiguration.class)
@Documented
@Inherited
public @interface EnableAceAuthClient {
}
