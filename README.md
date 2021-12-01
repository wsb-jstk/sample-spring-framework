# Introduction to Spring Framework

Napisz aplikację, która:

- [x] wyświetli listę wszystkich dostępnych produktów na magazynie
- [x] zmniejszy ilość produktów na magazynie
- [x] jeśli ilość produktów na magazynie spadnie do 10 - aplikacja opublikuje zdarzenie, tak aby inne aplikacje, które
  użyją tego kodu, mogły to zdarzenie przechwycić i zalogować ten fakt
- [x] jeśli ilość produktów na magazynie spadnie do 0 - aplikacja wyśle maila z ostrzeżeniem
    - do testow, mozesz sprobowac uzyc ponizsze skrzynki tymczasowe
        - [Mailtrap](https://mailtrap.io/)
            * Przykladowa konfiguracja w Spring Boocie:

```properties
spring.mail.host=smtp.mailtrap.io
spring.mail.port=2525
spring.mail.username=[user]
spring.mail.password=[password]
spring.mail.properties.mail.smtp.auth=true
spring.mail.properties.mail.smtp.starttls.enable=true
```

        - [Mailinator](https://www.mailinator.com/)

- [x] policzy czas wykonywania się operacji zmniejszania ilości produktów na magazynie. Zaloguj informacje:
    - [x] jak dlugo wykonywala sie operacja
    - [x] z jakimi parametrami zostala wywołana metoda
- [ ] zamiast uzywac `AssignmentRunner`, stworz endpointy, ktore beda obslugiwaly:
    - [x] GET /inventory - lista wszystkich produktow
    - [ ] POST /inventory/[name] - zaktualizuje produkt o podane w Body wartosci
- [ ] napisz Filtr, który będzie logował IP osoby, która wywołuje request

# Working with Tomcat

* download Tomcat from [Apache Tomcat](https://tomcat.apache.org/).
    * You can use [versions](https://tomcat.apache.org/whichversion.html) to check, which version You really need
* unzip it
* set system paths:
    * CATALINA_HOME - pointing to Your unzipped directory (for ex
      to `C:\WKSPC_local\Project_Java\bin\apache-tomcat-9.0.55`)
    * Path - add `%CATALINA_HOME%\bin` so You will be able to call `catalina` from the command line
* open command line (not git bash!) and enter `catalina` to see, if the path was correctly added. You should see some
  output, similar to below:

```
C:\Users\mlipski>catalina
Using CATALINA_BASE:   "C:\WKSPC_local\Project_Java\bin\apache-tomcat-9.0.55"
Using CATALINA_HOME:   "C:\WKSPC_local\Project_Java\bin\apache-tomcat-9.0.55"
Using CATALINA_TMPDIR: "C:\WKSPC_local\Project_Java\bin\apache-tomcat-9.0.55\temp"
Using JRE_HOME:        "C:\Users\mlipski\.jdks\adopt-openjdk-11.0.11"
Using CLASSPATH:       "C:\WKSPC_local\Project_Java\bin\apache-tomcat-9.0.55\bin\bootstrap.jar;C:\WKSPC_local\Project_Java\bin\apache-tomcat-9.0.55\bin\tomcat-juli.jar"
Using CATALINA_OPTS:   ""
Usage:  catalina ( commands ... )
commands:
  debug             Start Catalina in a debugger
  debug -security   Debug Catalina with a security manager
  jpda start        Start Catalina under JPDA debugger
  run               Start Catalina in the current window
  run -security     Start in the current window with security manager
  start             Start Catalina in a separate window
  start -security   Start in a separate window with security manager
  stop              Stop Catalina
  configtest        Run a basic syntax check on server.xml
  version           What version of tomcat are you running?
```

* In order to manage applications, You have to first create a user with appropriate privileges -
  open `%CATALINA_HOME%/conf/tomcat-users.xml` file and add entries:
    * Users:
        * tomcat-gui will be used to manage application from the WWW
        * tomcat-script will be used to deploy app with scripts (for example Maven plugin tomcat9-maven-plugin)
    * Roles:
        * `admin-gui` - access to [Tomcat Virtual Host Manager](http://localhost:8080/host-manager/html)

```
<user username="tomcat-gui" password="tomcat" roles="manager-gui,admin-gui"/>
<user username="tomcat-script" password="tomcat" roles="manager-script"/>
```

* start Tomcat with `catalina start` - Tomcat will start working on port 8080
    * if You need to use debugger, You can use `catalina jpda start` instead (this will start Tomcat with
      params `-agentlib:jdwp=transport=dt_socket,address=8000,server=y,suspend=n`)

```
18:00:25.786 INFO [main] org.apache.catalina.startup.HostConfig.deployDirectory Deploying web application directory [D:\Project_Java\bin\apache-tomcat-9.0.43\webapps\ROOT]
18:00:25.805 INFO [main] org.apache.catalina.startup.HostConfig.deployDirectory Deployment of web application directory [D:\Project_Java\bin\apache-tomcat-9.0.43\webapps\ROOT] has finished in [19] ms
18:00:25.810 INFO [main] org.apache.coyote.AbstractProtocol.start Starting ProtocolHandler ["http-nio-8080"]
18:00:25.820 INFO [main] org.apache.catalina.startup.Catalina.start Server startup in [958] milliseconds
```

* You can access Tomcat on [http://localhost:8080/](http://localhost:8080/)
* Now You can open the [http://localhost:8080/manager/html](http://localhost:8080/manager/html) and
  enter `tomcat-gui/tomcat` to manage apps

## Known issues

- By default, server is staring under 8005 port (defined in `/conf/server.xml`). If this port is not accessible for You,
  You will see below error message. To avoid it - simply change 8005 to other port, such as 8006

```
01-Dec-2021 14:40:18.288 SEVERE [main] org.apache.catalina.core.StandardServer.await Failed to create server shutdown socket on address [localhost] and port [8005] (base port [8005] and offset [0])
	java.net.BindException: Address already in use: NET_Bind
```

# Articles

* [Spring Framework](https://spring.io/)
    * [Core Technologies](https://docs.spring.io/spring-framework/docs/current/reference/html/core.html)
    * [API](https://docs.spring.io/spring-framework/docs/current/javadoc-api/)
* [Baeldung](https://www.baeldung.com/)
* [Apache Tomcat](https://en.wikipedia.org/wiki/Apache_Tomcat)
    * [Debugging Tomcat9 in IntelliJ when running it as a separate app](https://blog.trifork.com/2014/07/14/how-to-remotely-debug-application-running-on-tomcat-from-within-intellij-idea/)
