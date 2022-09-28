package org.springframework.integration.config;

import java.lang.Class;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link IdGeneratorConfigurer}
 */
public class IdGeneratorConfigurer__BeanDefinitions {
  /**
   * Get the bean definition for 'idGeneratorConfigurer#0'
   */
  public static BeanDefinition getIdGeneratorConfigurerBeanDefinition() {
    Class<?> beanType = IdGeneratorConfigurer.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setRole(BeanDefinition.ROLE_INFRASTRUCTURE);
    beanDefinition.setInstanceSupplier(IdGeneratorConfigurer::new);
    return beanDefinition;
  }
}
