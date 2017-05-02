Feature: Franciscan ERP

  @scenario1
  Scenario: To delete all the set due limits
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then set due limit page is opened
    Then user click view on set due limit page
    Then user delete all the records on set due limit page

  @scenario2
  Scenario: To set due limit for all classes and all fee types as amount on all heads
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then set due limit page is opened
    Then user click yes of late fee on due on set due limit page
    Then user enter dues amount as "100" on set due limit page
    Then user click save on set due limit page

  @scenario3
  Scenario: To set due limit for all classes and all fee types as due percent on all heads
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then set due limit page is opened
    Then user click yes of late fee on due on set due limit page
    Then user enter dues percent as "50" on set due limit page
    Then user click percent on set due limit page
    Then user click save on set due limit page

  @scenario4
  Scenario: To set due limit for single class and single fee type as due amount on all heads
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then set due limit page is opened
    Then user select class "1" on set due limit page
    Then user select fee type "SCHOOL FEE" on set due limit page
    Then user click yes of late fee on due on set due limit page
    Then user enter dues amount as "100" on set due limit page
    Then user click save on set due limit page

  @scenario5
  Scenario: To set due limit for single class and single fee type as due percent on all heads
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then set due limit page is opened
    Then user select class "1" on set due limit page
    Then user select fee type "SCHOOL FEE" on set due limit page
    Then user click yes of late fee on due on set due limit page
    Then user enter dues percent as "50" on set due limit page
    Then user click percent on set due limit page
    Then user click save on set due limit page

  @scenario6
  Scenario: To set due limit for single class and single fee type as due amount on single head
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then set due limit page is opened
    Then user select class "1" on set due limit page
    Then user select fee type "SCHOOL FEE" on set due limit page
    Then user click yes of late fee on due on set due limit page
    Then user enter dues amount as "100" on set due limit page
    Then user select head "TUITION FEE" on set due limit page
    Then user click save on set due limit page

  @scenario7
  Scenario: To set due limit for single class and single fee type as due percent on single head
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then set due limit page is opened
    Then user select class "1" on set due limit page
    Then user select fee type "SCHOOL FEE" on set due limit page
    Then user click yes of late fee on due on set due limit page
    Then user enter dues percent as "50" on set due limit page
    Then user click percent on set due limit page
    Then user select head "TUITION FEE" on set due limit page
    Then user click save on set due limit page
    
  @scenario8
  Scenario: To set due limit for all classes and all fee types as amount on single head
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then set due limit page is opened
    Then user click yes of late fee on due on set due limit page
    Then user enter dues amount as "100" on set due limit page
    Then user select head "TUITION FEE" on set due limit page
    Then user click save on set due limit page
   
  @scenario9
  Scenario: To set due limit for all classes and all fee types as amount on single head
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then set due limit page is opened
    Then user click yes of late fee on due on set due limit page
    Then user enter dues percent as "50" on set due limit page
    Then user click percent on set due limit page
    Then user select head "TUITION FEE" on set due limit page
    Then user click save on set due limit page