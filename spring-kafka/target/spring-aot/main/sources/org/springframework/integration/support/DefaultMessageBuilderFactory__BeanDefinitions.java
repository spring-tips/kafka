package org.springframework.integration.support;

import java.lang.Class;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link DefaultMessageBuilderFactory}
 */
public class DefaultMessageBuilderFactory__BeanDefinitions {
  /**
   * Get the bean definition for 'messageBuilderFactory'
   */
  public static BeanDefinition getMessageBuilderFactoryBeanDefinition() {
    Class<?> beanType = DefaultMessageBuilderFactory.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.getPropertyValues().addPropertyValue("readOnlyHeaders", "#{T(org.springframework.integration.context.IntegrationContextUtils).getIntegrationProperties(beanFactory).toProperties().getProperty('spring.integration.readOnly.headers')}");
    beanDefinition.setInstanceSupplier(DefaultMessageBuilderFactory::new);
    return beanDefinition;
  }
}
