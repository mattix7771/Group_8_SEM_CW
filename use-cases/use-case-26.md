# USE CASE: 25 Produce a Report on the population of people, people living in cities, and people not living in cities in each country.

## CHARACTERISTIC INFORMATION

### Goal in Context

The organisation has asked to produce a report on the population of people, people living in cities, and people not living in cities in each country.

### Scope

Organisation.

### Level

Primary task.

### Preconditions

Database contains all cities and population in the world.

### Success End Condition

A report is provided with population of people, people living in cities and people not living in cities in each country.

### Failed End Condition

No report is produced.

### Primary Actor

An organisation.

### Trigger

A request for population information is sent to world database.

## MAIN SUCCESS SCENARIO

1. Request for population information is sent.
2. Extracting name, total population.
3. Extracting total population living in cities (including a %).
4. Extracting total population not living in cities (including a %).
5. Group by country.
6. Producing a report.

## EXTENSIONS

None.

## SUB-VARIATIONS

None.

## SCHEDULE

**DUE DATE**: Release 0.1.0.5