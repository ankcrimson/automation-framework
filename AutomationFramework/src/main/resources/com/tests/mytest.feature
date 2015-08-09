Feature: Google Browse

  Scenario: Search Selenium
    Given Browser is chrome on mobile
    And Webpage is http://www.google.com
    Then search for github ankcrimson
    Then click on 1st link
    Then wait for 3000 ms
    Then close browser