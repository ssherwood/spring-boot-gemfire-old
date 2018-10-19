#!/usr/bin/env bash

export DEFAULT_LOCATOR_PORT=41111
export DEFAULT_HEAP=256m

# start a single locator with 3 members...
gfsh start locator --properties-file=./gemfire.properties --initial-heap=${DEFAULT_HEAP} --max-heap=${DEFAULT_HEAP} --port=${DEFAULT_LOCATOR_PORT} --name=locator1
gfsh start server --properties-file=./gemfire.properties --initial-heap=${DEFAULT_HEAP} --max-heap=${DEFAULT_HEAP} --server-port=0 --name=server1
gfsh start server --properties-file=./gemfire.properties --initial-heap=${DEFAULT_HEAP} --max-heap=${DEFAULT_HEAP} --server-port=0 --name=server2
gfsh start server --properties-file=./gemfire.properties --initial-heap=${DEFAULT_HEAP} --max-heap=${DEFAULT_HEAP} --server-port=0 --name=server3
