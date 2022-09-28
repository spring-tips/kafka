package org.springframework.boot.autoconfigure.jackson;

import java.lang.Class;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.ApplicationContext;

/**
 * Bean definitions for {@link JacksonAutoConfiguration.Jackson2ObjectMapperBuilderCustomizerConfiguration}
 */
public class JacksonAutoConfiguration_Jackson2ObjectMapperBuilderCustomizerConfiguration__BeanDefinitions {
  /**
   * Get the bean definition for 'jackson2ObjectMapperBuilderCustomizerConfiguration'
   */
  public static BeanDefinition getJacksonObjectMapperBuilderCustomizerConfigurationBeanDefinition(
      ) {
    Class<?> beanType = JacksonAutoConfiguration.Jackson2ObjectMapperBuilderCustomizerConfiguration.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(JacksonAutoConfiguration.Jackson2ObjectMapperBuilderCustomizerConfiguration::new);
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'standardJacksonObjectMapperBuilderCustomizer'.
   */
  private static BeanInstanceSupplier<JacksonAutoConfiguration.Jackson2ObjectMapperBuilderCustomizerConfiguration.StandardJackson2ObjectMapperBuilderCustomizer> getStandardJacksonObjectMapperBuilderCustomizerInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<JacksonAutoConfiguration.Jackson2ObjectMapperBuilderCustomizerConfiguration.StandardJackson2ObjectMapperBuilderCustomizer>forFactoryMethod(JacksonAutoConfiguration.Jackson2ObjectMapperBuilderCustomizerConfiguration.class, "standardJacksonObjectMapperBuilderCustomizer", ApplicationContext.class, JacksonProperties.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(JacksonAutoConfiguration.Jackson2ObjectMapperBuilderCustomizerConfiguration.class).standardJacksonObjectMapperBuilderCustomizer(args.get(0), args.get(1)));
  }

  /**
   * Get the bean definition for 'standardJacksonObjectMapperBuilderCustomizer'
   */
  public static BeanDefinition getStandardJacksonObjectMapperBuilderCustomizerBeanDefinition() {
    Class<?> beanType = JacksonAutoConfiguration.Jackson2ObjectMapperBuilderCustomizerConfiguration.StandardJackson2ObjectMapperBuilderCustomizer.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(getStandardJacksonObjectMapperBuilderCustomizerInstanceSupplier());
    return beanDefinition;
  }
}
