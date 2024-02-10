#!/bin/bash
javac *.java
# JMI Server:
PORT="11099"
rmiregistry "$PORT"
# App Server:
#java CalculatorServer
# Client:
#java CalculatorClient
