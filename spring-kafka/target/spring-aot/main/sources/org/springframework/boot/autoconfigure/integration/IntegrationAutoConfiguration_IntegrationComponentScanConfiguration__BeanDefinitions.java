package org.springframework.boot.autoconfigure.integration;

import java.lang.Class;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link IntegrationAutoConfiguration.IntegrationComponentScanConfiguration}
 */
public class IntegrationAutoConfiguration_IntegrationComponentScanConfiguration__BeanDefinitions {
  /**
   * Get the bean instance supplier for 'org.springframework.boot.autoconfigure.integration.IntegrationAutoConfiguration$IntegrationComponentScanConfiguration'.
   */
  private static BeanInstanceSupplier<IntegrationAutoConfiguration.IntegrationComponentScanConfiguration> getIntegrationComponentScanConfigurationInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<IntegrationAutoConfiguration.IntegrationComponentScanConfiguration>forConstructor();
  }

  /**
   * Get the bean definition for 'integrationComponentScanConfiguration'
   */
  public static BeanDefinition getIntegrationComponentScanConfigurationBeanDefinition() {
    Class<?> beanType = IntegrationAutoConfiguration.IntegrationComponentScanConfiguration.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(getIntegrationComponentScanConfigurationInstanceSupplier());
    return beanDefinition;
  }
}
