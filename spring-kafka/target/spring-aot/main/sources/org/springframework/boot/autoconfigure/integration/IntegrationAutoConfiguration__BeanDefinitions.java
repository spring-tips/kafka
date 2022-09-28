package org.springframework.boot.autoconfigure.integration;

import java.lang.Class;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link IntegrationAutoConfiguration}
 */
public class IntegrationAutoConfiguration__BeanDefinitions {
  /**
   * Get the bean definition for 'integrationAutoConfiguration'
   */
  public static BeanDefinition getIntegrationAutoConfigurationBeanDefinition() {
    Class<?> beanType = IntegrationAutoConfiguration.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(IntegrationAutoConfiguration::new);
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'integrationGlobalProperties'.
   */
  private static BeanInstanceSupplier<org.springframework.integration.context.IntegrationProperties> getIntegrationGlobalPropertiesInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<org.springframework.integration.context.IntegrationProperties>forFactoryMethod(IntegrationAutoConfiguration.class, "integrationGlobalProperties", IntegrationProperties.class)
            .withGenerator((registeredBean, args) -> IntegrationAutoConfiguration.integrationGlobalProperties(args.get(0)));
  }

  /**
   * Get the bean definition for 'integrationGlobalProperties'
   */
  public static BeanDefinition getIntegrationGlobalPropertiesBeanDefinition() {
    Class<?> beanType = org.springframework.integration.context.IntegrationProperties.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(getIntegrationGlobalPropertiesInstanceSupplier());
    return beanDefinition;
  }
}
