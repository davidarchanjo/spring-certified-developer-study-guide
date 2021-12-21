# SPRING CERTIFIED DEVELOPER STUDY GUIDE
![banner](./assets/banner.jpg)


# SPRING CORE CONCEPTS
- Spring IoC Container is responsible for instantiating beans, wiring dependencies and managing the bean lifecycle from its instantiation till destruction. Spring have two IoC container implementations : BeanFactory and ApplicationContext.
- Inversion of Control is a process in which an object defines its dependencies without creating them explicitly. This object delegates the job of constructing such dependencies to an IoC container.

https://www.baeldung.com/inversion-control-and-dependency-injection-in-spring
https://knpcode.com/spring/spring-ioc-container-types-applicationcontext-and-beanfactory

https://www.baeldung.com/spring-bean
https://www.baeldung.com/spring-bean-scopes
https://dzone.com/articles/spring-bean-lifecycle
https://www.geeksforgeeks.org/bean-life-cycle-in-java-spring/
https://knpcode.com/spring/spring-bean-lifecycle-callback-methods/

https://www.baeldung.com/spring-core-annotations
https://www.journaldev.com/2410/spring-dependency-injection
https://www.baeldung.com/spring-expression-language

## ANNOTATIONS
* `@Bean` - used to mark a factory method which instantiates a Spring bean;

* `@Scope` - used to indicate the scope to be used for instances of the annotated bean;

* `@Autowired` - used at constructors, methods and fields to indicate that the injection (i.e. instantiation) will be managed by the Spring container dinamically;

* `@Qualifier` - used to disambiguate bean references of the same type when Spring is otherwise unable to do so;

* `@Primary` - used to indicate that a bean must have a higher preference when there are multiple beans of the same type;

* `@Profile` - used to indicate that a component class or bean is registrable when the specified profile(s) are active;


* `@Component` - generic stereotype annotation used to indicate that a class is a managed component, registering as a bean;
* `@Repository` - is a @Component stereotype annotation used to indicate that a class defines a data repository. Enables automatic translation of exceptions thrown from the underlying persistence layer;

* `@Service` - is a @Component stereotype annotation used to indicate that a class defines business logic;

* `@Configuration` - used to tag a class as a source of bean definitions for Spring Boot to find it during scanning;

* `@Import` - used to indicate one or more component classes to import — typically @Configuration classes.

* `@Value` - used at the field or method/constructor parameter level to inject property value into beans;

* `@PropertySource` - used to load values from property files — the values can be accessed from [Environment](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/core/env/Environment.html) or injected by the @Value annotation;



# SPRING BOOT BASICS AND AUTO CONFIGURATION
https://www.baeldung.com/spring-boot-annotations
https://www.marcobehler.com/guides/spring-boot
https://www.baeldung.com/spring-component-scanning
https://reflectoring.io/spring-boot-conditionals/
https://zetcode.com/springboot/conditionalbeans/

## ANNOTATIONS
* `@SpringBootApplication` - is a combination of `@Configuration`, `@EnableAutoConfiguration`, and `@ComponentScan` annotations with their default attributes.

* `@EnableAutoConfiguration` – used to indicate to the Spring container to automatically add beans based on the dependencies on the classpath.

* `@ComponentScan` – tells Spring to look for other beans, components and configurations in the same package and below of the annotated class.

* `@SpringBootConfiguration` - Indicates that a class provides Spring Boot application @Configuration. Can be used as an alternative to @Configuration annotation so that configuration can be found automatically.

* `@Conditional` - 

* `@Import` - used to import a bean configuration class marked with `@Configuration` which contains custom bean definitions.

* `@ImportAutoConfiguration` - when you don't want to enable the default autoconfiguration with @EnableAutoConfiguration. only runs the configuration classes that you provided in the annotation. 



