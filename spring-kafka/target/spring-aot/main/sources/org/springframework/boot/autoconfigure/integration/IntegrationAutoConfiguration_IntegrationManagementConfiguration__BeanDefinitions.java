package org.springframework.boot.autoconfigure.integration;

import java.lang.Class;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link IntegrationAutoConfiguration.IntegrationManagementConfiguration}
 */
public class IntegrationAutoConfiguration_IntegrationManagementConfiguration__BeanDefinitions {
  /**
   * Get the bean instance supplier for 'org.springframework.boot.autoconfigure.integration.IntegrationAutoConfiguration$IntegrationManagementConfiguration'.
   */
  private static BeanInstanceSupplier<IntegrationAutoConfiguration.IntegrationManagementConfiguration> getIntegrationManagementConfigurationInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<IntegrationAutoConfiguration.IntegrationManagementConfiguration>forConstructor();
  }

  /**
   * Get the bean definition for 'integrationManagementConfiguration'
   */
  public static BeanDefinition getIntegrationManagementConfigurationBeanDefinition() {
    Class<?> beanType = IntegrationAutoConfiguration.IntegrationManagementConfiguration.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(getIntegrationManagementConfigurationInstanceSupplier());
    return beanDefinition;
  }
}
