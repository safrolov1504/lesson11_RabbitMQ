package com.home.rabbitMQ;

public class MyConstant {
    private static final String TASK_QUEUE_NAME_1 = "task_java";
    private static final String EXCHANGE_NAME = "exchange_java";
    private static final String BINDING_NAME_1 = "java";

    private static final String TASK_QUEUE_NAME_2 = "task_php";
    private static final String BINDING_NAME_2 = "php";

    public static String getTaskQueueName1() {
        return TASK_QUEUE_NAME_1;
    }


    public static String getBindingName1() {
        return BINDING_NAME_1;
    }

    public static String getTaskQueueName2() {
        return TASK_QUEUE_NAME_2;
    }

    public static String getExchangeName() {
        return EXCHANGE_NAME;
    }

    public static String getBindingName2() {
        return BINDING_NAME_2;
    }
}
