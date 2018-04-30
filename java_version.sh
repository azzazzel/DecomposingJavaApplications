#!/bin/bash

JAVA_HOME=$JAVA_HOME 
PATH=$PATH

function setJavaVersion () {
	VERSION=$1;
	# Mac OS only! Please atapt for your own OS
	JAVA_HOME="`/usr/libexec/java_home -v $VERSION`";
	PATH="`/usr/libexec/java_home -v $VERSION`/bin:$PATH";
}


