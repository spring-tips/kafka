package org.springframework.boot.autoconfigure.jackson;

import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;
import java.lang.Class;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link JacksonAutoConfiguration.ParameterNamesModuleConfiguration}
 */
public class JacksonAutoConfiguration_ParameterNamesModuleConfiguration__BeanDefinitions {
  /**
   * Get the bean definition for 'parameterNamesModuleConfiguration'
   */
  public static BeanDefinition getParameterNamesModuleConfigurationBeanDefinition() {
    Class<?> beanType = JacksonAutoConfiguration.ParameterNamesModuleConfiguration.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(JacksonAutoConfiguration.ParameterNamesModuleConfiguration::new);
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'parameterNamesModule'.
   */
  private static BeanInstanceSupplier<ParameterNamesModule> getParameterNamesModuleInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<ParameterNamesModule>forFactoryMethod(JacksonAutoConfiguration.ParameterNamesModuleConfiguration.class, "parameterNamesModule")
            .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean(JacksonAutoConfiguration.ParameterNamesModuleConfiguration.class).parameterNamesModule());
  }

  /**
   * Get the bean definition for 'parameterNamesModule'
   */
  public static BeanDefinition getParameterNamesModuleBeanDefinition() {
    Class<?> beanType = ParameterNamesModule.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(getParameterNamesModuleInstanceSupplier());
    return beanDefinition;
  }
}
