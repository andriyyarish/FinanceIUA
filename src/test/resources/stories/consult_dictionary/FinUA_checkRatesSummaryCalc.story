Lookup a definition
Narrative:
In order to check calculation of exchange rates in summary table
As an user
I want to calc average rates of EUR currency based on collection of rates from each bank and compare with summary table

Scenario: Change rates data to EUR-UAH
Given the user is on the finance.i.ua home page
When the user click on 'EUR' button
Then 'EUR' rates are shown
Then calculated avg BID rate is equal to avg BID value from summary block
Then calculated avg ASK rate is equal to avg ASK value from summary block
Then minimum value of BID rate from bank's table is equal to minimum value of BID rate in summary table
Then minimum value of ASK rate from bank's table is equal to minimum value of ASK rate in summary table
Then maximum value of BID rate from bank's table is equal to maximum value of BID rate in summary table
Then maximum value of ASK rate from bank's table is equal to maximum value of ASK rate in summary table


