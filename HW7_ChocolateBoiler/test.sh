#!/bin/sh
BASEDIR=$(dirname "$0")
cd $BASEDIR

echo "test ${BASEDIR}"

echo "sample 1"
java Main sampleInput.in > output.out
diff output.out sampleOutput.out
if [ "$?" -ne "0" ]; then
  echo "sample 1 WA"
  exit 1
fi
echo "sample 1 AC"

echo "sample 2"
java Main sampleInput2.in > output2.out
diff output2.out sampleOutput2.out
if [ "$?" -ne "0" ]; then
  echo "sample 2 WA"
  exit 1
fi
echo "sample 2 AC"

echo "sample 3"
java Main sampleInput3.in > output3.out
diff output3.out sampleOutput3.out
if [ "$?" -ne "0" ]; then
  echo "sample 3 WA"
  exit 1
fi
echo "sample 3 AC"