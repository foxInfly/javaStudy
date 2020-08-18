package com.pupu.consumer;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.util.Arrays;
import java.util.Properties;

/**
 * @author puli2
 * @since 2020/1/3 17:12
 */
public class MyConsumer {

    public static void main(String[] args) {
        //1.创建Kafka producer的配置信息
        Properties properties = new Properties();
        //2.给配置信息赋值
        //连接的zookeeper集群
        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,"zookeeper01:9092");
        //是否开启自动提交
//        properties.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG,true);
        properties.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG,false);

        //latest、earliest;
        properties.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG,"earliest");
        properties.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG,"1000");//自动提交offset延迟,默认开启，1000ms
        //key\value反序列化配置
        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,"org.apache.kafka.common.serialization.StringDeserializer");
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,"org.apache.kafka.common.serialization.StringDeserializer");
        //消费者组
        properties.put(ConsumerConfig.GROUP_ID_CONFIG,"wst_rest");

        //创建消费者
        KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(properties);
        //订阅主题
        consumer.subscribe(Arrays.asList("first"));
        //拉取数据
        while (true){
            ConsumerRecords<String, String> consumerRecords = consumer.poll(100);
            //解析并打印ConsumerRecords
            for (ConsumerRecord<String, String> consumerRecord : consumerRecords) {
                System.out.println(consumerRecord.key()+"--"+consumerRecord.value());
            }

        }
    }
}
