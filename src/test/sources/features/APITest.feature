Feature: Ejemplo de request

    @API
    Scenario: Prueba Get al endpoint.
    Given I send a GET request to the endpoint
    Then I get a 200 status
