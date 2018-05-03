#!/bin/bash

modules=(
	'./HouseCleaning3-client/target/HouseCleaning3-client-0.0.1-SNAPSHOT.jar'
	'./HouseCleaning3-assets/target/HouseCleaning3-assets-0.0.1-SNAPSHOT.jar'
	'./HouseCleaning3-front/target/HouseCleaning3-front-0.0.1-SNAPSHOT.jar'
	'./HouseCleaning3-company/target/HouseCleaning3-company-0.0.1-SNAPSHOT.jar'
	"$HOME/.m2/repository/org/jline/jline/3.7.0/jline-3.7.0.jar"
	"$HOME/.m2/repository/org/joda/joda-money/0.12/joda-money-0.12.jar"
	'../things/target/things-0.0.1-SNAPSHOT.jar'
	)
	
. ../java_version.sh
. ../run_functions.sh

run $1