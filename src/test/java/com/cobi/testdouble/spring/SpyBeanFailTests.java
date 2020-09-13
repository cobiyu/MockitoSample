package com.cobi.testdouble.spring;

import com.cobi.testdouble.repository.SampleRepository;
import com.cobi.testdouble.service.SampleService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
public class SpyBeanFailTests {
//    @SpyBean
    @MockBean
    private SampleRepository sampleRepository;

    @Autowired
    private SampleService sampleService;

    @Test
    public void failTest(){
        sampleRepository.sampleMethod();
        sampleService.sampleServiceMethod();
    }
}
