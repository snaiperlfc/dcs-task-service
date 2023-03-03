# Getting Started

### Docker Compose Classic (Local)

The `docker-compose.yml` file that is in the root directory of this project will provide you with a `v3.3` Docker
Compose manifest that you can use to run this application locally or to deploy to Kubernetes/Docker Swarm. To run this
example locally, without using a container orchestrator, just run the following commands.

```bash
docker-compose up -d
docker-compose logs -f
```

You'll see a flurry of system logs flash before your eyes as multiple containers in a distributed system begin to spin
up and start. It is recommended that you wait until the logging comes to a slow halt. In another tab, ensure that all of
the containers are running using the following command.

```bash
docker-compose ps
```

Access Grafana via your web browser at `http://localhost:8080`

Enter the credentials below to authenticate.

```text
    Username: admin
    Password: password
 ```

After signing in, there are two dashboards available for you to start monitoring the different applications. You can
start by navigating to the `Micrometer JVM Statistics` dashboard, which provides the most important information about
how a JVM application is running. This dashboard has been designed specifically for Kubernetes, allowing you to select
an `application` and either a single `instance` or `all` instances. When selecting `all` instances, the dashboard will
create a panel for each `instance` of your chosen `application`.

![Micrometer JVM Statistics](https://i.imgur.com/6Yl6E3K.png)

In the screenshot above, you can see a few of the metrics that are visible for a single instance of the `user-service`.
Notice how the *CPU Usage* is near 100%. This is because the shell script for parallel execution is being used to scale
test the social network. You can try this by running the script locally on your machine.

```bash
sh ./deployment/sbin/generate-parallel.sh
```

Create new task run the following commands:

````bash
curl -L 'http://localhost:8080/task' -H 'Content-Type: application/json' -d '{
    "text": "Google AdWords Strategy 1",
    "startDate": "2023-03-03 00:01:49.815",
    "endDate": "2023-03-03 00:05:49.815",
    "assigneeId": 3,
    "priorityId": 2
}'
````

Get all tasks run the following commands:

````bash
curl -L 'http://localhost:8080/task'
````

Search by start date run the following commands:

````bash
curl -L 'http://localhost:8080/task/search/findByStartDateAfter?start=2023-03-03%2003%3A05%3A00.000'
````

### Reference Documentation

For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.7.9/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.7.9/maven-plugin/reference/html/#build-image)
* [Spring Configuration Processor](https://docs.spring.io/spring-boot/docs/2.7.9/reference/htmlsingle/#appendix.configuration-metadata.annotation-processor)
* [Rest Repositories](https://docs.spring.io/spring-boot/docs/2.7.9/reference/htmlsingle/#howto.data-access.exposing-spring-data-repositories-as-rest)
* [Prometheus](https://docs.spring.io/spring-boot/docs/2.7.9/reference/htmlsingle/#actuator.metrics.export.prometheus)
* [Spring Data Reactive MongoDB](https://docs.spring.io/spring-boot/docs/2.7.9/reference/htmlsingle/#data.nosql.mongodb)

### Guides

The following guides illustrate how to use some features concretely:

* [Accessing JPA Data with REST](https://spring.io/guides/gs/accessing-data-rest/)
* [Accessing Neo4j Data with REST](https://spring.io/guides/gs/accessing-neo4j-data-rest/)
* [Accessing MongoDB Data with REST](https://spring.io/guides/gs/accessing-mongodb-data-rest/)
* [Accessing Data with MongoDB](https://spring.io/guides/gs/accessing-data-mongodb/)

