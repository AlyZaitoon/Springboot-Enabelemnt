# Springboot-Enablement
This repository represents the work done during my training period
# Springboot well known annotations
@RestController => RestController is used for making restful web services with the help of the @RestController annotation. This annotation is used at the class level and allows the class to handle the requests made by the client.<br/>
@RequestMapping => RequestMapping annotation is used to map web requests onto specific handler classes and/or handler methods.<br/>
@RequestParam => @RequestParam annotation enables spring to extract input data that may be passed as a query, form data, or any arbitrary custom data. For example http://localhost:8080/add?name=ahmed&subject=math<br/>
@PathVariable => @PathVariable is a Spring annotation which indicates that a method parameter should be bound to a URI template variable. For example http://localhost:8080/delete/123151231215<br/>
@Repository=> mark a class as a repository. A repository is a class that provides access to data storage<br/>
@Service=> mark a class a service.A service is a class that provides business logic<br/>
@Autowired=> Used to handle dependency injection/inject components<br/>
@Qualifier=> used to determine which component will be used/injected
# Springboot actuator important links 
http://localhost:8080/actuator => show links and health<br/>
http://localhost:8080/actuator/health =>show server status<br/>
http://localhost:8080/actuator/mappings =>show all mappings inside app<br/>
# Springboot layers and thier functionalties
<img src="https://i.ytimg.com/vi/QYDHxlpr04U/sddefault.jpg" />
1. Controller Layer receives the requests from the clients (Front End) by the @RequestMapping annotation <br/>
2. Service Layer includes the buisness logic Ex: Payment services, Cart services <br/>
3. DAO/Repository Layer (Data access objects) it is used to access data from Database or Fake Dummy Data<br/>
# Spring framework notes
<ul>
  <li>Spring framework was designed to decouple depedencies of application classes via dependency injection. For example: Drawing has a shape. This shape can be triangle, circle which means that it can be changed at runtime.</li>
  <li>Spring container manages objects inside it only</li>
  <li>Spring framework works with factory pattern which means when an object is requested , the bean factory/ Application Context will look up the spring xml configuration file for the blueprint of the requested object and then will return the new object </li>
  <li>Before the introduction of springboot , programmers using spring had to write a xml file defining the blue prints of the objects so that when they use the bean factory it is able to create the objects </li>
  <li>To add an attribute we use property tag in the xml which uses the setters of the class</li>
  <li>If i want to set an attribute in the constructor then constructor-arg is used and this allows to add more than one argument note: Spring can convert string to integer according to the constructor that is eligible ex: 20 can be integer or string. And by default spring convert 20 to integer if the string is required, type=java.lang.String can make it string. Index can be used to determine which argument is assigned to which </li>
<li>The previous two were settings attributes by dependency injection. Dependency injection for objects can be also done by Spring using the xml. Assume that a class named triangle has 3 objects of Point class. In the XML, 3 Points beans are inserted and triangle bean is inserted with 3 property tags that reference 3 points beans using “ref” instead of value. 
An important note: that getBean for the triangle will also get the others so it isn’t necessary to make 3 getBeans for the points, only one getBean(‘triangle’) is enough</li>
<li>Next 2 points are naming facilities: InnerBean & Alias. Also id and name can be used to change the name</li>
<li>If i have 3 points and 2 of them is used only inside the triangle then InnerBean can be used for this case and these 2 points will be inserted inside the triangle bean as follows
<bean id=”triangle” class=”org.demo.company.Triangle”>
  <property name=”point2”>
    <bean id=”point0” class=”org.demo.company.Point”>
      <property name=”x” value=”20”/>
    </bean>
  </property>
</bean>
InnerBean is used to isolate the bean where it is required. Note that there is no performance difference by using the InnerBean</li>
<li>Alias can be used to name beans</li>
<li>To restrict the reference to only id: 
<property name=”pointA”>
  <idref=”zeroPoint”/>
</property></li>
<li>Collections can be used, for example: a list of ref beans can be used</li>
<li>Autowire can be added in bean to make it access other bean autowire=”byName” which means that objects in the class should have the same name as in the xml file
<bean id=”triangle” class=”org.demo.company.Triangle” autowire=”byName”></li>
<li>Autowire can be used by type but each bean/object should have different type
<bean id=”triangle” class=”org.demo.company.Triangle” autowire=”byType”></li>
<li>Autowire can be used by constructor
<bean id=”triangle” class=”org.demo.company.Triangle” autowire=”constructor”></li>
<li>When the application starts, application context refers to the spring.xml before getBean. When it refers to the spring.xml, it looks at all beans and creates them by itself and will initialize them.
After that, when any object request an object (getBean), the application context will return the bean</li>

