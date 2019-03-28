package com.shatokhina.homework9.messageTask;

import java.util.List;

enum MessagePriority {
    LOW, MEDIUM, HIGH, URGENT;

    public static MessagePriority getPriority(int number) {
        for (MessagePriority priority : values())
            if (number == priority.ordinal()) return priority;
        throw new AssertionError("Wrong ordinal: " + number);
    }
}

public class Message {
    private final int code;
    private final MessagePriority priority;

    public Message(int code, MessagePriority priority) {
        this.code = code;
        this.priority = priority;
    }

    public int getCode() { return code; }

    public MessagePriority getPriority() { return priority; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Message message = (Message) o;
        return code == message.code && priority == message.priority;
    }

    @Override
    public int hashCode() {
        return 31 * code + (priority != null ? priority.hashCode() : 0);
    }

    @Override
    public String toString() {
        return "Message: " +
                "code = "+ code +
                ", priority = " + priority;
    }

    public static void main(String[] args) {
        MessageGenerator generator = new MessageGenerator();
        MessageManager messageManager = MessageManager.getMessageTask();

        List<Message> messages = generator.generate(34);
        System.out.println("Messages:");
        messages.forEach(System.out::println);
        System.out.println("\nNumber of messages with each priority:");
        messageManager.countEachPriority(messages);
        System.out.println("\nNumber of messages with each code:");
        messageManager.countEachCode(messages);
        System.out.print("\nNumber of unique messages = ");
        messageManager.uniqueMessageCount(messages);
        System.out.println("\nUnique message: ");
        messageManager.uniqueMessagesInOriginalOrder(messages).forEach(System.out::println);
        System.out.println("\nRemove message with high priority: ");
        messageManager.removeEach(messages, MessagePriority.getPriority(2));
        System.out.println("\nRemove message without high priority: ");
        messageManager.removeOther(messages, MessagePriority.getPriority(2));
    }
}

