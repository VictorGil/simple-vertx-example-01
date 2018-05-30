# simple-vertx-example-01

This is a very simple example of vert.x (https://vertx.io) library usage.
It uses Java 8 and Maven and no custom vert.x configuration (just the default).
The main class creates one verticle and then that verticle creates two more verticles: PublisherVerticle and ConsumerVerticle.
The PublisherVerticle simply publishes (broadcasts) five messages using JSON and the ConsumerVerticle receives the messages and just logs their contents.

This example is useful for people who are new to vert.x since it showcases the following:
- how to start vert.x
- how to deploy and start verticles
- how to serialize/marshal a POJO to be encapsulated inside a vert.x message using JSON
- how to publish a message to the vert.x event bus
- how to receive a message from the vert.x event bus
- how to construct a POJO from the received message
- how to stop vert.x
- the asynchronous behaviour of vert.x

