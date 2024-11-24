
---------------steps for the revisit---------------(This doc is common for consumer and producer)

step 1:
//To get the host ip,
ifconfig and get the host ip

step 2:
Update the docker-compose-final.yaml (which ever latest)
ie in kafka:
KAFKA_CFG_ADVERTISED_LISTENERS=PLAINTEXT://192.168.1.14:9092
KAFKA_CLUSTERS_0_BOOTSTRAP_SERVERS=192.168.1.14:9092

ie in intellij:
props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,
"192.168.1.14:9092");
adminProps.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, "192.168.1.14:9092");

step 3:
//This is to run the docker-compose file, below is the latest
docker-compose -f docker-compose-final.yaml up -d

//This is to stop and remove the docker-container
docker-compose down -v




//to remove orphans
docker-compose down -v --remove-orphans

---------------common commands---------------
//to list the containers
docker ps

//This is to check the logs of the kafka server
docker logs kafka-1

//to take the ip of the kafka container, assume kafka-2 is the container name
docker inspect kafka-1


