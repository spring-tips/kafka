package org.springframework.integration.config;

import java.lang.Class;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link ConverterRegistrar}
 */
public class ConverterRegistrar__BeanDefinitions {
  /**
   * Get the bean definition for 'converterRegistrar'
   */
  public static BeanDefinition getConverterRegistrarBeanDefinition() {
    Class<?> beanType = ConverterRegistrar.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(ConverterRegistrar::new);
    return beanDefinition;
  }
}
