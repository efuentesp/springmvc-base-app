package com.softtek.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ComponentScan(basePackages = "com.softtek.spring.seguridad")
@ComponentScan("com.softtek.spring.seguridad.impl.TestJUnitTest")
public class AppConfig {

}
