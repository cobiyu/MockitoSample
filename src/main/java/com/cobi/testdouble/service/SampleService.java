package com.cobi.testdouble.service;

import com.cobi.testdouble.repository.SampleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class SampleService {
    private final SampleRepository sampleRepository;

    public void sampleServiceMethod(){
        sampleRepository.sampleMethod();
    }

}
