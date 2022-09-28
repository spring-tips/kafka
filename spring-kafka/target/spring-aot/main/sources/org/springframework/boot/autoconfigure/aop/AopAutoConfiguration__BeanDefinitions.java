package org.springframework.boot.autoconfigure.aop;

import java.lang.Class;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link AopAutoConfiguration}
 */
public class AopAutoConfiguration__BeanDefinitions {
  /**
   * Get the bean definition for 'aopAutoConfiguration'
   */
  public static BeanDefinition getAopAutoConfigurationBeanDefinition() {
    Class<?> beanType = AopAutoConfiguration.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(AopAutoConfiguration::new);
    return beanDefinition;
  }
}
