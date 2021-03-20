package com.britosw.kafkaconsumer.service.broker;

import com.britosw.kafkaconsumer.model.Message;
import com.britosw.kafkaconsumer.repository.MessageRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Component
@Slf4j
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class KafkaConsumerService {

    private final MessageRepository repository;

    @KafkaListener(topics = "${spring.kafka.template.default-topic}", groupId = "${spring.kafka.consumer.group-id}")
    public Mono<Message> consume(Message message) {
        repository.save(message);
        log.info(message.toString());
        return Mono.just(message);
    }

    public Flux<List<Message>> findAll() {
        return Flux.just(this.repository.findAll());
    }
}
