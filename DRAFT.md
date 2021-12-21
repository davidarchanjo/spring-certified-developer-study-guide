https://www.geeksforgeeks.org/introduction-to-spring-framework/
https://www.baeldung.com/inversion-control-and-dependency-injection-in-spring

Section 1-1 – Container, Dependency and IOC 
• What is dependency injection and what are the advantages of using it? 
https://www.baeldung.com/inversion-control-and-dependency-injection-in-spring


• What is an interface and what are the advantages of making use of them in Java? 
https://www.baeldung.com/java-interfaces
https://www.geeksforgeeks.org/interfaces-in-java/


• What is an ApplicationContext? How are you going to create a new instance of an ApplicationContext?  
https://www.baeldung.com/spring-application-context
https://www.geeksforgeeks.org/spring-applicationcontext/
https://zetcode.com/springboot/applicationcontext/


• Can you describe the lifecycle of a Spring Bean in an ApplicationContext?
https://www.geeksforgeeks.org/bean-life-cycle-in-java-spring/
https://howtodoinjava.com/spring-core/spring-bean-life-cycle/


• How are you going to create an ApplicationContext in an integration test?
https://www.geeksforgeeks.org/spring-applicationcontext/


• What is the preferred way to close an application context? Does Spring Boot do this for you?


• Are beans lazily or eagerly instantiated by default? How do you alter this behavior?


• What is a property source? How would you use @PropertySource?


• What is a BeanFactoryPostProcessor and what is it used for? When is it invoked?


• What is a BeanPostProcessor and how is it different to a BeanFactoryPostProcessor? What do they do? When are they called?


• What does component-scanning do?


• What is the behavior of the annotation @Autowired with regards to field injection, constructor injection and method injection?
https://www.baeldung.com/spring-autowire
@Autowired - marks a dependency which Spring is going to resolve and inject. Can be used on properties, setters, and constructors.


• How does the @Qualifier annotation complement the use of @Autowired?


• What is a proxy object and what are the two different types of proxies Spring can create?


• What does the @Bean annotation do?
@Bean marks a factory method which instantiates a Spring bean:


• What is the default bean id if you only use @Bean? How can you override this?


• Why are you not allowed to annotate a final class with @Configuration


• How do you configure profiles? What are possible use cases where they might be useful? 


• Can you use @Bean together with @Profile? 


• Can you use @Component together with @Profile? 


• How many profiles can you have? 


• How do you inject scalar/literal values into Spring beans? 
@Value is used to inject property or scalar/literal values into beans. Can be used on constructor, setter, and field injection.

• What is Spring Expression Language (SpEL for short)? 


• What is the Environment abstraction in Spring? 


• Where can properties in the environment come from – there are many sources for properties – check the documentation if not sure. Spring Boot adds even more. 


• What can you reference using SpEL?


• What is the difference between $ and # in @Value expressions?
https://www.usastudyhelp.com/2019/09/what-is-the-difference-between-and-in-value-expressions/
https://www.baeldung.com/spring-value-annotation