package org.springframework.boot.autoconfigure.transaction;

import java.lang.Class;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link TransactionAutoConfiguration}
 */
public class TransactionAutoConfiguration__BeanDefinitions {
  /**
   * Get the bean definition for 'transactionAutoConfiguration'
   */
  public static BeanDefinition getTransactionAutoConfigurationBeanDefinition() {
    Class<?> beanType = TransactionAutoConfiguration.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(TransactionAutoConfiguration::new);
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'platformTransactionManagerCustomizers'.
   */
  private static BeanInstanceSupplier<TransactionManagerCustomizers> getPlatformTransactionManagerCustomizersInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<TransactionManagerCustomizers>forFactoryMethod(TransactionAutoConfiguration.class, "platformTransactionManagerCustomizers", ObjectProvider.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(TransactionAutoConfiguration.class).platformTransactionManagerCustomizers(args.get(0)));
  }

  /**
   * Get the bean definition for 'platformTransactionManagerCustomizers'
   */
  public static BeanDefinition getPlatformTransactionManagerCustomizersBeanDefinition() {
    Class<?> beanType = TransactionManagerCustomizers.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(getPlatformTransactionManagerCustomizersInstanceSupplier());
    return beanDefinition;
  }
}
