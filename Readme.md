docker compose up
docker compose down
docker exec -it CONTAINER_ID /bin/bash

# create kafka topic in /bin/bash
/opt/kafka/bin/kafka-topics.sh --create --zookeeper 192.168.1.6:2181 --replication-factor 1 --partitions 1 --topic TestTopic

docker exec -it kafka /bin/bash

/opt/kafka/bin/kafka­topics.sh ­­--zookeeper localhost:2181 --­­delete --topic test

./kafka­-console­-producer.sh --­­broker-­list 192.168.1.7:9092 ­­--topic Topic1

./kafka-console-consumer.sh --bootstrap-server 192.168.1.6:9092 --topic TestTopic
