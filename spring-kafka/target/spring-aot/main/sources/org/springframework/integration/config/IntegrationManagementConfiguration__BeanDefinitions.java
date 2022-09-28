package org.springframework.integration.config;

import java.lang.Class;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link IntegrationManagementConfiguration}
 */
public class IntegrationManagementConfiguration__BeanDefinitions {
  /**
   * Get the bean definition for 'integrationManagementConfiguration'
   */
  public static BeanDefinition getIntegrationManagementConfigurationBeanDefinition() {
    Class<?> beanType = IntegrationManagementConfiguration.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(IntegrationManagementConfiguration::new);
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'integrationManagementConfigurer'.
   */
  private static BeanInstanceSupplier<IntegrationManagementConfigurer> getIntegrationManagementConfigurerInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<IntegrationManagementConfigurer>forFactoryMethod(IntegrationManagementConfiguration.class, "managementConfigurer", ObjectProvider.class, ObjectProvider.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(IntegrationManagementConfiguration.class).managementConfigurer(args.get(0), args.get(1)));
  }

  /**
   * Get the bean definition for 'integrationManagementConfigurer'
   */
  public static BeanDefinition getIntegrationManagementConfigurerBeanDefinition() {
    Class<?> beanType = IntegrationManagementConfigurer.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setRole(BeanDefinition.ROLE_INFRASTRUCTURE);
    beanDefinition.setInstanceSupplier(getIntegrationManagementConfigurerInstanceSupplier());
    return beanDefinition;
  }
}
