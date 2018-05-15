package com.example;

import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.InitializationError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by admin on 2018/5/11.
 */
public class MySpringJUnit4ClassRunner extends BlockJUnit4ClassRunner {

    private AutowireCapableBeanFactory beanFactory;

    public MySpringJUnit4ClassRunner(Class<?> klass) throws InitializationError {
        super(klass);
    }

    @Override
    protected Object createTest() throws Exception {
        Object jobInstance = super.createTest();
//        AutowireCapableBeanFactory beanFactory = testContext.getApplicationContext().getAutowireCapableBeanFactory();
//        beanFactory.autowireBeanProperties(bean, AutowireCapableBeanFactory.AUTOWIRE_NO, false);
//        beanFactory.initializeBean(bean, testContext.getTestClass().getName());
//        testContext.removeAttribute(REINJECT_DEPENDENCIES_ATTRIBUTE);
        beanFactory.autowireBean(jobInstance);
        return jobInstance;
    }
}