<li>There are two basic scope bean:
-Singleton: When spring container/application context is initialized, it will look in the XML. It’s going to look in the beans in the XML and will initialize one bean per bean definition no matter how many calls are made
-Prototype: a new bean is created every request or reference</li>
<li>There are web-aware scopes because spring ties well with web applications like Servlet (java class that handles http requests) and JSP (technology that embed java code in HTML page). Spring knows if a request is received and bean can be tied to the request or the session as follows:
-Request: new bean per servlet request
-Session: new bean per session (as long as one customer per session)
-Global Session: new bean per global http session (portlet context)</li>
<li>Default bean scope is singleton</li>
<li>ApplicationContext or BeanFactory is used to initialize Spring Container using configuration “spring.xml”</li>
<li>Inorder for a bean to be aware of the application context that is running, we can implement ApplicationContextAware. This is useful for beans that need to access other beans or if a singleton bean has a reference to prototype bean(s)
This can allows creating new beans for Point each time the triangle class is created and it allows accessing other beans</li>
<li>>There is bean definition inheritance which allows one bean to inherit a property from the parent bean. Parent bean can have a list that is inherited by another bean. If the child bean has a list then it will overwrite the parent bean, a merge can be used to merge the list of the child bean with the list of the parent bean. If you want the parent bean to be a template which means that there is no bean created then you will have to make it abstract</li>
<li>Abstract Application Context register a shutdown hook to close contexts, a register for context.registerShutdownHook() is needed to know when the bean is destroyed. Also there are some interfaces that can be implemented like InitializingBean which has a method that is called when the bean is created. There is a Disposable interface which has a method that is called when the bean is destroyed</li>
<li>A method can be called when a bean is initialized either by using InitializingBean or by using configuration file by adding an init-method=”methodName” or a destroy-method=”methodName”</li>
<li>A default init method and a default destroy method can be made by writing them in the beans tag which make all the children beans have these methods
As mentioned before, beans can be tracked by interfaces or configuration files. In this case the interfaces method will be called before the configuration file </li>
<li>BeanPostProcessor are classes that tell spring that there is some processing that spring needs to do after initializing the beans and this allows the execution of a method after the bean is initialized.
Method run for every bean in the spring.xml and BeanPostProcessor is a separate class which have runs on initializations of different beans in spring.xml
</li>
<li>
BeanPostProcessor can be called before initialization or after initialization. This can be done by making a class as mentioned above and adding the bean in the spring.xml
Note: BeanPostProcessor requires that the programmer should write the methods, on the other hand BeanFactoryProcessor has some ready to use beans.</li>
<li>
There is a BeanFactoryPostProcessor which has methods that  are out of the box. A class should be written that implements BeanFactoryPostProcessor and also a tag bean should be added to the spring.xml
Note that the BeanFactoryPostProcessor is initialized before initializing the beans
There are some ready beans like PropertyPlaceHolderConfigurer which can be used to set values/placeholders in the spring.xml to values in a config file
Placeholder is written like this value=’${pointA.pointX}’
Bean should be added in the spring.xml in order to work and provide the path of the file in a property tag
All this is done before initializing of the bean</li>
<li>Annotations can be used to tell spring. For example @Required annotation is used to tell spring that a property/ref is required for a set method in order to work
BeanFactoryPostProcessor is used to verify that all @Required are initialized correctly as it will check that all @Required are met and if they aren’t then it will throw an exception</li>
<li>@Autowired can be used to reference a bean that is inside the spring.xml file but the annotation’s bean should be written in spring.xml file but this is done if there is only one bean for the needed type otherwise it will search for a name similar to the one in the class and if doesn’t find there will be an error.</li>
<li>@Qualifier can be used to rename the setter in the class to match the bean in the spring.xml (tag qualifier value=”name”)
Note that: config should be added to allow all xml elements/namespaces/tags to work like: qualifier
Note: a tag can be added to add all BeanPostProcessor like AutoWiredAnnotation </li>
<li>There is JSR annotation which stands for Java Specification Request which have some annotations 
@Resource(name=”beanName”)
@PostConstruct in which method is called after the bean is created
@PreDestroy in which method is called before the bean is destroyed</li>
<li>There is a stereotype annotation @Component that tells spring that this is a bean but a tag should be added to the spring.xml to tell spring to scan the code for annotations.
Stereotype annotation tell spring what role is the bean playing</li>
<li>Spring has event handling that listen to different events
Ex: ApplicationListener is used to listen to different events in the application and it prints every event that happens
To publish events there are two things that should be made:
-We need an event class    -We need to publish the event in a bean (in a method)
A publisher is needed to publish the event for example: class circle need to publish an event draw so it will have a publisher in its attribute and it will call it when needed
ApplicationEventPublisherAware is need to set the publisher to be used</li>

  

</ul>


