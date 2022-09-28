package org.springframework.expression.spel.support;

import java.lang.Class;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.integration.config.IntegrationSimpleEvaluationContextFactoryBean;

/**
 * Bean definitions for {@link SimpleEvaluationContext}
 */
public class SimpleEvaluationContext__BeanDefinitions {
  /**
   * Get the bean definition for 'integrationSimpleEvaluationContext'
   */
  public static BeanDefinition getIntegrationSimpleEvaluationContextBeanDefinition() {
    Class<?> beanType = IntegrationSimpleEvaluationContextFactoryBean.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setRole(BeanDefinition.ROLE_INFRASTRUCTURE);
    beanDefinition.setInstanceSupplier(IntegrationSimpleEvaluationContextFactoryBean::new);
    return beanDefinition;
  }
}
