#!/bin/sh
BASEDIR=$(dirname "$0")
cd $BASEDIR

echo "sample 1"
java Main sampleInput.in > output.out
diff output.out sampleOutput.out