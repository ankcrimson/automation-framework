@simple_demo
Feature: Google Browse

  Scenario: Search Selenium
    Given Browser is chrome and platform is mobile
    And Webpage is http://www.google.com
    Then search for selenium