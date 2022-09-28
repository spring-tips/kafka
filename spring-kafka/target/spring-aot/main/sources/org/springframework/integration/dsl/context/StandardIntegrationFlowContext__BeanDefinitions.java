package org.springframework.integration.dsl.context;

import java.lang.Class;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link StandardIntegrationFlowContext}
 */
public class StandardIntegrationFlowContext__BeanDefinitions {
  /**
   * Get the bean definition for 'integrationFlowContext'
   */
  public static BeanDefinition getIntegrationFlowContextBeanDefinition() {
    Class<?> beanType = StandardIntegrationFlowContext.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(StandardIntegrationFlowContext::new);
    return beanDefinition;
  }
}
