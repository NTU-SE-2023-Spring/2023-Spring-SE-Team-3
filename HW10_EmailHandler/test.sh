#!/bin/sh
BASEDIR=$(dirname "$0")
cd $BASEDIR

echo "test ${BASEDIR}"

echo "sample 1"
java Main Sample.in > output.out
diff output.out Sample.out
if [ "$?" -ne "0" ]; then
  echo "sample 1 WA"
  exit 1
fi
echo "sample 1 AC"
