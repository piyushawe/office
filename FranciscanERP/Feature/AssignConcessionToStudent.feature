Feature: Franciscan ERP

  @scenario1
  Scenario: Assign concession to student
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then assign concession to student page is opened
    Then select class "test1" on assign concession to student page
    Then select section "A" on assign concession to student page
    Then assign concession "100% Concession on Tuition Fee APRIL" to student "sonia5" on assign concession to student page
    Then click update on assign concession to student page