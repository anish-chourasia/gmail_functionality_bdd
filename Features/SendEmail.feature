@SendEmail
Feature: Functionality check for Sending Email in Gmail

  Scenario Outline: Test Compose Email of Gmail
    Given User is successfully logged in gmail
    When User clicks Compose tab
    And User provides to-email <recipient> subject <subject> and body <body>
    Then User clicks Send button

    Examples: 
      | recipient          | subject  | body                            |
      | incubyte@gmail.com | Incubyte | Automation QA test for Incubyte |

  Scenario Outline: Test Recently Sent Email
    Given User sent email
    When User opens Sent email page
    Then User opens recently sent email <subject>

    Examples: 
      | subject  |
      | Incubyte |
      
      
  #Scenario: Test Deleting of recently sent email
    #Given User is on recently sent email
    #Then User deletes the open email
    
  Scenario: User logs out from Gmail
    Given User is on recently sent email
    Then User logs out of Gmail




#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
#@tag
#Feature: Title of your feature
  #I want to use this template for my feature file
#
  #@tag1
  #Scenario: Title of your scenario
    #Given I want to write a step with precondition
    #And some other precondition
    #When I complete action
    #And some other action
    #And yet another action
    #Then I validate the outcomes
    #And check more outcomes
#
  #@tag2
  #Scenario Outline: Title of your scenario outline
    #Given I want to write a step with <name>
    #When I check for the <value> in step
    #Then I verify the <status> in step
#
    #Examples: 
      #| name  | value | status  |
      #| name1 |     5 | success |
      #| name2 |     7 | Fail    |
