@RAPID
  Feature: BraveNewCoin API Scenarios

    Rule: When I send a POST request, I receive a token I can use it to make further authenticated calls.

      @FIRST
    Scenario: As a user a can retrieve a Token when making a valid post request
      Given I have a valid API key for the https://bravenewcoin.p.rapidapi.com URI
      When I send a POST request with a valid body to the endpoint /oauth/token
      Then I can validate I received a valid token in the response

    Scenario: As a user, when I can use an invalid API key, I get a HTTP Code Status 403
      Given I have an invalid API key for the https://bravenewcoin.p.rapidapi.com URI
      When I send a POST request with a valid body to the endpoint /oauth/token
      Then I can validate I received a HTTP Code Status 403

    Scenario: As a user, when I can send the request without "grand_type", I get a HTTP Code Status 400
      Given I have a valid API key for the https://bravenewcoin.p.rapidapi.com URI
      When I send a POST request with an invalid body to the endpoint /oauth/token
      Then I can validate I received a HTTP Code Status 400



