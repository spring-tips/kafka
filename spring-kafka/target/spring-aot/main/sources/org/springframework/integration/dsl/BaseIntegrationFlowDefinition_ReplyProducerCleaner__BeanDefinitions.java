package org.springframework.integration.dsl;

import java.lang.Class;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link BaseIntegrationFlowDefinition.ReplyProducerCleaner}
 */
public class BaseIntegrationFlowDefinition_ReplyProducerCleaner__BeanDefinitions {
  /**
   * Get the bean definition for 'replyProducerCleaner'
   */
  public static BeanDefinition getReplyProducerCleanerBeanDefinition() {
    Class<?> beanType = BaseIntegrationFlowDefinition.ReplyProducerCleaner.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(BaseIntegrationFlowDefinition.ReplyProducerCleaner::new);
    return beanDefinition;
  }
}
