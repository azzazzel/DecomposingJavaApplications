#!/bin/bash

modules=(
	'./HouseCleaning5-client/target/HouseCleaning5-client-0.0.1-SNAPSHOT.jar'
	'./HouseCleaning5-frontoffice/target/HouseCleaning5-frontoffice-0.0.1-SNAPSHOT.jar'
	'./HouseCleaning5-usecases/target/HouseCleaning5-usecases-0.0.1-SNAPSHOT.jar'
	'./HouseCleaning5-company/target/HouseCleaning5-company-0.0.1-SNAPSHOT.jar'
	"$HOME/.m2/repository/org/jline/jline/3.7.0/jline-3.7.0.jar"
	"$HOME/.m2/repository/org/joda/joda-money/0.12/joda-money-0.12.jar"
	'../things/target/things-0.0.1-SNAPSHOT.jar'
	)
	
. ../java_version.sh
. ../run_functions.sh

run $1