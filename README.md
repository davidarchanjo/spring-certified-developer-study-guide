![banner](./assets/banner.jpg)
</br></br>

# TABLE OF CONTENTS
1. <a href="#1-introduction-" id="1">INTRODUCTION</a>
2. <a href="#2-exam-overview-" id="2">EXAM OVERVIEW</a>
3. <a href="#3-rest-concepts-" id="3">REST CONCEPTS</a>
4. <a href="#4-spring-core-concepts-" id="4">SPRING CORE CONCEPTS</a>
5. <a href="#5-spring-boot-basics-and-auto-configuration-" id="5">SPRING BOOT BASICS AND AUTO-CONFIGURATION</a>
6. <a href="#6-aspect-oriented-programming-" id="6">ASPECT-ORIENTED PROGRAMMING</a>
7. <a href="#7-data-management-jdbc-transactions-" id="7">DATA MANAGEMENT: JDBC, TRANSACTIONS</a>
8. <a href="#8-spring-data-jpa-" id="8">SPRING DATA JPA</a>
9. <a href="#9-spring-mvc-" id="9">SPRING MVC</a>
10. <a href="#10-spring-security-" id="10">SPRING SECURITY</a>
11. <a href="#11-spring-boot-actuator-" id="11">SPRING BOOT ACTUATOR</a>
12. <a href="#12-spring-boot-testing-" id="12">SPRING BOOT TESTING</a>
</br></br>


