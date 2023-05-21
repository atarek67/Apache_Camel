package com.tik.microservices.camelmicroservicea.routes.a;

import org.apache.camel.builder.RouteBuilder;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.logging.Logger;

@Component
public class MyFirstTimerRouter extends RouteBuilder {


    @Autowired
    private GetCurrentTimeBean getCurrentTimeBean;//To avoid mistakes if someone changes its name so now we just use a variable

    @Override
    public void configure() throws Exception {

        /* -Those 3 steps called Route
        * -We have here 2 endpoints first one is the queue and the second is database
        * -first we wil not use queue we will use Timer and write them to a log not in a database
        * */


        //listen to a [queue] at first

        //whatever what input comes in I will do some [transformation]

        //then this changes save it to [database]



        //Timer

        //whatever what input comes in I will do some [transformation]

        //Log

        //from() specify the starting point of the route from where?
        from("timer:first-timer")
//                .bean("getCurrentTimeBean")
                .bean(getCurrentTimeBean)

                .log("${body}")
                .to("log:first-timer");
    }
}

@Component
class GetCurrentTimeBean{
    public String getCurrentTime(){
        return "The time now is " + LocalDateTime.now();
    }
}
