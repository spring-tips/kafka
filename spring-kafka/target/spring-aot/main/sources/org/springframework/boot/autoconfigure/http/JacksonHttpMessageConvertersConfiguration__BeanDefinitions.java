package org.springframework.boot.autoconfigure.http;

import java.lang.Class;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link JacksonHttpMessageConvertersConfiguration}
 */
public class JacksonHttpMessageConvertersConfiguration__BeanDefinitions {
  /**
   * Get the bean definition for 'jacksonHttpMessageConvertersConfiguration'
   */
  public static BeanDefinition getJacksonHttpMessageConvertersConfigurationBeanDefinition() {
    Class<?> beanType = JacksonHttpMessageConvertersConfiguration.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(JacksonHttpMessageConvertersConfiguration::new);
    return beanDefinition;
  }
}
