package org.springframework.integration.support.channel;

import java.lang.Class;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link BeanFactoryChannelResolver}
 */
public class BeanFactoryChannelResolver__BeanDefinitions {
  /**
   * Get the bean definition for 'integrationChannelResolver'
   */
  public static BeanDefinition getIntegrationChannelResolverBeanDefinition() {
    Class<?> beanType = BeanFactoryChannelResolver.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(BeanFactoryChannelResolver::new);
    return beanDefinition;
  }
}
