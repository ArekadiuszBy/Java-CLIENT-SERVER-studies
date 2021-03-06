## Java projects for studies based on Clinet-Server architecture

Client–server model is a distributed application structure that partitions tasks or workloads between the providers of a resource or service, called servers, and service requesters, called clients. Often clients and servers communicate over a computer network on separate hardware, but both client and server may reside in the same system. A server host runs one or more server programs, which share their resources with clients. A client does not share any of its resources, but it requests content or service from a server. Clients, therefore, initiate communication sessions with servers, which await incoming requests. Examples of computer applications that use the client-server model are email, network printing, and the World Wide Web.

## Table of contents
* [1. Threads](#1-threads)
* [2. Synchronized](#2-synchronized)
* [3. Server sockets](#3-server-sockets)
* [4. Server Stream - Data Flow](#4-server-stream---data-flow)
* [5,6,7. Client](#567-client)
* [8. Server multi-thread](#8-server-multi-thread)
* [11. RMI (Remote Method Invocation)](#910-none-11-rmi-remote-method-invocation)
* [12. Datagrams](#12-datagrams)
* [13. Semaphores](#13-semaphores)
* [14. Jframe, Swing](#14-jframe-swing)


### 1. Threads
Threads allows a program to operate more efficiently by doing multiple things at the same time.
Threads can be used to perform complicated tasks in the background without interrupting the main program.

### 2. Synchronized 
The Java programming language provides two basic synchronization idioms: synchronized methods and synchronized statements. The more complex of the two, synchronized statements, are described in the next section.

### 3. Server sockets
The server in the client/server pair serves up Knock Knock jokes. Knock Knock jokes are favored by children and are usually vehicles for bad puns. 

### 4. Server Stream - Data Flow
Reading from and Writing to a Socket

### 5,6,7. Client
Client is the main entry point to the fluent API used to build and execute client requests in order to consume responses returned.

### 8. Server multi-thread
A server having more than one thread is known as Multithreaded Server. When a client sends the request, a thread is generated through which a user can communicate with the server. We need to generate multiple threads to accept multiple requests from multiple clients at the same time.

### (9,10-none), 11. RMI (Remote Method Invocation)
Java RMI is a Java API that performs remote method invocation, the object-oriented equivalent of remote procedure calls (RPC), with support for direct transfer of serialized Java classes and distributed garbage-collection.

### 12. Datagrams
Java DatagramSocket class represents a connection-less socket for sending and receiving datagram packets.
A datagram is basically an information but there is no guarantee of its content, arrival or arrival time.

### 13. Semaphores
A semaphore controls access to a shared resource through the use of a counter. If the counter is greater than zero, then access is allowed. If it is zero, then access is denied. What the counter is counting are permits that allow access to the shared resource. Thus, to access the resource, a thread must be granted a permit from the semaphore.

### 14. Jframe, Swing
The javax. swing. JFrame class is a type of container which inherits the java. ... JFrame works like the main window where components like labels, buttons, textfields are added to create a GUI. Unlike Frame, JFrame has the option to hide or close the window with the help of setDefaultCloseOperation(int) method.
