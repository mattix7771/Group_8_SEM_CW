# USE CASE: 4 Produce Reports on the population of people.

## CHARACTERISTIC INFORMATION

### Goal in Context

An analyst has asked to produce reports on the population of people who are living and not living in cities.

### Scope

Organisation.

### Level

Primary task.

### Preconditions

Database contains population of the world.

### Success End Condition

The following reports are produced:
- The population of people, people living in cities, and people not living in cities in each continent, region and country.

### Failed End Condition

No report is produced.

### Primary Actor

An analyst.

### Trigger

A request for population information is sent to world database.

## MAIN SUCCESS SCENARIO

1. Request for population information is sent.
2. Extracting name, total population from database.
3. Extracting total population(%) of people living in cities.
4. Extracting total population(%) of people NOT living in cities.
5. Producing reports.

## EXTENSIONS

None.

## SUB-VARIATIONS

None.

## SCHEDULE

**DUE DATE**: Release 0.1.0.5