# ASPECT-ORIENTED PROGRAMMING
https://www.javatpoint.com/spring-aop-tutorial
https://docs.spring.io/spring-framework/docs/3.0.x/reference/aop.html
https://docs.spring.io/spring-framework/docs/current/reference/html/core.html#aop
https://www.journaldev.com/2583/spring-aop-example-tutorial-aspect-advice-pointcut-joinpoint-annotations
https://howtodoinjava.com/spring-aop-tutorial/

## OVERVIEW
Aspect-Oriented Programming (AOP) complements Object-Oriented Programming (OOP) by providing another way of thinking about program structure. The key unit of modularity in OOP is the _class_ whereas in AOP the unit of modularity is the _aspect_.

## CORE CONCEPTS OF AOP
* **Cross-Cutting Concerns** - are common functions that span on multiple points of an application.

* **Join Point** - is any point during the execution of a program, such as the execution of a method, the handling of an exception or a field access etc. Spring AOP only supports _method execution join points_.

* **Advice** - represents an action(s) taken by an **Aspect** at a particular **Join Point**. There are five different types of Advices:

* **Pointcut** - is an expression language of AOP that matches **Joint Point**.

* **Introduction** - is a means to declare additional methods and fields for a type, allowing to introduce new interface to any advised object.

* **Target Object** - is the object being advised by one or more **Aspects**, i.e. the object on which advices are applied. It is known as proxied objects in Spring.

* **Aspect** - is a class that contains Advices, Join Points etc.

* **Interceptor** - is an Aspect that contains only one advice

* **AOP Proxy** - is an object created by the AOP framework in order to implement the aspect contracts. In the Spring Framework, an AOP proxy will be a _proxied object_.

* **Weaving** - is the process of linking aspects with other application types or objects to create an advised object. Weaving can be done at compile time, load time or runtime. Spring AOP Framework performs weaving at runtime.

## ANNOTATIONS
`@Aspect` - is used to indicate a marked `@Component` class as an aspect declaration.

`@Before` - Executes before a Join Point.

`@AfterReturning` - Executes after a Join Point completes normally.

`@AfterThrowing` - Executes if method exits by throwing an exception.

`@AfterFinally` - Executes regardless of the means by which a Joint Point exits (normal or exceptionally).

`@Around` - Executes before and after a Joint Point.



# DATA MANAGEMENT: JDBC, TRANSACTIONS
https://spring.io/guides/gs/accessing-data-jpa/
https://spring.io/guides/gs/relational-data-access/
https://spring.io/guides/gs/managing-transactions/

https://www.javainuse.com/spring/boot-transaction-propagation
https://www.marcobehler.com/guides/spring-transaction-management-transactional-in-depth
https://www.baeldung.com/transaction-configuration-with-jpa-and-spring
https://www.baeldung.com/spring-jdbc-jdbctemplate

## ANNOTATIONS
* `@Entity` - 
* `@Table` -
* `@Id` -
* `@GeneratedValue` -
* `@Column` -
* `@Transactional` -



# SPRING DATA JPA
https://knpcode.com/spring/spring-data-tutorial/
https://www.baeldung.com/the-persistence-layer-with-spring-data-jpa



# SPRING MVC
https://www.baeldung.com/spring-mvc-tutorial
https://spring.io/guides/gs/serving-web-content/
https://docs.spring.io/spring-framework/docs/3.2.x/spring-framework-reference/html/mvc.html
https://howtodoinjava.com/spring-boot2/resttemplate/spring-restful-client-resttemplate-example/

## ANNOTATIONS
* `@GetMapping`, `@PostMapping`, `@PutMapping`, `@DeleteMapping`, and `@PatchMapping` are different variants of `@RequestMapping` for handling the HTTP methods GET, POST, PUT, DELETE, and PATCH respectively. By default `@RequestMapping` maps all HTTP operations. 

* `@PathVariable` - used to bind a named URI path parameter into a method argument.

* `@RequestParam` - used to bind a URI query parameter to a method argument.

* `@RequestHeader` - used to bind a request header to a method parameter

* `@RequestPart` - used to associate a part of a multipart request with a method argument.

* `@CookieValue` - used to indicate that a method parameter is bound to an HTTP cookie.

