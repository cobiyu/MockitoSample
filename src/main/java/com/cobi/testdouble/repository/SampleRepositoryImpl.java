package com.cobi.testdouble.repository;

import org.springframework.stereotype.Repository;

@Repository
public class SampleRepositoryImpl implements SampleRepository {
    @Override
    public String sampleMethod() {
        System.out.println("SampleRepositoryImpl sampleMethod");
        return null;
    }
}
