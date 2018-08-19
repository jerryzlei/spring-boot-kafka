package com.qudian.kafka;

import com.didispace.swagger.EnableSwagger2Doc;
import com.qudian.kafka.config.ProfilesActiveConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * <p></p>
 *
 * @author zhengfei
 * @create 2018-02-07 上午9:42
 **/
@SpringBootApplication(scanBasePackages = "com.qudian")
@EnableSwagger2Doc
@Slf4j
public class Bootstrap {
    private static volatile boolean running = true;
    @Autowired
    private ProfilesActiveConfig activeConfig;


    public static void main(String[] args) {
        SpringApplication.run(Bootstrap.class, args);
        log.info("service started successfully");

        synchronized (Bootstrap.class) {
            while (running) {
                try {
                    Bootstrap.class.wait();
                } catch (Throwable e) {
                    log.error("Bootstrap Throwable：", e);
                }
            }
        }
    }

    @PostConstruct
    public void init() {
        log.info("service init,profiles:{}",activeConfig.getProfilesActive());
    }

    @PreDestroy
    public void destroy() {
        log.info("service destroy...");
        running = false;
    }



}
