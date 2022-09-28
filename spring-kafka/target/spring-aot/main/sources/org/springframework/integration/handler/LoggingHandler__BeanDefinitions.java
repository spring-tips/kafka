package org.springframework.integration.handler;

import java.lang.Class;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link LoggingHandler}
 */
public class LoggingHandler__BeanDefinitions {
  /**
   * Get the bean instance supplier for '_org.springframework.integration.errorLogger.handler'.
   */
  private static BeanInstanceSupplier<LoggingHandler> getHandlerInstanceSupplier() {
    return BeanInstanceSupplier.<LoggingHandler>forConstructor(LoggingHandler.Level.class)
            .withGenerator((registeredBean, args) -> new LoggingHandler(args.get(0, LoggingHandler.Level.class)));
  }

  /**
   * Get the bean definition for 'handler'
   */
  public static BeanDefinition getHandlerBeanDefinition() {
    Class<?> beanType = LoggingHandler.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.getConstructorArgumentValues().addIndexedArgumentValue(0, LoggingHandler.Level.ERROR);
    beanDefinition.setInstanceSupplier(getHandlerInstanceSupplier());
    return beanDefinition;
  }
}
