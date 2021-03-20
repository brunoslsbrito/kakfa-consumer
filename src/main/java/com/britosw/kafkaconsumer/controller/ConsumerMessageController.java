package com.britosw.kafkaconsumer.controller;

import com.britosw.kafkaconsumer.model.Message;
import com.britosw.kafkaconsumer.service.broker.KafkaConsumerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("consumer")
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class ConsumerMessageController {

    private final KafkaConsumerService service;

    @GetMapping
    public Flux<List<Message>> consumeMessages() {
        return this.service.findAll();
    }
}
