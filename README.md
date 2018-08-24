# pebbles-gateway
Gateway Service (Zuul) application for the Pebbles Microservice Ecosystem

# Sprint 1 Final Thoughts - 8/24/18

- Brandon Scoggins | 1806-Jun-USF-Java | Wezley Singleton

The Zuul Gateway service is fully operational, and contains a centralized Docket for swagger documentation for all of its registered
services. Any future services will need to be registered with the gateway in it's application.yml file (for gateway functionallity), 
and in the DocumentationController.java file (for integration into the centralized swagger doc). 

Future sprints may want to replace the functionallity of this service by using AWS Application Load Balancer.
