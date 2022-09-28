package org.springframework.boot.autoconfigure.integration;

import java.lang.Class;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link IntegrationProperties}
 */
public class IntegrationProperties__BeanDefinitions {
  /**
   * Get the bean definition for 'integrationProperties'
   */
  public static BeanDefinition getIntegrationPropertiesBeanDefinition() {
    Class<?> beanType = IntegrationProperties.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(IntegrationProperties::new);
    return beanDefinition;
  }
}
