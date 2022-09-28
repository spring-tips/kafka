package org.springframework.boot.autoconfigure.kafka;

import java.lang.Class;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link KafkaProperties}
 */
public class KafkaProperties__BeanDefinitions {
  /**
   * Get the bean definition for 'kafkaProperties'
   */
  public static BeanDefinition getKafkaPropertiesBeanDefinition() {
    Class<?> beanType = KafkaProperties.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(KafkaProperties::new);
    return beanDefinition;
  }
}
