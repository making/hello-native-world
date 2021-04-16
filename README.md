# Deploy a spring native image to Azure Functions

## Run the application without Azure Function

```
./mvnw clean package -DskipTests
java -jar target/hello-world-0.0.1-SNAPSHOT.jar
```

```
$ curl "http://localhost:8080/api/hello?name=Native"
{"id":1,"message":"Hello Native!","uptime":"PT4.751S"}
```

## Run Azure Functions locally

> GraalVM and `JAVA_HOME` must be installed and configured in advance for this instruction.

```
./mvnw clean package azure-functions:run -DskipTests -Pnative
```

```
$ curl "http://localhost:7071/api/hello?name=Native"
{"id":1,"message":"Hello Native!","uptime":"PT4.751S"}
```


## Deploy to Azure Functions

> Docker in required but **GraalVM is not needed** for this instruction.

```
az login
./mvnw clean spring-boot:build-image antrun:run@copy-image azure-functions:deploy -DskipTests -DfunctionResourceGroup=demo -DfunctionAppName=hello-spring-native -DfunctionAppRegion=japaneast
```

```
$ curl "https://hello-native-world.azurewebsites.net/api/hello?name=Native"
{"id":1,"message":"Hello Native!","uptime":"PT4.751S"}
```