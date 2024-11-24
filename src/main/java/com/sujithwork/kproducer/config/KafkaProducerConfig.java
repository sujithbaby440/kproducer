package com.sujithwork.kproducer.config;

import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaAdmin;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaProducerConfig {

//    @Bean
//    public NewTopic createTopic(){
//        return new NewTopic("topic-msg1", 3, (short) 1);
//    }

    @Bean
    public NewTopic createTopic2() {
        return new NewTopic("topic-event1", 3, (short) 1);
    }

    @Bean
    public Map<String,Object> producerConfig(){
        Map<String,Object> props=new HashMap<>();
//        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,
//                "192.168.1.8:9092");
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,
                "192.168.1.14:9092");
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,
                StringSerializer.class);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
                JsonSerializer.class);
        return props;
    }

    @Bean
    public ProducerFactory<String,Object> producerFactory(){
        return new DefaultKafkaProducerFactory<>(producerConfig());
    }

    @Bean
    public KafkaTemplate<String,Object> kafkaTemplate(){
        return new KafkaTemplate<>(producerFactory());
    }

    @Bean
    public KafkaAdmin admin() {
        Map<String, Object> adminProps = new HashMap<>();
       // adminProps.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, "192.168.1.8:9092");
        adminProps.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, "192.168.1.14:9092");
        return new KafkaAdmin(adminProps);
    }
}
