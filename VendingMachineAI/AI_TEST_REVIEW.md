# AI-Generated Test Review — Task 2

ChatGPT initially generated 15 tests covering basic functionality, invalid inputs, and exceptions. The tests were well organized and helped identify a bug in the VendingMachine constructor. After fixing the bug, all 15 tests passed.

Compared to my 30 manual tests, the AI tests were just as thorough after some slight corrections. My manual tests achieved 100% coverage, while the initial AI tests reached 93.06% line coverage for VendingMachine and 100% for VendingMachineItem. Some tests were repetitive, and a few important cases were missed.

After providing ChatGPT with the uncovered lines, it generated three additional tests for slots C and D and purchasing from an empty slot. This brought the total to 18 passing tests and increased line coverage to 100% for both classes.

AI was helpful and very fast for generating tests, it missed some cases that I had covered manually but with JUnit this takes no time to identify. AI generated tests are more time efficient assuming proper review.