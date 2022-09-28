package org.springframework.integration.endpoint;

import java.lang.Class;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.RuntimeBeanReference;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.integration.config.ConsumerEndpointFactoryBean;

/**
 * Bean definitions for {@link AbstractEndpoint}
 */
public class AbstractEndpoint__BeanDefinitions {
  /**
   * Get the bean definition for 'errorLogger'
   */
  public static BeanDefinition getErrorLoggerBeanDefinition() {
    Class<?> beanType = ConsumerEndpointFactoryBean.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.getPropertyValues().addPropertyValue("inputChannelName", "errorChannel");
    beanDefinition.getPropertyValues().addPropertyValue("handler", new RuntimeBeanReference("_org.springframework.integration.errorLogger.handler"));
    beanDefinition.setInstanceSupplier(ConsumerEndpointFactoryBean::new);
    return beanDefinition;
  }
}
