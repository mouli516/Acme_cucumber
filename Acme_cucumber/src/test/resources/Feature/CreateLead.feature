Feature: CreateLead

  Scenario Outline: Verifying CreateLead by Creating New Lead
    Given User Opened the Chrome browser
    And user is on Acme_Crm Loginpage
    When User Enter valid <UserName> and <Passsword>
    When User Clicks On LeadsButton
    And User is On LeadsPage
    When User ClicksOn Create New LeadButton
    And User in New Leads Page
    When User Enters <company> and <lastName> in Comopany and Lastname textFields
    Then NewLead Created and user is in Lead Details Page

    Examples: 
      | UserName        | Password | company | lastName       |
      | rashmi@dell.com | 123456   | Wipro   | mouli Nadipena |
