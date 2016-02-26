Scenario: Checking switching to RUB-UAH bank's rates data

Given the user is on the finance.i.ua home page
When the user click on 'RUB' button
Then 'RUB' rates are shown


Scenario: Checking calculation of MAXIMUM RUB-UAH rates based on bank's rates data

Given the user is on the finance.i.ua home page
When the user click on 'RUB' button
And 'RUB' rates are shown
Then maximum value of BID rate in bank's table is equal to maximum value of BID rate in summary table
Then maximum value of ASK rate in bank's table is equal to maximum value of ASK rate in summary table


Scenario: Checking calculation of AVERAGE RUB-UAH rates based on bank's rates data

Given the user is on the finance.i.ua home page
When the user click on 'RUB' button
And 'RUB' rates are shown
Then calculated avg BID rate is equal to avg BID value from summary block
Then calculated avg ASK rate is equal to avg ASK value from summary block


Scenario: Checking calculation of MINIMUM RUB-UAH rates based on bank's rates data

Given the user is on the finance.i.ua home page
When the user click on 'RUB' button
And 'RUB' rates are shown
Then minimum value of BID rate in bank's table is equal to minimum value of BID rate in summary table
Then minimum value of ASK rate in bank's table is equal to minimum value of ASK rate in summary table


Scenario: Checking calculation of OPTIMAL RUB-UAH rates based on bank's rates data

Given the user is on the finance.i.ua home page
When the user click on 'RUB' button
And 'RUB' rates are shown
Then optimal value of BID rate in summary table is equal to maximum value of BID rate in summary table
Then optimal value of ASK rate in summary table is equal to minimum value of ASK rate in summary table
