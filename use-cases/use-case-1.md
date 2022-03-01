# USE CASE: 1 Produce Reports on countries based on the population.

## CHARACTERISTIC INFORMATION

### Goal in Context

An analyst has asked to produce reports on countries based on the population, including reports where data can be manipulated with user input.

### Scope

Organisation.

### Level

Primary task.

### Preconditions

Database contains all countries of the world.

### Success End Condition

The following reports are produced:  
- All the countries in the world, continent and region organised by largest population to smallest.
- The top N populated countries in the world, continent and region.

### Failed End Condition

No report is produced.

### Primary Actor

An analyst.

### Trigger

A request for countries information is sent to world database.

## MAIN SUCCESS SCENARIO

1. Request for countries information is sent.
2. Extracting code, name, continent, region, population, capital from database.
3. Sorting information in descending order by population.
4. Producing reports.

## EXTENSIONS

User inputs invalid character/number: Error message produced.

## SUB-VARIATIONS

None.

## SCHEDULE

**DUE DATE**: Release 0.1.0.5