Feature: Google Browse

Scenario Outline: Finding GITHUB ANKCRIMSON Repository on GIT

    Given Browser is <browser> on <platform>
    And Webpage is http://www.google.com
    Then search for <searchtext>
    Then click on 1st link
    Then wait for 3000 ms
    Then close browser
    
Examples:
    | browser | platform | searchtext |
    |  chrome   |  desktop  |  github ankcrimson   |
    |  chrome   |  mobile  |  github ankcrimson  |