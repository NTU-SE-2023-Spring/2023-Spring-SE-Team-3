#!/bin/sh
BASEDIR=$(dirname "$0")
cd $BASEDIR

echo "build ${BASEDIR}"
javac *.java