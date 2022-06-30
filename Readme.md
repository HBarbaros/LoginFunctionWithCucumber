# Cucumber Framework for Login Function in Jira
## Framework Format

1. configuration.properties: to avoid hard coding, 
externalize the test data and avoid effecting the project, 
centralized location, cross browser testing.

2. Create resources directory same level with java directory.
The purpose is to hold our scenarios for the project.

3. Crate Java packages:
   1. . runners
   2. pages(POM)
   3. step_definitions
   4. utilities

