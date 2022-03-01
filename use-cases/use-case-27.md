# USE CASE: 27 Produce a Report on additional information.

## CHARACTERISTIC INFORMATION

### Goal in Context

The organisation has asked to produce a report on the population of the world, continent, region, country, district, city.

### Scope

Organisation.

### Level

Primary task.

### Preconditions

Database contains all the information needed to extract the population for specific cities, countries etc.

### Success End Condition

A report is provided with the population of chosen (assuming by a user) city, country, continent etc.

### Failed End Condition

No report is produced.

### Primary Actor

An organisation.

### Trigger

A user input for specific place and request is sent to world database.

## MAIN SUCCESS SCENARIO

1. User inputs a place of interest.
2. Request for population information is sent.
3. Extracting name, total population.
4. If applicable, extracting total population living in cities (including a %).
5. If applicable, extracting total population not living in cities (including a %).
6. Producing a report.

## EXTENSIONS

None.

## SUB-VARIATIONS

None.

## SCHEDULE

**DUE DATE**: Release 0.1.0.5