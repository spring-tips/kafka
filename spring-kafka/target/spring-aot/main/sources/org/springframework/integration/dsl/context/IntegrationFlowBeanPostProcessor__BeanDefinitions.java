package org.springframework.integration.dsl.context;

import java.lang.Class;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link IntegrationFlowBeanPostProcessor}
 */
public class IntegrationFlowBeanPostProcessor__BeanDefinitions {
  /**
   * Get the bean definition for 'integrationFlowBeanPostProcessor'
   */
  public static BeanDefinition getIntegrationFlowBeanPostProcessorBeanDefinition() {
    Class<?> beanType = IntegrationFlowBeanPostProcessor.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(IntegrationFlowBeanPostProcessor::new);
    return beanDefinition;
  }
}
