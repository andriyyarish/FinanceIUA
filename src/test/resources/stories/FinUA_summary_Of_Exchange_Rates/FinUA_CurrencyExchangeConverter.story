Meta:

Narrative:
As a user I am going to sell some amount of currency
I want to perform calculation
So I can calculate expected amount of currency which I can get

Scenario: Open Currency converter tab
Given the user is on the finance.i.ua home page
When user click on CurrencyConverter link
Then user should see currency converter Page
And url should be equal to 'http://finance.i.ua/converter/'