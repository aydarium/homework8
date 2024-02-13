package ru.aydar.config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:config/${env}.properties")
public interface TestDataConfig extends Config {
    String locale();
    String email();
    String address();
}
