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
  <li></li>
</ul>


