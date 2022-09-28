package org.springframework.boot.autoconfigure;

import java.lang.Class;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link SharedMetadataReaderFactoryContextInitializer.SharedMetadataReaderFactoryBean}
 */
public class SharedMetadataReaderFactoryContextInitializer_SharedMetadataReaderFactoryBean__BeanDefinitions {
  /**
   * Get the bean definition for 'internalCachingMetadataReaderFactory'
   */
  public static BeanDefinition getInternalCachingMetadataReaderFactoryBeanDefinition() {
    Class<?> beanType = SharedMetadataReaderFactoryContextInitializer.SharedMetadataReaderFactoryBean.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(SharedMetadataReaderFactoryContextInitializer.SharedMetadataReaderFactoryBean::new);
    return beanDefinition;
  }
}
