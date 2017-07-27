package fc.wpf.rest.utils;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import fc.wpf.rest.npe.NonablePC;

/**
 * bean容器
 */
@Slf4j
public class BeanFactory implements ApplicationContextAware {
	private static ApplicationContext ctx;

	public static Object getBean(String beanName) {
		if (ctx.containsBean(beanName))
			return ctx.getBean(beanName);
		else
			return null;
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		ctx = applicationContext;
	}

	
//	public static FCProcessClient client=new NonablePC("localhost",8080);
//
//	public static FCProcessClient getProcClient() {
//		for(int i=0;i<60&&(client instanceof NonablePC);i++)
//		 {
//			log.trace("流程未初始化完成，");
//			try {
//				Thread.sleep(1000);
//			} catch (InterruptedException e) {
//			}
//		}
//		if(client instanceof NonablePC){
//			log.warn("流程未初始化！！！！！！========");
//		}
//		return client;
//	}

}
