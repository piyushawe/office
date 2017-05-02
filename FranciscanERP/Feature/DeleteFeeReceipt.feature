Feature: Franciscan ERP

  @delete1
  Scenario: To delete fee receipt by student details
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then delete fee receipt page is opened
    Then user searches a student to delete by class"1" section"A" and student details"sonia1"
    Then user enters the reason"test" to delete
    Then user deletes the receipt "10145"

  @delete2
  Scenario: To delete cancelled fee receipt
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then delete fee receipt page is opened
    Then user searches a student to delete by class"1" section"A" and student details"aditya ranjan"
    Then select search cancel fee receipt
    Then user enters the reason"test" to delete
    Then user deletes the receipt "9943"

  @delete3
  Scenario: To delete all cancelled fee receipts
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then delete fee receipt page is opened
    Then user searches a student to delete by class"test1" section"A" and student details"sonia5"
    Then select search cancel fee receipt
    Then user deletes all the cancelled fee receipts

  @delete4
  Scenario: To delete all fee receipts
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then delete fee receipt page is opened
    Then user searches a student to delete by class"test1" section"A" and student details"sonia1"
    Then user delete all the fee receipts
