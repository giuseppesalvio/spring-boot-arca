# Cose fatte
* Capire come intervengono i vari componenti (Feign, Ribbon, Eureka, Zuul, Hystrix, Zipkin)

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
> Basato su "named clients".
> Fornisce:
> * service discovery: usa Eureka di default
> * load balancing: secondo regole out-of-the-box o customizzabili; fra quelle out-of-the-box abbiamo:
>   * Simple Round Robin LB
>   * Weighted Response Time LB
>   * Zone Aware Round Robin LB
>   * Random LB
>   * Retry (con Round Robin di default)
> * fault tolerance: usa Hystrix come circuit breaker
> * caching
> * multiple protocol (HTTP, TCP, UDP)
> * circuit breaker
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
>
> ##### Zipkin
> Applicazione per distributed tracing.
> Si tratta di un log collector: registra sequenze di chiamate HTTP fra applicazioni.
> Contiene un motore di ricerca per individuare trace specifici.
> Registra dipendenze fra servizi in base al traffico osservato in una finestra temporale specificata.

* Come configurare il load balancing
> `<client-name>.ribbon.NFLoadBalancerRuleClassName = ...`
> `ribbon.NFLoadBalancerRuleClassName = ...`

* Preparare progetto POC
> [Struttura progetto](https://docs.google.com/drawings/d/1l7Am3nHJqjSYvjKBUiroqssNSLQzXHb-j8noKkNNUUU/edit?usp=sharing)

* Capire come gestire l'hot swap di versione di un servizio
> [Strategia](https://docs.google.com/drawings/d/1qhWYa_wOuLFtjJWA4nvn-6mlHM7JoMRukRHXvyyeSew/edit?usp=sharing)

* Front-end Angular
* Spring Session
> Configurato DB condiviso da tutte le istanze/applicazioni (H2 con AUTO_SERVER)
* **Spring Cloud Sleuth**: distributed tracing (intercetta chiamate HTTP e invia trace a Zipkin)
* **Zipkin**: tracing collector (HTTP server con UI)

* Studiare SAGA pattern (transazioni distribuite)
> * Events/choreography:
>   * [happy-path](https://blog.couchbase.com/wp-content/uploads/2018/01/Screen-Shot-2018-01-09-at-6.13.39-PM-768x817.png)
>   * [rollback-on-error](https://blog.couchbase.com/wp-content/uploads/2018/01/Screen-Shot-2018-01-09-at-6.36.17-PM-768x526.png)
> * Command/Orchestration:
>   * [happy-path](https://blog.couchbase.com/wp-content/uploads/2018/01/Screen-Shot-2018-01-11-at-7.40.54-PM-768x470.png)
>   * [rollback-on-error](https://blog.couchbase.com/wp-content/uploads/2018/01/Screen-Shot-2018-01-11-at-7.41.06-PM-768x489.png)

Cose da vedere ancora
---------------------
* Config Eureka refresh a fronte di down srv
* Config circuit breaker
** Capire come evitare HTTP 504 in caso di down di servizio (LB non redirige il traffico immediatamente sulle istanze superstiti)
* Sleuth/Zipkin: capire come puntare a Zipkin non in localhost da un servizio (property su config server)
