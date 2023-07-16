# Gilded Rose starting position in Java

The project aims to refactor a Kata project called `Gilded Rose` that can be reachable from the address: 
https://github.com/emilybache/GildedRose-Refactoring-Kata/

## Rules to Apply
* All items have a `SellIn` value which denotes the number of days we have to sell the item.
* All items have a `Quality` value which denotes how valuable the item is.
* At the end of each day our system lowers both values for every item.
* Once the sell by date has passed, `Quality` degrades twice as fast.
* The `Quality` of an item is never negative.
* `Aged Brie` actually increases in Quality the older it gets.
* The `Quality` of an item is never more than `50`.
* `Sulfuras`, being a legendary item, never has to be sold or decreases in Quality.
* `Backstage passes`, like aged brie, increases in Quality as its SellIn value approaches. `Quality` increases by `2`
when there are `10` days or less and by `3` when there are `5` days or less but `Quality` drops to `0` after the concert.
* `Conjured` items degrade in `Quality` twice as fast as normal items

You may get additional information from the specification document `\docs\GildedRoseRequirements.txt`
To understand the spaghetti flows that is given at the initial code, you can check the flowchart documents.
(`\docs\1_updateQuality_BeforeExpire.png`, `2_updateSellin.png`, `3_updateQuality_AfterExpire.png` )
These charts do not contain `Conjured` items, since it was not implemented in the initial code.

## Keywords
The system implemented with the versions below

![](https://img.shields.io/badge/java-11-green)

## Installation & Deployment Steps

### Requirements:

* Building tool `Gradle` must be installed on your machine.

#### Running the Application
## Run the Text Fixture from Command-Line

```
./gradlew -q text
```

### Specify Number of Days

For e.g. 10 days:

```
./gradlew -q text --args 10
```

* Run/Debug the Application from `TexttestFixture` which will simulate the application.

## Usage

### Authentication & Authorization

No Authentication is used.

### Test

Test coverage is set to 100%
You can get detailed `Jacoco` report with the command below.
It will automatically generate a `Jacoco` report under the directory of:
`/build/reports/jacoco/test/html/index.html`

```shell script
./gradlew build jacocoTestReport
```

## Support
You can solve the issues `/to-do`'s if you want that is written in the roadmap part.
Priorities are in the order of the issue numbers

## Roadmap
* `#todo-1` If `Goblin` accepts to modify Item class, refactor `Item` and all models; Take `Item` as a base class
* `#todo-2` Storing mechanism also can be implemented (DB integration?)
* `#todo-3` Estimation method can be written that takes day and Item and gives the future value of it.


## Contributing
The project is open to contribution especially the issues that are written in RoadMap.


## Authors and Acknowledgment

*`my family` that allow me to implement this amusing project.

*`Authors of Gilded Rose` thanks to authors to prepare such a funny nice Kata.

*`github` for giving us this amazing facility.

*`World of Warcraft` this project reminds me good old times in the past.

## License
![](https://img.shields.io/badge/MIT-License-red)

vmaltas
