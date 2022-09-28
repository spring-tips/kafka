package org.springframework.boot.autoconfigure.jmx;

import java.lang.Class;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link JmxProperties}
 */
public class JmxProperties__BeanDefinitions {
  /**
   * Get the bean definition for 'jmxProperties'
   */
  public static BeanDefinition getJmxPropertiesBeanDefinition() {
    Class<?> beanType = JmxProperties.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(JmxProperties::new);
    return beanDefinition;
  }
}
