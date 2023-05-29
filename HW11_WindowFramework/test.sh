#!/bin/sh
BASEDIR=$(dirname "$0")
cd $BASEDIR

echo "test ${BASEDIR}"

echo "sample 1"
java Main sampleInput > output
diff output sampleOutput
if [ "$?" -ne "0" ]; then
  echo "sample 1 WA"
  exit 1
fi
echo "sample 1 AC"

echo "sample 2"
java Main sampleInput2 > output
diff output sampleOutput2
if [ "$?" -ne "0" ]; then
  echo "sample 2 WA"
  exit 1
fi
echo "sample 2 AC"
