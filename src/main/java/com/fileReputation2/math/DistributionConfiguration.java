package com.fileReputation2.math;

import org.apache.commons.math3.distribution.ParetoDistribution;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DistributionConfiguration {
    
    @Bean
    public ParetoDistribution paretoDistribution() {
        
        ParetoDistribution paretoDistribution = new ParetoDistribution();
        
        return paretoDistribution;
        
    }

}
