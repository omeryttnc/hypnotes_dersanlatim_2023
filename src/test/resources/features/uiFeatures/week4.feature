Business Need: week 4

  @UI
  @therapist
  Scenario: US_078 part 1
    When user clicks on Documents on the side bar
    Then Add New Document should be visible

    When user clicks on Add New Document button
    Then user should be on upload page
    And cancel, upload, select file should be visible

    When user clicks on Cancel button
    Then Add New Document should be visible

  @UI
  @therapist
  Scenario: US_078 part 2
    When user clicks on Documents on the side bar
    And user clicks on Add New Document button
    Then user should be on upload page

    When user should be able to upload document
    And file Name window should be active when the file is added
    And you click the Next button
    Then the Add Annotation section should be visible
    When user click on view Guide
    Then OK and cancel button should be visible
    And video should play when click view guide


  @UI
  @therapist
  Scenario: US_078 part 3
    When user clicks on Documents on the side bar
    And user clicks on Add New Document button
    Then user should be on upload page

    When user should be able to upload document
    And you click the Next button

    And add Text Field, Add Checkbox, Add Signature Field, Add Text Input, Add Signature Input, Previus Page, Next Page, Zoom In, Zoom Out buttons should be visible

    When user clicks on signature field
    Then signature field should be able to be generated

    When user clicks on Preview button
    And Save button should be visible

    When user clicks on save button
    When user should be able to see "Document Successfully uploaded. You will be redirected to the main documents page in 3 seconds." as alert message

    When user click on delete button to delete document
    And user click on Yes button
    When user should be able to see "Document deleted" as alert message
