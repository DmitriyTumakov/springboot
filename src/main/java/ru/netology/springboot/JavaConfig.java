package ru.netology.springboot;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.netology.springboot.SystemProfile.DevProfile;
import ru.netology.springboot.SystemProfile.ProductionProfile;
import ru.netology.springboot.SystemProfile.SystemProfile;

@ConfigurationProperties("netology.profile.dev")
@Configuration
public class JavaConfig {
    @ConditionalOnProperty(prefix = "netology.profile", name = "dev", havingValue = "true")
    @Bean()
    public SystemProfile devProfile() {
        return new DevProfile();
    }

    @ConditionalOnProperty(prefix = "netology.profile", name = "dev", havingValue = "false")
    @Bean()
    public SystemProfile prodProfile() {
        return new ProductionProfile();
    }
}
