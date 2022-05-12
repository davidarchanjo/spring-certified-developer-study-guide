# 2. ACTUATOR

# 1. SpEL
how to access properties from spel
systemProperties.data.limit 
or
systemProperties['dataLimit']

# 4. TRANSACTIONS (09)
transactions in testing
@Commit, @Rollback

# 3. JDBC (10)
ResultSet, RowMapper
what types are mapped by resultset??
long, int, etc
generic map??
jsonobject??
domain objects??

# 5. SPRING MVC (11)
requestmapping

# 6. AUTOCONFIG (11)
-Dconfig.properties works application.properties??

# 7. TESTING (11)
@ContextConfiguration
@MockMvc and @Mock are interchangeable??

# SPRING SECURITY (11)
difference between * and **
test hasRole from less specific to most using distinct roles

Caso #1
- logado como: 
	AUTHOR_ADMIN
- config:
	.antMatchers("/api/public/get").hasRole(Roles.AUTHOR_ADMIN)
	.antMatchers("/api/public/**").hasRole(Roles.USER_ADMIN)
- result:
	/api/public     - 403
	/api/public/get - 200

Caso #2
- logado como: 
	AUTHOR_ADMIN
- config:
	.antMatchers("/api/public/**").hasRole(Roles.USER_ADMIN)
	.antMatchers("/api/public/get").hasRole(Roles.AUTHOR_ADMIN)
- result:
	/api/public     - 403
	/api/public/get - 403

Caso #3
- logado como: 
	AUTHOR_ADMIN
- config:
	.antMatchers("/api/public/*").hasRole(Roles.USER_ADMIN)
	.antMatchers("/api/public/get").hasRole(Roles.AUTHOR_ADMIN)	
- result:
	/api/public     - 200
	/api/public/get - 403

Caso #4
- logado como: 
	AUTHOR_ADMIN
- config:
	.antMatchers("/api/public/get").hasRole(Roles.AUTHOR_ADMIN)
	.antMatchers("/api/public/*").hasRole(Roles.USER_ADMIN)
- result:
	/api/public     - 200
	/api/public/get - 200

# 9. SPRING CONDITIONAL ANNOTATIONS (11)

# WRAP UP (11)

# EXAM DATE
18/Fev



testing
testresttemplate vs resttemplate
[09:26, 3/12/2022] David Archanjo: stirng has abstraction so we can use any mocking framework?
[09:28, 3/12/2022] David Archanjo: string has its internal mock framework so we can get it off of Mockito or EasyMock?

bean
bean-life-cycle
[01:54, 3/12/2022] David Archanjo: beans with inner initialization
[01:54, 3/12/2022] David Archanjo: applicationconext.getBean(...) variantes

aop
what is Advice, Pointcut, Introduction, Aspect, Interceptor

auto-configuration
@Conditionals annotations

actuator
timer?? gauge?? what're the purpose

jdbc
datasource e spring-boot-starter-jdbc

spring-mvc
What are the ready-to-use argument types you can use in a controller method?
What are the HTTP status return codes for a successful GET, POST, PUT or DELETE operation?
RequestMapping accepts HEAD?