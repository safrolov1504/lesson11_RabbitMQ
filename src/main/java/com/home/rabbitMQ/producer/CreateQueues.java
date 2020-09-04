package com.home.rabbitMQ.producer;

import com.home.rabbitMQ.MyConstant;
import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class CreateQueues {
    private static final String EXCHANGE_NAME = MyConstant.getExchangeName();

    private static final String TASK_QUEUE_NAME_1 = MyConstant.getTaskQueueName1();
    private static final String BINDING_NAME_1 = MyConstant.getBindingName1();

    private static final String TASK_QUEUE_NAME_2 = MyConstant.getTaskQueueName2();
    private static final String BINDING_NAME_2 = MyConstant.getBindingName2();

    public static void main(String[] args) throws Exception{
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("localhost");

        try (Connection connection = connectionFactory.newConnection();
             Channel channel = connection.createChannel()) {
            channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.DIRECT);

            channel.queueDeclare(TASK_QUEUE_NAME_1, true, false, false, null);
            channel.queueBind(TASK_QUEUE_NAME_1,EXCHANGE_NAME,BINDING_NAME_1);

            channel.queueDeclare(TASK_QUEUE_NAME_2, true, false, false, null);
            channel.queueBind(TASK_QUEUE_NAME_2,EXCHANGE_NAME,BINDING_NAME_2);
        }
    }
}
