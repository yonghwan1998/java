package xyz.itwill04.bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanAttributeApp {
	public static void main(String[] args) {
		System.out.println("=============== Spring Container 초기화 전 ===============");
		ApplicationContext context = new ClassPathXmlApplicationContext("04-2_beanAttribute.xml");
		System.out.println("=============== Spring Container 초기화 후 ===============");
		// ApplicationContext.getBean(String beanName) : 스프링 컨테이너로부터 매개변수로 전달받은
		// beanName의 Spring Bean(객체)를 검색하여 반환하는 메소드
		// => Object 타입의 객체를 반환하므로 반드시 명시적 객체 형변환 사용
		// InitDestroyMethodBean
		// bean=(InitDestroyMethodBean)context.getBean("initDestroyMethodBean");

		// ApplicationContext.getBean(String beanName, Class<T> clazz) : 스프링 컨테이너로부터
		// 매개변수로 전달받은 beanName의 Spring Bean를 Class 객체로 객체 형변환하여 반환하는 메소드
		InitDestroyMethodBean bean = context.getBean("initDestroyMethodBean", InitDestroyMethodBean.class);

		// bean 엘리먼트를 이용하면 메소드를 객체를 생성한 후 자동으로 호출되도록 설정 가능
		// bean.init();//초기화 메소드

		bean.display();

		// bean 엘리먼트를 이용하면 메소드를 객체 소멸 전 자동으로 호출되도록 설정 가능
		// bean.destroy();//마무리 메소드
		System.out.println("==========================================================");
		context.getBean("lazyInitBean", LazyInitBean.class);
		System.out.println("==========================================================");
		((ClassPathXmlApplicationContext) context).close();
		System.out.println("==========================================================");
	}
}