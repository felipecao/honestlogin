#!/bin/bash

docker build --tag honestlogin:0.0.1 .
docker run --publish 8080:8080 --detach --name hl honestlogin:0.0.1