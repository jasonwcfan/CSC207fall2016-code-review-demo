# Code Review Demo
This is a demo for the Fall 2016 offering of CSC207, intended to show some code that runs, but is written poorly and has many
design errors. A full list of the errors will be posted after the demo. (feel feel to submit PRs for any more errors/optimizations
you may find!)

Contributors:
- [Jason Fan] (https://github.com/jasonwcfan)
- [Colin Chartier] (https://github.com/ColinChartier)

## Classes

`MoneyStorage`
`BankAccount`
`PiggyBank`
`TotalMoney`
`PovertyException`



# Issues

1. Money should not be stored as double. Int for dollar and Int for cents works better
2. TotalMoney does not need to be a static class. Probably better to be represented as a “Person” object or something, and each person tracks their finances individually from all other people so we need to be able to create separate instances of it.
3. naming of smashPiggyBank and oinkBalance does not make it clear what they actually do
4. PovertyException can be a checked exception so it should subclass Exception instead of RuntimeException
5. Related to #4, withdraw and deposit can handle PovertyException with try/catch blocks instead of just throwing the exception
6. Related to #4, PovertyException does not make it clear what the exception actually is, especially since it’s called for 2 different cases: when the PiggyBank has too low a balance for a withdrawal, and also when TotalMoney is too low to deposit to a PiggyBank
7. MoneyStorage makes more sense as an abstract class or interface instead of an object (an instance of “MoneyStorage” makes no sense)
8. PiggyBank location is not unique, but transferMoneyToPiggyBank assumes it is
9. location/accountNumber should not be public, should use getters/setters
10. withdrawalLimit and capacity should be set in the constructor, not hard coded.
11. no documentation
