## Why Spring?
 - Spring’s flexible and comprehensive set of extensions and third-party libraries let developers build almost any application imaginable. At its core, Spring Framework’s Inversion of Control (IoC) and Dependency Injection (DI) features provide the foundation for a wide-ranging set of features and functionality. Whether you’re building secure, reactive, cloud-based microservices for the web, or complex streaming data flows for the enterprise, Spring has the tools to help.
 - The Spring community is enormous, global, diverse, and spans folks of all ages and capabilities, from complete beginners to seasoned pros. No matter where you are on your journey, you can find the support and resources you need to get you to the next level: quickstarts, guides & tutorials, videos, meetups, support, or even formal training and certification.

## Spring’s Inversion of Control (IoC) container.
 - The org.springframework.context.ApplicationContext interface represents the Spring IoC container and is responsible for instantiating, configuring, and assembling the beans.
 -  Instantiating a Container
     + The location path or paths supplied to an ApplicationContext constructor are resource strings that let the container load configuration metadata from a variety of external          resources, such as the local file system, the Java CLASSPATH, and so on.
          - Java code : ApplicationContext context = new ClassPathXmlApplicationContext("services.xml", "daos.xml");
 - Bean Definition:
     + In Spring, the objects that form the backbone of your application and that are managed by the Spring IoC container are called beans. A bean is an object that is instantiated, assembled, and otherwise managed by a Spring IoC container.
     + https://www.baeldung.com/spring-bean
