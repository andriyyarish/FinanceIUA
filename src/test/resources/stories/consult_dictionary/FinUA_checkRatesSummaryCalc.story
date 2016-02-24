Check calculation of summary exchange rates
Narrative:
In order to check calculation of exchange rates in summary table
As an user
I want to calc summary rates of EUR currency based on collection of rates from each bank and compare with summary table

Scenario: Checking switching to EUR-UAH bank's rates data
Given the user is on the finance.i.ua home page
When the user click on 'EUR' button
Then 'EUR' rates are shown

Scenario: Checking calculation of MAXIMUM EUR-UAH rates based on bank's rates data
Given the user is on the finance.i.ua home page
When the user click on 'EUR' button
Then 'EUR' rates are shown
Then maximum value of BID rate in bank's table is equal to maximum value of BID rate in summary table
Then maximum value of ASK rate in bank's table is equal to maximum value of ASK rate in summary table

Scenario: Checking calculation of AVERAGE EUR-UAH rates based on bank's rates data
Given the user is on the finance.i.ua home page
When the user click on 'EUR' button
Then 'EUR' rates are shown
Then calculated avg BID rate is equal to avg BID value from summary block
Then calculated avg ASK rate is equal to avg ASK value from summary block

Scenario: Checking calculation of MINIMUM EUR-UAH rates based on bank's rates data
Given the user is on the finance.i.ua home page
When the user click on 'EUR' button
Then 'EUR' rates are shown
Then minimum value of BID rate in bank's table is equal to minimum value of BID rate in summary table
Then minimum value of ASK rate in bank's table is equal to minimum value of ASK rate in summary table

Scenario: Checking calculation of OPTIMAL EUR-UAH rates based on bank's rates data
Given the user is on the finance.i.ua home page
When the user click on 'EUR' button
Then 'EUR' rates are shown
Then optimal value of BID rate in summary table is equal to maximum value of BID rate in summary table
Then optimal value of ASK rate in summary table is equal to minimum value of ASK rate in summary table
