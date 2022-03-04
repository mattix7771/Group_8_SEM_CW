# USE CASE: 6 Produce Reports on population of people speaking in different languages.

## CHARACTERISTIC INFORMATION

### Goal in Context

An analyst has asked to produce the number of people who speak the following languages from greatest number to smallest, including the percentage of the world population.

### Scope

Organisation.

### Level

Primary task.

### Preconditions

Database contains population of the world.

### Success End Condition

The following reports are produced:
- The population of people who speak Chinese, English, Hindi, Spanish and Arabic.

### Failed End Condition

No report is produced.

### Primary Actor

An analyst.

### Trigger

A request for population information is sent to world database.

## MAIN SUCCESS SCENARIO

1. Request for population information is sent.
2. Extracting language, population from database.
3. Sorting information in descending order by population(%).
4. Producing reports.

## EXTENSIONS

None.

## SUB-VARIATIONS

None.

## SCHEDULE

**DUE DATE**: Release 0.1.0.5