package org.springframework.integration.support.converter;

import java.lang.Class;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link ConfigurableCompositeMessageConverter}
 */
public class ConfigurableCompositeMessageConverter__BeanDefinitions {
  /**
   * Get the bean definition for 'integrationArgumentResolverMessageConverter'
   */
  public static BeanDefinition getIntegrationArgumentResolverMessageConverterBeanDefinition() {
    Class<?> beanType = ConfigurableCompositeMessageConverter.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(ConfigurableCompositeMessageConverter::new);
    return beanDefinition;
  }
}
