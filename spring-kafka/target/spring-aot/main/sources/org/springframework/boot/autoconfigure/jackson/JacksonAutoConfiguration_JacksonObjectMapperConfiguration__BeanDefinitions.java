package org.springframework.boot.autoconfigure.jackson;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.lang.Class;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

/**
 * Bean definitions for {@link JacksonAutoConfiguration.JacksonObjectMapperConfiguration}
 */
public class JacksonAutoConfiguration_JacksonObjectMapperConfiguration__BeanDefinitions {
  /**
   * Get the bean definition for 'jacksonObjectMapperConfiguration'
   */
  public static BeanDefinition getJacksonObjectMapperConfigurationBeanDefinition() {
    Class<?> beanType = JacksonAutoConfiguration.JacksonObjectMapperConfiguration.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(JacksonAutoConfiguration.JacksonObjectMapperConfiguration::new);
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'jacksonObjectMapper'.
   */
  private static BeanInstanceSupplier<ObjectMapper> getJacksonObjectMapperInstanceSupplier() {
    return BeanInstanceSupplier.<ObjectMapper>forFactoryMethod(JacksonAutoConfiguration.JacksonObjectMapperConfiguration.class, "jacksonObjectMapper", Jackson2ObjectMapperBuilder.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(JacksonAutoConfiguration.JacksonObjectMapperConfiguration.class).jacksonObjectMapper(args.get(0)));
  }

  /**
   * Get the bean definition for 'jacksonObjectMapper'
   */
  public static BeanDefinition getJacksonObjectMapperBeanDefinition() {
    Class<?> beanType = ObjectMapper.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setPrimary(true);
    beanDefinition.setInstanceSupplier(getJacksonObjectMapperInstanceSupplier());
    return beanDefinition;
  }
}
