package me.mmmjjkx.betterChests.utils;

public class MessageReplacement {
    private final String key;
    private final String value;

    private MessageReplacement(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public static MessageReplacement of(String key, String value) {
        return new MessageReplacement(key, value);
    }

    public static MessageReplacement of(String key, int value) {
        return new MessageReplacement(key, String.valueOf(value));
    }

    public static MessageReplacement of(String key, double value) {
        return new MessageReplacement(key, String.valueOf(value));
    }

    public String parse(String msg) {
        return msg.replace("%" + key + "%", value);
    }

    public String k() {
        return key;
    }

    public String v() {
        return value;
    }
}
