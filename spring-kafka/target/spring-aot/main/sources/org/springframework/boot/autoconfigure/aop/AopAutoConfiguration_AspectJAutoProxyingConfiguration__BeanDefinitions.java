package org.springframework.boot.autoconfigure.aop;

import java.lang.Class;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link AopAutoConfiguration.AspectJAutoProxyingConfiguration}
 */
public class AopAutoConfiguration_AspectJAutoProxyingConfiguration__BeanDefinitions {
  /**
   * Get the bean definition for 'aspectJAutoProxyingConfiguration'
   */
  public static BeanDefinition getAspectJAutoProxyingConfigurationBeanDefinition() {
    Class<?> beanType = AopAutoConfiguration.AspectJAutoProxyingConfiguration.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(AopAutoConfiguration.AspectJAutoProxyingConfiguration::new);
    return beanDefinition;
  }
}
