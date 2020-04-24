# OrderManager
[![time tracker](https://wakatime.com/badge/github/ssysm/OrderManager.svg)](https://wakatime.com/badge/github/ssysm/OrderManager)
[![Build Status](https://travis-ci.org/ssysm/OrderManager.svg?branch=master)](https://travis-ci.org/ssysm/OrderManager)
[![Maintainability](https://api.codeclimate.com/v1/badges/d8a132847042f1682439/maintainability)](https://codeclimate.com/github/ssysm/OrderManager/maintainability)

A Java Order System Manager

## Requirements & Running

Requirements:
- Java 11(or later)

To run, [download](https://github.com/ssysm/OrderManager/releases) the latest version of the jar file or [build](#Development-Instructions) it
your self.

## Development Instructions
###Run@Intellij:
 
Requirements:
- Java 11 SDK
- Intellij Idea

Steps:
1. Clone this repo.
1. Open in Intellij Idea
1. Navigate to [`OrderManager.java`](src/main/java/com/theeditorstudio/ordermanager/OrderManager.java)
1. Run `OrderManager.main()`

###Build@Maven

Requirements:
- Java 11 SDK
- Maven 3.3

Steps:
1. Clone this repo.
1. `maven package`

Build jar file located at `target/OrderManager[-jar-with-dependencies].jar`

## System Structure

### [`com.theeditorstudio.ordermanager.actions`](src/main/java/com/theeditorstudio/ordermanager/actions)
This package contains all the `ActionListener` Implementations.

In this package, `menu` sub-package contains listener that was bind to
all `JMenuItem`, `table` sub-package contains listener that was bind to all
`JTable`.
 
### [`com.theeditorstudio.ordermanager.adapters`](src/main/java/com/theeditorstudio/ordermanager/adapters)
This package contains all GUI Adapter Implementations.

### [`com.theeditorstudio.ordermanager.interfaces`](src/main/java/com/theeditorstudio/ordermanager/interfaces)
This package contains both data & class interface.

### [`com.theeditorstudio.ordermanager.menus`](src/main/java/com/theeditorstudio/ordermanager/menus)
This package contains all `JMenu*` related class & class factory.

### [`com.theeditorstudio.ordermanager.models`](src/main/java/com/theeditorstudio/ordermanager/models)
This package contains both normal data model and `JTabel`'s `TabelModel` implementations.

### [`com.theeditorstudio.ordermanager.parsers`](src/main/java/com/theeditorstudio/ordermanager/parsers)
This package contains a parser and a serializer to retrieve and store CSV file.

### [`com.theeditorstudio.ordermanager.utils`](src/main/java/com/theeditorstudio/ordermanager/utils)
This package contains various static helper functions. The `searchs` sub-package contains
only searching helper functions.

### [`com.theeditorstudio.ordermanager.windows`](src/main/java/com/theeditorstudio/ordermanager/windows)
This package contains all additional window/dialog that will be used 
in this program. The `searchs` sub-package contains only searching windows.




