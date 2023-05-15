#!/bin/sh
BASEDIR=$(dirname "$0")
cd $BASEDIR

JAVA_VER=$(java -version 2>&1 | head -1 | cut -d'"' -f2 | sed '/^1\./s///' | cut -d'.' -f1)
echo "${JAVA_VER}"
if [ "$JAVA_VER" -eq "8" ]; then
  echo "omit ${BASEDIR}"
  exit 0
fi

echo "build ${BASEDIR}"
javac *.java