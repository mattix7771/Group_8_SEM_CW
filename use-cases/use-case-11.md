# USE CASE: 11 Produce a Report on all the cities in a district organised by largest population to smallest.

## CHARACTERISTIC INFORMATION

### Goal in Context

The organisation has asked to produce a report on all cities in a district organised by largest population to smallest.

### Scope

Organisation.

### Level

Primary task.

### Preconditions

Database contains all cities in the world.

### Success End Condition

A report is provided with all cities in a district in descending order.

### Failed End Condition

No report is produced.

### Primary Actor

An organisation.

### Trigger

A request for cities information is sent to world database.

## MAIN SUCCESS SCENARIO

1. Request for cities information is sent.
2. Extracting name, country, district, population.
3. Sorting in descending order by population.
4. Grouping by district.
5. Producing a report.

## EXTENSIONS

None.

## SUB-VARIATIONS

None.

## SCHEDULE

**DUE DATE**: Release 0.1.0.5