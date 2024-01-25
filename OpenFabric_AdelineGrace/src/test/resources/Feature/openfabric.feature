Feature: Openfabric AI Testnet

  Scenario: User visits the Openfabric website
    Given User wants to explore Openfabric AI Testnet
    When User visits Openfabric webpage
    Then User lands on login page

  Scenario: User finds Metamask missing popup
    Given User is in the Openfabric login page
    When User clicks Login with Metamask icon
    Then User finds the pop up with the message "MetaMask Missing"

  Scenario: User installs Metamask
    Given User finds Metamask is not installed
    When User follows onscreen instruction to install Metamask
    Then User finds Metamask is installed

  Scenario: User setups Metamask
    Given User finds Metamask is not installed
    When User follows onscreen instruction to setup Metamask
    Then User connects the Openfabric AI with Metamask

  Scenario: User finds Metamask installed
    Given User is in the Openfabric login page
    When User clicks Login with Metamask icon
    Then User finds Metamask is installed in the system

  Scenario: User can signup with valid details
    Given User is in the Openfabric login page
    When User Clicks "Sign Up" after Entering the valid values in the Registration Form
    Then User lands on the Openfabric AI Testnet page

  Scenario: User cannot signup with invalid email
    Given User is in the Openfabric login page
    When User Clicks "Sign Up" after Entering the invalid values in the Registration Form
    Then User receives error message "Invalid Credentials"

  Scenario: User cannot signup with missing firstname
    Given User is in the Openfabric login page
    When User Clicks "Sign Up" after Entering the missing FirstName in the Registration Form
     Then User receives First Name error message "The first name is required"

  Scenario: User cannot signup with missing lastname
    Given User is in the Openfabric login page
    When User Clicks "Sign Up" after Entering the missing LastName in the Registration Form
    Then User receives Last Name error message "The last name is required"

  Scenario: User cannot signup with missing email
    Given User is in the Openfabric login page
    When User Clicks "Sign Up" after Entering the missing Email in the Registration Form
    Then User receives Email error message "The email is required"

  Scenario: User can see available AI apps
    Given User is in the Openfabric AI Testnet page
    When User clicks on "AI Marketplace" dropdown
    Then User sees all the available AI app

  Scenario: User can choose available AI apps
    Given User is in the Openfabric AI Testnet page
    When User clicks on "AI Marketplace" dropdown
    Then User chooses his favorite available AI app

  Scenario: User cannot select his favorite AI app
    Given User is in the Openfabric AI Testnet page
    When User clicks on "AI Marketplace" dropdown
    Then User is not able to select his favorite available AI app

  Scenario: User navigates to the chosen AI app page
    Given User is in the Openfabric AI Testnet page
    When User clicks on the favorite AI app
    Then User navigates to the chosen AI app page

  Scenario: User stays on the same Openfabric Testnet page
    Given User is in the Openfabric AI Testnet page
    When User clicks on the favorite AI app
    Then User stays on the same Openfabric Testnet page

  Scenario: User finds the "+Create instances" icon
    Given User is in the chosen AI app
    When User gets navigated to the chosen AI app page
    Then User sees the "+Create instances" icon

  Scenario: User not able to see the "+Create instances" icon
    Given User is in the chosen AI app
    When User gets navigated to the chosen AI app page
    Then User not able to see the "+Create instances" icon
    
  Scenario: User starts the create instance flow
    Given User is in the chosen AI app
    When User clicks "+Create instances" icon
    Then User starts the create instance flow

  Scenario: User doesn't get started with the create instance flow
    Given User is in the chosen AI app
    When User clicks "+Create instances" icon
    Then User doesnt get started with the create instance flow

  Scenario: User can choose the favorite Infrastructure option
    Given User is in the chosen AI app
    When User clicks "+Create instances" icon
    Then User sees the options of "Infrastructure Selection"
    And User chooses the favorite Infrastructure option

  Scenario: User not able to choose the favorite Infrastructure option
    Given User is in the chosen AI app
    When User clicks "+Create instances" icon
    Then User sees the options of "Infrastructure Selection"
    And User is not able to choose the favorite Infrastructure option

  Scenario: User gets navigated to the Payment stage
    Given User is in the chosen AI app
    When User chooses an infrastructure option
    Then User gets navigated to the Payment stage

  Scenario: User stays on the infrastructure selection
    Given User is in the chosen AI app
    When User chooses an infrastructure option
    Then User stays on the infrastructure selection

  Scenario: User receives Payment success confirmation
    Given User chosen infrastructure option
    When User sees that the Payment process started
    Then User receives Payment success confirmation

  Scenario: User receives Payment process failed message
    Given User chosen infrastructure option
    When User sees that the Payment process started
    Then User receives Payment process failed message

  Scenario: User enters installation process of the AI app
    Given User has chosen the infrastructure selection for the AI app
    When User reviews the costs of both AI app and infrastructure
    And User gets payment successful confirmation
    Then User enters the installation process of AI app

  Scenario: User not able to enter the installation process of AI app
    Given User has chosen the infrastructure selection for the AI app
    When User reviews the costs of both AI app and infrastructure
    And User doesn't get payment successful confirmation
    Then User not able to enter the installation process of AI app

  Scenario: User can access the chosen AI app
    Given User enters installation process of AI app
    When User sees installation complete
    Then User can able to access the AI app

  Scenario: User not able to access the AI app
    Given User enters the installation process of AI app
    When User sees installation complete
    Then User not able to access the AI app

  Scenario: User can run the AI app
    Given User able to access the AI app
    When User follows the on-screen prompt to set up the app
    And User clicks "Run"
    Then User is able to set the app in motion

  Scenario: User not able to run the AI app
    Given User can able to access the AI app
    When User follows the on-screen prompt to set up the app
    And User clicks "Run"
    Then User not able to set the app in motion

  Scenario: User can rate the app
    Given User can access the chosen AI app
    When User clicks ratings
    Then User can rate the app

  Scenario: User not able to rate the app
    Given User can access the chosen AI app
    When User clicks ratings
    Then User not able to rate the app

  Scenario: User can add notes about the app experience
    Given User can access the chosen AI app
    When User clicks the notes textbox
    Then User is able to add notes about the app experience

  Scenario: User not able to add notes about the app experience
    Given User can access the chosen AI app
    When User clicks the notes textbox
    Then User not able to add notes about the app experience

