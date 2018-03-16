package com.fileReputation2.math;

import org.apache.commons.math3.distribution.ParetoDistribution;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DistributionTest {
        
    @Autowired
    ParetoDistribution paretoDistribution;
    
    @Test
    public void testPareto() {
        
        
        for ( int i = 0; i < 50; ++i )
            System.out.println( paretoDistribution.sample() );
        
    }

}
