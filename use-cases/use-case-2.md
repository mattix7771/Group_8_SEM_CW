# USE CASE: 2 Produce Reports on cities based on the population.

## CHARACTERISTIC INFORMATION

### Goal in Context

An analyst has asked to produce reports on cities based on the population, including reports where data can be manipulated with user input.

### Scope

Organisation.

### Level

Primary task.

### Preconditions

Database contains all cities of the world.

### Success End Condition

The following reports are produced:
- All the cities in the world, continent, region, country and district organised by largest population to smallest.
- The top N populated cities in the world, continent, region, country and district.

### Failed End Condition

No report is produced.

### Primary Actor

An analyst.

### Trigger

A request for cities information is sent to world database.

## MAIN SUCCESS SCENARIO

1. Request for cities information is sent.
2. Extracting name, country, district, population from database.
3. Sorting information in descending order by population.
4. Producing reports.

## EXTENSIONS

User inputs invalid character/number: Error message produced.

## SUB-VARIATIONS

None.

## SCHEDULE

**DUE DATE**: Release 0.1.0.5