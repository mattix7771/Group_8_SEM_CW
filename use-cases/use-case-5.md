# USE CASE: 5 Produce a Report on the top N populated countries in a continent where N is provided by the user.

## CHARACTERISTIC INFORMATION

### Goal in Context

The organisation has asked to produce a report on the top N populated countries in a continent where N is provided by the user.

### Scope

Organisation.

### Level

Primary task.

### Preconditions

Database contains all countries of the world.  
User input available.

### Success End Condition

A report is provided with N number of top populated countries in a continent.

### Failed End Condition

No report is produced.

### Primary Actor

An organisation.

### Trigger

A user inputs a number then request is sent to database.

## MAIN SUCCESS SCENARIO

1. User input a number.
2. Request for countries information is sent.
3. Extracting code, name, continent, region, population, capital from database.
4. Grouping by continent.
5. Producing a report.

## EXTENSIONS

User inputs invalid character/number: Error message produced

## SUB-VARIATIONS

None.

## SCHEDULE

**DUE DATE**: Release 0.1.0.5