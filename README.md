# SPRING CERTIFIED DEVELOPER STUDY GUIDE
![banner](./assets/banner.jpg)
</br></br>

# INTRODUCTION
This guide walks you through some technical notes and references about the Spring Framework, with a focus on the Spring Boot Framework, as a supporting material for whoever it is preparing to take the [VMware Spring Professional 2021](https://www.vmware.com/education-services/certification/vcp-spring-exam.html) exam. The content in this guide are by no means definitive and exhaustive so that they alone can enable someone to take the exam with peace of mind. It is worthy to mention that much of my knowledge on the Spring Framework comes from [my professional working experience as a Java Developer](https://www.linkedin.com/in/davidarchanjo/) such that this guide served as way to organize sources of technical documentations which I considered relevant as well as to define a study planning to help me get certified.

I hope this guide helps you in some way on your journey. Good luck 🤞🍀!
</br></br>


# EXAM OVERVIEW
The [Spring Certified Professional](https://www.vmware.com/education-services/certification/vcp-spring-exam.html) certification is a 50-multiple-choice exam, with a passing score of 76% correctness (i.e. at least 38 out of 50 questions must be answered correctly). This Spring Professional certification exam is designed to test and validate the overall understanding and familiarity with core aspects of Spring and Spring Boot as follows:
 - Container, Dependency, and IOC
 - Aspect-Oriented Programming (AOC)
 - Data Management: JDBC, Transactions
 - Spring Data JPA
 - Spring MVC Basics
 - Spring MVC REST
 - Security
 - Testing 
 - Spring Boot Basics
 - Spring Boot Auto Configuration
 - Spring Boot Actuator
 - Spring Boot Testing

### EXAM INFO
**Duration:** 90 Minutes

**Number of Questions:** 50 Questions

**Passing Score:** 76%

**Format:** Multiple Choice, Multiple Choice Multiple Selection, Drag and Drop, Matching
</br></br>


# TABLE OF CONTENTS
1. <a href="#1-spring-core-concepts-" id="1">SPRING CORE CONCEPTS</a>
2. <a href="#2-spring-boot-basics-and-auto-configuration-" id="2">SPRING BOOT BASICS AND AUTO-CONFIGURATION</a>
3. <a href="#3-aspect-oriented-programming-" id="3">ASPECT-ORIENTED PROGRAMMING</a>
4. <a href="#4-data-management-jdbc-transactions-" id="4">DATA MANAGEMENT: JDBC, TRANSACTIONS</a>
5. <a href="#5-spring-data-jpa-" id="5">SPRING DATA JPA</a>
6. <a href="#6-spring-mvc-" id="6">SPRING MVC</a>
7. <a href="#7-spring-security-" id="7">SPRING SECURITY</a>
8. <a href="#8-spring-boot-actuator-" id="8">SPRING BOOT ACTUATOR</a>
9. <a href="#9-spring-boot-testing-" id="9">SPRING BOOT TESTING</a>
</br></br>


# 1. SPRING CORE CONCEPTS <a id="1-spring-core-concepts-" href="#1"></a>
- **Bean** is an object that is instantiated, assembled, and otherwise managed by the **Spring IoC Container**.
- **Spring IoC Container** is responsible for instantiating beans, wiring dependencies and managing the bean lifecycle from its instantiation till destruction. Spring have two IoC container implementations: [BeanFactory](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/beans/factory/BeanFactory.html) and [ApplicationContext](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/context/ApplicationContext.html).
- **Inversion of Control (IoC)** is a process in which an object defines its dependencies without creating them explicitly. This object delegates the job of constructing such dependencies to the IoC container.
- **Dependency Injection** is a pattern used to implement IoC, where the control being inverted is the setting and injecting of an object's dependencies.

- BeanPostProcessor
- BeanFactoryPostProcessor

## REFERENCES
- https://www.baeldung.com/inversion-control-and-dependency-injection-in-spring
- https://knpcode.com/spring/spring-ioc-container-types-applicationcontext-and-beanfactory
- https://www.journaldev.com/2410/spring-dependency-injection
- https://www.baeldung.com/spring-bean
- https://www.baeldung.com/spring-bean-scopes
- https://dzone.com/articles/spring-bean-lifecycle
- https://www.geeksforgeeks.org/bean-life-cycle-in-java-spring
- https://knpcode.com/spring/spring-bean-lifecycle-callback-methods
- https://www.baeldung.com/spring-core-annotations
- https://www.baeldung.com/spring-expression-language

## KEY ANNOTATIONS
`@Bean` - used to mark a factory method which instantiates a Spring bean;

`@Scope` - used to indicate the scope for instances of the annotated bean;

`@Autowired` - used at constructors, methods and fields to indicate that the injection (i.e. instantiation) will be managed by the Spring container dinamically;

`@Qualifier` - used to disambiguate bean references of the same type when Spring is otherwise unable to do so;

`@Primary` - used to indicate that a bean must be given preference when multiple candidates are qualified to autowire a single-valued dependency, i.e. is used to give higher preference to a bean when there are multiple beans of the same type.

`@Lazy` - used to indicate whether a bean is to be lazily initialized, i.e. if present on a `@Component` or `@Bean` definition and set to <code>true</code>, the `@Bean` or `@Component` will not be initialized until referenced by another bean or explicitly retrieved from the enclosing [BeanFactory](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/beans/factory/BeanFactory.html). This annotation may also be placed on injection points marked `@Autowired`;

`@Profile` - used to indicate that a component class or bean is registrable when the specified profile(s) are active;

`@Component` - generic stereotype annotation used to indicate that a class is a managed component, registering as a bean;

`@Repository` - is a @Component stereotype annotation used to indicate that a class defines a data repository. Enables automatic translation of exceptions thrown from the underlying persistence layer;

`@Service` - is a @Component stereotype annotation used to indicate that a class defines business logic;

`@Configuration` - used to tag a class as a source of bean definitions for Spring Boot to find it during scanning;

`@Import` - used to indicate one or more component classes to import — typically @Configuration classes.

`@Value` - used at the field or method/constructor parameter level to inject property value into beans;

`@PropertySource` - used to load values from property files — the values can be accessed from [Environment](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/core/env/Environment.html) or injected by the @Value annotation;

`@ConfigurationProperties` - used to map resource files such as properties or YAML files to Java Bean object.

`@EnableConfigurationProperties` - enables support for `@ConfigurationProperties` annotated classes in our application.
</br></br>


# 2. SPRING BOOT BASICS AND AUTO-CONFIGURATION <a id="2-spring-boot-basics-and-auto-configuration-" href="#2"></a>
## REFERENCES
- https://www.baeldung.com/spring-boot-annotations
- https://www.baeldung.com/spring-conditional-annotations
- https://www.marcobehler.com/guides/spring-boot
- https://www.baeldung.com/spring-component-scanning
- https://reflectoring.io/spring-boot-conditionals
- https://zetcode.com/springboot/conditionalbeans

## KEY ANNOTATIONS
`@SpringBootApplication` - is a combination of `@Configuration`, `@EnableAutoConfiguration`, and `@ComponentScan` annotations with their default attributes.

`@EnableAutoConfiguration` – used to indicate to the Spring container to automatically add beans based on the dependencies on the classpath.

`@ComponentScan` – tells Spring to look for other beans, components and configurations in the same package and below of the annotated class.

`@SpringBootConfiguration` - Indicates that a class provides Spring Boot application @Configuration. Can be used as an alternative to @Configuration annotation so that configuration can be found automatically.

`@Conditional` - 

`@Import` - used to import a bean configuration class marked with `@Configuration` which contains custom bean definitions.

`@ImportAutoConfiguration` - when you don't want to enable the default autoconfiguration with @EnableAutoConfiguration. only runs the configuration classes that you provided in the annotation. 
</br></br>


# 3. ASPECT-ORIENTED PROGRAMMING <a id="3-aspect-oriented-programming-" href="#3"></a>
## REFERENCES
- https://www.javatpoint.com/spring-aop-tutorial
- https://docs.spring.io/spring-framework/docs/3.0.x/reference/aop.html
- https://docs.spring.io/spring-framework/docs/current/reference/html/core.html#aop
- https://www.journaldev.com/2583/spring-aop-example-tutorial-aspect-advice-pointcut-joinpoint-annotations
- https://howtodoinjava.com/spring-aop-tutorial/
- https://www.baeldung.com/spring-aop-pointcut-tutorial
- https://www.eclipse.org/aspectj/doc/next/aspectj5rt-api/org/aspectj/lang/annotation/package-summary.html

## OVERVIEW
Aspect-Oriented Programming (AOP) complements Object-Oriented Programming (OOP) by providing another way of thinking about program structure. The key unit of modularity in OOP is the _class_ whereas in AOP the unit of modularity is the _aspect_.

### CORE CONCEPTS
* **Cross-Cutting Concerns** - are common functions that span on multiple points of an application, such as logging, transaction management, data validation, etc;

* **Join Point** - is any point during the execution of a program, such as the execution of a method, the handling of an exception or a field access. In Spring AOP, a join point always represents a method execution;

* **Advice** - is an action(s) taken by an **Aspect** at a particular **Join Point**; 

* **Pointcut** - is an expression language of AOP that matches **Joint Point**. Spring uses the AspectJ pointcut expression language by default;

* **Introduction** - is a means to declare additional methods and fields for a type, allowing to introduce new interface to any advised object;

* **Target Object** - is the object being advised by one or more **Aspects**, i.e. the object on which advices are applied. It is known as proxied objects in Spring;

* **Aspect** - is a class that contains Advices, Join Points etc;

* **Interceptor** - is an Aspect that contains only one advice;

* **AOP Proxy** - is an object created by the AOP framework in order to implement the aspect contracts. In Spring, an AOP proxy will be a _proxied object_;

* **Weaving** - is the process of linking aspects with other application types or objects to create an advised object. Weaving can be done at compile time, load time or runtime. Spring AOP performs weaving at runtime;

## KEY ANNOTATIONS
[@EnableAspectJAutoProxy](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/context/annotation/EnableAspectJAutoProxy.html) - used to enable support for handling component classes marked with @Aspect. Must be used in a @Configuration class to take effect;

[@Aspect](https://www.eclipse.org/aspectj/doc/next/aspectj5rt-api/org/aspectj/lang/annotation/Aspect.html) - used to mark a @Component class as an aspect declaration;

[@Pointcut](https://www.eclipse.org/aspectj/doc/next/aspectj5rt-api/org/aspectj/lang/annotation/Pointcut.html) - used in methods to declare pointcut, which can be used by advice annotations to refer to that pointcut;

[@Before](https://www.eclipse.org/aspectj/doc/next/aspectj5rt-api/org/aspectj/lang/annotation/Before.html) - used to mark a method to be executed before the matching joint point;

[@AfterReturning](https://www.eclipse.org/aspectj/doc/next/aspectj5rt-api/org/aspectj/lang/annotation/AfterReturning.html) - used to mark a method to be executed after the matching joint point completes, whether normally or by throwing an exception;

[@AfterThrowing](https://www.eclipse.org/aspectj/doc/next/aspectj5rt-api/org/aspectj/lang/annotation/AfterThrowing.html) - used to mark a method to be executed after the matching join point exits by throwing an exception;

[@Around](https://www.eclipse.org/aspectj/doc/next/aspectj5rt-api/org/aspectj/lang/annotation/Around.html) - used to mark a method to be executed before and after a Joint Point.
</br></br>


# 4. DATA MANAGEMENT: JDBC, TRANSACTIONS <a id="4-data-management-jdbc-transactions-" href="#4"></a>
## REFERENCES
- https://spring.io/guides/gs/accessing-data-jpa/
- https://spring.io/guides/gs/relational-data-access/
- https://spring.io/guides/gs/managing-transactions/

- https://www.javainuse.com/spring/boot-transaction-propagation
- https://www.marcobehler.com/guides/spring-transaction-management-transactional-in-depth
- https://www.baeldung.com/transaction-configuration-with-jpa-and-spring
- https://www.baeldung.com/spring-jdbc-jdbctemplate

## KEY ANNOTATIONS
`@Transactional` -
</br></br>


# 5. SPRING DATA JPA <a id="5-spring-data-jpa-" href="#5"></a>
## REFERENCES
- https://knpcode.com/spring/spring-data-tutorial/
- https://www.baeldung.com/the-persistence-layer-with-spring-data-jpa

## KEY ANNOTATIONS
`@Entity` - 

`@Table` -

`@Id` -

`@GeneratedValue` -

`@Column` -

`@Transactional` -
</br></br>


# 6. SPRING MVC <a id="6-spring-mvc-" href="#6"></a>
## REFERENCES
- https://www.baeldung.com/spring-mvc-tutorial
- https://spring.io/guides/gs/serving-web-content
- https://docs.spring.io/spring-framework/docs/3.2.x/spring-framework-reference/html/mvc.html
- https://howtodoinjava.com/spring-boot2/resttemplate/spring-restful-client-resttemplate-example

## KEY ANNOTATIONS
`@GetMapping` - used to map HTTP GET requests onto specific handler method. It is a composed annotation that acts as a shortcut for <code>@RequestMapping(method = RequestMethod.GET)</code>;

`@PostMapping` - used to map HTTP POST requests onto specific handler method. It is a composed annotation that acts as a shortcut for <code>@RequestMapping(method = RequestMethod.POST)</code>;

`@PutMapping` - used to map HTTP PUT requests onto specific handler method. It is a composed annotation that acts as a shortcut for <code>@RequestMapping(method = RequestMethod.PUT)</code>;

`@DeleteMapping` - used to map HTTP DELETE requests onto specific handler method. It is a composed annotation that acts as a shortcut for <code>@RequestMapping(method = RequestMethod.DELETE)</code>;

`@PatchMapping` - used to map HTTP PATCH requests onto specific handler method. It is a composed annotation that acts as a shortcut for <code>@RequestMapping(method = RequestMethod.PATCH)</code>;

`@RequestMapping` - used to map web requests onto methods in request-handling classes with flexible method signatures. `@GetMapping`, `@PostMapping`, `@PutMapping`, `@DeleteMapping`, and `@PatchMapping` are different variants of `@RequestMapping` for handling the specific HTTP operation by these annotations. By default `@RequestMapping` maps all HTTP operations.

`@PathVariable` - used to bind a named URI path parameter into a method argument.

`@RequestParam` - used to bind a URI query parameter to a method argument.

`@RequestHeader` - used to bind a request header to a method parameter

`@RequestPart` - used to associate a part of a multipart request with a method argument.

`@CookieValue` - used to indicate that a method parameter is bound to an HTTP cookie.

`@RequestBody` - used to bind the body of the request to a method argument (object).

`@ResponseBody` - used to indicate that the result of a request handler method is the response itself.
If a class is annotated with `@ResponseBody`, all of its request handler methods will be functioning like that.

`@ResponseStatus` - used to specify the HTTP response status of a request handler method.

`@Controller` - used to mark a class as a source of request method handlers.

`@RestController` - combines the `@Controller` and `@ResponseBody` annotations, making all class request handler methods assumes `@ResponseBody` by default.
RestTemplate - 
</br></br>


# 7. SPRING SECURITY <a id="7-spring-security-" href="#7"></a>
## OVERVIEW
<p>Spring Security by default actives both HTTP security filters and the security filter chain and configures/enforces basic authentication for all URLs, which is session-based.</p> 
<p>The Spring Security framework provides two options to set up authorization schema configuration: URL-based and Annotation-based.

* **Security Filters Chain** - 

* **AuthenticationManager** - works like a coordinator where authentication providers are registered.

* **AuthenticationProvider** - processes specific types of authentication.

* **UserDetailsService** - core interface that loads user-specific data in the Spring Security flow.

* **antMatcher()** - method used to configure URL access restrictions by using [ant patterns](https://ant.apache.org/manual/dirtasks.html#patterns) so that they are only invoked only if the given pattern matches.

* **mvcMatcher()** - works like antMatcher but is more secure and more general, and can also handle some possible configuration mistakes.

## CORE CONCEPTS
* **Authentication** - refers to the process of verifying the identity of a user, based on provided credentials. A common example is entering a username and a password when you log in to a website. You can think of it as an answer to the question: _Who are you?_.

* **Authorization** - refers to the process of determining if a user has proper permission to perform a particular action or access particular data, assuming that the user is successfully authenticated. You can think of it as an answer to the question: _Can a user do/access this?_.

* **Principle** - refers to the currently authenticated user.

* **Granted Authority** - refers to the permission of the authenticated user.

* **Role** - refers to a group of permissions which the authenticated user have.

## REFERENCES
- https://www.toptal.com/spring/spring-security-tutorial
- https://spring.io/guides/topicals/spring-security-architecture
- https://www.marcobehler.com/guides/spring-security
- https://www.baeldung.com/spring-security-expressions
- https://www.section.io/engineering-education/springboot-antmatchers
- https://medium.com/rapaduratech/criando-um-token-jwt-para-autentica%C3%A7%C3%A3o-em-spring-boot-371ccb54a093
- https://levelup.gitconnected.com/learn-how-to-build-a-token-based-authentication-server-using-spring-boot-and-spring-security-14a82d186f88
- https://medium.com/wolox/securing-applications-with-jwt-spring-boot-da24d3d98f83
- https://medium.com/geekculture/spring-security-authentication-process-authentication-flow-behind-the-scenes-d56da63f04fa

## KEY ANNOTATIONS
[@EnableWebSecurity](https://docs.spring.io/spring-security/site/docs/current/api/org/springframework/security/config/annotation/web/configuration/EnableWebSecurity.html) - marks a @Configuration class  as a source of web access security configuration. Usually such class extends the [WebSecurityConfigurerAdapter](https://docs.spring.io/spring-security/site/docs/current/api/org/springframework/security/config/annotation/web/configuration/WebSecurityConfigurerAdapter.html) base class and overrides its methods for a more granular configuration;

[@EnableMethodSecurity]() - 

[@EnableGlobalMethodSecurity]()


[@PreAuthorized]() -

[@PostAuthorize]() - supports Spring Expression Language and is used to provide expression-based access control after executing the method (provides the ability to access the method result).

[@PreFilter] - supports Spring Expression Language and is used to filter the collection or arrays before executing the method based on custom security rules we define.

[@PostFilter] - supports Spring Expression Language and is used to filter the returned collection or arrays after executing the method based on custom security rules we define (provides the ability to access the method result).

[@Secured] - doesn’t support Spring Expression Language and is used to specify a list of roles on a method.

[@RolesAllowed] - is the JSR 250’s equivalent annotation of the @Secured annotation.
</br></br>


# 8. SPRING BOOT ACTUATOR <a id="8-spring-boot-actuator-" href="#8"></a>
## REFERENCES
- https://www.baeldung.com/spring-boot-actuators
- https://docs.spring.io/spring-boot/docs/current/reference/html/actuator.html#actuator
- https://spring.io/guides/gs/actuator-service/
</br></br>


# 9. SPRING BOOT TESTING <a id="9-spring-boot-testing-" href="#9"></a>
## REFERENCES
- https://spring.io/guides/gs/testing-web/
- https://howtodoinjava.com/spring-boot2/testing/springboot-test-configuration/
- https://howtodoinjava.com/spring-boot2/testing/junit5-with-spring-boot2/
- https://reflectoring.io/spring-boot-test/
- https://rieckpil.de/spring-boot-unit-and-integration-testing-overview/
- https://rieckpil.de/difference-between-mock-and-mockbean-spring-boot-applications/
- https://newbedev.com/unit-test-or-integration-test-in-spring-boot

## KEY ANNOTATIONS
`@SpringBootTest` - used to bootstrap a complete application context for testing. `@SpringBootTest` by default starts searching in the current package of the annotated test class and then searches upwards through the package structure, looking for a class annotated with `@SpringBootConfiguration` from which it reads the configuration to create an application context. This class is usually the main application class since the `@SpringBootApplication` annotation includes the `@SpringBootConfiguration` annotation. It then creates an application context very similar to the one that would be started in a production environment.

`@WebMvcTest` - used to set up an application context with just enough components and configurations required to test the **Web MVC Controller Layer**. It disables full auto-configuration and instead apply only configuration relevant to MVC tests.

`@DataJpaTest` - used to set up an application context specificaly to test the **Persistence Layer**, by configuring entities, repositories as well as an embedded database.

`@TestConfiguration` - used to define additional beans or override existing beans in the Spring application context in order to add specialized configuration for testing. Configuration classes annotated with `@TestConfiguration` are excluded from component scanning. Configuration classes with bean definition annotated with `@TestConfiguration` can be imported by `@Import` or declared as static inner classes. It is required to set the property `spring.main.allow-bean-definition-overriding` to `true` in order to enable bean overriding feature during testing.

`@MockBean` - annotation part of Spring Test Framework used to create mocks for beans whenever running tests with the _Spring Test context_ (i.e. testing with `@SpringBootTest`, `@WebMvcTest` and so on).

`@Mock` - annotation part of [Mockito Framework](https://site.mockito.org) used to create a mock instance of the marked field, just like if we would be calling <code>Mockito.mock()</code> manually.

`@InjectMock` - annotation part of [Mockito Framework](https://site.mockito.org) used to create a mock instance of the marked field and injects all dependencies annotated with `@Mock` into it.