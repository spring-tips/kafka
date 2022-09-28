package org.springframework.integration.channel;

import java.lang.Class;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link DefaultHeaderChannelRegistry}
 */
public class DefaultHeaderChannelRegistry__BeanDefinitions {
  /**
   * Get the bean definition for 'integrationHeaderChannelRegistry'
   */
  public static BeanDefinition getIntegrationHeaderChannelRegistryBeanDefinition() {
    Class<?> beanType = DefaultHeaderChannelRegistry.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(DefaultHeaderChannelRegistry::new);
    return beanDefinition;
  }
}
