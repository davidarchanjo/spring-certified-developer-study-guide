# 2. ACTUATOR (05)
custom health indicator
possíveis status??
UP, DOWN??
preciso criar tags para??
o q é retornado no /info? posso customizar??

# 1. SpEL OK (06)
how to access properties from spel
systemProperties.data.limit 
or
systemProperties['dataLimit']



# 3. JDBC (06)
ResultSet, RowMapper
what types are mapped by resultset??
long, int, etc
generic map??
jsonobject??
domain objects??

# 4. TRANSACTIONS (07)
transactions in testing
@Commit, @Rollback

# 5. SPRING MVC (08)
requestmapping

# 6. AUTOCONFIG (09)
-Dconfig.properties works application.properties??

# 7. TESTING (10)
@ContextConfiguration
@MockMvc and @Mock are interchangeable??

# 8. SPRING SECURITY (04)
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

# WRAP UP (11)

# EXAM DATE
18/Fev