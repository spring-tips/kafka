package org.springframework.boot.autoconfigure.kafka;

import java.lang.Class;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link KafkaAnnotationDrivenConfiguration.EnableKafkaConfiguration}
 */
public class KafkaAnnotationDrivenConfiguration_EnableKafkaConfiguration__BeanDefinitions {
  /**
   * Get the bean definition for 'enableKafkaConfiguration'
   */
  public static BeanDefinition getEnableKafkaConfigurationBeanDefinition() {
    Class<?> beanType = KafkaAnnotationDrivenConfiguration.EnableKafkaConfiguration.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(KafkaAnnotationDrivenConfiguration.EnableKafkaConfiguration::new);
    return beanDefinition;
  }
}
