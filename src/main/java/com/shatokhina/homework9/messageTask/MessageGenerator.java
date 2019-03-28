package com.shatokhina.homework9.messageTask;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class MessageGenerator {
    public List<Message> generate(int num) {
        if (num <= 0) return Collections.emptyList();

        ThreadLocalRandom random = ThreadLocalRandom.current();
        int typesCount = MessagePriority.values().length;

        return Stream.generate(() -> random.nextInt(typesCount))
                .limit(num)
                .map(MessagePriority::getPriority)
                .map(priority -> new Message(random.nextInt(10), priority))
                .collect(toList());
    }
}