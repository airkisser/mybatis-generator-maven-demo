package com.airkisser.mybatis.base;

import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

/**
 * Created by AIR on 2016/6/30.
 */
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
@TestPropertySource("classpath:jdbc-test.properties")
@ActiveProfiles("test")
public class BaseRepositoryTests extends AbstractTransactionalJUnit4SpringContextTests {
}
