# Graceful shutdown test

1. Download honeycomb java agent
```
curl -L https://github.com/honeycombio/honeycomb-opentelemetry-java/releases/download/v1.5.1/honeycomb-opentelemetry-javaagent-1.5.1.jar -o honeycomb-agent.jar 
```
2. Build app
```
./gradlew build
```
3. Set environment variables
```
HONEYCOMB_API_KEY=xxx
HONEYCOMB_DATASET=xxx
```
4. Run app
```
java -Dotel.javaagent.configuration-file=otel.properties -javaagent:honeycomb-agent.jar -Dservice.name=test-service -jar build/libs/graceful-shutdown-test.jar
```
5. Curl the wait endpoint and you should see the trace in honeycomb. It will take 10 seconds to complete.
```
curl http://localhost:8080/wait
```
6. Curl the wait endpoint again and terminate the running app while the request is being processed. 
The app will gracefully shutdown and fully terminate after serving the request but the trace will not exist in honeycomb.