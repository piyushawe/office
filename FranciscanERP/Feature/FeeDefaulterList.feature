Feature: Franciscan ERP

  @scenario1
  Scenario: To open fee defaulter receipt
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then fee defaulter page is opened
    Then user selects class"1" on fee defaulter list
    And selects section"A" on fee defaulter list
    Then selects installment"JANUARY - MARCH" on fee defaulter list
    Then filter with cheque clearing date
    Then selects with fine on fee defaulter list
    Then selects without head on fee defaulter list
    Then click on show on fee defaulter list

  @scenario2
  Scenario: To open fee defaulter receipt
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then fee defaulter page is opened
    Then select school"All Schools" on fee defaulter list
    Then user selects class"1" on fee defaulter list
    And selects section"A" on fee defaulter list
    Then selects installment"JANUARY - MARCH" on fee defaulter list
    Then selects without head on fee defaulter list
    Then click on show on fee defaulter list

  @scenario3
  Scenario: To open fee defaulter receipt
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then fee defaulter page is opened
    Then select school"All Schools" on fee defaulter list
    Then user selects class"1" on fee defaulter list
    And selects section"A" on fee defaulter list
    Then selects installment"JANUARY - MARCH" on fee defaulter list
    Then selects with fine on fee defaulter list
    Then selects with head on fee defaulter list
    Then click on show on fee defaulter list

  @scenario4
  Scenario: To open fee defaulter receipt
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then fee defaulter page is opened
    Then select school"All Schools" on fee defaulter list
    Then user selects class"1" on fee defaulter list
    And selects section"A" on fee defaulter list
    Then selects installment"JANUARY - MARCH" on fee defaulter list
    Then selects with head on fee defaulter list
    Then click on show on fee defaulter list

  @scenario5
  Scenario: To open fee defaulter receipt
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then fee defaulter page is opened
    Then user click class range on fee defaulter list
    Then user select class range "1-A" on fee defaulter list
    Then selects installment"APRIL" on fee defaulter list
    Then user click date range on fee defaulter list
    Then user select from date as month "April" year "2016" and day "1" on fee defaulter list
    Then user select to date as month "April" year "2016" and day "30" on fee defaulter list
    Then selects with fine on fee defaulter list
    Then selects with head on fee defaulter list
    Then click on show on fee defaulter list