* `@RequestBody` - used to bind the body of the request to a method argument (object).

* `@ResponseBody` - used to indicate that the result of a request handler method is the response itself.
If a class is annotated with `@ResponseBody`, all of its request handler methods will be functioning like that.

* `@ResponseStatus` - used to specify the HTTP response status of a request handler method.

* `@Controller` - used to mark a class as a source of request method handlers.

* `@RestController` - combines the `@Controller` and `@ResponseBody` annotations, making all class request handler methods assumes `@ResponseBody` by default.
RestTemplate - 



# SPRING SECURITY
https://www.marcobehler.com/guides/spring-security
https://spring.io/guides/topicals/spring-security-architecture/
https://spring.io/guides/gs/securing-web/
https://www.baeldung.com/spring-security-expressions
https://www.section.io/engineering-education/springboot-antmatchers/
https://medium.com/rapaduratech/criando-um-token-jwt-para-autentica%C3%A7%C3%A3o-em-spring-boot-371ccb54a093
https://levelup.gitconnected.com/learn-how-to-build-a-token-based-authentication-server-using-spring-boot-and-spring-security-14a82d186f88
https://medium.com/wolox/securing-applications-with-jwt-spring-boot-da24d3d98f83

antMatcher - 
mvcMatcher - 

## ANNOTATIONS
* `@EnableWebSecurity` - 
* `@EnableMethodSecurity` - 
* `@PreAuthorized` - 
* `@RolesAllowed` - 



# SPRING BOOT ACTUATOR
https://www.baeldung.com/spring-boot-actuators
https://docs.spring.io/spring-boot/docs/current/reference/html/actuator.html#actuator
https://spring.io/guides/gs/actuator-service/



# SPRING BOOT TESTING
https://spring.io/guides/gs/testing-web/
https://howtodoinjava.com/spring-boot2/testing/springboot-test-configuration/
https://howtodoinjava.com/spring-boot2/testing/junit5-with-spring-boot2/
https://reflectoring.io/spring-boot-test/
https://rieckpil.de/spring-boot-unit-and-integration-testing-overview/
https://rieckpil.de/difference-between-mock-and-mockbean-spring-boot-applications/
https://newbedev.com/unit-test-or-integration-test-in-spring-boot

## ANNOTATIONS
* `@SpringBootTest` - used to bootstrap a complete application context for testing. `@SpringBootTest` by default starts searching in the current package of the annotated test class and then searches upwards through the package structure, looking for a class annotated with `@SpringBootConfiguration` from which it reads the configuration to create an application context. This class is usually the main application class since the `@SpringBootApplication` annotation includes the `@SpringBootConfiguration` annotation. It then creates an application context very similar to the one that would be started in a production environment.

* `@WebMvcTest` - used to set up an application context with just enough components and configurations required to test the **Web MVC Controller Layer**. It disables full auto-configuration and instead apply only configuration relevant to MVC tests.

* `@DataJpaTest` - used to set up an application context specificaly to test the **Persistence Layer**, by configuring entities, repositories as well as an embedded database.

* `@TestConfiguration` - used to define additional beans or override existing beans in the Spring application context in order to add specialized configuration for testing. Configuration classes annotated with `@TestConfiguration` are excluded from component scanning. Configuration classes with bean definition annotated with `@TestConfiguration` can be imported by `@Import` or declared as static inner classes. It is required to set the property `spring.main.allow-bean-definition-overriding` to `true` in order to enable bean overriding feature during testing.

* `@MockBean` - annotation part of Spring Test Framework used to create mocks for beans whenever running tests with the _Spring Test context_ (i.e. testing with `@SpringBootTest`, `@WebMvcTest` and so on).

* `@Mock` - annotation part of Mockito Framework used to create a mock instance of the marked field, just like if we would be calling Mockito.mock() manually.

* `@InjectMock` - annotation part of Mockito Framework used to create a mock instance of the marked field and injects all dependencies annotated with `@Mock` into it.