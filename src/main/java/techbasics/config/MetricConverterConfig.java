package techbasics.config;

import techbasics.aspect.RestBoundaryLoggerAspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MetricConverterConfig {

    @Bean
    public RestBoundaryLoggerAspect restBoundaryLoggerAspect() {
        return new RestBoundaryLoggerAspect();
    }

}
