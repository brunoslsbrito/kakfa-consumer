package com.britosw.kafkaconsumer.repository;

import com.britosw.kafkaconsumer.model.Message;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MessageRepository extends MongoRepository<Message, String> {
}
