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
java -javaagent:honeycomb-agent.jar -Dservice.name=test-service -jar build/libs/graceful-shutdown-test.jar
```