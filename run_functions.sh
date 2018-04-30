#!/bin/bash

module="dja.housecleaning.client"
mainClass="dja.housecleaning.client.RequestHouseCleaning"

function buildClassPath () {
	classpath=$(IFS=: ; echo "${modules[*]}")
}

function run () {
	buildClassPath;
	OPTION=$1;
	case $OPTION in 

		"j8")
			setJavaVersion "1.8" ;
			java -cp $classpath $mainClass
		;;

		"j9c")
			setJavaVersion "9" ;
			java -cp $classpath $mainClass
		;;

		"j9m")
			setJavaVersion "9" ;
			java -p $classpath -m $module/$mainClass
		;;

		"j10c")
			setJavaVersion "10" ;
			java -cp $classpath $mainClass
		;;

		"j10m")
			setJavaVersion "10" ;
			java -p $classpath -m $module/$mainClass
		;;

		*)
			echo "please specify correct run option (j8, j9c, j9m, j10c or j10m)"
	esac;
}

