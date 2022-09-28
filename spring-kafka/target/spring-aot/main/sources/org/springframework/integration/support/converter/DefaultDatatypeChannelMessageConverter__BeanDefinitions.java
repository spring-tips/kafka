package org.springframework.integration.support.converter;

import java.lang.Class;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link DefaultDatatypeChannelMessageConverter}
 */
public class DefaultDatatypeChannelMessageConverter__BeanDefinitions {
  /**
   * Get the bean definition for 'datatypeChannelMessageConverter'
   */
  public static BeanDefinition getDatatypeChannelMessageConverterBeanDefinition() {
    Class<?> beanType = DefaultDatatypeChannelMessageConverter.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(DefaultDatatypeChannelMessageConverter::new);
    return beanDefinition;
  }
}
