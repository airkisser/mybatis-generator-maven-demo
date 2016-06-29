package com.airkisser.mybatis.base;

import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * Created by AIR on 2016/6/30.
 */
@ContextConfiguration({"classpath:spring-servlet.xml","classpath:spring-mybatis.xml"})
@TestPropertySource("classpath:jdbc-test.properties")
@WebAppConfiguration
@ActiveProfiles("test")
public class BaseControllerTests extends AbstractTransactionalJUnit4SpringContextTests {
}