package org.springframework.boot.autoconfigure.aop;

import java.lang.Class;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link AopAutoConfiguration.AspectJAutoProxyingConfiguration.CglibAutoProxyConfiguration}
 */
public class AopAutoConfiguration_AspectJAutoProxyingConfiguration_CglibAutoProxyConfiguration__BeanDefinitions {
  /**
   * Get the bean definition for 'cglibAutoProxyConfiguration'
   */
  public static BeanDefinition getCglibAutoProxyConfigurationBeanDefinition() {
    Class<?> beanType = AopAutoConfiguration.AspectJAutoProxyingConfiguration.CglibAutoProxyConfiguration.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(AopAutoConfiguration.AspectJAutoProxyingConfiguration.CglibAutoProxyConfiguration::new);
    return beanDefinition;
  }
}
