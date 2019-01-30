package com.luv2code.aopdemo;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration // Tell SPring we're using a Java Configuration
@EnableAspectJAutoProxy // enable auto proxy with Spring AOP
@ComponentScan("com.luv2code.aopdemo") // Where will spring scan for components
public class DemoConfig {

}
