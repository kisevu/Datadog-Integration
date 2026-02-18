# DATADOG OBSERVABILITY TOOL 🚀🚀🚀
**************
## Introduction
*************
 Datadog serves as a cloud-based observability platform that provides full-stack monitoring for;
 >  - Infrastructure - CPU,RAM,DISK,NETWORK etc.
 >  - Containers  - Docker resource usage, Jenkins pipelines etc.
 >  - Applications - application Metrics & Traces.
 >  - Logs - Centralized logs aggregation + correlations.
 >  - APM - Distributed tracing.
 
 


## Set up journey 🛠️
****
### Phase 1

### Single command deploys monitoring agent
docker run -d --name dd-agent --privileged --network host \
-e DD_API_KEY=************************* \
-e DD_SITE=datadoghq.com -e DD_ENV=dev -e DD_APM_ENABLED=true \
-v /var/run/docker.sock:/var/run/docker.sock:ro \
-v /proc/:/host/proc/:ro \
-v /sys/fs/cgroup/:/host/sys/fs/cgroup:ro \
datadog/agent:latest

### verification
> docker ps           # Shows "healthy" status <br/>
> ss -tuln | grep 8126 # Confirms APM port listening <br/>
> docker logs dd-agent # "Datadog Agent is running"

 ### Phase 2
  #### Download  tracer(bytcode instrumentation)
   > wget -O dd-java-agent.jar https://dtdg.co/latest-java-tracer

  #### Run Spring-boot with auto-tracing
   > java -javaagent:./dd-java-agent.jar \  <br/>
   >  -Ddd.agent.host=localhost -Ddd.agent.port=8126 \  <br/>
   > -Ddd.service=webflux-banking -Ddd.env=dev \  <br/>
   > -jar ./target/Datadog-integration-0.0.1-SNAPSHOT.jar  <br/>
   

   > Update properties as in source code.

### 🔗 Access your Dashboard 
   ****
Infrastructure → Hosts → AMEDA (CPU/RAM/Docker)
APM → Services → Datadog-integration (flame graphs)
Metrics Explorer → datadog.* (JVM metrics)
Logs → service:Datadog-integration (request logs)

### 🎉 Achievement 
  ***
✅ Deployed production-grade monitoring stack <br/>
✅ 100% Docker-native (no host agents)  <br/>
✅ Automatic Spring WebFlux tracing (no code changes)  <br/>
✅ GCP free tier compatible (fits e2-micro)  <br/>
✅ Ready for Jenkins CI/CD + Node.js monitoring  <br/>
✅ Full visibility: Host → Container → Application  <br/>



