docker compose up
docker compose down
docker exec -it CONTAINER_ID /bin/bash

# create kafka topic in /bin/bash
/usr/bin/kafka-topics --create --zookeeper 192.168.1.6:2181 --replication-factor 1 --partitions 1 --topic test

/usr/bin/kafka­topics ­­--zookeeper localhost:2181 --­­delete --topic test

./kafka­-console­-producer --­­broker-­list 192.168.1.6:9092 ­­--topic test

./kafka-console-consumer --bootstrap-server 192.168.1.6:9092 --topic test
