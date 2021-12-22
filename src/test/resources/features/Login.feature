Feature: N11 Login Functionality With Facebook

  In order to do shopping
  As a valid N11 customer
  User want to login successfully

  Scenario: Login Successful
    Given User navigate to N11 homepage
    When User enter valid credentials "can.yondem.22@gmail.com" and "1234qwer." with facebook in login page
    Then User should see email "can.yondem.22@gmail.com" in main page