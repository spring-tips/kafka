package org.springframework.boot.autoconfigure.http;

import java.lang.Class;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link HttpMessageConvertersAutoConfiguration}
 */
public class HttpMessageConvertersAutoConfiguration__BeanDefinitions {
  /**
   * Get the bean definition for 'httpMessageConvertersAutoConfiguration'
   */
  public static BeanDefinition getHttpMessageConvertersAutoConfigurationBeanDefinition() {
    Class<?> beanType = HttpMessageConvertersAutoConfiguration.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(HttpMessageConvertersAutoConfiguration::new);
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'messageConverters'.
   */
  private static BeanInstanceSupplier<HttpMessageConverters> getMessageConvertersInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<HttpMessageConverters>forFactoryMethod(HttpMessageConvertersAutoConfiguration.class, "messageConverters", ObjectProvider.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(HttpMessageConvertersAutoConfiguration.class).messageConverters(args.get(0)));
  }

  /**
   * Get the bean definition for 'messageConverters'
   */
  public static BeanDefinition getMessageConvertersBeanDefinition() {
    Class<?> beanType = HttpMessageConverters.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(getMessageConvertersInstanceSupplier());
    return beanDefinition;
  }
}
