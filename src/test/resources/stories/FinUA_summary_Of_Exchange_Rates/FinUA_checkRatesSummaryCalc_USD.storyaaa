Scenario: Checking switching to USD-UAH bank's rates data

Given the user is on the finance.i.ua home page
When the user click on 'USD' button
Then 'USD' rates are shown


Scenario: Checking calculation of MAXIMUM USD-UAH rates based on bank's rates data

Given the user is on the finance.i.ua home page
When the user click on 'USD' button
And 'USD' rates are shown
Then maximum value of BID rate in bank's table is equal to maximum value of BID rate in summary table
Then maximum value of ASK rate in bank's table is equal to maximum value of ASK rate in summary table


Scenario: Checking calculation of AVERAGE USD-UAH rates based on bank's rates data

Given the user is on the finance.i.ua home page
When the user click on 'USD' button
And 'USD' rates are shown
Then calculated avg BID rate is equal to avg BID value from summary block
Then calculated avg ASK rate is equal to avg ASK value from summary block


Scenario: Checking calculation of MINIMUM USD-UAH rates based on bank's rates data

Given the user is on the finance.i.ua home page
When the user click on 'USD' button
And 'USD' rates are shown
Then minimum value of BID rate in bank's table is equal to minimum value of BID rate in summary table
Then minimum value of ASK rate in bank's table is equal to minimum value of ASK rate in summary table


Scenario: Checking calculation of OPTIMAL USD-UAH rates based on bank's rates data

Given the user is on the finance.i.ua home page
When the user click on 'USD' button
And 'USD' rates are shown
Then optimal value of BID rate in summary table is equal to maximum value of BID rate in summary table
Then optimal value of ASK rate in summary table is equal to minimum value of ASK rate in summary table
