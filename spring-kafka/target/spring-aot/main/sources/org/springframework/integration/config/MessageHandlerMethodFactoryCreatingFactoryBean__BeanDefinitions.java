package org.springframework.integration.config;

import java.lang.Class;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.RuntimeBeanReference;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link MessageHandlerMethodFactoryCreatingFactoryBean}
 */
public class MessageHandlerMethodFactoryCreatingFactoryBean__BeanDefinitions {
  /**
   * Get the bean instance supplier for 'integrationMessageHandlerMethodFactory'.
   */
  private static BeanInstanceSupplier<MessageHandlerMethodFactoryCreatingFactoryBean> getIntegrationMessageHandlerMethodFactoryInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<MessageHandlerMethodFactoryCreatingFactoryBean>forConstructor(boolean.class)
            .withGenerator((registeredBean, args) -> new MessageHandlerMethodFactoryCreatingFactoryBean(args.get(0)));
  }

  /**
   * Get the bean definition for 'integrationMessageHandlerMethodFactory'
   */
  public static BeanDefinition getIntegrationMessageHandlerMethodFactoryBeanDefinition() {
    Class<?> beanType = MessageHandlerMethodFactoryCreatingFactoryBean.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.getConstructorArgumentValues().addIndexedArgumentValue(0, false);
    beanDefinition.getPropertyValues().addPropertyValue("argumentResolverMessageConverter", new RuntimeBeanReference("integrationArgumentResolverMessageConverter"));
    beanDefinition.setInstanceSupplier(getIntegrationMessageHandlerMethodFactoryInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'integrationListMessageHandlerMethodFactory'.
   */
  private static BeanInstanceSupplier<MessageHandlerMethodFactoryCreatingFactoryBean> getIntegrationListMessageHandlerMethodFactoryInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<MessageHandlerMethodFactoryCreatingFactoryBean>forConstructor(boolean.class)
            .withGenerator((registeredBean, args) -> new MessageHandlerMethodFactoryCreatingFactoryBean(args.get(0)));
  }

  /**
   * Get the bean definition for 'integrationListMessageHandlerMethodFactory'
   */
  public static BeanDefinition getIntegrationListMessageHandlerMethodFactoryBeanDefinition() {
    Class<?> beanType = MessageHandlerMethodFactoryCreatingFactoryBean.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.getConstructorArgumentValues().addIndexedArgumentValue(0, true);
    beanDefinition.getPropertyValues().addPropertyValue("argumentResolverMessageConverter", new RuntimeBeanReference("integrationArgumentResolverMessageConverter"));
    beanDefinition.setInstanceSupplier(getIntegrationListMessageHandlerMethodFactoryInstanceSupplier());
    return beanDefinition;
  }
}
