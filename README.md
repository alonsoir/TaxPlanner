# TaxPlanner

## Introduccion

	Proyecto para calcular impuestos a una serie de productos pertenecientes a una orden.

	Los productos van a tener un precio mas un impuesto, dependiendo de si el producto es 
	importado (5%) o no, y si está exento de pagar impuestos o no (10%). 

	Los exentos son productos como libros, comida y medicinas.

	El problema está resuelto usando el framework DROOLS y java8, un sistema de gestión de 
	reglas de negocio, el cual permite crear las reglas de negocio en forma de fichero .drl,
	de manera que un equipo de negocio puede crear dicho fichero usando una herramienta 
	o también se puede generar a mano, guardandolo en la carpeta src/main/resources.

# Prerequisitos

	java8 y maven
	
## Como se compila

	mvn clean install

	Veremos una salida como la siguiente:

	Last login: Sat Dec 14 13:08:53 on ttys000
	aironman@MacBook-Pro-de-Alonso TaxPlanner % fish
	Welcome to fish, the friendly interactive shell
	aironman@MacBook-Pro-de-Alonso ~/e/TaxPlanner> mvn clean install
	[INFO] Scanning for projects...
	[INFO] 
	[INFO] -----------------< com.aironman.test.rumbo:TaxPlanner >-----------------
	[INFO] Building TaxPlanner 0.0.1-SNAPSHOT
	[INFO] --------------------------------[ jar ]---------------------------------
	[INFO] 
	[INFO] --- maven-resources-plugin:2.6:resources (default-resources) @ TaxPlanner ---
	[INFO] Using 'UTF-8' encoding to copy filtered resources.
	[INFO] Copying 3 resources
	[INFO] 
	[INFO] --- maven-compiler-plugin:3.1:compile (default-compile) @ TaxPlanner ---
	[INFO] Nothing to compile - all classes are up to date
	[INFO] 
	[INFO] --- maven-resources-plugin:2.6:testResources (default-testResources) @ TaxPlanner ---
	[INFO] Using 'UTF-8' encoding to copy filtered resources.
	[INFO] Copying 3 resources
	[INFO] 
	[INFO] --- maven-compiler-plugin:3.1:testCompile (default-testCompile) @ TaxPlanner ---
	[INFO] Nothing to compile - all classes are up to date
	[INFO] 
	[INFO] --- maven-surefire-plugin:2.12.4:test (default-test) @ TaxPlanner ---
	[INFO] Surefire report directory: /Users/aironman/eclipse-workspace/TaxPlanner/target/surefire-reports

	-------------------------------------------------------
 	T E S T S
	-------------------------------------------------------
	Running com.aironman.test.rumbo.RulesJUnitTest
	ba17a20f-93f3-442a-9303-d92a456aefd2.jar:
	/META-INF/
	/META-INF/beans.xml
	dic. 14, 2019 8:05:09 P. M. org.jboss.weld.bootstrap.WeldStartup <clinit>
	INFO: WELD-000900: 2.3.0 (Final)
	SLF4J: Failed to load class "org.slf4j.impl.StaticLoggerBinder".
	SLF4J: Defaulting to no-operation (NOP) logger implementation
	SLF4J: See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.
	dic. 14, 2019 8:05:09 P. M. org.jboss.weld.bootstrap.WeldStartup startContainer
	INFO: WELD-000101: Transactional services not available. Injection of @Inject UserTransaction not available. Transactional observers will be invoked synchronously.
	dic. 14, 2019 8:05:10 P. M. org.jboss.weld.interceptor.util.InterceptionTypeRegistry <clinit>
	WARN: WELD-001700: Interceptor annotation class javax.ejb.PostActivate not found, interception based on it is not enabled
	dic. 14, 2019 8:05:10 P. M. org.jboss.weld.interceptor.util.InterceptionTypeRegistry <clinit>
	WARN: WELD-001700: Interceptor annotation class javax.ejb.PrePassivate not found, interception based on it is not enabled
	dic. 14, 2019 8:05:10 P. M. org.jboss.weld.bootstrap.WeldStartup startContainer
	WARN: WELD-000135: Legacy deployment metadata provided by the integrator. Certain functionality will not be available.
	WARNING: An illegal reflective access operation has occurred
	WARNING: Illegal reflective access by com.thoughtworks.xstream.core.util.Fields (file:/Users/aironman/.m2/repository/com/thoughtworks/xstream/xstream/1.4.7/xstream-1.4.7.jar) to field java.util.TreeMap.comparator
	WARNING: Please consider reporting this to the maintainers of com.thoughtworks.xstream.core.util.Fields
	WARNING: Use --illegal-access=warn to enable warnings of further illegal reflective access operations
	WARNING: All illegal access operations will be denied in a future release
	dic. 14, 2019 8:05:10 P. M. org.jboss.weld.bootstrap.Validator validateCustomBean
	WARN: WELD-001473: javax.enterprise.inject.spi.Bean implementation org.drools.compiler.cdi.KieCDIExtension$StatefulKSessionBean@6d868997 declared a normal scope but does not implement javax.enterprise.inject.spi.PassivationCapable. It won't be possible to inject this bean into a bean with a passivating scope (@SessionScoped, @ConversationScoped). This can be fixed by assigning the Bean implementation a unique id by implementing the PassivationCapable interface.
	 >>> Rule Fired for Object: 
	Order [id=0bffcfc3-9b2f-4765-9bc9-7cb521e6c313
	, products=[Product [id=aaa7e492-ccdf-45da-a93b-ae711bd5d633, description=book, prize=12.49, imported=false, tax_exempt=true, sale_tax=0.0]
	, Product [id=e3abe82c-148a-4a1a-ba98-538d127edbdf, description=Music CD, prize=14.99, imported=false, tax_exempt=false, sale_tax=0.0]
	, Product [id=27debb81-69b2-4a88-b39a-54fc2f08287b, description=food chocolate bar, prize=0.85, imported=false, tax_exempt=true, sale_tax=0.0]
	], totalPrize=0.0, totalTaxes=0.0]
	
	order1 after apply rules: 
	Order [id=0bffcfc3-9b2f-4765-9bc9-7cb521e6c313
	, products=[Product [id=aaa7e492-ccdf-45da-a93b-ae711bd5d633, description=book, prize=12.49, imported=false, tax_exempt=true, sale_tax=0.0]
	, Product [id=e3abe82c-148a-4a1a-ba98-538d127edbdf, description=Music CD, prize=14.99, imported=false, tax_exempt=false, sale_tax=1.499]
	, Product [id=27debb81-69b2-4a88-b39a-54fc2f08287b, description=food chocolate bar, prize=0.85, imported=false, tax_exempt=true, sale_tax=0.0]
	], totalPrize=29.829, totalTaxes=1.499]
	
	 >>> Rule Fired for Object: 
	Order [id=028af9eb-72f9-4fc9-9bfd-38c2e80ed6c0
	, products=[Product [id=20870c9b-f0ce-455c-9f4b-2bfcdf6be1a8, description=imported food box of chocolate, prize=11.25, imported=true, tax_exempt=true, sale_tax=0.0]
	, Product [id=a8a3c21b-6cad-463b-8963-29f53efc57de, description=imported bottle of perfume, prize=27.99, imported=true, tax_exempt=false, sale_tax=0.0]
	, Product [id=d5687ed3-d17e-4d4a-9aac-ae71539a399a, description=packet headache pills, medical, prize=9.75, imported=false, tax_exempt=true, sale_tax=0.0]
	, Product [id=e97d8a0c-bd49-4a9a-8ae9-38497246d0bf, description=bottle of perfume, prize=18.99, imported=false, tax_exempt=false, sale_tax=0.0]
	], totalPrize=0.0, totalTaxes=0.0]
	
	order3 after apply rules: 
	Order [id=028af9eb-72f9-4fc9-9bfd-38c2e80ed6c0
	, products=[Product [id=20870c9b-f0ce-455c-9f4b-2bfcdf6be1a8, description=imported food box of chocolate, prize=11.25, imported=true, tax_exempt=true, sale_tax=0.5625]
	, Product [id=a8a3c21b-6cad-463b-8963-29f53efc57de, description=imported bottle of perfume, prize=27.99, imported=true, tax_exempt=false, sale_tax=4.198499999999999]
	, Product [id=d5687ed3-d17e-4d4a-9aac-ae71539a399a, description=packet headache pills, medical, prize=9.75, imported=false, tax_exempt=true, sale_tax=0.0]
	, Product [id=e97d8a0c-bd49-4a9a-8ae9-38497246d0bf, description=bottle of perfume, prize=18.99, imported=false, tax_exempt=false, sale_tax=1.899]
	], totalPrize=74.64, totalTaxes=6.659999999999999]
	
	 >>> Rule Fired for Object: Hi There From Test!
	 >>> Rule Fired for Object: 
	Order [id=a7cb12c6-0cea-4735-aca3-939ac8b9a189
	, products=[Product [id=99363c89-5122-4c22-acc2-1fdb42e38397, description=imported food box of chocolate, prize=10.0, imported=true, tax_exempt=true, sale_tax=0.0]
	, Product [id=58c87774-d912-42df-9324-261d0ad02680, description=imported bottle of perfume, prize=47.5, imported=true, tax_exempt=false, sale_tax=0.0]
	], totalPrize=0.0, totalTaxes=0.0]
	
	order2 after apply rules: 
	Order [id=a7cb12c6-0cea-4735-aca3-939ac8b9a189
	, products=[Product [id=99363c89-5122-4c22-acc2-1fdb42e38397, description=imported food box of chocolate, prize=10.0, imported=true, tax_exempt=true, sale_tax=0.5]
	, Product [id=58c87774-d912-42df-9324-261d0ad02680, description=imported bottle of perfume, prize=47.5, imported=true, tax_exempt=false, sale_tax=7.125]
	], totalPrize=65.125, totalTaxes=7.625]
	
	Tests run: 4, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 1.473 sec
	
	Results :
	
	Tests run: 4, Failures: 0, Errors: 0, Skipped: 0
	
	[INFO] ------------------------------------------------------------------------
	[INFO] BUILD SUCCESS
	[INFO] ------------------------------------------------------------------------
	[INFO] Total time:  2.485 s
	[INFO] Finished at: 2019-12-14T20:05:11+01:00
	[INFO] ------------------------------------------------------------------------
	
