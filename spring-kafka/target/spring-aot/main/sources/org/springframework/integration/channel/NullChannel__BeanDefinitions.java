package org.springframework.integration.channel;

import java.lang.Class;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link NullChannel}
 */
public class NullChannel__BeanDefinitions {
  /**
   * Get the bean definition for 'nullChannel'
   */
  public static BeanDefinition getNullChannelBeanDefinition() {
    Class<?> beanType = NullChannel.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(NullChannel::new);
    return beanDefinition;
  }
}
