package bootiful;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.lang.Class;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.listener.ContainerProperties;

/**
 * Bean definitions for {@link SpringIntegrationKafkaConfiguration}
 */
public class SpringIntegrationKafkaConfiguration__BeanDefinitions {
  /**
   * Get the bean definition for 'springIntegrationKafkaConfiguration'
   */
  public static BeanDefinition getSpringIntegrationKafkaConfigurationBeanDefinition() {
    Class<?> beanType = SpringIntegrationKafkaConfiguration.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(SpringIntegrationKafkaConfiguration::new);
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'containerProperties'.
   */
  private static BeanInstanceSupplier<ContainerProperties> getContainerPropertiesInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<ContainerProperties>forFactoryMethod(SpringIntegrationKafkaConfiguration.class, "containerProperties")
            .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean(SpringIntegrationKafkaConfiguration.class).containerProperties());
  }

  /**
   * Get the bean definition for 'containerProperties'
   */
  public static BeanDefinition getContainerPropertiesBeanDefinition() {
    Class<?> beanType = ContainerProperties.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(getContainerPropertiesInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'inboundFileOutboundKafkaIntegrationFlow'.
   */
  private static BeanInstanceSupplier<IntegrationFlow> getInboundFileOutboundKafkaIntegrationFlowInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<IntegrationFlow>forFactoryMethod(SpringIntegrationKafkaConfiguration.class, "inboundFileOutboundKafkaIntegrationFlow", KafkaTemplate.class, ObjectMapper.class, File.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(SpringIntegrationKafkaConfiguration.class).inboundFileOutboundKafkaIntegrationFlow(args.get(0), args.get(1), args.get(2)));
  }

  /**
   * Get the bean definition for 'inboundFileOutboundKafkaIntegrationFlow'
   */
  public static BeanDefinition getInboundFileOutboundKafkaIntegrationFlowBeanDefinition() {
    Class<?> beanType = IntegrationFlow.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(getInboundFileOutboundKafkaIntegrationFlowInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'inboundKafkaIntegrationFlow'.
   */
  private static BeanInstanceSupplier<IntegrationFlow> getInboundKafkaIntegrationFlowInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<IntegrationFlow>forFactoryMethod(SpringIntegrationKafkaConfiguration.class, "inboundKafkaIntegrationFlow", ContainerProperties.class, ConsumerFactory.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(SpringIntegrationKafkaConfiguration.class).inboundKafkaIntegrationFlow(args.get(0), args.get(1)));
  }

  /**
   * Get the bean definition for 'inboundKafkaIntegrationFlow'
   */
  public static BeanDefinition getInboundKafkaIntegrationFlowBeanDefinition() {
    Class<?> beanType = IntegrationFlow.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(getInboundKafkaIntegrationFlowInstanceSupplier());
    return beanDefinition;
  }
}
