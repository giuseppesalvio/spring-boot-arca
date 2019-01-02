# Cose da fare
* Capire come intervengono i vari componenti (Feign, Ribbon, Eureka, Zuul)

> ##### Feign
> Semplifica la costruzione di client di webservices.
> Si usano interfacce annotate, simili ai repository in Spring JPA.
> Feign usa Ribbon.
> 
> ##### Eureka
> Naming server.
> 
> ##### Ribbon
> Client-side load balancer.
> Basato su "named clients"
> Fornisce:
> * service discovery: usa Eureka di default
> * load balancing: secondo regole out-of-the-box o customizzabili; fra quelle out-of-the-box abbiamo:
>   * Simple Round Robin LB
>   * Weighted Response Time LB
>   * Zone Aware Round Robin LB
>   * Random LB
> * fault tolerance: usa Hystrix come circuit breaker
> * caching
> * multiple protocol (HTTP, TCP, UDP)
> 
> Info:
> * [client-side-load-balancing](https://spring.io/guides/gs/client-side-load-balancing/)
> * [spring-cloud-netflix-load-balancer](http://salerno-rafael.blogspot.com/2016/09/spring-cloud-netflix-load-balancer-with.html)
> * [working-with-load-balancers](https://github.com/Netflix/ribbon/wiki/Working-with-load-balancers#components-of-load-balancer)
> 
> ##### Zuul
> Application gateway.
> Supporta authentication, routing, filtering, load balancing.
> Si integra con Ribbon per il load balancing.
> 
> ##### Hystrix
> Libreria per latency/fault tolerance.
> Non più in sviluppo, solo mantenimento.

* Come configurare il load balancing

> <client-name>.ribbon.NFLoadBalancerRuleClassName = ...
> ribbon.NFLoadBalancerRuleClassName = ...

Per la prossima demo
--------------------
* (i servizi forex+conversion vanno bene)
* Capire come gestire l'hot swap di versione di un servizio
* Front-end Angular

Altri temi
----------
* Config Eureka refresh a fronte di down srv
* Config circuit breaker
** Capire come evitare HTTP 504 in caso di down di servizio (LB non redirige il traffico immediatamente sulle istanze superstiti)
* **Spring Cloud Sleuth**: distributed tracing
* **Zipkin**: tracing collector (HTTP server) -- usare spring-cloud-sleuth-zipkin
