#!/bin/sh

./build.sh && \
aws --profile kotlin-book s3 cp book s3://kotlin-by-example/ --recursive --exclude '.DS_Store'
aws --profile kotlin-book s3 cp examples \
  s3://kotlin-by-example/src --recursive --exclude '.DS_Store' \
  --content-type="text/markdown"
