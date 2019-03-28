package com.shatokhina.homework9.messageTask;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.*;

public class MessageManager {
    private static final MessageManager MESSAGE_MANAGER = new MessageManager();

    private MessageManager() {}

    static MessageManager getMessageTask() { return MESSAGE_MANAGER; }

    void countEachPriority(List<Message> messages) {
        messages.stream()
                .collect(groupingBy(Message::getPriority, summarizingInt(message -> 1)))
                .forEach((priority, sumInfo) -> System.out.println(priority + " = " + sumInfo.getCount()));
    }

    void countEachCode(List<Message> messages) {
        Map<Integer, Integer> numberOfCode = new HashMap<>();
        for (Message message : messages)
            numberOfCode.merge(message.getCode(), 1, Integer::sum);
        numberOfCode.forEach((code, count) -> System.out.println(code + " = " + count));
    }

    void uniqueMessageCount(List<Message> messages) {
        System.out.println(messages.stream().distinct().count());
    }

    List<Message> uniqueMessagesInOriginalOrder(List<Message> messages) {
        return messages.stream().distinct().collect(toList());
    }

    void removeEach(List<Message> messages, MessagePriority priority) {
        System.out.println("Before: ");
        messages.forEach(System.out::println);
        List<Message> collect = messages.stream().filter(message -> !message.getPriority().equals(priority)).collect(toList());
        System.out.println("After: ");
        collect.forEach(System.out::println);
    }

    void removeOther(List<Message> messages, MessagePriority priority) {
        System.out.println("Before: ");
        messages.forEach(System.out::println);
        List<Message> collect = messages.stream().filter(message -> message.getPriority().equals(priority)).collect(toList());
        System.out.println("After: ");
        collect.forEach(System.out::println);
    }
}