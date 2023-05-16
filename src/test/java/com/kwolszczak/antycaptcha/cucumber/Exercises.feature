@tag
  Feature: Do all of the given exercises

    Background:
      Given I landed on main page

    @tag2
    Scenario Outline: Positive test of exercise one - three buttons
      Given landing page is opened for user <name>
      When  I open three button page
      And   execute all steps
      And   check solution
      Then  <ok> message is displayed on the page

      Examples:
      |ok               |name       |status   |
      |"OK. Good answer"|"Kamil"    |"succes" |

