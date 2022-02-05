# 1. SpEL
how to access properties from spel
systemProperties.data.limit 
or
systemProperties['dataLimit']

# 2. ACTUATOR
custom health indicator
possíveis status??
UP, DOWN??
preciso criar tags para??
o q é retornado no /info? posso customizar??

# 3. JDBC
ResultSet, RowMapper
what types are mapped by resultset??
long, int, etc
generic map??
jsonobject??
domain objects??

# 4. TRANSACTIONS
transactions in testing
@Commit, @Rollback

# 5. SPRING MVC
requestmapping

# 6. AUTOCONFIG
-Dconfig.properties works application.properties??

# 7. TESTING
@ContextConfiguration
@MockMvc and @Mock are interchangeable??

# 8. SPRING SECURITY
difference between * and **
test hasRole from less specific to most using distinct roles

Caso #1
- logado como: 
	AUTHOR_ADMIN
- config:
	.antMatchers("/api/public/get").hasRole(Roles.AUTHOR_ADMIN)
	.antMatchers("/api/public/**").hasRole(Roles.USER_ADMIN)
- test:
	/api/public     - 403
	/api/public/get - 200

Caso #2
- logado como: 
	AUTHOR_ADMIN
- config:
	.antMatchers("/api/public/**").hasRole(Roles.USER_ADMIN)
	.antMatchers("/api/public/get").hasRole(Roles.AUTHOR_ADMIN)	
- test:
	/api/public     - 403
	/api/public/get - 403
	
Caso #3
- logado como: 
	AUTHOR_ADMIN
- config:
	.antMatchers("/api/public/get").hasRole(Roles.AUTHOR_ADMIN)
	.antMatchers("/api/public/*").hasRole(Roles.USER_ADMIN)
- test:
	/api/public     - 200
	/api/public/get - 200
	
Caso #2
- logado como: 
	AUTHOR_ADMIN
- config:
	.antMatchers("/api/public/*").hasRole(Roles.USER_ADMIN)
	.antMatchers("/api/public/get").hasRole(Roles.AUTHOR_ADMIN)	
- test:
	/api/public     - 200
	/api/public/get - 403

# WRAP UP (30,31)

# EXAM DATE
14/Fev