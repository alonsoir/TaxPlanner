# TaxPlanner

## Introduccion

	Proyecto para demostrar el calculo de impuestos a una serie de productos pertenecientes a una orden.

	Los productos van a tener un precio mas un impuesto, dependiendo de si el producto es 
	importado (5%) o no, y si está exento de pagar impuestos o no (10%). 

	Los exentos son productos como libros, comida y medicinas.

	El problema está resuelto usando el framework DROOLS y java8, un sistema de gestión de 
	reglas de negocio, el cual permite crear las reglas de negocio en forma de fichero .drl,
	de manera que un equipo de negocio puede crear dicho fichero usando una herramienta 
	o también se puede generar a mano, guardandolo en la carpeta src/main/resources.

	Se ha escrito una clase con un test unitario que demuestra la hipótesis de inicio.
	
	Ejecutad el test, por favor. (mvn test)

# Prerequisitos

	java8 como mínimo y maven

	Last login: Sat Dec 14 20:07:37 on ttys002
	aironman@MacBook-Pro-de-Alonso TaxPlanner % fish
	Welcome to fish, the friendly interactive shell
	aironman@MacBook-Pro-de-Alonso ~/e/TaxPlanner> java -version
	openjdk version "13.0.1" 2019-10-15
	OpenJDK Runtime Environment (build 13.0.1+9)
	OpenJDK 64-Bit Server VM (build 13.0.1+9, mixed mode, sharing)
	aironman@MacBook-Pro-de-Alonso ~/e/TaxPlanner> mvn --version
	Apache Maven 3.6.2 (40f52333136460af0dc0d7232c0dc0bcf0d9e117; 2019-08-27T17:06:16+02:00)
	Maven home: /usr/local/Cellar/maven/3.6.2/libexec
	Java version: 13.0.1, vendor: Oracle Corporation, runtime: /Library/Java/JavaVirtualMachines/openjdk-13.0.1.jdk/Contents/Home
	Default locale: es_ES, platform encoding: UTF-8
	OS name: "mac os x", version: "10.15.1", arch: "x86_64", family: "mac"
	
## Como se compila y ejecuta.

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
	
	Importante!!
	El último test, el de la orden3, he aplicado un valor delta en el test de 0.051 por la siguiente razón:
	
	Ese producto, "imported food box of chocolate", 11.25f, esta exento and es importado, por lo que le
	toca aplicar una tasa del 5%. Por lo que, las cuentas son asi:
			11.25 * 5/100 = 0.5625 de tasa del producto, redondeado, queda en 0.56
			11.25 + 0.5625 = 11.8125 precio total aplicado impuestos
			
	Que redondeado hacia arriba queda en 11.85, como pone en el output propuesto con un tax_sale calculado de 0.56.
	Ahora, si sumamos, 11.85 + 9.75 + 20.89 + 31.19 da un total de 74.68 y si sumamos 0.56 + 4.2 + 1.9 da 6.66, 
	que redondeado da 6.70 como pone en el enunciado. 
		
	La verdad es que este caso especial me ha dejado confundido y no se si es error a proposito de su parte para que
	me diera cuenta o es un error mío, porque si aplico la lógica pedida en el enunciado, es decir,
	"aplicar un sale_tax redondeado a cada producto del 0.05" y mostrar dos decimales en los resultados finales,
	creo que la lógica aplicada en los objetos java Order y Product es la correcta, y si no lo es, y los números 
	calculados para este producto en concreto, necesitan comprobar si están entre el valor delta y su valor original, 
	en cuyo caso, redondeo hacia arriba o hacia abajo. Como no lo tengo claro, lo dejo indicado, con el deseo de dejar 
	constancia del razonamiento. 
		
	En la vida real habría que tomar una decisió u otra y no se si estaría autorizado a tomar dicha decisión. 
	Hablamos del dinero de la compañia y no es cosa baladí.
	 
		
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
	
	Por motivos de simplicidad, asumí que los productos vienen uno a uno. Está simulado de esa manera usando
	una clase Utilities. En el mundo real es posible que vengan de otra manera, soy consciente.
	
	Por motivos de simplicidad, asumí que un producto es importado si aparece imported en su descripción, 
	activando un campo booleano para un uso claro y eficiente en la regla de negocio. 
	Es mucho más eficiente y rápido en tiempo de ejecución comparar muchas veces un campo booleano que comparar 
	muchas veces una cadena de caracteres.
	 
	Por motivos de simplicidad para este test, decidí que un producto está exento en función de la descripción,
	de manera que asumo que si aparece book, food o medicine en la descripción, se activa el campo booleano.
	
	Por supuesto, en el mundo real, puede ser que hubiera que decidir si un producto real está exento o no, 
	en base a una lógica más complicada. Tal y como están planteados los datos de entrada, soy consciente 
	que uno de los productos no tiene food para referirse al chocolate importado, por lo que asumo que es
	un error de transcripción. 
	
	En el mundo real, me aseguraría si realmente los productos vienen con una descripción tan holgada,
	en caso de ser así, habría que programar una lógica mucho más exhaustiva, teniendo en cuenta todos los
	posibles casos a nivel de número de idiomas posibles, si hubiera más campos que me permitieran determinar si
	un producto es de un tipo u otro, tendría que ser sensible a los posibles errores de escritura, como que 
	apareciera fod en vez de food, ocolate en vez de chocolate, cosas asi.
	
	A lo mejor habría que mantener una lista con los productos realmente exentos, más allá de que en la descripción
	aparezca food, medicine o books, pero esa lista podría llegar a ser monstruosamente grande, ya que, cuantas
	comidas, libros y medicinas en los distintos idiomas hay en el mundo? millones?. 
	Lo mejor desde el punto de vista del rendimiento y velocidad de ejecución sería que el producto viniera marcado 
	como tal desde origen como exento o no.
	
	El proposito del test es demostrar que en función de dos campos booleanos, se puede escribir una regla que hasta
	un no programador pudiera entender, para poder separar bien la lógica de negocio y tener un código lo más limpio
	y elegante posible.  
	
	
	   
## Para hacer más adelante

	Conseguir un redondeo más ajustado. Ver el método estático Utilities.redondearDecimales.

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