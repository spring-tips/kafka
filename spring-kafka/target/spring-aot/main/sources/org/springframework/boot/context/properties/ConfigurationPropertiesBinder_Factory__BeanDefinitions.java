package org.springframework.boot.context.properties;

import java.lang.Class;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link ConfigurationPropertiesBinder.Factory}
 */
public class ConfigurationPropertiesBinder_Factory__BeanDefinitions {
  /**
   * Get the bean definition for 'internalConfigurationPropertiesBinderFactory'
   */
  public static BeanDefinition getInternalConfigurationPropertiesBinderFactoryBeanDefinition() {
    Class<?> beanType = ConfigurationPropertiesBinder.Factory.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setRole(BeanDefinition.ROLE_INFRASTRUCTURE);
    beanDefinition.setInstanceSupplier(ConfigurationPropertiesBinder.Factory::new);
    return beanDefinition;
  }
}
