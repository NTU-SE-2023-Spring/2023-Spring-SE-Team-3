#!/bin/sh
BASEDIR=$(dirname "$0")
cd $BASEDIR

JAVA_VER=$(java -version 2>&1 | head -1 | cut -d'"' -f2 | sed '/^1\./s///' | cut -d'.' -f1)
if [ "$JAVA_VER" -eq "8" ]; then
  echo "omit ${BASEDIR}"
  exit 0
fi

echo "test ${BASEDIR}"

echo "sample 1"
java Main sampleInput > output
diff output sampleOutput
if [ "$?" -ne "0" ]; then
  echo "sample 1 WA"
  exit 1
fi
echo "sample 1 AC"