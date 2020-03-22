package com.fyp;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.storage.StorageLevel;
import org.influxdb.InfluxDB;
import org.influxdb.dto.BatchPoints;
import org.influxdb.dto.Point;
import org.influxdb.dto.Query;

import java.util.concurrent.TimeUnit;

import static org.influxdb.InfluxDBFactory.connect;

public class Main {

    public static void main(String[] args) {

                SparkConf sparkConf = new SparkConf()
                        .setAppName("Example Spark App")
                        .setMaster("local[*]"); // Delete this line when submitting to a cluster
                JavaSparkContext sparkContext = new JavaSparkContext(sparkConf);

                JavaRDD<CardiacEvent> contexts = sparkContext.textFile("hdfs://localhost:9000/flume/cardiacevents/2020/03/*")
                    .map(Main::parseCardiacEvents).persist(StorageLevel.DISK_ONLY());
//
                contexts.foreach(println -> System.out.println(println.getId() + " " + " " + println.getSensor() + " "  + println.getValue()));

                contexts.foreach(cardiacEvent -> {
                    InfluxDB  influxDB;
                    Query createDatabaseQuery;
                    BatchPoints batchPoints;
                    influxDB = connect("http://localhost:8086", "root", "root");

                    createDatabaseQuery = new Query("CREATE DATABASE CardiacEventsBackUp", "CardiacEventsBackUp");

                    influxDB.query(createDatabaseQuery);
                    influxDB.setDatabase("CardiacEventsBackUp");

                    batchPoints = BatchPoints
                            .database("CardiacEventsBackUp")
                            .build();

                    Point point1 = Point.measurement("heartRate")
                            .time(System.currentTimeMillis(), TimeUnit.MILLISECONDS)
                                .tag("id", Integer.toString(cardiacEvent.getId()))
                                .tag("sensor", "heartRate")
                                .addField("value", cardiacEvent.getValue())
                                .build();
                        batchPoints.point(point1);
                        influxDB.write(batchPoints);

            });
        }

            private static CardiacEvent parseCardiacEvents(String json) {
                ObjectMapper objectMapper = new ObjectMapper();

                try {
                    return objectMapper.readValue(json, CardiacEvent.class);

                } catch (Exception e) {
                    return null;
                }
            }
        }
