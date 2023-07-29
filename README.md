# Springboot-Enablement
This repository represents my work during my training period
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
