package com.jadendong.tianyiiot.auto;

import com.jadendong.tianyiiot.Hello;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author jaden
 */
@Configuration
@EnableConfigurationProperties(IotProperties.class)
@ConditionalOnClass(IotProperties.class)
@ConditionalOnProperty(prefix = "north", value = "enabled", matchIfMissing = true)
public class IotAutoConfiguration {

    private final IotProperties iotProperties;

    public IotAutoConfiguration(IotProperties iotProperties) {
        this.iotProperties = iotProperties;
    }

    @Bean
    @ConditionalOnMissingBean(IotProperties.class)
    public Hello hello() {
        return new Hello(iotProperties);
    }
}
