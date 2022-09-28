package org.springframework.boot.autoconfigure.jackson;

import java.lang.Class;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.boot.jackson.JsonComponentModule;
import org.springframework.boot.jackson.JsonMixinModule;
import org.springframework.context.ApplicationContext;

/**
 * Bean definitions for {@link JacksonAutoConfiguration}
 */
public class JacksonAutoConfiguration__BeanDefinitions {
  /**
   * Get the bean definition for 'jacksonAutoConfiguration'
   */
  public static BeanDefinition getJacksonAutoConfigurationBeanDefinition() {
    Class<?> beanType = JacksonAutoConfiguration.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(JacksonAutoConfiguration::new);
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'jsonComponentModule'.
   */
  private static BeanInstanceSupplier<JsonComponentModule> getJsonComponentModuleInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<JsonComponentModule>forFactoryMethod(JacksonAutoConfiguration.class, "jsonComponentModule")
            .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean(JacksonAutoConfiguration.class).jsonComponentModule());
  }

  /**
   * Get the bean definition for 'jsonComponentModule'
   */
  public static BeanDefinition getJsonComponentModuleBeanDefinition() {
    Class<?> beanType = JsonComponentModule.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(getJsonComponentModuleInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'jsonMixinModule'.
   */
  private static BeanInstanceSupplier<JsonMixinModule> getJsonMixinModuleInstanceSupplier() {
    return BeanInstanceSupplier.<JsonMixinModule>forFactoryMethod(JacksonAutoConfiguration.class, "jsonMixinModule", ApplicationContext.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(JacksonAutoConfiguration.class).jsonMixinModule(args.get(0)));
  }

  /**
   * Get the bean definition for 'jsonMixinModule'
   */
  public static BeanDefinition getJsonMixinModuleBeanDefinition() {
    Class<?> beanType = JsonMixinModule.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(getJsonMixinModuleInstanceSupplier());
    return beanDefinition;
  }
}
