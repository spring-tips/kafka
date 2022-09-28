package bootiful;

import java.lang.Class;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link SpringKafkaApplication}
 */
public class SpringKafkaApplication__BeanDefinitions {
  /**
   * Get the bean definition for 'springKafkaApplication'
   */
  public static BeanDefinition getSpringKafkaApplicationBeanDefinition() {
    Class<?> beanType = SpringKafkaApplication.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(SpringKafkaApplication::new);
    return beanDefinition;
  }
}
