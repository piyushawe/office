Feature: Franciscan ERP

  @scenario1
  Scenario: Assign opening balance to a student on a particular fee type and verify on fee entry page
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then assign opening balance page is opened
    Then select class "test1" on assign opening balance page
    Then select section "A" on assign opening balance page
    Then select fee type "SCHOOL FEE" on assign opening balance page
    Then assign opening balance to student "sonia5" of amount "1000" on assign opening balance page
    Then click save on assign opening balance page
    Then go back to the default page
    Then fee entry form is opened
    Then user searches a student on fee entry form by class"test1" section"A" and student details"sonia5"
    Then user select fee type "SCHOOL FEE" on fee entry page
    Then verify advance amount "1000" on fee entry page

  @scenario2
  Scenario: Assign opening balance to a student on a different fee types and verify on fee entry page with all fee types
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then assign opening balance page is opened
    Then select class "test1" on assign opening balance page
    Then select section "A" on assign opening balance page
    Then select fee type "SCHOOL FEE" on assign opening balance page
    Then assign opening balance to student "sonia5" of amount "1000" on assign opening balance page
    Then click save on assign opening balance page
    Then select fee type "TRANSPORT" on assign opening balance page
    Then assign opening balance to student "sonia5" of amount "1000" on assign opening balance page
    Then click save on assign opening balance page
    Then go back to the default page
    Then fee entry form is opened
    Then user searches a student on fee entry form by class"test1" section"A" and student details"sonia5"
    Then user select fee type "All FeeTypes" on fee entry page
    Then verify advance amount "2000" on fee entry page

  @scenario3
  Scenario: Assign opening balance to a student on a different fee types and verify on fee entry page with individual fee types
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then assign opening balance page is opened
    Then select class "test1" on assign opening balance page
    Then select section "A" on assign opening balance page
    Then select fee type "SCHOOL FEE" on assign opening balance page
    Then assign opening balance to student "sonia9" of amount "1000" on assign opening balance page
    Then click save on assign opening balance page
    Then select fee type "TRANSPORT" on assign opening balance page
    Then assign opening balance to student "sonia9" of amount "1000" on assign opening balance page
    Then click save on assign opening balance page
    Then go back to the default page
    Then fee entry form is opened
    Then user searches a student on fee entry form by class"test1" section"A" and student details"sonia9"
    Then user select fee type "SCHOOL FEE" on fee entry page
    Then verify advance amount "1000" on fee entry page
    Then user select fee type "TRANSPORT" on fee entry page
    Then verify advance amount "1000" on fee entry page