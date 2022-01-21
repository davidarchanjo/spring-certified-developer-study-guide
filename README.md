![banner](./assets/banner.jpg)
</br></br>

# INTRODUCTION
This guide walks through some technical notes and references about the Spring Framework, with focus on the Spring Boot Framework, providing a _supporting material_ for whoever it is preparing to take the [Spring Certified Professional](https://www.vmware.com/education-services/certification/vcp-spring-exam.html) exam. The content in this guide are by no means definitive and exhaustive so that it alone can enable someone to take the exam with peace of mind. This guide is accompanied by many sources of relevant technical documentations and tutorials, and supplies a well structured and concise study planning to help you on your preparation.

I hope this guide and its content be useful for you in some way. Good luck 🤞🍀!
</br></br>


# EXAM OVERVIEW
The **Spring Certified Professional** certification is a 50-multiple-choice exam, with a passing score of 76% correctness (i.e. at least 38 out of 50 questions must be answered correctly). This Spring professional certification exam is designed to test and validate the overall understanding and familiarity with core aspects of Spring and Spring Boot frameworks as follows:
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

### EXAM INFO
**Duration:** 90 Minutes

**Number of Questions:** 50 Questions

**Passing Score:** 76%

**Format:** Multiple Choice, Multiple Choice Multiple Selection, Drag and Drop, Matching
</br></br>


# TABLE OF CONTENTS
1. <a href="#1-rest-concepts-" id="1">REST BASICS</a>
2. <a href="#2-spring-core-concepts-" id="2">SPRING CORE CONCEPTS</a>
3. <a href="#3-spring-boot-basics-and-auto-configuration-" id="3">SPRING BOOT BASICS AND AUTO-CONFIGURATION</a>
4. <a href="#4-aspect-oriented-programming-" id="4">ASPECT-ORIENTED PROGRAMMING</a>
5. <a href="#5-data-management-jdbc-transactions-" id="5">DATA MANAGEMENT: JDBC, TRANSACTIONS</a>
6. <a href="#6-spring-data-jpa-" id="6">SPRING DATA JPA</a>
7. <a href="#7-spring-mvc-" id="7">SPRING MVC</a>
8. <a href="#8-spring-security-" id="8">SPRING SECURITY</a>
9. <a href="#9-spring-boot-actuator-" id="9">SPRING BOOT ACTUATOR</a>
10. <a href="#10-spring-boot-testing-" id="10">SPRING BOOT TESTING</a>
</br></br>


# 1. REST BASICS <a id="1-rest-concepts-" href="#1"></a>
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
| POST   | Create a REST API resource |
| GET    | Retrieve information about a specific REST API resource or a collection |
| PUT    | Update a REST API resource |
| DELETE | Delete a REST API resource or related component |

## HTTP STATUS
In REST APIs, HTTP status codes are used to inform the consumer about the request's result. The status codes are divided into five categories:</br>
| Category   | Description |
| :--------- | :---------- |
| 1xx Status | Indicates that the server received the request and is continuing the process |
| 2xx Status | Indicates that the client’s request was accepted successfully |
| 3xx Status | Indicates that the client must take some additional action in order to complete the request |
| 4xx Status | Indicates that the client's request contains erros or bad syntax |
| 5xx Status | Indicates that the client's request was unable to be performed due to a server-side error |

## API DESIGN & CONVENTIONS
The key principles of REST involves separating the API into _logical resources_ and manipulate them through HTTP requests where every HTTP method (GET, POST, PUT, DELETE etc) performs a specific operation.

The functionalities provided by an API are related to _resources_ and by convention the resources are represented on URIs as **nouns in the plural**. The operation(s) made available via URI should be mapped to a HTTP method that corresponds to the action is intended to be carried out. The mapping rules goes as follows:</br>
| Method | URL        | Operation | Status |
| :----- | :--------- | :-------- | :---------: |
| GET    | `/todos`   | Retrieves a list of todos | 200 |
| GET    | `/todos/1` | Retrieves a specific todo | 200 |
| POST   | `/todos`   | Creates a new todo | 201 |
| PUT    | `/todos/1` | Fully updates todo referenced by #1 | 204 |
| PATCH  | `/todos/1` | Partially updates todo referenced by #1 | 204 |
| DELETE | `/todos/1` | Deletes todo referenced by #1 | 204 |

</br>

# 2. SPRING CORE CONCEPTS <a id="1-spring-core-concepts-" href="#2"></a>
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

## OVERVIEW
**Bean** is an object that is instantiated, assembled, and managed by the **Spring IoC Container**.

**Spring IoC Container** is responsible for instantiating beans, wiring dependencies and managing the bean lifecycle from its instantiation till destruction. Spring have two IoC container implementations: [BeanFactory](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/beans/factory/BeanFactory.html) and [ApplicationContext](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/context/ApplicationContext.html).

**Inversion of Control (IoC)** is a process in which an object defines its dependencies without creating them explicitly. The object delegates the job of construction its dependencies to the IoC container.

**Dependency Injection** is a pattern used to implement IoC, where the control being inverted is the setting and injection of object's dependencies.

## KEY ANNOTATIONS
[@Bean](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/context/annotation/Bean.html) - used on factory methods to indicate that their produced object will be managed by the Spring container;

[@Scope](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/context/annotation/Scope.html) - used to indicate the scope for instances of the annotated bean;

[@Autowired](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/beans/factory/annotation/Autowired.html) - used at constructors, methods and fields to indicate that the injection (i.e. instantiation) will be managed by the Spring container dinamically;

[@Qualifier](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/beans/factory/annotation/Qualifier.html) - used to specify (by name) which bean have to be used for injection if more than one type is eligible for injection;

[@Primary](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/context/annotation/Primary.html) - used to indicate that a bean must be given preference when multiple candidates are qualified to autowire a single-valued dependency, i.e. is used to give higher preference to a bean when there are multiple beans of the same type.

[@Lazy](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/context/annotation/Lazy.html) - used to indicate whether a bean is to be lazily initialized, i.e. if present on a @Component or @Bean definition and set to <code>true</code>, the bean or component will not be initialized until referenced by another bean or explicitly retrieved from the enclosing [BeanFactory](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/beans/factory/BeanFactory.html). This annotation may also be placed on injection points marked with @Autowired, like constructor parameters, method parameters etc;

[@Profile](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/context/annotation/Profile.html) - used to indicate that a component class or bean is eligiable for registration when the specified profile(s) are active;

[@Component](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/stereotype/Component.html) - generic stereotype annotation used to indicate that a class is a managed component, registering as a bean;

[@Repository](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/stereotype/Repository.html) - is a @Component stereotype annotation used to indicate that a class defines a data repository. Enables automatic translation of exceptions thrown from the underlying persistence layer;

[@Service](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/stereotype/Service.html) - is a @Component stereotype annotation used to indicate that a class defines business logic;

[@Configuration](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/context/annotation/Configuration.html) - used to mark a class as a source of bean definitions;

[@Import](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/context/annotation/Import.html) - used to indicate one or more component class to import — typically from @Configuration classes.

[@ImportAutoConfiguration](https://docs.spring.io/spring-boot/docs/current/api/org/springframework/boot/autoconfigure/ImportAutoConfiguration.html) - used to disable the default autoconfiguration flow performed by @EnableAutoConfiguration, importing only the configuration classes provided in the annotation.

[@Value](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/beans/factory/annotation/Value.html) - used at field or method/constructor parameter level to inject property value into beans;

[@PropertySource](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/context/annotation/PropertySource.html) - used to load values from property files — the values can be accessed from [Environment](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/core/env/Environment.html) or injected by the @Value annotation;

[@ConfigurationProperties](https://docs.spring.io/spring-boot/docs/current/api/org/springframework/boot/context/properties/ConfigurationProperties.html) - used to map resource files such as properties or YAML files to Java Bean object.

[@EnableConfigurationProperties](https://docs.spring.io/spring-boot/docs/current/api/org/springframework/boot/context/properties/EnableConfigurationProperties.html) - enables support for @ConfigurationProperties annotated classes in our application.
</br></br>


# 3. SPRING BOOT BASICS AND AUTO-CONFIGURATION <a id="3-spring-boot-basics-and-auto-configuration-" href="#3"></a>
## REFERENCES
- https://www.baeldung.com/spring-boot-annotations
- https://www.baeldung.com/spring-conditional-annotations
- https://www.marcobehler.com/guides/spring-boot
- https://www.baeldung.com/spring-component-scanning
- https://reflectoring.io/spring-boot-conditionals
- https://zetcode.com/springboot/conditionalbeans

## KEY ANNOTATIONS
[@SpringBootApplication](https://docs.spring.io/spring-boot/docs/current/api/org/springframework/boot/autoconfigure/SpringBootApplication.html) - is a combination of @Configuration, @EnableAutoConfiguration, and @ComponentScan annotations with their default attributes;

[@EnableAutoConfiguration](https://docs.spring.io/spring-boot/docs/current/api/org/springframework/boot/autoconfigure/EnableAutoConfiguration.html) – used to indicate to the Spring container to automatically add beans based on the dependencies on the classpath;

[@ComponentScan](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/context/annotation/ComponentScan.html) – indicates to Spring for looking for other beans, components and configurations in the same package and sub-packages of the annotated class;

[@SpringBootConfiguration](https://docs.spring.io/spring-boot/docs/current/api/org/springframework/boot/SpringBootConfiguration.html) - used to indicate that a class provides Spring Boot application @Configuration. Can be used as an alternative to @Configuration annotation so that configuration can be found automatically;

[@Conditional](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/context/annotation/Conditional.html) - used to indicate that a component is only eligible for registration when all specified conditions match;
</br></br>


# 4. ASPECT-ORIENTED PROGRAMMING <a id="4-aspect-oriented-programming-" href="#4"></a>
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

[JoinPoint](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/aopalliance/intercept/Joinpoint.html) - 

[ProceedingJoinPoint](https://www.javadoc.io/doc/org.aspectj/aspectjrt/latest/org/aspectj/lang/ProceedingJoinPoint.html) - 

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
[@EnableAspectJAutoProxy](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/context/annotation/EnableAspectJAutoProxy.html) - used on @Configuration classes to enable support for handling component classes annotated with @Aspect;

[@Aspect](https://www.eclipse.org/aspectj/doc/next/aspectj5rt-api/org/aspectj/lang/annotation/Aspect.html) - used to mark a @Component class as an aspect declaration;

[@Pointcut](https://www.eclipse.org/aspectj/doc/next/aspectj5rt-api/org/aspectj/lang/annotation/Pointcut.html) - used in methods to declare pointcut, which can be availed by advice annotations on refering to that pointcut;

[@Before](https://www.eclipse.org/aspectj/doc/next/aspectj5rt-api/org/aspectj/lang/annotation/Before.html) - used to mark a method to be executed before the matching joint point;

[@AfterReturning](https://www.eclipse.org/aspectj/doc/next/aspectj5rt-api/org/aspectj/lang/annotation/AfterReturning.html) - used to mark a method to be executed after the matching joint point completes, whether normally or by throwing an exception;

[@AfterThrowing](https://www.eclipse.org/aspectj/doc/next/aspectj5rt-api/org/aspectj/lang/annotation/AfterThrowing.html) - used to mark a method to be executed after the matching join point exits by throwing an exception;

[@Around](https://www.eclipse.org/aspectj/doc/next/aspectj5rt-api/org/aspectj/lang/annotation/Around.html) - used to mark a method to be executed before and after a Joint Point.
</br></br>


# 5. DATA MANAGEMENT: JDBC, TRANSACTIONS <a id="5-data-management-jdbc-transactions-" href="#5"></a>
## REFERENCES
- https://www.javainuse.com/spring/boot-transaction
- https://www.baeldung.com/spring-transactional-propagation-isolation
- https://www.marcobehler.com/guides/spring-transaction-management-transactional-in-depth
- https://www.byteslounge.com/tutorials/spring-transaction-propagation-tutorial
- https://www.byteslounge.com/tutorials/spring-transaction-isolation-tutorial

## OVERVIEW 
<p>
  <b>Transaction</b> is a single logical unit of work which could be composed by one or many actions that potentially modify the contents of a database, i.e. a sequence of actions that are considered as a single logical unit by the application. For an application, if any action running into a transactional context fails then all other actions gets rolled back. Is worthy to mention that the only exception types that set a transaction to roll back by default are unchecked exceptions (RuntimeException and its subclasses). To make a transaction roll back when a given checked exception occurs we have to specify it on the @Transaction's <code>rollbakFor</code> parameter.
</p>

<p>
  <b>Transaction Propagation</b> is a mechanism used to indicate if a given action will or will not participate in a transactional context as well as how it will behave when called from a service which already has or not a transaction in place.
</p>

- Types of Transaction Propagation:

  | Propagation   | Behaviour                                                                                                                                                                                                                                                                                                            |
  |:---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------| :-------- |
  | REQUIRED      | Always executes in a transaction and if there is an active transaction it is used otherwise a new one is created                                                                                                                                                                                                     |
  | REQUIRES_NEW  | Always executes in a new transaction and if there is an active transaction it gets suspended before stars a new one                                                                                                                                                                                                  |
  | NESTED        | Like REQUIRES_NEW always executes in a new transaction but differs in the way that if there is an active transaction it will be created a _sub-transaction_ by setting savepoints between nested invocations so that this _sub-transaction_ may rollback independently of the outer (main) transaction in case of failure |
  | SUPPORTS      | If a transaction exists then it makes use of it but if none exits the method will execute in a non-transactional context                                                                                                                                                                                             |
  | NOT_SUPPORTED | Always executes without a transaction and if there is an active transaction it gets suspended until the end of the method execution                                                                                                                                                                                  |
  | NEVER         | Always executes without a transaction but if there is an active transaction an [IllegalTransactionStateException](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/transaction/IllegalTransactionStateException.html) is thrown                                                  |
  | MANDATORY     | Always executes in a transaction and if there is an active transaction it is used. If does not exist an active transaction an [IllegalTransactionStateException](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/transaction/IllegalTransactionStateException.html) is thrown   |

<p>
  <b>Transaction Isolation Level</b> is a mechanism used to indicate how changes made to data by one transaction affect other concurrent transactions as well as how and when changed data becomes available to other concurrent transactions, i.e. how changes applied on data by concurrent transactions are visible to each other.
</p>

- Types of Transaction Isolation Level:

  | Isolation        | Behaviour |
  | :--------------- | :-------- |
  | DEFAULT          | Indicates that for any transaction the default isolation level of the underlying RDBMS will be used |
  | READ_COMMITTED   | Indicates that a transaction can not read data that is not yet committed by other concurrent transactions |
  | READ_UNCOMMITTED | Indicates that a transaction may read data that is still uncommitted by other concurrent transactions |
  | REPEATABLE_READ  | Indicates that if a transaction reads one record from the database multiple times the result of all reading must always be the same |
  | SERIALIZABLE     | Indicates that transactions must be executed with locking at all levels (read, range and write locking) so that they behave as if they were executed in a serialized way, i.e. concurrent execution of a group of transactions should have the same result as if they are executed sequentially |

## KEY ANNOTATIONS
[@Transactional](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/transaction/annotation/Transactional.html) - used to indicate declaratively control over transaction boundaries on managed beans, usually for @Service classes which contain business logic;

[@EnableTransactionManagement](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/transaction/annotation/EnableTransactionManagement.html) - used to enable the Spring's annotation-driven declarative transaction management capabilities. Must be used on @Configuration classes. @EnableTransactionManagement is **optional** in Spring Boot application as long as one of spring-data-* modules is configured on the project;
</br></br>


# 6. SPRING DATA JPA <a id="6-spring-data-jpa-" href="#6"></a>
## REFERENCES
- https://spring.io/guides/gs/accessing-data-jpa/
- https://knpcode.com/spring/spring-data-tutorial/
- https://www.baeldung.com/the-persistence-layer-with-spring-data-jpa
- https://www.baeldung.com/spring-data-jpa-query

## KEY ANNOTATIONS
[@Entity](https://javaee.github.io/javaee-spec/javadocs/javax/persistence/Entity.html) - used to specify that the annotated class maps a database entity. If we forget to mark a domain class that will map a database entity with @Entity annotation, we will get an IllegalArgumentException since Spring will not be able to invocate the init method in a not managed type;

[@Table](https://javaee.github.io/javaee-spec/javadocs/javax/persistence/Table.html) - used to specify the table that will map the entity in the database;

[@Id](https://javaee.github.io/javaee-spec/javadocs/javax/persistence/Id.html) - used to mark a property in a entity class as the primary key. If no @Column annotation is specified, the primary key column name is assumed to be the name of the property;

[@GeneratedValue](https://javaee.github.io/javaee-spec/javadocs/javax/persistence/GeneratedValue.html) - used to specify the primary key generation strategy which by default is autoincrement;

[@Column](https://javaee.github.io/javaee-spec/javadocs/javax/persistence/Column.html) - used to specify the database column details like name, constraint etc to which a property will be mapped. If no @Column annotation is specified, then the field name will be used for mapping;

[@Query](https://docs.spring.io/spring-data/jpa/docs/current/api/org/springframework/data/jpa/repository/Query.html) - used to declare custom queries on 
repository methods to execute both JPQL or native SQL queries;

[@Modifying](https://docs.spring.io/spring-data/jpa/docs/current/api/org/springframework/data/jpa/repository/Modifying.html) - used to indicate that a @Query annotated repository method executes a modifying JPQL or native SQL such as a INSERT, UPDATE, DELETE or DDL statement;

[@EntityScan](https://docs.spring.io/spring-boot/docs/current/api/org/springframework/boot/autoconfigure/domain/EntityScan.html) - used on @Configuration classes to indicate to Spring where is located entity classes when they are not placed in the main application package or its sub-packages;

[@EnableJpaRepositories](https://docs.spring.io/spring-data/jpa/docs/current/api/org/springframework/data/jpa/repository/config/EnableJpaRepositories.html) - used on @Configuration classes to indicate to Spring where is located JPA repository classes when they are not placed in the same package of the main application class or under its sub-packages;
</br></br>


# 7. SPRING MVC <a id="7-spring-mvc-" href="#7"></a>
## REFERENCES
- https://www.baeldung.com/spring-mvc-tutorial
- https://spring.io/guides/gs/serving-web-content
- https://docs.spring.io/spring-framework/docs/3.2.x/spring-framework-reference/html/mvc.html
- https://howtodoinjava.com/spring-boot2/resttemplate/spring-restful-client-resttemplate-example

## KEY ANNOTATIONS
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


# 8. SPRING SECURITY <a id="8-spring-security-" href="#8"></a>
## OVERVIEW
<p>Spring Security by default actives both HTTP security filters and the security filter chain and configures/enforces basic authentication for all URLs, which is session-based.</p> 
<p>The Spring Security framework provides two options to set up authorization schema configuration: URL-based and Annotation-based.

* **Security Filters Chain** - 

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
[@EnableWebSecurity](https://docs.spring.io/spring-security/site/docs/current/api/org/springframework/security/config/annotation/web/configuration/EnableWebSecurity.html) - marks a @Configuration class as a source of web access security configuration. Usually such class extends the [WebSecurityConfigurerAdapter](https://docs.spring.io/spring-security/site/docs/current/api/org/springframework/security/config/annotation/web/configuration/WebSecurityConfigurerAdapter.html) base class and overrides its methods for a more granular configuration;

[@EnableGlobalMethodSecurity](https://docs.spring.io/spring-security/site/docs/5.6.0-M1/api/org/springframework/security/config/annotation/method/configuration/EnableGlobalMethodSecurity.html) / [@EnableMethodSecurity](https://docs.spring.io/spring-security/site/docs/5.6.0-M1/api/org/springframework/security/config/annotation/method/configuration/EnableMethodSecurity.html) - both are used to configure security on method level through annotations. They have the following attributes:
<ol>
<li><code>securedEnabled</code></li>
  <span>If set to true enables @Secured annotation. Default is false</span>
<li><code>jsr250Enabled</code></li>
  <span>If set to true enables @RolesAllowed annotation. Default is false</span>
<li><code>prePostEnabled</code></li>
  <span>If set to true enables @PreAuthorize, @PostAuthorize, @PreFilter, @PostFilter annotations. Default is false</span>
</ol>

[@PreAuthorized](https://docs.spring.io/spring-security/site/docs/current/api/org/springframework/security/access/prepost/PreAuthorize.html) - supports SpEL and is used to provide expression-based access control before executing the method;

[@PostAuthorize](https://docs.spring.io/spring-security/site/docs/current/api/org/springframework/security/access/prepost/PostAuthorize.html) - supports SpEL and is used to provide expression-based access control after executing the method and provides the ability to access/alter the method's result;

[@PreFilter](https://docs.spring.io/spring-security/site/docs/current/api/org/springframework/security/access/prepost/PreFilter.html) - supports SpEL and is used to filter the collection or arrays before executing the method based on custom security rules we define;

[@PostFilter](https://docs.spring.io/spring-security/site/docs/current/api/org/springframework/security/access/prepost/PostFilter.html) - supports SpEL and is used to filter the returned collection or arrays after executing the method based on custom security rules we define (provides the ability to access the method result);

[@Secured](https://docs.spring.io/spring-security/site/docs/3.2.8.RELEASE/apidocs/org/springframework/security/access/annotation/Secured.html) - does not support SpEL and is used to specify a list of roles which the logged user must have in order to access the annotated method;

[@RolesAllowed](https://javaee.github.io/javaee-spec/javadocs/javax/annotation/security/RolesAllowed.html) - does not support SpEL and is the [JSR 250](https://jcp.org/en/jsr/detail?id=250)’s equivalent annotation of the @Secured annotation;
</br></br>


# 9. SPRING BOOT ACTUATOR <a id="9-spring-boot-actuator-" href="#9"></a>
## OVERVIEW
Spring Boot Actuator provides us with resources so we can monitor and manage our application's health and availability. Such functionalities are: monitoring, metrics, tracing and auditing.

## REFERENCES
- https://www.baeldung.com/spring-boot-actuators
- https://docs.spring.io/spring-boot/docs/current/reference/html/actuator.html#
- https://lightrun.com/best-practices/getting-started-with-spring-boot-actuator
- https://www.javadevjournal.com/spring-boot/spring-boot-actuator-custom-endpoint

## KEY ENDPOINTS
| API                 | DESCRIPTION |
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
| `/loggers`          | Returns and modifies the configuration of loggers in the application |
| `/metrics`          | Returns metrics information for the current app |
| `/mappings`         | Returns a grouped list of all your application's APIs |
| `/scheduledtasks`   | Returns the tasks scheduled in your application |
| `/sessions`         | Returns retrieval and deletion of user sessions from a Spring Session supported session store. Requires a Servlet-based web application using Spring Session |
| `/shutdown`         | Returns you to be able to disable your application. It is disabled by default |
| `/startup`          | Returns the startup step data collected by ApplicationStartup |
| `/threaddump`       | Performs a thread dump |

## KEY ANNOTATIONS
[@Endpoint](https://docs.spring.io/spring-boot/docs/current/api/org/springframework/boot/actuate/endpoint/annotation/Endpoint.html) - used to indicate a type as being an actuator endpoint that provides information about the running application;

[@RestControllerEndpoint](https://docs.spring.io/spring-boot/docs/current/api/org/springframework/boot/actuate/endpoint/web/annotation/RestControllerEndpoint.html) - used to indicate a type as being a REST endpoint that is only exposed over Spring MVC or Spring WebFlux;

[@Selector](https://docs.spring.io/spring-boot/docs/current/api/org/springframework/boot/actuate/endpoint/annotation/Selector.html) - works like @PathVariable annotation by binding a named URI actuator endpoint path parameter into an argument;

[@ReadOperation](https://docs.spring.io/spring-boot/docs/current/api/org/springframework/boot/actuate/endpoint/annotation/ReadOperation.html) – used to indicate a method on an @Endpoint component class as read operation (HTTP GET accessible);

[@WriteOperation](https://docs.spring.io/spring-boot/docs/current/api/org/springframework/boot/actuate/endpoint/annotation/WriteOperation.html) – used to indicate a method on an @Endpoint component class as write operation (HTTP POST accessible);

[@DeleteOperation](https://docs.spring.io/spring-boot/docs/current/api/org/springframework/boot/actuate/endpoint/annotation/DeleteOperation.html) – used to indicate a method on an @Endpoint component class as delete operation (HTTP DELETE accessible);
</br></br>


# 10. SPRING BOOT TESTING <a id="10-spring-boot-testing-" href="#10"></a>
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
[@ExtendWith](https://junit.org/junit5/docs/5.0.3/api/org/junit/jupiter/api/extension/ExtendWith.html) - JUnit annotation that is used to register extensions for the annotated test class or test method. [Prior to Spring 2.1 release](https://github.com/spring-projects/spring-boot/wiki/Spring-Boot-2.1-Release-Notes#junit-5), `@ExtendWith(SpringExtension.class)` was necessary to be specified in order to enable Spring support, but as of then is no longer needed because it's included as a meta annotation in the Spring Boot test annotations like @DataJpaTest, @WebMvcTest, and @SpringBootTest.

[@SpringBootTest](https://docs.spring.io/spring-boot/docs/current/api/org/springframework/boot/test/context/SpringBootTest.html) - used to bootstrap a complete application context for testing. @SpringBootTest by default starts searching in the current package of the annotated test class and then searches upwards through the package structure, looking for a class annotated with @SpringBootConfiguration from which it reads the configuration to create an application context. This class is usually the main application class since the @SpringBootApplication annotation includes the @SpringBootConfiguration annotation. It then creates an application context very similar to the one that would be started in a production environment.

[@ContextConfiguration](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/test/context/ContextConfiguration.html) - used to load <ins>component classes</ins><a href="#note1" id="note1ref"><sup>1</sup></a> in order to configure an ApplicationContext for integration test. It can load component configuration from XML resource or from config classes annotated with @Configuration. It can also load a component class annotated with @Component, @Service, @Repository etc.

[@WebMvcTest](https://docs.spring.io/spring-boot/docs/current/api/org/springframework/boot/test/autoconfigure/web/servlet/WebMvcTest.html) - used to set up an application context with just enough components and configurations required to test the **Web MVC Controller Layer**. It disables full auto-configuration and instead apply only configuration relevant to MVC tests.

[@DataJpaTest](https://docs.spring.io/spring-boot/docs/current/api/org/springframework/boot/test/autoconfigure/orm/jpa/DataJpaTest.html) - used to set up an application context specificaly to test the **Persistence Layer**, by configuring entities, repositories as well as an embedded database.

[@TestConfiguration](https://docs.spring.io/spring-boot/docs/current/api/org/springframework/boot/test/context/TestConfiguration.html) - used to define additional beans or override existing beans in the Spring application context in order to add specialized configuration for testing. Configuration classes annotated with @TestConfiguration are excluded from component scanning. Configuration classes with bean definition annotated with @TestConfiguration can be imported by @Import or declared as static inner classes. It is required to set the property <code>spring.main.allow-bean-definition-overriding=true</code> in order to enable bean overriding feature during testing.

[@MockBean](https://docs.spring.io/spring-boot/docs/current/api/org/springframework/boot/test/mock/mockito/MockBean.html) - annotation part of Spring Test Framework used to create mocks for beans whenever running tests with the _Spring Test context_ (i.e. testing with @SpringBootTest, @WebMvcTest and so on).

[@Mock](https://javadoc.io/doc/org.mockito/mockito-core/latest/org/mockito/Mockito.html) - annotation part of [Mockito Framework](https://site.mockito.org) used to create a mock for the marked field, just like if we would be calling <code>Mockito.mock()</code> manually.

[@InjectMock](https://javadoc.io/doc/org.mockito/mockito-core/latest/org/mockito/InjectMocks.html) - annotation part of [Mockito Framework](https://site.mockito.org) used to create a mock for the marked field and injects all dependencies annotated with @Mock into it.
</br></br>


<a id="note1" href="#note1ref"><sup>1</sup></a> <ins>component classes</ins> - is any class annotated with @Configuration or @Component (including any of its stereotype variants like @Service, @Repository etc) as well as any JSR-330 compliant class that is annotated with javax.inject annotations.