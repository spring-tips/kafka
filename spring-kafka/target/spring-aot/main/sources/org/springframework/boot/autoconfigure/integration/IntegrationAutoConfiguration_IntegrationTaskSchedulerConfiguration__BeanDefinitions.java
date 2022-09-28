package org.springframework.boot.autoconfigure.integration;

import java.lang.Class;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.boot.task.TaskSchedulerBuilder;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

/**
 * Bean definitions for {@link IntegrationAutoConfiguration.IntegrationTaskSchedulerConfiguration}
 */
public class IntegrationAutoConfiguration_IntegrationTaskSchedulerConfiguration__BeanDefinitions {
  /**
   * Get the bean instance supplier for 'org.springframework.boot.autoconfigure.integration.IntegrationAutoConfiguration$IntegrationTaskSchedulerConfiguration'.
   */
  private static BeanInstanceSupplier<IntegrationAutoConfiguration.IntegrationTaskSchedulerConfiguration> getIntegrationTaskSchedulerConfigurationInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<IntegrationAutoConfiguration.IntegrationTaskSchedulerConfiguration>forConstructor();
  }

  /**
   * Get the bean definition for 'integrationTaskSchedulerConfiguration'
   */
  public static BeanDefinition getIntegrationTaskSchedulerConfigurationBeanDefinition() {
    Class<?> beanType = IntegrationAutoConfiguration.IntegrationTaskSchedulerConfiguration.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(getIntegrationTaskSchedulerConfigurationInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'taskScheduler'.
   */
  private static BeanInstanceSupplier<ThreadPoolTaskScheduler> getTaskSchedulerInstanceSupplier() {
    return BeanInstanceSupplier.<ThreadPoolTaskScheduler>forFactoryMethod(IntegrationAutoConfiguration.IntegrationTaskSchedulerConfiguration.class, "taskScheduler", TaskSchedulerBuilder.class);
  }

  /**
   * Get the bean definition for 'taskScheduler'
   */
  public static BeanDefinition getTaskSchedulerBeanDefinition() {
    Class<?> beanType = ThreadPoolTaskScheduler.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(getTaskSchedulerInstanceSupplier());
    return beanDefinition;
  }
}
