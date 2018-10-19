#!/usr/bin/env bash

export DEFAULT_LOCATOR_PORT=41111

gfsh -e "connect --locator=localhost[${DEFAULT_LOCATOR_PORT}]" -e "shutdown --include-locators=true"