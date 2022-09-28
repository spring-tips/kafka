package org.springframework.expression.spel.support;

import java.lang.Class;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.integration.config.IntegrationEvaluationContextFactoryBean;

/**
 * Bean definitions for {@link StandardEvaluationContext}
 */
public class StandardEvaluationContext__BeanDefinitions {
  /**
   * Get the bean definition for 'integrationEvaluationContext'
   */
  public static BeanDefinition getIntegrationEvaluationContextBeanDefinition() {
    Class<?> beanType = IntegrationEvaluationContextFactoryBean.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setRole(BeanDefinition.ROLE_INFRASTRUCTURE);
    beanDefinition.setInstanceSupplier(IntegrationEvaluationContextFactoryBean::new);
    return beanDefinition;
  }
}
