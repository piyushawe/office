Feature: Franciscan ERP

  @scenario1
  Scenario: Draft Tc
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then generate tc page is opened
    Then user click draft tc on generate tc page
    Then user click preview tc of "anshuman" on generate tc page
    Then user click generate tc of "anshuman" on generate tc page

  @scenario2
  Scenario: Generated TC
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then generate tc page is opened
    Then user click generated tc on generate tc page
    Then user click generated preview tc of "anshuman" on generate tc page
    Then user click cancel tc of "anshuman" on generate tc page

  @scenario3
  Scenario: Cancelled TC
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then generate tc page is opened
    Then user click cancelled tc on generate tc page
    Then user click search cancelled tc of "anshuman" on generate tc page
