#!/usr/bin/env bash
mvn spring-javaformat:apply && git add * &&  git commit -am polish && git  push
