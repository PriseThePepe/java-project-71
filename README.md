# Difference Calculator

## Overview
This program compares two configuration files in JSON or YML format. The diff is based on how the files have changed relative to each other, with keys displayed in alphabetical order. The result of the file comparison can be output in different formats.

## Table of Contents
- [How it works](#asciinema-video)
- [Installation](#installation)
- [Usage](#usage)
- [Features](#features)
- [Requirements](#requirements)
- [Testing](#testing)


## Installation
1. Clone the repository:
   git clone https://github.com/PriseThePepe/java-project-71.git
2. Navigate to the project directory:
   cd java-project-71
3. Build the project using Gradle:
   ./gradlew build or make build

## Usage
To compare two files, use the following command:

./build/install/app/bin/app [-f] filepath1.json filepath2.json
Where:
-f, -- format - Output format that you need.
filepath1.json, filepath2.json - Two JSON or YAML files that need to compare.

To show help massage, use following command:
./build/install/app/bin/app -h or --help

## Features
- Compare JSON and YML files
- Display differences in various formats (stylish, plain, JSON)
- Keys are displayed in alphabetical order

## Requirements
- Java 21 or higher
- Gradle 8.5 or higher

## Testing
To run tests, use the following command:
./gradlew test or make test



### Hexlet tests and linter status:
[![Actions Status](https://github.com/PriseThePepe/java-project-71/actions/workflows/hexlet-check.yml/badge.svg)](https://github.com/PriseThePepe/java-project-71/actions)

[![Java CI](https://github.com/PriseThePepe/java-project-71/actions/workflows/main.yaml/badge.svg)](https://github.com/PriseThePepe/java-project-71/actions/workflows/main.yaml)

### Codeclimate Maintainability Badge:
[![Maintainability](https://api.codeclimate.com/v1/badges/07c566f2799b3c71f08a/maintainability)](https://codeclimate.com/github/PriseThePepe/java-project-71/maintainability)

### Test Coverage Badge
[![Test Coverage](https://api.codeclimate.com/v1/badges/07c566f2799b3c71f08a/test_coverage)](https://codeclimate.com/github/PriseThePepe/java-project-71/test_coverage)

#### Asciinema video:
* [Plain JSON files](https://asciinema.org/a/VnTUffOmSX4JwgqFUvaDH84ZW)
* [Plain YAML files](https://asciinema.org/a/cLMjCNkzBPxOmGyf8SLYrNjI9)
* [Nested JSON files](https://asciinema.org/a/9njAfmuv5QKQCye2w7A4VVnUa)
* [Nested JSON files with "plain" formatter](https://asciinema.org/a/UcGpuJSJB7O0XgLpQjvJGgqBL)
* [Nested JSON files with "json" formatter](https://asciinema.org/a/D7b0E8uQs1S0oKqZNOr0KTaLa)

