package bootiful;

import java.lang.Class;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.ResolvableType;
import org.springframework.kafka.core.KafkaTemplate;

/**
 * Bean definitions for {@link SpringKafkaConfiguration}
 */
public class SpringKafkaConfiguration__BeanDefinitions {
  /**
   * Get the bean definition for 'springKafkaConfiguration'
   */
  public static BeanDefinition getSpringKafkaConfigurationBeanDefinition() {
    Class<?> beanType = SpringKafkaConfiguration.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(SpringKafkaConfiguration::new);
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'notifications'.
   */
  private static BeanInstanceSupplier<NewTopic> getNotificationsInstanceSupplier() {
    return BeanInstanceSupplier.<NewTopic>forFactoryMethod(SpringKafkaConfiguration.class, "notifications")
            .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean(SpringKafkaConfiguration.class).notifications());
  }

  /**
   * Get the bean definition for 'notifications'
   */
  public static BeanDefinition getNotificationsBeanDefinition() {
    Class<?> beanType = NewTopic.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(getNotificationsInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'greetings'.
   */
  private static BeanInstanceSupplier<NewTopic> getGreetingsInstanceSupplier() {
    return BeanInstanceSupplier.<NewTopic>forFactoryMethod(SpringKafkaConfiguration.class, "greetings")
            .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean(SpringKafkaConfiguration.class).greetings());
  }

  /**
   * Get the bean definition for 'greetings'
   */
  public static BeanDefinition getGreetingsBeanDefinition() {
    Class<?> beanType = NewTopic.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(getGreetingsInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'greetingsRunner'.
   */
  private static BeanInstanceSupplier<ApplicationListener> getGreetingsRunnerInstanceSupplier() {
    return BeanInstanceSupplier.<ApplicationListener>forFactoryMethod(SpringKafkaConfiguration.class, "greetingsRunner", KafkaTemplate.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(SpringKafkaConfiguration.class).greetingsRunner(args.get(0)));
  }

  /**
   * Get the bean definition for 'greetingsRunner'
   */
  public static BeanDefinition getGreetingsRunnerBeanDefinition() {
    ResolvableType beanType = ResolvableType.forClassWithGenerics(ApplicationListener.class, ApplicationReadyEvent.class);
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(getGreetingsRunnerInstanceSupplier());
    return beanDefinition;
  }
}
