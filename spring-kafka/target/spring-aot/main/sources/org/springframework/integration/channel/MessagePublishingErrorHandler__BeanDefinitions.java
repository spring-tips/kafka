package org.springframework.integration.channel;

import java.lang.Class;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link MessagePublishingErrorHandler}
 */
public class MessagePublishingErrorHandler__BeanDefinitions {
  /**
   * Get the bean definition for 'integrationMessagePublishingErrorHandler'
   */
  public static BeanDefinition getIntegrationMessagePublishingErrorHandlerBeanDefinition() {
    Class<?> beanType = MessagePublishingErrorHandler.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(MessagePublishingErrorHandler::new);
    return beanDefinition;
  }
}
