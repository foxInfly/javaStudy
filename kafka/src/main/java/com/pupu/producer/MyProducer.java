package com.pupu.producer;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.util.Properties;

/**Kafka生产者
 * 不带回调函数的API
 * @author puli2
 * @since 2020/1/3 16:09
 */
public class MyProducer {


    public static void main(String[] args) {
        //1.创建Kafka producer的配置信息
        Properties properties = new Properties();
        //kafka集群，broker-list
        properties.put("bootstrap.servers","zookeeper01:9092");
        //应答机制，at least once
        properties.put("acks","all");
        //重试次数
        properties.put("retries",1);
        //批次大小，16K
        properties.put("batch.size",16384);
        //逗留等待时间,单位毫秒
        properties.put("linger.ms",1);
        //RecordAccumulator 缓冲区大小32M
        properties.put("buffer.memory",33554432);
        //key\value序列化反序列化配置
        properties.put("key.serializer","org.apache.kafka.common.serialization.StringSerializer");
        properties.put("value.serializer","org.apache.kafka.common.serialization.StringSerializer");

        KafkaProducer<String, String> producer = new KafkaProducer<String, String>(properties);
        String value = "第一个通过Java API发送的消息";
        //2.发送数据,循环发送多条
        for (int i = 0; i < 10; i++) {
            producer.send(new ProducerRecord<String, String>("first",value+i),new Callback() {
                        public void onCompletion(RecordMetadata recordMetadata, Exception e) {
                            if (e == null){
                                System.out.println(recordMetadata.partition()+"--"+recordMetadata.offset());
                            }else {
                                e.printStackTrace();
                            }
                        }
                    }

            );

        }

        //3.关闭资源
        producer.close();

    }
}

