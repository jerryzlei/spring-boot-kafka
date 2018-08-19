package com.qudian.kafka.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * <p></p>
 *
 * @author zhengfei
 * @create 2018-02-05 20:21
 **/
@Configuration
@Data
public class ProfilesActiveConfig {
    @Value("${spring.profiles.active}")
    public String profilesActive;
}
