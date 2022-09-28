package org.springframework.integration.channel;

import java.lang.Class;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link PublishSubscribeChannel}
 */
public class PublishSubscribeChannel__BeanDefinitions {
  /**
   * Get the bean instance supplier for 'errorChannel'.
   */
  private static BeanInstanceSupplier<PublishSubscribeChannel> getErrorChannelInstanceSupplier() {
    return BeanInstanceSupplier.<PublishSubscribeChannel>forConstructor(boolean.class)
            .withGenerator((registeredBean, args) -> new PublishSubscribeChannel(args.get(0, boolean.class)));
  }

  /**
   * Get the bean definition for 'errorChannel'
   */
  public static BeanDefinition getErrorChannelBeanDefinition() {
    Class<?> beanType = PublishSubscribeChannel.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.getConstructorArgumentValues().addIndexedArgumentValue(0, "#{T(org.springframework.integration.context.IntegrationContextUtils).getIntegrationProperties(beanFactory).toProperties().getProperty('spring.integration.channels.error.requireSubscribers')}");
    beanDefinition.getPropertyValues().addPropertyValue("ignoreFailures", "#{T(org.springframework.integration.context.IntegrationContextUtils).getIntegrationProperties(beanFactory).toProperties().getProperty('spring.integration.channels.error.ignoreFailures')}");
    beanDefinition.setInstanceSupplier(getErrorChannelInstanceSupplier());
    return beanDefinition;
  }
}
