package org.springframework.integration.support;

import java.lang.Class;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link SmartLifecycleRoleController}
 */
public class SmartLifecycleRoleController__BeanDefinitions {
  /**
   * Get the bean definition for 'integrationLifecycleRoleController'
   */
  public static BeanDefinition getIntegrationLifecycleRoleControllerBeanDefinition() {
    Class<?> beanType = SmartLifecycleRoleController.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(SmartLifecycleRoleController::new);
    return beanDefinition;
  }
}
