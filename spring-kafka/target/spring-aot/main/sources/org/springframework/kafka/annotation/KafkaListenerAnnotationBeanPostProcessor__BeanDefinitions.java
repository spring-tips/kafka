package org.springframework.kafka.annotation;

import java.lang.Object;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.core.ResolvableType;

/**
 * Bean definitions for {@link KafkaListenerAnnotationBeanPostProcessor}
 */
public class KafkaListenerAnnotationBeanPostProcessor__BeanDefinitions {
  /**
   * Get the bean definition for 'internalKafkaListenerAnnotationProcessor'
   */
  public static BeanDefinition getInternalKafkaListenerAnnotationProcessorBeanDefinition() {
    ResolvableType beanType = ResolvableType.forClassWithGenerics(KafkaListenerAnnotationBeanPostProcessor.class, Object.class, Object.class);
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(KafkaListenerAnnotationBeanPostProcessor::new);
    return beanDefinition;
  }
}
