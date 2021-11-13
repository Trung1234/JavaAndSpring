## Why Spring?
 - Spring’s flexible and comprehensive set of extensions and third-party libraries let developers build almost any application imaginable. At its core, Spring Framework’s Inversion of Control (IoC) and Dependency Injection (DI) features provide the foundation for a wide-ranging set of features and functionality. 
 - The Spring community is enormous, global, diverse, and spans folks of all ages and capabilities, from complete beginners to seasoned pros. No matter where you are on your journey, you can find the support and resources you need to get you to the next level: quickstarts, guides & tutorials, videos, meetups, support, or even formal training and certification.
 - Spring is fast. With Spring, you’ll notice fast startup, fast shutdown, and optimized execution, by default. Increasingly, Spring projects also support the reactive (nonblocking) programming model for even greater efficiency.
 - Doc spring: https://docs.spring.io/spring-framework/docs/3.0.0.M3/reference/html/
 - To add more lib in spring project
     + add dependency in pom.xml
     + Right-click on your project then "maven"->update project

## Spring’s Inversion of Control (IoC) container.
 - The org.springframework.context.ApplicationContext interface represents the Spring IoC container and is responsible for instantiating, configuring, and assembling the beans.
 -  Instantiating a Container
     + The location path or paths supplied to an ApplicationContext constructor are resource strings that let the container load configuration metadata from a variety of external          resources, such as the local file system, the Java CLASSPATH, and so on.
          - Java code : ApplicationContext context = new ClassPathXmlApplicationContext("services.xml", "daos.xml");
 - Spring Bean :
     + Definition: In Spring, the objects that form the backbone of your application and that are managed by the Spring IoC container are called beans. A bean is an object that is instantiated, assembled, and otherwise managed by a Spring IoC container.
     + https://docs.spring.io/spring-framework/docs/current/reference/html/core.html#beans-introduction
     + Bean scope: 
          - https://docs.spring.io/spring-framework/docs/3.0.0.M3/reference/html/ch04s04.html
     + Bean lifescycle: 
          - https://docs.spring.io/spring-framework/docs/3.0.0.M3/reference/html/ch04s05.html
          - https://techmaster.vn/posts/36168/spring-boot-3-spring-bean-life-cycle-postconstruct-va-predestroy
     + Constructor injection 
          - https://docs.spring.io/spring-framework/docs/current/reference/html/core.html#beans-autowired-annotation
     + Autowired annotation
          - https://techmaster.vn/posts/36167/spring-boot-2-autowired-primary-qualifier
     + Spring bean scopes annotation
          - https://www.journaldev.com/21039/spring-bean-scopes

## Spring Boot
 - https://howtodoinjava.com/spring-boot-tutorials/
 - https://www.baeldung.com/spring-boot
 - https://mkyong.com/spring-boot/spring-boot-spring-security-thymeleaf-example/
 - Pagination: https://www.baeldung.com/spring-thymeleaf-pagination
 - Sorting : https://www.javaguides.net/2020/06/pagination-and-sorting-with-spring-boot-thymeleaf-spring-data-jpa-hibernate-mysql.html
 - https://codebun.com/create-a-login-form-using-thymleaf-in-spring-boot/
 - Session: https://www.javainuse.com/spring/springboot_session
 - Authenticate: https://o7planning.org/11705/create-a-login-application-with-spring-boot-spring-security-jpa
 - CRUD Ajax: https://loizenjs.com/spring-boot-thymeleaf-ajax-crud-example/
 - LIKE Queries in Spring JPA: https://www.baeldung.com/spring-jpa-like-queries
## Spring Security
 - Why you should use BCrypt to hash passwords:
      + Using a Key Factor, BCrypt is able to adjust the cost of hashing. With Key Factor changes, the hash output can be influenced. In this way, BCrypt remains extremely resistant to hacks, especially a type of password cracking called rainbow table.
## Tomcat issue solutions
- Command delivers basic statistics on all network activities and informs users on which portsand addresses : netstat -aon. 
- https://stackoverflow.com/questions/59549059/the-server-cannot-started-because-one-or-more-of-the-ports-are-invalid-tomcat-i

## References
https://www.javaguides.net/p/top-java-tutorials.html
