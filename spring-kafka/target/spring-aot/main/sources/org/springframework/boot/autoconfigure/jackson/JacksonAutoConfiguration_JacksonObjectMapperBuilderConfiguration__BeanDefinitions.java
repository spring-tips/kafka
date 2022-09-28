package org.springframework.boot.autoconfigure.jackson;

import java.lang.Class;
import java.util.List;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

/**
 * Bean definitions for {@link JacksonAutoConfiguration.JacksonObjectMapperBuilderConfiguration}
 */
public class JacksonAutoConfiguration_JacksonObjectMapperBuilderConfiguration__BeanDefinitions {
  /**
   * Get the bean definition for 'jacksonObjectMapperBuilderConfiguration'
   */
  public static BeanDefinition getJacksonObjectMapperBuilderConfigurationBeanDefinition() {
    Class<?> beanType = JacksonAutoConfiguration.JacksonObjectMapperBuilderConfiguration.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(JacksonAutoConfiguration.JacksonObjectMapperBuilderConfiguration::new);
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'jacksonObjectMapperBuilder'.
   */
  private static BeanInstanceSupplier<Jackson2ObjectMapperBuilder> getJacksonObjectMapperBuilderInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<Jackson2ObjectMapperBuilder>forFactoryMethod(JacksonAutoConfiguration.JacksonObjectMapperBuilderConfiguration.class, "jacksonObjectMapperBuilder", ApplicationContext.class, List.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(JacksonAutoConfiguration.JacksonObjectMapperBuilderConfiguration.class).jacksonObjectMapperBuilder(args.get(0), args.get(1)));
  }

  /**
   * Get the bean definition for 'jacksonObjectMapperBuilder'
   */
  public static BeanDefinition getJacksonObjectMapperBuilderBeanDefinition() {
    Class<?> beanType = Jackson2ObjectMapperBuilder.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setScope("prototype");
    beanDefinition.setInstanceSupplier(getJacksonObjectMapperBuilderInstanceSupplier());
    return beanDefinition;
  }
}
