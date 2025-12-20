#!/usr/bin/env sh

set -e

DIR="$(cd "$(dirname "$0")" && pwd)"

GRADLE_WRAPPER_JAR="$DIR/gradle/wrapper/gradle-wrapper.jar"

if [ ! -f "$GRADLE_WRAPPER_JAR" ]; then
  echo "Gradle wrapper JAR missing"
  exit 1
fi

java -jar "$GRADLE_WRAPPER_JAR" "$@"
