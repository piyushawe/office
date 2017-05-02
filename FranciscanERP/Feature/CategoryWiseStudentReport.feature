Feature: Franciscan ERP

  @scenario1
  Scenario: Category Wise Student Report
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then category wise student report page is opened
    Then user select category"General" on category wise student report page
    Then user select class "1" on category wise student report page
    And select section "A" on category wise student report page
    And select father profession" Business" on category wise student report page
    Then user click on show on category wise student report page