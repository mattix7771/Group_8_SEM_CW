# USE CASE: 21 Produce a Report on the top N populated capital cities in the world where N is provided by the user.

## CHARACTERISTIC INFORMATION

### Goal in Context

The organisation has asked to produce a report on the top N populated capital cities in the world where N is provided by the user.

### Scope

Organisation.

### Level

Primary task.

### Preconditions

Database contains all cities in the world.

### Success End Condition

A report is provided with top N capital cities in the world.

### Failed End Condition

No report is produced.

### Primary Actor

An organisation.

### Trigger

A user inputs a number and request is sent to database.

## MAIN SUCCESS SCENARIO

1. User inputs a number.
2. Request for cities information is sent.
3. Extracting name, country, population from database.
4. Producing a report.

## EXTENSIONS

User inputs invalid character/number: Error message produced

## SUB-VARIATIONS

None.

## SCHEDULE

**DUE DATE**: Release 0.1.0.5