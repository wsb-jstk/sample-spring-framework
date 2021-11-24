package com.capgemini.sample.sf.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.MessageSourceAware;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.AbstractApplicationContext;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public final class BeanLifecycleDemo {

    public static void main(String[] args) {
        final AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext(SimpleBean.class, BeanLifecycle.class,
                MyBeanPostProcessor.class, MyBeanFactoryPostProcessor.class);
        appContext.registerShutdownHook();
    }


    /**
     * For presentation purpose, create below object in order:
     * <ol>
     *     <li>BeanFactoryPostProcessor</li>
     * </ol>
     * <ol>
     *     <li>Instantiation - Constructor</li>
     *     <li>Populating Properties - {@link Aware}, {@link BeanNameAware}, {@link BeanFactoryAware}, {@link ApplicationContextAware}, {@link MessageSourceAware}</li>
     *     <li>Pre-Initialization - {@link BeanPostProcessor#postProcessBeforeInitialization}</li>
     *     <li>AfterPropertiesSet - {@link InitializingBean}</li>
     *     <li>Custom Initialization - initMethod / {@link PostConstruct}</li>
     *     <li>Post-Initialization - {@link BeanPostProcessor#postProcessAfterInitialization}</li>
     *     <li>Pre-Destroy - {@link PreDestroy}</li>
     *     <li>Destroy - {@link DisposableBean#destroy}</li>
     *     <li>Custom Destruction - {@link Bean#destroyMethod}</li>
     * </ol>
     *
     * @see <a href="https://reflectoring.io/spring-bean-lifecycle/">Hooking Into the Spring Bean Lifecycle</a>
     */
    @Slf4j
    public static class BeanLifecycle implements BeanNameAware, BeanFactoryAware, ApplicationContextAware, InitializingBean, DisposableBean {

        private final SimpleBean simpleBean;

        private String beanName;

        public BeanLifecycle(final SimpleBean simpleBean) {
            this.simpleBean = simpleBean;
            log.info("constructor. SimpleBean: {}", this.simpleBean);
        }

        /**
         * Comes from JSR-250
         *
         * @see <a href="https://jcp.org/en/jsr/detail?id=250">JSR-250</a>
         */
        @PostConstruct
        private void postConstruct() {
            log.info("@PostConstruct. SimpleBean: {}", this.simpleBean);
        }

        /**
         * @see <a href="https://www.baeldung.com/spring-shutdown-callbacks">Spring Shutdown Callbacks</a>
         */
        @PreDestroy
        private void preDestroy() {
            log.info("@PreDestroy. SimpleBean: {}", this.simpleBean);
        }

        /**
         * init-method
         */
        @Override
        public void afterPropertiesSet() {
            log.info("afterPropertiesSet from InitializingBean");
        }

        @Override
        public void destroy() {
            log.info("destroy() from DisposableBean");
        }

        /**
         * Same name as would be given in {@link Bean#name}
         */
        @Override
        public void setBeanName(final String name) {
            log.info("Name from BeanNameAware: {}", name);
            this.beanName = name;
        }

        @Override
        public void setBeanFactory(final BeanFactory beanFactory) throws BeansException {
            log.info("From BeanFactoryAware. Is this is a singleton? {}", beanFactory.isSingleton(this.beanName));
        }

        /**
         * Called from {@link org.springframework.context.support.ApplicationContextAwareProcessor} which is added to registry in {@link
         * AbstractApplicationContext#prepareBeanFactory}
         */
        @Override
        public void setApplicationContext(final ApplicationContext applicationContext) throws BeansException {
            log.info("From ApplicationContextAware: {}", applicationContext.getDisplayName());
        }

    }

    @Slf4j
    public static class SimpleBean {

        @PostConstruct
        public void postConstruct() {
            log.info("@PostConstruct");
        }

        @PreDestroy
        public void preDestroy() {
            log.info("@PreDestroy");
        }

    }

    @Slf4j
    static class MyBeanPostProcessor implements BeanPostProcessor {

        @Override
        public Object postProcessBeforeInitialization(final Object bean, final String beanName) throws BeansException {
            log.info("BeanPostProcessor. BeanName = {}, bean={}", beanName, bean);
            return bean;
        }

        @Override
        public Object postProcessAfterInitialization(final Object bean, final String beanName) throws BeansException {
            log.info("BeanPostProcessor. BeanName = {}, bean={}", beanName, bean);
            return bean;
        }

    }

    @Slf4j
    static class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

        @Override
        public void postProcessBeanFactory(final ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
            final String[] beanDefinitionNames = configurableListableBeanFactory.getBeanDefinitionNames();
            log.info("BeanFactoryPostProcessor detected number of beans: {}: {}", beanDefinitionNames.length, beanDefinitionNames);
        }

    }


}
