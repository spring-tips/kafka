package org.springframework.boot.autoconfigure.kafka;

import java.lang.Class;
import java.lang.Object;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.core.ResolvableType;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.KafkaAdmin;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.ProducerListener;

/**
 * Bean definitions for {@link KafkaAutoConfiguration}
 */
public class KafkaAutoConfiguration__BeanDefinitions {
  /**
   * Get the bean instance supplier for 'org.springframework.boot.autoconfigure.kafka.KafkaAutoConfiguration'.
   */
  private static BeanInstanceSupplier<KafkaAutoConfiguration> getKafkaAutoConfigurationInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<KafkaAutoConfiguration>forConstructor(KafkaProperties.class)
            .withGenerator((registeredBean, args) -> new KafkaAutoConfiguration(args.get(0)));
  }

  /**
   * Get the bean definition for 'kafkaAutoConfiguration'
   */
  public static BeanDefinition getKafkaAutoConfigurationBeanDefinition() {
    Class<?> beanType = KafkaAutoConfiguration.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(getKafkaAutoConfigurationInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'kafkaTemplate'.
   */
  private static BeanInstanceSupplier<KafkaTemplate> getKafkaTemplateInstanceSupplier() {
    return BeanInstanceSupplier.<KafkaTemplate>forFactoryMethod(KafkaAutoConfiguration.class, "kafkaTemplate", ProducerFactory.class, ProducerListener.class, ObjectProvider.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(KafkaAutoConfiguration.class).kafkaTemplate(args.get(0), args.get(1), args.get(2)));
  }

  /**
   * Get the bean definition for 'kafkaTemplate'
   */
  public static BeanDefinition getKafkaTemplateBeanDefinition() {
    ResolvableType beanType = ResolvableType.forClassWithGenerics(KafkaTemplate.class, Object.class, Object.class);
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(getKafkaTemplateInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'kafkaProducerListener'.
   */
  private static BeanInstanceSupplier<ProducerListener> getKafkaProducerListenerInstanceSupplier() {
    return BeanInstanceSupplier.<ProducerListener>forFactoryMethod(KafkaAutoConfiguration.class, "kafkaProducerListener")
            .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean(KafkaAutoConfiguration.class).kafkaProducerListener());
  }

  /**
   * Get the bean definition for 'kafkaProducerListener'
   */
  public static BeanDefinition getKafkaProducerListenerBeanDefinition() {
    ResolvableType beanType = ResolvableType.forClassWithGenerics(ProducerListener.class, Object.class, Object.class);
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(getKafkaProducerListenerInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'kafkaConsumerFactory'.
   */
  private static BeanInstanceSupplier<ConsumerFactory> getKafkaConsumerFactoryInstanceSupplier() {
    return BeanInstanceSupplier.<ConsumerFactory>forFactoryMethod(KafkaAutoConfiguration.class, "kafkaConsumerFactory", ObjectProvider.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(KafkaAutoConfiguration.class).kafkaConsumerFactory(args.get(0)));
  }

  /**
   * Get the bean definition for 'kafkaConsumerFactory'
   */
  public static BeanDefinition getKafkaConsumerFactoryBeanDefinition() {
    ResolvableType beanType = ResolvableType.forClassWithGenerics(ConsumerFactory.class, Object.class, Object.class);
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(getKafkaConsumerFactoryInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'kafkaProducerFactory'.
   */
  private static BeanInstanceSupplier<ProducerFactory> getKafkaProducerFactoryInstanceSupplier() {
    return BeanInstanceSupplier.<ProducerFactory>forFactoryMethod(KafkaAutoConfiguration.class, "kafkaProducerFactory", ObjectProvider.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(KafkaAutoConfiguration.class).kafkaProducerFactory(args.get(0)));
  }

  /**
   * Get the bean definition for 'kafkaProducerFactory'
   */
  public static BeanDefinition getKafkaProducerFactoryBeanDefinition() {
    ResolvableType beanType = ResolvableType.forClassWithGenerics(ProducerFactory.class, Object.class, Object.class);
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(getKafkaProducerFactoryInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'kafkaAdmin'.
   */
  private static BeanInstanceSupplier<KafkaAdmin> getKafkaAdminInstanceSupplier() {
    return BeanInstanceSupplier.<KafkaAdmin>forFactoryMethod(KafkaAutoConfiguration.class, "kafkaAdmin")
            .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean(KafkaAutoConfiguration.class).kafkaAdmin());
  }

  /**
   * Get the bean definition for 'kafkaAdmin'
   */
  public static BeanDefinition getKafkaAdminBeanDefinition() {
    Class<?> beanType = KafkaAdmin.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(getKafkaAdminInstanceSupplier());
    return beanDefinition;
  }
}