# 1. INTRODUCTION <a id="1-introduction-" href="#1"></a>
This guide walks through some technical notes and references about the Spring Framework, with focus on the Spring Boot Framework, serving as a _supporting material_ for whoever is preparing to take the [Spring Certified Professional](https://www.vmware.com/education-services/certification/vcp-spring-exam.html) exam. I came up with this guide in order to consolidate my knowledge throughout my studies, hence all the content presented here are by no means definitive and exhaustive so that someone only based on what I present here can take the exam fully prepared. Ultimately this guide contains many sources for relevant technical documentations, tutorials and notes, and also offers a structured and concise study planning to help on your preparation.

I hope you find something useful. Good luck 🤞🍀!
</br></br>


# 2. EXAM OVERVIEW <a id="2-exam-overview-" href="#2"></a>
The **Spring Certified Professional** certification offered by VMWare is an exam scaled on a range from 100-500, with the determined raw cut score scaled to a value of 300. The exam may contain unscored questions in addition to the scored questions, this is a standard testing practice used by VMWare. We can't know which questions are unscored and the final result will reflect the scored questions only. This certification exam is designed to test and validate the overall understanding and familiarity with core aspects of Spring and Spring Boot frameworks as follows:
 - Container, Dependency, and IoC
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

## EXAM INFO
**Duration:** 90 Minutes </br>
**Number of Questions:** 50 Questions </br>
**Passing Score:** 300 </br>
**Format:** Multiple Choice, Multiple Choice Multiple Selection, Drag and Drop, Matching
</br></br>


# 3. REST CONCEPTS <a id="3-rest-concepts-" href="#3"></a>
## REFERENCES
- https://restfulapi.net
- https://restapitutorial.com

## OVERVIEW
**REST** stands for **RE**presentational **S**tate **T**ransfer and it is a software architectural style introduced by [Roy Fielding](https://en.wikipedia.org/wiki/Roy_Fielding) on 2000 as a design guide to the WEB on its early days.

Any web API that conforms to [The REST Principles](https://en.wikipedia.org/wiki/Representational_state_transfer) is classified as **RESTful**.

The data and its functionalities provided by a RESTful API are referred _resources_ and are accessed through **Uniform Resource Identifiers**.

## HTTP METHODS
REST API resources are manipulated by HTTP methods and the most-commonly-used HTTP methods are POST, GET, PUT and DELETE. These methods correspond, respectively, to **C**reate, **R**ead, **U**pdate, and **D**elete operations and those actions are commonlly referred by the **CRUD** acronym.

The following summarises the use of those HTTP methods:
| Method | Action |
| :----- | :----- |
| POST   | Create a resource |
| GET    | Retrieve information about a specific resource or a collection |
| PUT    | Update a resource |
| DELETE | Delete a resource or related component |

## HTTP STATUS
In REST APIs, HTTP status codes are used to inform the consumer about the request's result. The status codes are divided into five categories:</br>
| Category   | Description |
| :--------- | :---------- |
| 1xx Status | Indicates that the server received the request and is continuing the process |
| 2xx Status | Indicates that the client’s request was accepted successfully |
| 3xx Status | Indicates that the client must take some additional action in order to complete the request |
| 4xx Status | Indicates that the client's request contains erros or bad syntax |
| 5xx Status | Indicates that the client's request was unable to be performed due to a server-side error |

## API CONVENTIONS
The key principles of REST involves separating the API into _logical resources_ and manipulate them through HTTP requests where every HTTP method (GET, POST, PUT, DELETE etc) performs a specific operation.

The functionalities provided by an API are related to _resources_ and by convention the resources are represented on URIs as **nouns in the plural**. All operation made available via URI should be mapped to a HTTP method that corresponds to the action is intended to be carried out. 

Follows some common examples of mapping correspondence between the HTTP method, operation type and URI format:</br>
| Method | URL        | Operation |
| :----- | :--------- | :-------- |
| GET    | `/todos`   | Retrieves a list of all todos
| GET    | `/todos/{id}` | Retrieves todo referenced by `id`
| POST   | `/todos`   | Creates a new todo
| PUT    | `/todos/{id}` | Fully updates todo referenced by `id`
| PATCH  | `/todos/{id}` | Partially updates todo referenced by `id`
| DELETE | `/todos/{id}` | Deletes todo referenced by `id`

</br>

# 4. SPRING CORE CONCEPTS <a id="4-spring-core-concepts-" href="#4"></a>
## SAMPLE PROJECTS
- [spring-bean](./spring-bean/)
- [spring-bean-factory-post-processor](./spring-bean-factory-post-processor/)
- [spring-bean-lifecycle-callback-order](./spring-bean-lifecycle-callback-order/)
- [spring-bean-post-processor](./spring-bean-post-processor/)
- [spring-spel](./spring-spel/)
- [spring-startup](./spring-startup/)

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
- https://asyncstream.com/tutorials/spring-initmethod-or-initializingbean/
- https://programmer.help/blogs/after-properties-set-and-init-method-postconstruct-of-spring-initializing-bean.html
- https://www.dineshonjava.com/writing-beanpostprocessor-in-spring/
- https://www.dev2qa.com/spring-expression-language-example-vs/

## OVERVIEW
**Bean** is an object that is instantiated and managed from creation to destruction by the **Spring IoC Container**.

**Spring IoC Container** is responsible for instantiating beans, wiring dependencies and managing the bean lifecycle from its instantiation till destruction. Spring have two IoC container implementations: [BeanFactory](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/beans/factory/BeanFactory.html) and [ApplicationContext](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/context/ApplicationContext.html).

**Inversion of Control (IoC)** is a process in which an object defines its dependencies without creating them explicitly. The object delegates the construction/instantiation job of its dependencies to the IoC container.

**Dependency Injection** is a pattern used to implement IoC, where the control being inverted is the setting and injection of object's dependencies.

## SPRING EXPRESSION LANGUAGE
The Spring Expression Language (SpEL for short) is used to query property values from properties file or to manipulate java objects and its attributes at runtime. @Value annotation is the most used way to process SpEL.

A SpEL expression begins with `#` and is enclosed by braces, e.g. `#{2 + 2}`. Properties can be referenced in a similar fashion with `$`, and are enclosed by braces too, e.g. `${foo.bar}`. Property placeholders cannot contain SpEL expressions, but expressions can, e.g. `#{'${foo.bar}' + 2}`. **Notice that to access the property contained in the properties file from SpEL, is mandatory to reference the property enclosed by single quotes**.

SpEL provides two special built-in variables: `systemProperties` and `systemEnvironment`:
- **systemProperties** – a java.util.Properties object that provides runtime environment properties, like `os.name`, or JVM argument;
- **systemEnvironment** – a java.util.Properties object retrieving environment specific properties from the runtime environment, like env variables;

## KEY INTERFACES
### STARTUP
Spring Boot provides two interfaces to run specific pieces of code as soon as the application starts: [CommandLineRunner](https://docs.spring.io/spring-boot/docs/current/api/org/springframework/boot/CommandLineRunner.html) and [ApplicationRunner](https://docs.spring.io/spring-boot/docs/current/api/org/springframework/boot/ApplicationRunner.html).

By default, when defining multiple beans of both types ***in the same configuration class*** (@SpringBootApplication or @Configuration), beans of type ApplicationRunner will execute before beans of type CommandLineRunner. That rule also applies when they are defined individually as components (@Component). However when defined as components, that default execution order can be changed through the use of [@Order](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/core/annotation/Order.html) annotation.

### BEAN STATE ANNOTATION
[BeanFactoryPostProcessor](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/beans/factory/config/BeanFactoryPostProcessor.html) - used to modify the definition of any bean before it get created/instantiated by working on its configuration metadata phase, such as loading value for it from external property files.

[BeanPostProcessor](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/beans/factory/config/BeanPostProcessor.html) - Factory hook interface that allows for custom modification of new bean instances _before_ and _after_ properties are set from initialization callbacks.

[InitializingBean](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/beans/factory/InitializingBean.html) - interface to be implemented by beans that need to react once all their properties have been set by overriding the [afterPropertiesSet](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/beans/factory/InitializingBean.html#afterPropertiesSet--) method.

[DisposableBean](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/beans/factory/DisposableBean.html) - interface to be implemented by beans that want to release resources upon their destruction by overriding the [destroy](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/beans/factory/DisposableBean.html#destroy--) method.

[@PostConstruct](https://docs.oracle.com/javaee/7/api/javax/annotation/PostConstruct.html) - used on beans to mark a method to be executed, like a callback, after the dependency injection is done.

[@PreDestroy](https://docs.oracle.com/javaee/7/api/javax/annotation/PreDestroy.html) - used on beans to mark a method as a callback to signal the instance is in the process of being removed from the container;

#### CALLBACK ORDER EXECUTION
If all lifecycle callbacks, annotations and BeanPostProcessor are used in conjuction, the sequence goes like this: <br>
➡️ Bean's constructor<br>
➡️ BeanPostProcessor's postProcessBeforeInitialization<br>
➡️ @PostConstruct<br>
➡️ InitializingBean's afterPropertiesSet<br>
➡️ Bean's initMethod<br>
➡️ BeanPostProcessor's postProcessAfterInitialization<br>
➡️ @PreDestroy<br>
➡️ DisposableBean's destroy<br>
➡️ Bean's destroyMethod

## KEY ANNOTATIONS
[@Bean](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/context/annotation/Bean.html) - used on factory methods to indicate that the produced object will be managed by the Spring container;

[@Scope](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/context/annotation/Scope.html) - used to indicate the scope for instances of the annotated bean;

[@Autowired](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/beans/factory/annotation/Autowired.html) - used at constructors, methods and fields to indicate that the injection (i.e. instantiation) will be managed by the Spring container dinamically;
> 📌 @Autowired can not be used to inject primitive and string values. It only works with reference objects.

> 📌 @Autowired, when processing field injection, first looks for a bean which *name* is equal to the field name. If none is found, then it looks for a bean which *type* is the same as the field to be injected

> 📌 When the injection of a field/parameter marked to be autowired is going to be via its type and there are many available bean instances for the given type, an [NoUniqueBeanDefinitionException](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/beans/factory/NoUniqueBeanDefinitionException.html) will be thrown. To solve this, we can either add @Primary to one of the bean definition or add @Qualifier to the field/parameter specifying the name from one of the matching beans

[@Qualifier](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/beans/factory/annotation/Qualifier.html) - used to specify the id of the bean that have to be used for injection when more than one type is eligible, i.e. when there are multiple beans resulting in ambiguity;

[@Primary](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/context/annotation/Primary.html) - used to indicate that a bean must be given preference when multiple candidates are qualified to autowire a single-valued dependency, i.e. is used to set higher preference for a given bean when there are multiple ones of the same type;

[@Lazy](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/context/annotation/Lazy.html) - used to indicate whether a bean is to be lazily initialized, i.e. if present on a @Component or @Bean definition and set to <code>true</code>, the bean or component will not be initialized until referenced by another bean or explicitly retrieved from the enclosing [BeanFactory](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/beans/factory/BeanFactory.html). This annotation may also be placed on injection points marked with @Autowired, like constructor parameters, method parameters etc;

[@Profile](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/context/annotation/Profile.html) - used to indicate that a component class or bean is eligiable for registration when the specified profile(s) are active;

[@Component](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/stereotype/Component.html) - generic stereotype annotation used to indicate that a class is a managed component, registering as a bean;

[@Repository](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/stereotype/Repository.html) - is a @Component stereotype annotation used to indicate that a class defines a data repository. Enables automatic translation of exceptions thrown from the underlying persistence layer;

[@Service](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/stereotype/Service.html) - is a @Component stereotype annotation used to indicate that a class defines business logic;

[@Configuration](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/context/annotation/Configuration.html) - used to mark a class as a source of bean definitions. **NOTE**: Spring creates dynamic proxies for classes annotated with @Configuration and uses CGLIB to extend those class to create proxies. Hence, @Configuration classes must not be final, because final classes cannot be extended, i.e. cannot be subclassed;

[@Import](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/context/annotation/Import.html) - used to indicate one or more component class to import — typically from @Configuration classes.

[@ImportAutoConfiguration](https://docs.spring.io/spring-boot/docs/current/api/org/springframework/boot/autoconfigure/ImportAutoConfiguration.html) - used to disable the default autoconfiguration flow performed by @EnableAutoConfiguration, importing only the configuration classes provided in the annotation.

[@Value](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/beans/factory/annotation/Value.html) - used at field or method/constructor parameter level to inject value from properties located at .properties/.yml files, SpEL, classpath's resources etc;

[@PropertySource](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/context/annotation/PropertySource.html) - used to load values from property files — the values can be accessed from [Environment](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/core/env/Environment.html) or injected by the @Value annotation;

[@ConfigurationProperties](https://docs.spring.io/spring-boot/docs/current/api/org/springframework/boot/context/properties/ConfigurationProperties.html) - used to map resource files such as properties or YAML files to Java Bean object.

[@EnableConfigurationProperties](https://docs.spring.io/spring-boot/docs/current/api/org/springframework/boot/context/properties/EnableConfigurationProperties.html) - enables support for @ConfigurationProperties annotated classes in our application.
</br></br>


# 5. SPRING BOOT BASICS AND AUTO-CONFIGURATION <a id="5-spring-boot-basics-and-auto-configuration-" href="#5"></a>
## SAMPLE PROJECTS
- [spring-conditional](./spring-conditional/)

## REFERENCES
- https://www.baeldung.com/spring-boot-annotations
- https://www.baeldung.com/spring-conditional-annotations
- https://docs.spring.io/spring-boot/docs/2.0.x/reference/html/using-boot-auto-configuration.html
- https://www.marcobehler.com/guides/spring-boot
- https://www.baeldung.com/spring-component-scanning
- https://reflectoring.io/spring-boot-conditionals
- https://zetcode.com/springboot/conditionalbeans
- https://www.baeldung.com/spring-boot-custom-starter

## AUTO-CONFIGURATION
Auto-configuration is a mechanism in which Spring automatically configures an application based on the dependencies found on its classpath.

When every Spring application boots up, Spring tries to read in properties from 17 locations in addition to the `spring.factories` file in the classpath.

`spring.factories` file is a special file that Spring automatically loads when booting up. It contains reference to a lot of @Configuration class mappings which Spring will try to run. The `spring.factories` file is located in `META-INF` of the [org.springframework.boot:spring-boot-autoconfigure](https://github.com/spring-projects/spring-boot/tree/main/spring-boot-project/spring-boot-autoconfigure/src/main/java/org/springframework/boot/autoconfigure) dependency.

@Conditional-based annotations are one of the key pieces that makes Spring auto-configuartion mechanism work. We can apply @Conditional-based annotations to common Spring components, like @Bean, @Component, @Service, @Repository and @Controller.

[@Conditional](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/context/annotation/Conditional.html) - used to indicate that a given component is only eligible for registration when all specified condition match;

[@ConditionalOnBean](https://docs.spring.io/spring-boot/docs/current/api/org/springframework/boot/autoconfigure/condition/ConditionalOnBean.html) - used to condition the registration of the annotated component when beans of all classes specified are contained in the BeanFactory;

[@ConditionalOnMissingBean](https://docs.spring.io/spring-boot/docs/current/api/org/springframework/boot/autoconfigure/condition/ConditionalOnMissingBean.html) - used to condition the registration of the annotated component when none of the bean class specified is contained in the BeanFactory;

[@ConditionalOnClass](https://docs.spring.io/spring-boot/docs/current/api/org/springframework/boot/autoconfigure/condition/ConditionalOnClass.html) used to condition the registration of the annotated component only if the specified classes are on the classpath;

[@ConditionalOnMissingClass](https://docs.spring.io/spring-boot/docs/current/api/org/springframework/boot/autoconfigure/condition/ConditionalOnMissingClass.html) - used to condition the registration of the annotated component only if none of the specified classes are on the classpath;

[@ConditionalOnExpression](https://docs.spring.io/spring-boot/docs/current/api/org/springframework/boot/autoconfigure/condition/ConditionalOnExpression.html) - used to condition the registration of the annotated component only if the specified SpEL expression returns true;

[@ConditionalOnProperty](https://docs.spring.io/spring-boot/docs/current/api/org/springframework/boot/autoconfigure/condition/ConditionalOnProperty.html) - used to condition the registration of the annotated component only if the specified property is set;

[@ConditionalOnResource](https://docs.spring.io/spring-boot/docs/current/api/org/springframework/boot/autoconfigure/condition/ConditionalOnResource.html) - used to condition the registration of the annotated component only if the specified resources exist;

[@ConditionalOnJava](https://docs.spring.io/spring-boot/docs/current/api/org/springframework/boot/autoconfigure/condition/ConditionalOnJava.html) - used to condition the registration of the annotated component only if the application is running on the specified JVM version. By default returns true if the running JVM version is equal to or greater than the specified version;

[@ConditionalOnJndi](https://docs.spring.io/spring-boot/docs/current/api/org/springframework/boot/autoconfigure/condition/ConditionalOnJndi.html) - used to condition the registration of the annotated component only if the specified JNDI context exists;

[@ConditionalOnWebApplication](https://docs.spring.io/spring-boot/docs/current/api/org/springframework/boot/autoconfigure/condition/ConditionalOnWebApplication.html) - used to condition the registration of the annotated component only if the application is a web application (SERVLET or REACTIVE);

[@ConditionalOnNotWebApplication](https://docs.spring.io/spring-boot/docs/current/api/org/springframework/boot/autoconfigure/condition/ConditionalOnNotWebApplication.html) - used to condition the registration of the annotated component only if the application is not a web application;

[@ConditionalOnWarDeployment](https://docs.spring.io/spring-boot/docs/current/api/org/springframework/boot/autoconfigure/condition/ConditionalOnWarDeployment.html) - used to condition the registration of the annotated component only if the application is a traditional WAR deployment. For applications with embedded servers, this condition will always return `false`.

[@ConditionalOnSingleCandidate](https://docs.spring.io/spring-boot/docs/current/api/org/springframework/boot/autoconfigure/condition/ConditionalOnSingleCandidate.html) - used to condition the registration of the annotated component only if a bean of the specified class is already contained in the BeanFactory and only a single candidate can be determined;

[@ConditionalOnCloudPlatform](https://docs.spring.io/spring-boot/docs/current/api/org/springframework/boot/autoconfigure/condition/ConditionalOnCloudPlatform.html) - used to condition the registration of the annotated component only if the specified cloud platform is active;

### CUSTOM CONDITION
We can define a custom logic to be used as criteria for registering a component. To do so we should create a class that implements the [Condition](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/context/annotation/Condition.html) interface, overriding its [matches](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/context/annotation/Condition.html#matches-org.springframework.context.annotation.ConditionContext-org.springframework.core.type.AnnotatedTypeMetadata-) method with our custom logic, and then specify our class as parameter for the @Conditional annotation.

### COMBINE CONDITIONS
We can combine @Conditional-based annotations along with custom conditions in order to implement complex OR or AND logical operation.

To apply OR operation, we have to create a custom condition extending the [AnyNestedCondition](https://docs.spring.io/spring-boot/docs/current/api/org/springframework/boot/autoconfigure/condition/AnyNestedCondition.html) class, then uses it as argument in the @Conditional annotation. For that purpose I created the [HmlOrPrdEnvironmentCondition](/spring-conditional/src/main/java/io/davidarchanjo/HmlOrPrdEnvironmentCondition.java) custom condition and applied it [here](/spring-conditional/src/main/java/io/davidarchanjo/Config.java#L44).

To apply AND operation, we can group custom conditions in the @Conditional and additionally set others @Conditional-based annotations to the component. I demonstrate this operation [here](/spring-conditional/src/main/java/io/davidarchanjo/Config.java#L51).

## External Application Properties
By default, Spring Boot will find and load `application.[properties|yml]` files from the following locations when your application boots up. **Be aware of this list is ordered by precedence with values from lower items overriding earlier ones**:

> 📌 Spring applications have in its classpath the `src/main/resource` folder location by default.

> 📌 If we have both application.properties and application.yml files in the same location and a given property is defined in both, the value from the application.properties will take precedence over the value at application.yml.

> 📌 Command line properties, JVM arguments and OS environment variables will always take precedence over (same) properties defined from application.properties or application.yml.

1. From command-line and OS environment:
   - OS environment variable, e.g. `export server.port=9090`;
   - JVM argument, e.g. `-Dserver.port=9090`;
   - command-line argument, e.g. `--server-port=9090`;

2. From the classpath:
   - The classpath root, e.g. from `/resources` folder by default;
   - The classpath `/config` package, i.e. from `/resources/config` folder;

3. From the current directory:
   - The current directory;
   - The `/config` subdirectory in the current directory;
   - Immediate child directories of the `/config` subdirectory, according to system default folder ordering;

With that in mind, if a property is defined in `/resources/application.properties` and there is a definition for the same property in `/resources/config/application.properties` with a different value, the value from the latter location will take precedence over the former.

</br>

## KEY ANNOTATIONS
[@SpringBootApplication](https://docs.spring.io/spring-boot/docs/current/api/org/springframework/boot/autoconfigure/SpringBootApplication.html) - is a combination of @Configuration, @EnableAutoConfiguration, and @ComponentScan annotations with their default attributes;

[@EnableAutoConfiguration](https://docs.spring.io/spring-boot/docs/current/api/org/springframework/boot/autoconfigure/EnableAutoConfiguration.html) – used to indicates to ApplicationContext to add beans based on the dependencies on the classpath automatically;

[@ComponentScan](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/context/annotation/ComponentScan.html) – used to indicate to ApplicationContext to scan for other components, configurations and beans in the same package as the Application class and below;

[@SpringBootConfiguration](https://docs.spring.io/spring-boot/docs/current/api/org/springframework/boot/SpringBootConfiguration.html) - used to indicate that a class provides Spring Boot application @Configuration. Can be used as an alternative to @Configuration annotation so that configuration can be found automatically;

</br></br>

# 6. ASPECT-ORIENTED PROGRAMMING <a id="6-aspect-oriented-programming-" href="#6"></a>
## SAMPLE PROJECTS
- [spring-aop](./spring-aop/)

## REFERENCES
- https://www.javatpoint.com/spring-aop-tutorial
- https://docs.spring.io/spring-framework/docs/3.0.x/reference/aop.html
- https://docs.spring.io/spring-framework/docs/current/reference/html/core.html#aop
- https://www.journaldev.com/2583/spring-aop-example-tutorial-aspect-advice-pointcut-joinpoint-annotations
- https://howtodoinjava.com/spring-aop-tutorial/
- https://www.baeldung.com/spring-aop-pointcut-tutorial
- https://www.tutorialandexample.com/spring-aop-pointcut-expressions/
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

## KEY INTERFACE
[JoinPoint](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/aopalliance/intercept/Joinpoint.html) - provides reflective access to both the state available at a join point and static information about it.

[ProceedingJoinPoint](https://www.javadoc.io/doc/org.aspectj/aspectjrt/latest/org/aspectj/lang/ProceedingJoinPoint.html) - extends from JointPoint and exposes the `proceed(..)` method in order to support @Around advice.

## KEY ANNOTATIONS
[@EnableAspectJAutoProxy](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/context/annotation/EnableAspectJAutoProxy.html) - used on @Configuration classes to enable support for handling component classes annotated with @Aspect;

[@Aspect](https://www.eclipse.org/aspectj/doc/next/aspectj5rt-api/org/aspectj/lang/annotation/Aspect.html) - used to mark a @Component class as an aspect declaration;

[@Pointcut](https://www.eclipse.org/aspectj/doc/next/aspectj5rt-api/org/aspectj/lang/annotation/Pointcut.html) - used in methods to declare pointcut, which can be availed by advice annotations on refering to that pointcut;

[@Before](https://www.eclipse.org/aspectj/doc/next/aspectj5rt-api/org/aspectj/lang/annotation/Before.html) - used to mark a method to be executed before the matching joint point;

[@After](https://www.eclipse.org/aspectj/doc/next/aspectj5rt-api/org/aspectj/lang/annotation/After.html) - used to mark a method to be executed after the matching join point finishes, whether normally or by throwing an exception;

[@AfterReturning](https://www.eclipse.org/aspectj/doc/next/aspectj5rt-api/org/aspectj/lang/annotation/AfterReturning.html) - used to mark a method to be executed after only if the matching joint point completes normally;

[@AfterThrowing](https://www.eclipse.org/aspectj/doc/next/aspectj5rt-api/org/aspectj/lang/annotation/AfterThrowing.html) - used to mark a method to be executed after only if the matching join point exits by throwing an exception;

[@Around](https://www.eclipse.org/aspectj/doc/next/aspectj5rt-api/org/aspectj/lang/annotation/Around.html) - used to mark a method to be executed before and after a Joint Point.
</br></br>


# 7. DATA MANAGEMENT: JDBC, TRANSACTIONS <a id="7-data-management-jdbc-transactions-" href="#7"></a>
## SAMPLE PROJECTS
- [spring-datasource](./spring-datasource/)
- [spring-jdbctemplate](./spring-jdbctemplate/)
- [spring-transaction](./spring-transaction/)

## REFERENCES
- https://www.javainuse.com/spring/boot-transaction
- https://www.baeldung.com/spring-transactional-propagation-isolation
- https://www.marcobehler.com/guides/spring-transaction-management-transactional-in-depth
- https://www.byteslounge.com/tutorials/spring-transaction-propagation-tutorial
- https://www.byteslounge.com/tutorials/spring-transaction-isolation-tutorial

## TRANSACTIONS
<p>
  <b>Transaction</b> is a single logical unit of work which could be composed by one or many actions that potentially modify the content of a database, i.e. a sequence of actions that are considered as a single logical unit by the application. For an application, if any action running into a transactional context fails then all other actions gets rolled back. <i>By default, Spring will only roll back on <b>unchecked exceptions</b> (RuntimeException and its subclasses)</i>. To make a transaction roll back on checked exception we have to specify it on the @Transaction's <code>rollbakFor</code> parameter.
</p>

<p>
  <b>Transaction Propagation</b> is a mechanism used to indicate if a given action will or will not participate in a transactional context as well as how it will behave when called from a context which already has or not a transaction in place.
</p>

### READ-ONLY TRANSACTIONS
A read-only transaction is **a transaction which does not modify any data**. If we use the @Transactional's `readOnly` attribute set to `true` on a method which is performing create or update operation then we will not have any created or updated record into the database but rather an exception.

### NOTES
- If we have many @Transaction methods in the same class defined with different propagation types and if they are called sequentially, in practice only the propagation configuration of the first method in the flow will be considered. That is because Spring creates a proxy upon detecting the @Transactional annotation when we are calling any internal method, it will bypass the proxy.

- If we manually handle exceptions (including unchecked exceptions) via try-catch from a transactional context and an exception pops up, the rollback mechanism won't work and the current transaction will execute and commit normally.

- To make transaction suspension works across nested method calls, the methods must belong to different object instances. That rule applies when the @Transaction's propagation is set to `REQUIRES_NEW` or `NOT_SUPPORTED`.

- The @Transactional annotation at the class level will be applied to all of its public method. However, if a method is annotated with @Transactional its settings will take precedence over the transactional settings defined at the class level.

### TYPES OF TRANSACTION PROPAGATION

  | Propagation   | Behaviour |
  |:--------------| :-------- |
  | [REQUIRED](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/transaction/annotation/Propagation.html#REQUIRED)      | Always executes in a transaction and if there is an active transaction it is used otherwise a new one is created |
  | [REQUIRES_NEW](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/transaction/annotation/Propagation.html#REQUIRES_NEW)  | Always executes in a new transaction and if there is an active transaction it gets suspended before stars a new one |
  | [NESTED](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/transaction/annotation/Propagation.html#NESTED)        | Participates in existing transaction by creating _subtransaction_ which in turn sets _savepoints_ between nested method invocations so that these subtransactions can roll back independently of the outer transaction upon failure |
  | [SUPPORTS](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/transaction/annotation/Propagation.html#SUPPORTS)      | If a transaction exists then it makes use of it but if none exits the method will execute in a non-transactional context |
  | [NOT_SUPPORTED](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/transaction/annotation/Propagation.html#NOT_SUPPORTED) | Always executes without a transaction and if there is an active transaction it gets suspended until the end of the method execution |
  | [NEVER](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/transaction/annotation/Propagation.html#NEVER)         | Always executes without a transaction but if there is an active transaction an [IllegalTransactionStateException](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/transaction/IllegalTransactionStateException.html) is thrown |
  | [MANDATORY](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/transaction/annotation/Propagation.html#MANDATORY)     | Always executes in a transaction and if there is an active transaction it is used. If does not exist an active transaction an [IllegalTransactionStateException](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/transaction/IllegalTransactionStateException.html) is thrown |

<p>
  <b>Transaction Isolation</b> is a mechanism used to indicate how changes made to data by one transaction affect other concurrent transactions as well as how and when changed data becomes available to other concurrent transactions, i.e. how changes applied on data by concurrent transactions are visible to each other.
</p>

- Types of Transaction Isolation:

  | Isolation        | Behaviour |
  | :--------------- | :-------- |
  | DEFAULT          | Indicates that for any transaction the default isolation level of the underlying RDBMS will be used |
  | READ_COMMITTED   | Indicates that a transaction can only read data that is committed by concurrent transactions |
  | READ_UNCOMMITTED | Indicates that a transaction may read data that is still uncommitted by concurrent transactions |
  | REPEATABLE_READ  | Indicates that if a transaction reads one record from the database multiple times the result of all reading must always be the same |
  | SERIALIZABLE     | Indicates that transactions must be executed with locking at all levels (read, range and write locking) so that they behave as if they were executed in a serialized way, i.e. concurrent execution of a group of transactions should have the same result as if they are executed sequentially |

## KEY INTERFACES
[ResultSet](https://docs.oracle.com/en/java/javase/11/docs/api/java.sql/java/sql/ResultSet.html) - is used to access data produced by the execution of database queries. It provides getter methods (getBoolean, getLong, and so on) for retrieving column values (by name or column's index) from the current row.

[RowMapper](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/jdbc/core/RowMapper.html) - is used by JdbcTemplate for mapping rows of a ResultSet to Java object _on a per-row basis_.

## KEY ANNOTATIONS
[@Transactional](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/transaction/annotation/Transactional.html) - used to indicate declaratively control over transaction boundaries on managed beans, usually for @Service classes which contain business logic;

[@EnableTransactionManagement](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/transaction/annotation/EnableTransactionManagement.html) - used on @Configuration classes to enable the Spring's annotation-driven declarative transaction management capabilities. This annotation is **optional** in Spring Boot application as long as one of spring-data-* modules is configured on the project;
</br></br>


# 8. SPRING DATA JPA <a id="8-spring-data-jpa-" href="#8"></a>
## SAMPLE PROJECTS
- [spring-data-jpa](./spring-data-jpa/)

## REFERENCES
- https://spring.io/guides/gs/accessing-data-jpa/
- https://knpcode.com/spring/spring-data-tutorial/
- https://www.baeldung.com/the-persistence-layer-with-spring-data-jpa
- https://www.baeldung.com/spring-data-jpa-query

## OVERVIEW
Spring Boot configures Hibernate as the default JPA provider, and auto-configures a DataSource bean if there's in-memory database dependency of type H2, HSQLDB or Derby present on the classpath. Spring Boot applications may be configured with mutiple databases of different types.

Spring Boot allows to configure DataSource in two ways: programmatically via a @Configuration class or from properties configuration file.

## KEY INTERFACES
[CrudRepository](http://static.springsource.org/spring-data/data-commons/docs/current/api/org/springframework/data/repository/CrudRepository.html) - provides CRUD operations on a repository

[PagingAndSortingRepository](http://static.springsource.org/spring-data/data-commons/docs/current/api/org/springframework/data/repository/PagingAndSortingRepository.html) - extends from CrudRepository and provides methods for pagination and sorting records

[JpaRepository](http://static.springsource.org/spring-data/data-jpa/docs/current/api/org/springframework/data/jpa/repository/JpaRepository.html) - extends from PagingAndSortingRepository and additionally provides JPA related methods such as flushing the persistence context and delete records in a batch


## TESTING
By default, transactions in JUnit tests are flagged for rollback when they start. However, if the method is annotated with @Commit or @Rollback(false), they start flagged for commit instead.

By default @DataJpaTest autoconfigures an in-memory database like H2 to be used on testing, as long as one of that type is found in the classpath. To avoid stars an embedded database and use a real one like Postgres we must annotate the test class with `@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)`.

## KEY ANNOTATIONS
[@Entity](https://javaee.github.io/javaee-spec/javadocs/javax/persistence/Entity.html) - used to specify that the annotated class maps a database entity. If we forget to mark a domain class that will map a database entity with @Entity annotation, we will get an IllegalArgumentException since Spring will not be able to invocate the init method in a not managed type;

[@Table](https://javaee.github.io/javaee-spec/javadocs/javax/persistence/Table.html) - used to specify the table's details, like name, schema etc, that will map the entity in the database. It's not mandatory to use @Table on mapping an entity class, and in its absence, the table name will be taken from the class name;

[@Id](https://javaee.github.io/javaee-spec/javadocs/javax/persistence/Id.html) - used to mark a property in a entity class as the primary key. If no @Column annotation is specified, the primary key column name is assumed to be the name of the property;

[@GeneratedValue](https://javaee.github.io/javaee-spec/javadocs/javax/persistence/GeneratedValue.html) - used to specify the primary key generation strategy which by default is autoincrement;

[@Column](https://javaee.github.io/javaee-spec/javadocs/javax/persistence/Column.html) - used to specify database column details like name, constraint etc to which a property will be mapped. If no @Column annotation is specified, then the field name will be used for mapping;

[@Query](https://docs.spring.io/spring-data/jpa/docs/current/api/org/springframework/data/jpa/repository/Query.html) - used to declare custom queries on 
repository methods to execute both JPQL or native SQL queries;

[@Modifying](https://docs.spring.io/spring-data/jpa/docs/current/api/org/springframework/data/jpa/repository/Modifying.html) - used to indicate that a @Query annotated repository method executes a modifying JPQL or native SQL such as a INSERT, UPDATE, DELETE or DDL statement;

[@EntityScan](https://docs.spring.io/spring-boot/docs/current/api/org/springframework/boot/autoconfigure/domain/EntityScan.html) - used on @Configuration classes to indicate to Spring where is located entity classes when they are not placed under the main application package or its sub-packages;

[@EnableJpaRepositories](https://docs.spring.io/spring-data/jpa/docs/current/api/org/springframework/data/jpa/repository/config/EnableJpaRepositories.html) - used on @Configuration classes to indicate to Spring where is located JPA repository classes when they are not placed in the same package of the main application class or under its sub-packages;
</br></br>


# 9. SPRING MVC <a id="9-spring-mvc-" href="#9"></a>
## SAMPLE PROJECTS
- [spring-crud](./spring-crud/)
- [spring-mvc](./spring-mvc/)

## REFERENCES
- https://www.baeldung.com/spring-mvc-tutorial
- https://spring.io/guides/gs/serving-web-content
- https://docs.spring.io/spring-framework/docs/3.2.x/spring-framework-reference/html/mvc.html
- https://howtodoinjava.com/spring-boot2/resttemplate/spring-restful-client-resttemplate-example

## KEY INTERFACES
[Model](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/ui/Model.html) - used to supply attributes, i.e. the data of our application, utilized for rendering views;

[ModelMap](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/ui/ModelMap.html) - used to pass values to render a view, with the advantage to pass a collection of values like a Map.

[ModelAndView](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/web/servlet/ModelAndView.html) - used to pass all the information, i.e. model and view, required by Spring MVC for processing page rendering;

## KEY ANNOTATIONS
[@ModelAttribute](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/web/bind/annotation/ModelAttribute.html) - used to bind method parameter or method return value to a named model attribute, exposed in a web view. 

[@GetMapping](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/web/bind/annotation/GetMapping.html) - used to map HTTP GET requests onto specific handler method. It is a shortcut for <code>@RequestMapping(method = RequestMethod.GET)</code>;

[@PostMapping](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/web/bind/annotation/PostMapping.html) - used to map HTTP POST requests onto specific handler method. It is a shortcut for <code>@RequestMapping(method = RequestMethod.POST)</code>;

[@PutMapping](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/web/bind/annotation/PutMapping.html) - used to map HTTP PUT requests onto specific handler method. It is a shortcut for <code>@RequestMapping(method = RequestMethod.PUT)</code>;

[@DeleteMapping](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/web/bind/annotation/DeleteMapping.html) - used to map HTTP DELETE requests onto specific handler method. It is a shortcut for <code>@RequestMapping(method = RequestMethod.DELETE)</code>;

[@PatchMapping](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/web/bind/annotation/PatchMapping.html) - used to map HTTP PATCH requests onto specific handler method. It is a shortcut for <code>@RequestMapping(method = RequestMethod.PATCH)</code>;

[@RequestMapping](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/web/bind/annotation/RequestMapping.html) - used to map web requests onto methods in request-handling classes with flexible method signatures. @GetMapping, @PostMapping, @PutMapping, @DeleteMapping, and @PatchMapping are different variants of @RequestMapping for handling the specific HTTP operation by these annotations. By default @RequestMapping maps all HTTP operations;

[@PathVariable](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/web/bind/annotation/PathVariable.html) - used to bind a named URI path parameter into a method argument;

[@RequestParam](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/web/bind/annotation/RequestParam.html) - used to bind a URI query parameter to a method argument;

[@RequestHeader](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/web/bind/annotation/RequestHeader.html) - used to bind a request header to a method parameter;

[@RequestPart](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/web/bind/annotation/RequestPart.html) - used to associate a part of a multipart request with a method argument;

[@CookieValue](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/web/bind/annotation/CookieValue.html) - used to indicate that a method parameter is bound to an HTTP cookie;

[@RequestBody](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/web/bind/annotation/RequestBody.html) - used to bind the payload body from the request onto a method argument;

[@ResponseBody](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/web/bind/annotation/ResponseBody.html) - used to indicate that the result of a request handler method is the response itself.
If a class is annotated with @ResponseBody, all of its request handler methods will be functioning like that;

[@ResponseStatus](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/web/bind/annotation/ResponseStatus.html) - used to specify the HTTP response status of a request handler method;

[@Controller](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/stereotype/Controller.html) - is a @Component stereotype annotation used to mark a class as a source of request method handlers;

[@RestController](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/web/bind/annotation/RestController.html) - combines the @Controller and @ResponseBody annotations, making all request handler methods in the annotated class assumes @ResponseBody by default;
</br></br>


# 10. SPRING SECURITY <a id="10-spring-security-" href="#10"></a>
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

## OVERVIEW
<p>Spring Security by default actives both HTTP security filters and the Security Filter Chain and configures/enforces session-based basic authentication for all URLs.</p> 
<p>The Spring Security framework provides two options to set up authorization schema configuration: URL-based and Annotation-based.

* **AuthenticationManager** - works like a coordinator where authentication providers are registered.

* **AuthenticationProvider** - processes specific types of authentication.

* **UserDetailsService** - core interface that loads user-specific data in the Spring Security flow.

* **antMatcher()** - method used to configure URL access restrictions by using [ant patterns](https://ant.apache.org/manual/dirtasks.html#patterns) so that they are only invoked if the given pattern matches.

* **mvcMatcher()** - serves for the same purpose as antMatcher but is designed to apply precisely to what the Spring MVC @RequestMapping and related annotations understand, e.g. <code>"mvcMatcher(/hello)"</code> will also match <code>/hello</code> and <code>/hello/</code>, while with antMatcher() only the former will match.

## CORE CONCEPTS
* **Authentication** - refers to the process of verifying the identity of a user, based on provided credentials. A common example is entering a username and a password when you log in to a website. You can think of it as an answer to the question: _Who are you?_.

* **Authorization** - refers to the process of determining if a user has proper permission to perform a particular action or access particular data, assuming that the user is successfully authenticated. You can think of it as an answer to the question: _Can a user do/access this?_.

* **Principle** - refers to the currently authenticated user.

* **Granted Authority** - refers to the permission of the authenticated user.

* **Role** - refers to a group of permissions which the authenticated user have.

## NOTES
- Double wildcard pattern (`**`) will match **the current path segment (directory) and below**. For instance, the following rule will match `api/public`, `api/public/users`, `api/public/users/1` and so forth:
  ```java
  .mvcMatchers("/api/public/**")
  ```

- Single wildcard pattern (`*`) will match **path segments under the specified directory and below**. For instance, the following rule will match `api/public/users`, `api/public/users/1` and so forth:
  ```java
  .mvcMatchers("/api/public/*")
  ```

- URL pattern definitions with role access association should be defined from most to less specific. For instance, in the following definition the pattern `/api/public/get` should be put ideally before `/api/public/**`:
  ```java
  .mvcMatchers("/api/public/**").hasRole(Roles.USER_ADMIN)
  .mvcMatchers("/api/public/get").hasRole(Roles.AUTHOR_ADMIN)
  ```

## KEY ANNOTATIONS
[@EnableWebSecurity](https://docs.spring.io/spring-security/site/docs/current/api/org/springframework/security/config/annotation/web/configuration/EnableWebSecurity.html) - marks a @Configuration class as a source of web access security configuration. Usually such class extends the [WebSecurityConfigurerAdapter](https://docs.spring.io/spring-security/site/docs/current/api/org/springframework/security/config/annotation/web/configuration/WebSecurityConfigurerAdapter.html) class and overrides its methods for a more granular configuration;

[@EnableGlobalMethodSecurity](https://docs.spring.io/spring-security/site/docs/5.6.0-M1/api/org/springframework/security/config/annotation/method/configuration/EnableGlobalMethodSecurity.html) / [@EnableMethodSecurity](https://docs.spring.io/spring-security/site/docs/5.6.0-M1/api/org/springframework/security/config/annotation/method/configuration/EnableMethodSecurity.html) - both are used to configure security on method level through annotations. They have the following attributes:
<ol>
<li><code>securedEnabled</code></li>
  <span>If set to true enables @Secured annotation. Default is false</span>
<li><code>jsr250Enabled</code></li>
  <span>If set to true enables @RolesAllowed annotation. Default is false</span>
<li><code>prePostEnabled</code></li>
  <span>If set to true enables @PreAuthorize, @PostAuthorize, @PreFilter, @PostFilter annotations. Default is false</span>
</ol>

[@PreAuthorize](https://docs.spring.io/spring-security/site/docs/current/api/org/springframework/security/access/prepost/PreAuthorize.html) - supports SpEL and is used to provide expression-based access control before executing the method;

[@PostAuthorize](https://docs.spring.io/spring-security/site/docs/current/api/org/springframework/security/access/prepost/PostAuthorize.html) - supports SpEL and is used to provide expression-based access control after executing the method and provides the ability to access/alter the method's result;

[@PreFilter](https://docs.spring.io/spring-security/site/docs/current/api/org/springframework/security/access/prepost/PreFilter.html) - supports SpEL and is used to filter the collection or arrays before executing the method based on custom security rules we define;

[@PostFilter](https://docs.spring.io/spring-security/site/docs/current/api/org/springframework/security/access/prepost/PostFilter.html) - supports SpEL and is used to filter the returned collection or arrays after executing the method based on custom security rules we define (provides the ability to access the method result);

[@Secured](https://docs.spring.io/spring-security/site/docs/3.2.8.RELEASE/apidocs/org/springframework/security/access/annotation/Secured.html) - does not support SpEL and is used to specify a list of roles which the logged user must have in order to access the annotated method;

[@RolesAllowed](https://javaee.github.io/javaee-spec/javadocs/javax/annotation/security/RolesAllowed.html) - does not support SpEL and is the [JSR-250](https://jcp.org/en/jsr/detail?id=250)’s equivalent annotation of the @Secured annotation;

[@WithMockUser](https://docs.spring.io/spring-security/site/docs/current/api/org/springframework/security/test/context/support/WithMockUser.html) - can be added to a test method to emulate running with a mocked user;

[@WithUserDetails](https://docs.spring.io/spring-security/site/docs/current/api/org/springframework/security/test/context/support/WithUserDetails.html) - can be added to a test to emulate a UserDetails instance which is returned from the UserDetailsService according to the given username;

[@WithAnonymousUser](https://docs.spring.io/spring-security/site/docs/current/api/org/springframework/security/test/context/support/WithAnonymousUser.html) - can be added to a test method to emulate running with an anonymous user. This is useful when a user wants to run a majority of tests as a specific user and override a few methods to be anonymous;

[@WithSecurityContext](https://docs.spring.io/spring-security/site/docs/current/api/org/springframework/security/test/context/support/WithSecurityContext.html) - determines what SecurityContext to use, and all three annotations described above are based on it. If we have a specific use case, we can create our own annotation that uses @WithSecurityContext to create any SecurityContext we want;
</br></br>


# 11. SPRING BOOT ACTUATOR <a id="11-spring-boot-actuator-" href="#11"></a>

## REFERENCES
- https://www.baeldung.com/spring-actuators
- https://www.baeldung.com/spring-boot-health-indicators
- https://docs.spring.io/spring-boot/docs/current/reference/html/actuator.html#
- https://lightrun.com/best-practices/getting-started-with-spring-actuator
- https://www.javadevjournal.com/spring-boot/spring-actuator-custom-endpoint
- https://dimitr.im/mastering-spring-boot-actuator

## OVERVIEW
Spring Boot Actuator provides resources so we can monitor and manage our application's health and availability. It is mainly used to expose operational information about the running application, such as health, metrics, info, dump, env, etc.

## BUILT-IN ENDPOINTS
By default, Spring Boot Actuator comes with all built-in endpoints disabled, except `/health`. An endpoint is considered _available_ when it is both _enabled_ and _exposed_. Spring Boot Actuator's endpoints are exposed over REST endpoints and JMX.

| ENDPOINT            | DESCRIPTION |
| :------------------ | :---------- |
| `/auditevents`      | Returns audit event information for the current application |
| `/beans`            | Returns a complete list of all Spring beans in the current application |
| `/caches`           | Returns available caches |
| `/conditions`       | Returns a report of all conditions around autoconfiguration |
| `/configprops`      | Returns a grouped list of all @ConfigurationProperties |
| `/env`              | Returns the current environment properties from Spring’s ConfigurableEnvironment |
| `/health`           | Returns application health information |
| `/httptrace`        | Returns HTTP trace informations (last 100 HTTP request-response exchanges by default) |
| `/info`             | Returns arbitrary application information |
| `/integrationgraph` | Returns the Spring integration graph. Requires a spring-integration-core dependency |
| `/loggers`          | Returns the configuration of loggers in the application. Can be used to modify logging level of application's component |
| `/metrics`          | Returns metrics information for the current app |
| `/mappings`         | Returns a grouped list of all your application's APIs |
| `/scheduledtasks`   | Returns the tasks scheduled in your application |
| `/sessions`         | Returns retrieval and deletion of user sessions from a Spring Session supported session store. Requires a Servlet-based web application using Spring Session |
| `/shutdown`         | Disables the application. It is not enabled by default (To enable `management.endpoint.shutdown.enabled=true`)|
| `/startup`          | Returns the startup step data collected by ApplicationStartup |
| `/threaddump`       | Performs a thread dump |


## INFO ENDPOINT
To expose custom informations on `/info` we should set them as property entries starting with `info.*` at `application.yml` or `application.properties`. Also, it's required to set `management.info.env.enabled` to `true` because the Spring Actuator's `InfoContributor` is disabled by default.

### GIT & BUILD INFORMATION
To get git and build details returned on `/info`, we have to add the following to the plugin section:
```xml
<plugin>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-maven-plugin</artifactId>    
    <executions>
        <execution>
            <goals>
                <goal>build-info</goal>
            </goals>
        </execution>
    </executions>
</plugin>
<plugin>
    <groupId>pl.project13.maven</groupId>
    <artifactId>git-commit-id-plugin</artifactId>
</plugin>
```

## HEALTH INDICATOR
Health Indicators are used to report the healthiness and availability of inner components and services. Spring Boot Actuator comes with predefined health indicators to provide specific status about the application. Such built-in indicators are: [DiskSpaceHealthIndicator](https://docs.spring.io/spring-boot/docs/current/api/org/springframework/boot/actuate/system/DiskSpaceHealthIndicator.html), [PingHealthIndicator](https://docs.spring.io/spring-boot/docs/current/api/org/springframework/boot/actuate/health/PingHealthIndicator.html), [LivenessStateHealthIndicator](https://docs.spring.io/spring-boot/docs/current/api/org/springframework/boot/actuate/availability/LivenessStateHealthIndicator.html) and [ReadinessStateHealthIndicator](https://docs.spring.io/spring-boot/docs/current/api/org/springframework/boot/actuate/availability/ReadinessStateHealthIndicator.html). Some health indicators are registered/added automatically according to the existence of specific dependencies on the classpath or when other conditions are met. For instance, [DataSourceHealthIndicator](https://docs.spring.io/spring-boot/docs/current/api/org/springframework/boot/actuate/jdbc/DataSourceHealthIndicator.html) (if any relational database driver dependency is set) and [RedisHealthIndicator](https://docs.spring.io/spring-boot/docs/current/api/org/springframework/boot/actuate/redis/RedisHealthIndicator.html) (if the Redis dependency module is found on the classpath) and so on.

The Liveness and Readiness HTTP probe statuses are returned by default on `/health` for applications running on Kubernetes. To enable them to be exposed otherwise we have to set the property `management.health.probes.enabled` to `true`.

By default `/health` does not return detailed informations about the available indicators. To get them exposed, we have to set both properties `management.endpoint.health.show-components` and `management.endpoint.health.show-details` to `always`.

By default there are four types of health status: `UP`, `DOWN`, `OUT_OF_SERVICE` and `UNKNOWN`, and for each there is a corresponding HTTP code associated.
| STATUS         | HTTP_CODE  | MEANING |
| :--------------| :--------: | :------ |
| UP             | 200        | The component or subsystem is functioning as expected |
| DOWN           | 503        | The component or subsystem has suffered an unexpected failure |
| OUT_OF_SERVICE | 503        | The component or subsystem has been taken out of service and should not be used |
| UNKNOWN        | 200        | The component or subsystem is in an unknown state |

The application's **overall status** is an aggregate of all health indicators statuses, i.e. from all built-in (db, diskSpace, ping, livenessState, readiness etc) and custom health indicators. If one of them is found in failure or unknown state, _the root status will be reported as DOWN_.

### CUSTOM HEALTH INDICATORs
To register a custom health indicator we need to create a @Component class which implements the [HealthIndicator](https://docs.spring.io/spring-boot/docs/current/api/org/springframework/boot/actuate/health/HealthIndicator.html) interface and overrides the `health()` method.

To generate a composite health check indicator by combining other indicators is required to create a @Component class which implements the [CompositeHealthContributor](https://docs.spring.io/spring-boot/docs/current/api/org/springframework/boot/actuate/health/CompositeHealthContributor.html) interface; mark each of the contributing health indicators with the [HealthContributor](https://docs.spring.io/spring-boot/docs/current/api/org/springframework/boot/actuate/health/HealthContributor.html) interface; and override the `iterator()` method in the CompositeHealthContributor implementation component class with the list of health contributors (component class that implements HealthContributor)

## KEY ANNOTATIONS
[@Endpoint](https://docs.spring.io/spring-boot/docs/current/api/org/springframework/boot/actuate/endpoint/annotation/Endpoint.html) - used to indicate a type as being an actuator endpoint that provides information about the running application;

[@RestControllerEndpoint](https://docs.spring.io/spring-boot/docs/current/api/org/springframework/boot/actuate/endpoint/web/annotation/RestControllerEndpoint.html) - used to indicate a type as being a REST endpoint that is only exposed over Spring MVC or Spring WebFlux;

[@Selector](https://docs.spring.io/spring-boot/docs/current/api/org/springframework/boot/actuate/endpoint/annotation/Selector.html) - works like @PathVariable annotation by binding a named URI actuator endpoint path parameter into an argument;

[@ReadOperation](https://docs.spring.io/spring-boot/docs/current/api/org/springframework/boot/actuate/endpoint/annotation/ReadOperation.html) – used to indicate a method on an @Endpoint component class as read operation (HTTP GET accessible);

[@WriteOperation](https://docs.spring.io/spring-boot/docs/current/api/org/springframework/boot/actuate/endpoint/annotation/WriteOperation.html) – used to indicate a method on an @Endpoint component class as write operation (HTTP POST accessible);

[@DeleteOperation](https://docs.spring.io/spring-boot/docs/current/api/org/springframework/boot/actuate/endpoint/annotation/DeleteOperation.html) – used to indicate a method on an @Endpoint component class as delete operation (HTTP DELETE accessible);
</br></br>


# 12. SPRING BOOT TESTING <a id="12-spring-boot-testing-" href="#12"></a>
## REFERENCES
- https://spring.io/guides/gs/testing-web/
- https://howtodoinjava.com/spring-boot2/testing/springboot-test-configuration/
- https://howtodoinjava.com/spring-boot2/testing/junit5-with-spring-boot2/
- https://rieckpil.de/spring-boot-unit-and-integration-testing-overview/
- https://rieckpil.de/difference-between-mock-and-mockbean-spring-boot-applications/
- https://newbedev.com/unit-test-or-integration-test-in-spring-boot
- https://docs.spring.io/spring-framework/docs/current/reference/html/testing.html
- https://rieckpil.de/spring-boot-test-slices-overview-and-usage/
- https://reflectoring.io/spring-boot-test/

## KEY ANNOTATIONS
[@ExtendWith](https://junit.org/junit5/docs/5.0.3/api/org/junit/jupiter/api/extension/ExtendWith.html) - JUnit annotation that is used to register extensions for the annotated test class or test method. [Prior to Spring 2.1 release](https://github.com/spring-projects/spring-boot/wiki/Spring-Boot-2.1-Release-Notes#junit-5), `@ExtendWith(SpringExtension.class)` was necessary to be specified at the test class-level in order to enable Spring support, but as of then is no longer needed because it is included as a meta annotation in the Spring Boot test annotations like @DataJpaTest, @WebMvcTest, and @SpringBootTest.

[@SpringBootTest](https://docs.spring.io/spring-boot/docs/current/api/org/springframework/boot/test/context/SpringBootTest.html) - used to bootstrap a complete application context for testing. @SpringBootTest by default starts searching in the current package of the annotated test class and then searches upwards through the package structure, looking for a class annotated with @SpringBootConfiguration from which it reads the configuration to create an application context. This class is usually the main application class since the @SpringBootApplication annotation includes the @SpringBootConfiguration annotation. It then creates an application context very similar to the one that would be started in a production environment.

[@ContextConfiguration](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/test/context/ContextConfiguration.html) - used to load <ins>component classes</ins><a href="#note1" id="note1ref"><sup>1</sup></a> in order to configure an ApplicationContext for integration test.

[@WebMvcTest](https://docs.spring.io/spring-boot/docs/current/api/org/springframework/boot/test/autoconfigure/web/servlet/WebMvcTest.html) - used to set up an application context with just enough components and configurations required to test the **Web MVC Controller Layer**. It disables full auto-configuration and instead apply only configuration relevant to MVC tests.

[@DataJpaTest](https://docs.spring.io/spring-boot/docs/current/api/org/springframework/boot/test/autoconfigure/orm/jpa/DataJpaTest.html) - used to set up an application context specificaly to test the **Persistence Layer**, by configuring entities, repositories. @DataJpaTest by default autoconfigures an in-memory/embedded database like H2.

[@Commit](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/test/annotation/Commit.html) - *test annotation* used to indicate that changes performed on database from a test method should be committed before it ends. When used at class-level, all test methods will commit changes to the database.

[@Rollback](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/test/annotation/Rollback.html) - *test annotation* used to indicate that changes performed on database from a test method should be roll backed before it ends. When used at class-level, all test methods will behave in that way.

[@TestConfiguration](https://docs.spring.io/spring-boot/docs/current/api/org/springframework/boot/test/context/TestConfiguration.html) - used to define additional beans or override existing beans in the Spring application context in order to add specialized configuration for testing. Configuration classes annotated with @TestConfiguration are excluded from component scanning. Configuration classes with bean definition annotated with @TestConfiguration can be imported by @Import or declared as static inner classes. It is required to set the property <code>spring.main.allow-bean-definition-overriding=true</code> in order to enable bean overriding feature during testing.

[@MockBean](https://docs.spring.io/spring-boot/docs/current/api/org/springframework/boot/test/mock/mockito/MockBean.html) - part of the Spring Test Framework and used to create mocks for beans whenever running tests targeted to the _Spring Test context_ (i.e. testing with @SpringBootTest, @WebMvcTest, @DataJpaTest and so on).

[@Mock](https://javadoc.io/doc/org.mockito/mockito-core/latest/org/mockito/Mockito.html) - part of the [Mockito Framework](https://site.mockito.org) and used to create a mock for a class or interface. It is a shorhand for the <code>Mockito.mock()</code>.

[@InjectMocks](https://javadoc.io/doc/org.mockito/mockito-core/latest/org/mockito/InjectMocks.html) - part of the [Mockito Framework](https://site.mockito.org) and used to create a mock for the marked field and injects all dependencies annotated with @Mock into it.

## NOTES
### @SpringBootTest vs @ContextConfiguration
- Even though both can be used to specify how to load an application context in integration test, @ContextConfiguration doesn’t take full advantage of Spring Boot features, like logging or additional property loading.

### @MockBean vs @Mock
- For any test that doesn’t need any dependencies from the Spring Boot container (application context), @Mock should be used as it is fast and favours the isolation of the tested component;
- If a test relies on the Spring Boot container (application context) and it's also needed to add or mock one of the container beans, @MockBean should be used;
- As a rule of thumb, @Mock should be used when testing services components where business logic are implemented, and @MockBean should be used when doing sliced context testing like on the controller (@WebMvcTest) or repository (@DataJpaTest) layer, or when running backed Spring context tests (@SpringBootTest).
</br></br>


<a id="note1" href="#note1ref"><sup>1</sup></a> <ins>component classes</ins> - is any class annotated with @Configuration or @Component (including any of its stereotype like @Service, @Repository etc) as well as any JSR-330 compliant class that is annotated with javax.inject annotations.