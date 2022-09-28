package org.springframework.integration.config.annotation;

import java.lang.Class;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link MessagingAnnotationPostProcessor}
 */
public class MessagingAnnotationPostProcessor__BeanDefinitions {
  /**
   * Get the bean definition for 'internalMessagingAnnotationPostProcessor'
   */
  public static BeanDefinition getInternalMessagingAnnotationPostProcessorBeanDefinition() {
    Class<?> beanType = MessagingAnnotationPostProcessor.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setRole(BeanDefinition.ROLE_INFRASTRUCTURE);
    beanDefinition.setInstanceSupplier(MessagingAnnotationPostProcessor::new);
    return beanDefinition;
  }
}
