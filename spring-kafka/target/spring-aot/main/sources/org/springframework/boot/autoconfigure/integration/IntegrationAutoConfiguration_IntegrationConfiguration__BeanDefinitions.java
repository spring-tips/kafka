package org.springframework.boot.autoconfigure.integration;

import java.lang.Class;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.integration.scheduling.PollerMetadata;

/**
 * Bean definitions for {@link IntegrationAutoConfiguration.IntegrationConfiguration}
 */
public class IntegrationAutoConfiguration_IntegrationConfiguration__BeanDefinitions {
  /**
   * Get the bean instance supplier for 'org.springframework.boot.autoconfigure.integration.IntegrationAutoConfiguration$IntegrationConfiguration'.
   */
  private static BeanInstanceSupplier<IntegrationAutoConfiguration.IntegrationConfiguration> getIntegrationConfigurationInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<IntegrationAutoConfiguration.IntegrationConfiguration>forConstructor();
  }

  /**
   * Get the bean definition for 'integrationConfiguration'
   */
  public static BeanDefinition getIntegrationConfigurationBeanDefinition() {
    Class<?> beanType = IntegrationAutoConfiguration.IntegrationConfiguration.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(getIntegrationConfigurationInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'org.springframework.integration.context.defaultPollerMetadata'.
   */
  private static BeanInstanceSupplier<PollerMetadata> getDefaultPollerMetadataInstanceSupplier() {
    return BeanInstanceSupplier.<PollerMetadata>forFactoryMethod(IntegrationAutoConfiguration.IntegrationConfiguration.class, "defaultPollerMetadata", IntegrationProperties.class);
  }

  /**
   * Get the bean definition for 'defaultPollerMetadata'
   */
  public static BeanDefinition getDefaultPollerMetadataBeanDefinition() {
    Class<?> beanType = PollerMetadata.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(getDefaultPollerMetadataInstanceSupplier());
    return beanDefinition;
  }
}
