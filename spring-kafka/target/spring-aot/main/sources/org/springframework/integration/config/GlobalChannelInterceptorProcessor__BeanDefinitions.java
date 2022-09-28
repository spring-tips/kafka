package org.springframework.integration.config;

import java.lang.Class;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link GlobalChannelInterceptorProcessor}
 */
public class GlobalChannelInterceptorProcessor__BeanDefinitions {
  /**
   * Get the bean definition for 'globalChannelInterceptorProcessor'
   */
  public static BeanDefinition getGlobalChannelInterceptorProcessorBeanDefinition() {
    Class<?> beanType = GlobalChannelInterceptorProcessor.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setRole(BeanDefinition.ROLE_INFRASTRUCTURE);
    beanDefinition.setInstanceSupplier(GlobalChannelInterceptorProcessor::new);
    return beanDefinition;
  }
}
