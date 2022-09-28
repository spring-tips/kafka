package org.springframework.kafka.config;

import java.lang.Class;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link KafkaListenerEndpointRegistry}
 */
public class KafkaListenerEndpointRegistry__BeanDefinitions {
  /**
   * Get the bean definition for 'internalKafkaListenerEndpointRegistry'
   */
  public static BeanDefinition getInternalKafkaListenerEndpointRegistryBeanDefinition() {
    Class<?> beanType = KafkaListenerEndpointRegistry.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(KafkaListenerEndpointRegistry::new);
    return beanDefinition;
  }
}
