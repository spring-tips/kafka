package org.springframework.boot.autoconfigure.http;

import java.lang.Class;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.core.env.Environment;
import org.springframework.http.converter.StringHttpMessageConverter;

/**
 * Bean definitions for {@link HttpMessageConvertersAutoConfiguration.StringHttpMessageConverterConfiguration}
 */
public class HttpMessageConvertersAutoConfiguration_StringHttpMessageConverterConfiguration__BeanDefinitions {
  /**
   * Get the bean instance supplier for 'org.springframework.boot.autoconfigure.http.HttpMessageConvertersAutoConfiguration$StringHttpMessageConverterConfiguration'.
   */
  private static BeanInstanceSupplier<HttpMessageConvertersAutoConfiguration.StringHttpMessageConverterConfiguration> getStringHttpMessageConverterConfigurationInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<HttpMessageConvertersAutoConfiguration.StringHttpMessageConverterConfiguration>forConstructor();
  }

  /**
   * Get the bean definition for 'stringHttpMessageConverterConfiguration'
   */
  public static BeanDefinition getStringHttpMessageConverterConfigurationBeanDefinition() {
    Class<?> beanType = HttpMessageConvertersAutoConfiguration.StringHttpMessageConverterConfiguration.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(getStringHttpMessageConverterConfigurationInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'stringHttpMessageConverter'.
   */
  private static BeanInstanceSupplier<StringHttpMessageConverter> getStringHttpMessageConverterInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<StringHttpMessageConverter>forFactoryMethod(HttpMessageConvertersAutoConfiguration.StringHttpMessageConverterConfiguration.class, "stringHttpMessageConverter", Environment.class);
  }

  /**
   * Get the bean definition for 'stringHttpMessageConverter'
   */
  public static BeanDefinition getStringHttpMessageConverterBeanDefinition() {
    Class<?> beanType = StringHttpMessageConverter.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(getStringHttpMessageConverterInstanceSupplier());
    return beanDefinition;
  }
}