## Consideraciones

	La decisión de usar este framework es para poder separar claramente la lógica de negocio en forma 
	de fichero con reglas de negocio, de manera que se aplican esas reglas a 
	los objetos que permanecen en la zona de memoria de acción del framework. 
	
	Este objeto en la aplicacion se llama kSession y tiene embebido el fichero de reglas.
	
	Además, al usar el framework un motor de inyeccion de dependecias, éste puede ser usado de multiples
	maneras, pués podremos inyectarlo, por ejemplo, en un objeto controlador síncrono que atienda 
	peticiones restfull, un publicador/subscriptor de algún sistema de mensajería 
	asíncrono, etc...
	
	De esta manera, el código es más limpio, mucho más que hacer desde cero un nuevo motor de reglas o 
	embeber en el código las reglas, en mi humilde opinión.
	   
## Para hacer más adelante

	Conseguir un redondeo más ajustado.

	Aplicar el patron Factory para crear las ordenes y los productos.

	Controlador web REST que acepte peticiones POST con los datos que representen a los productos de 
	una orden y devuelva los datos actualizados de dicha orden.
	
	Publicador kafka que inyecte en un topic los datos de una orden.
	
	Consumidor kafka que recoja los datos de la orden, cree el objeto Order con una lista de productos 
	y use el objeto inyectado kSession para insertar en el motor de reglas.
	
	De esta manera, podemos distribuir la carga de peticiones, pues podremos tener tantos productores 
	consumidores como necesitemos para poder atender la demanda.

	Una mezcla de las dos variantes, de manera que así podamos dar servicio a tantos clientes web de 
	una manera síncrona y escalable. Lo mejor de ambos mundos.
	
	Contenedor Docker para una plataforma PAAS, escalable.
	
	Una manera de inyectar un nuevo fichero de reglas una vez que la aplicación está cargada en memoria, 
	de manera que el equipo puede generar un nuevo fichero de reglas que aplique a los objetos de 
	negocio, evitando al máximo la necesidad de recompilar el proyecto, bajar todos los contenedores 
	Docker, y así minimizar el tiempo en el que el sistema no está disponible.
	  
## Enlaces interesantes

	https://www.drools.org

	https://es.wikipedia.org/wiki/Drools
	
	https://www.arquitecturajava.com/usando-el-patron-factory/