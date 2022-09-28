package org.springframework.boot.autoconfigure.integration;

import java.lang.Class;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link IntegrationAutoConfiguration.IntegrationManagementConfiguration.EnableIntegrationManagementConfiguration}
 */
public class IntegrationAutoConfiguration_IntegrationManagementConfiguration_EnableIntegrationManagementConfiguration__BeanDefinitions {
  /**
   * Get the bean instance supplier for 'org.springframework.boot.autoconfigure.integration.IntegrationAutoConfiguration$IntegrationManagementConfiguration$EnableIntegrationManagementConfiguration'.
   */
  private static BeanInstanceSupplier<IntegrationAutoConfiguration.IntegrationManagementConfiguration.EnableIntegrationManagementConfiguration> getEnableIntegrationManagementConfigurationInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<IntegrationAutoConfiguration.IntegrationManagementConfiguration.EnableIntegrationManagementConfiguration>forConstructor();
  }

  /**
   * Get the bean definition for 'enableIntegrationManagementConfiguration'
   */
  public static BeanDefinition getEnableIntegrationManagementConfigurationBeanDefinition() {
    Class<?> beanType = IntegrationAutoConfiguration.IntegrationManagementConfiguration.EnableIntegrationManagementConfiguration.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(getEnableIntegrationManagementConfigurationInstanceSupplier());
    return beanDefinition;
  }
}
