package org.springframework.integration.config;

import java.lang.Class;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link CustomConversionServiceFactoryBean}
 */
public class CustomConversionServiceFactoryBean__BeanDefinitions {
  /**
   * Get the bean definition for 'integrationConversionService'
   */
  public static BeanDefinition getIntegrationConversionServiceBeanDefinition() {
    Class<?> beanType = CustomConversionServiceFactoryBean.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(CustomConversionServiceFactoryBean::new);
    return beanDefinition;
  }
}
