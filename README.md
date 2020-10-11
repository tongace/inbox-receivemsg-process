# inbox-receivemsg-process
## System Preparation
### Apache Kafka with Docker 
Use docker-compose file to create zookeeper and kafka broker server
```
version: '3.8'
services:
  zookeeper:
    image: wurstmeister/zookeeper
    ports:
      - "2181:2181"
    restart: always
  kafka:
    image: wurstmeister/kafka
    ports:
      - "9092:9092"
    environment:
      KAFKA_ADVERTISED_HOST_NAME: localhost
      KAFKA_ZOOKEEPER_CONNECT: zookeeper:2181
    restart: always
```
download kafka for do cli from https://archive.apache.org/dist/kafka/1.1.0/kafka_2.11-1.1.0.tgz then extract them in wherever you want then cd into kafka bin folder
#### run below command to create Topic "test"
./kafka-topics.sh --create --topic test --replication-factor 1 --partitions 3  --zookeeper localhost:2181
#### run below command to create Topic "test2"
./kafka-topics.sh --create --topic test2 --replication-factor 1 --partitions 3  --zookeeper localhost:2181

#### to view message in each topic use below command to do
##### topic test:
./kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic test --consumer-property group.id=test.topic.group 
##### topic test 2
./kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic test2 --consumer-property group.id=test.topic.group
