package com.home.rabbitMQ.producer;

import com.home.rabbitMQ.MyConstant;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class TaskProducerApp {

    public static void main(String[] args) throws Exception{
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("localhost");
        try(Connection connection = connectionFactory.newConnection()){
            Channel channel = connection.createChannel();
            int number;
            for (int i = 0; i < 20; i++) {
                number = (int)(Math.random()*(2))+1;
                String message = new String();
                if(number == 1){
                    message = "java: Hello with number "+number;
                    channel.basicPublish(MyConstant.getExchangeName(), MyConstant.getBindingName1(), null, message.getBytes("UTF-8"));
                } else {
                    message = "php: Hello with number "+number;
                    channel.basicPublish(MyConstant.getExchangeName(), MyConstant.getBindingName2(), null, message.getBytes("UTF-8"));
                }
                System.out.println(" [x] Sent '" + message + "'");
            }

        }
    }
}
