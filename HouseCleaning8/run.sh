#!/bin/bash

. ../java_version.sh
. ../run_functions.sh

modules=(
	'./HouseCleaning8-run/target/housecleaning-client.jar'
)
mainClass="aQute.launcher.pre.EmbeddedLauncher"

run $1
