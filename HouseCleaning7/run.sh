#!/bin/bash

modules=(
	'./HouseCleaning7-client/target/HouseCleaning7-client-0.0.1-SNAPSHOT.jar'
	'./HouseCleaning7-frontoffice/target/HouseCleaning7-frontoffice-0.0.1-SNAPSHOT.jar'
	'./HouseCleaning7-usecases/target/HouseCleaning7-usecases-0.0.1-SNAPSHOT.jar'
	'./HouseCleaning7-company/target/HouseCleaning7-company-0.0.1-SNAPSHOT.jar'
	'./HouseCleaning7-uber-transport/target/HouseCleaning7-uber-transport-0.0.1-SNAPSHOT.jar'
	"$HOME/.m2/repository/org/joda/joda-money/0.12/joda-money-0.12.jar"
	'../things/target/things-0.0.1-SNAPSHOT.jar'
)

. ../java_version.sh
. ../run_functions.sh

run $1
