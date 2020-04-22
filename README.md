# OrderManager
A Java Order System Manager

## Requirements & Running

Requirements:
- Java 11(or later)

To run, [download](https://github.com/ssysm/OrderManager/releases) the latest version of the jar file or [build](#Development-Instructions) it
your self.

## Development Instructions

Requirements:
- Java 11 SDK
- Intellij Idea

Steps:
1. Clone this repo.
1. Open in Intellij Idea
1. Navigate to [`OrderManager.java`](src/com/theeditorstudio/ordermanager/OrderManager.java)
1. Run `OrderManager.main()`

## System Structure

### [`com.theeditorstudio.ordermanager.actions`](src/com/theeditorstudio/ordermanager/actions)
This package contains all the `ActionListener` Implementations.

In this package, `menu` sub-package contains listener that was bind to
all `JMenuItem`, `table` sub-package contains listener that was bind to all
`JTable`.
 
### [`com.theeditorstudio.ordermanager.adapters`](src/com/theeditorstudio/ordermanager/adapters)
This package contains all GUI Adapter Implementations.

### [`com.theeditorstudio.ordermanager.interfaces`](src/com/theeditorstudio/ordermanager/interfaces)
This package contains both data & class interface.

### [`com.theeditorstudio.ordermanager.menus`](src/com/theeditorstudio/ordermanager/menus)
This package contains all `JMenu*` related class & class factory.

### [`com.theeditorstudio.ordermanager.models`](src/com/theeditorstudio/ordermanager/models)
This package contains both normal data model and `JTabel`'s `TabelModel` implementations.

### [`com.theeditorstudio.ordermanager.parsers`](src/com/theeditorstudio/ordermanager/parsers)
This package contains a parser and a serializer to retrieve and store CSV file.

### [`com.theeditorstudio.ordermanager.utils`](src/com/theeditorstudio/ordermanager/utils)
This package contains various static helper functions. The `searchs` sub-package contains
only searching helper functions.

### [`com.theeditorstudio.ordermanager.windows`](src/com/theeditorstudio/ordermanager/windows)
This package contains all additional window/dialog that will be used 
in this program. The `searchs` sub-package contains only searching windows.




