docker compose up
docker compose down
docker exec -it CONTAINER_ID /bin/bash

# create kafka topic in /bin/bash
/opt/kafka/bin/kafka-topics.sh --create --zookeeper 192.168.1.6:2181 --replication-factor 1 --partitions 1 --topic TestTopic

docker exec -it kafka /bin/bash

/opt/kafka/bin/kafka­topics.sh ­­--zookeeper localhost:2181 --­­delete --topic test

./kafka­-console­-producer.sh --­­broker-­list 192.168.1.6:9092 ­­--topic TestTopic

./kafka-console-consumer.sh --bootstrap-server 192.168.1.6:9092 --topic TestTopic

# Check out listening sockets
netstat -tulpn | grep LISTEN

# Testing out kafka multiple broker are working
kafkacat -b 192.168.1.2:9001,192.168.1.2:9000 -P -t test
kafkacat -b 192.168.1.2:9000,192.168.1.2:9001 -C -t test

docker-compose up -d
docker-compose scale kafka=3

# Check out hadoop file system and download files
http://localhost:9870/explorer.html#/
