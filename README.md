# Graceful shutdown test

1. Download honeycomb java agent
```
curl -L https://github.com/open-telemetry/opentelemetry-java-instrumentation/releases/download/v2.13.3/opentelemetry-javaagent.jar -o otel-agent.jar 
```
2. Build app
```
./gradlew build
```
3. Copy and set environment variables
```
cp template-otel.properties otel.properties
```
4. Run app
```
java -Dotel.javaagent.configuration-file=otel.properties -javaagent:otel-agent.jar -Dservice.name=test-service -jar build/libs/graceful-shutdown-test.jar
```
5. Curl the wait endpoint and you should see the trace in honeycomb. It will take 10 seconds to complete.
```
curl http://localhost:8080/wait
```
6. Curl the wait endpoint again and terminate the running app while the request is being processed. 
The app will gracefully shutdown and fully terminate after serving the request but the trace will not exist in honeycomb.