#!/bin/bash

modules=(
	'./HouseCleaning6-client/target/HouseCleaning6-client-0.0.1-SNAPSHOT.jar'
	'./HouseCleaning6-frontoffice/target/HouseCleaning6-frontoffice-0.0.1-SNAPSHOT.jar'
	'./HouseCleaning6-usecases/target/HouseCleaning6-usecases-0.0.1-SNAPSHOT.jar'
	'./HouseCleaning6-company/target/HouseCleaning6-company-0.0.1-SNAPSHOT.jar'
	"$HOME/.m2/repository/org/joda/joda-money/0.12/joda-money-0.12.jar"
	'../things/target/things-0.0.1-SNAPSHOT.jar'
	)
	
. ../run_functions.sh

run $1