<div align="center">
  <h1>Bukkit Menu Framework</h1>
  
  ![Licence](https://img.shields.io/github/license/ericstolly/menu-api?style=for-the-badge)
 
   <a href="https://github.com/ericstolly/menu-api/stargazers"><img src="https://img.shields.io/github/stars/ericstolly/menu-api" alt="Stars Badge"/></a>
  <a href="https://github.com/ericstolly/menu-api/network/members"><img src="https://img.shields.io/github/forks/ericstolly/menu-api" alt="Forks Badge"/></a>
  <a href="https://github.com/ericstolly/menu-api/pulls"><img src="https://img.shields.io/github/issues-pr/ericstolly/menu-api" alt="Pull Requests Badge"/></a>
  <a href="https://github.com/ericstolly/menu-api/issues"><img src="https://img.shields.io/github/issues/ericstolly/menu-api" alt="Issues Badge"/></a>
  <a href="https://github.com/ericstolly/menu-api/graphs/contributors"><img alt="GitHub contributors" src="https://img.shields.io/github/contributors/ericstolly/menu-api?color=2b9348"></a>
</div>

## Usage

### Menu Types
There are plenty of menu types you can pick from to star in your next product with many more in the works.
These can be found in `MenuType#`.
```java
SINGLE_ROW_CHEST (1 Row),
DOUBLE_ROW_CHEST (2 Rows),
TRIPPLE_ROW_CHEST (3 Rows),
QUADRUPLE_ROW_CHEST (4 Rows),
QUINTUPLE_ROW_CHEST (5 Rows),
SEXTUPLE_ROW_CHEST (6 Rows),
HOPPER,
BREWING_STAND,
DISPENSER,
DROPPER;
```

### Update Types
There are 3 update modes that control how menus are updated/refreshed on your server.
These can be found in `ButtonUpdateType#`.
```java
RUNNABLE (Repeating task every x amount of time),
ON_CLICK (Only when someone clicks a button),
NONE;
```

## Implementations

### Menus
Menus can be easily created with a few lines of code. We have provided you an example below.
```java
public class ExampleMenu extends Menu {
  
    @Override
    public String getTitle(final @NonNull Player player) {
        return ChatColor.GOLD + "Example Menu";
    }

    @Override
    public MenuType getMenuType() {
        return MenuType.SINGLE_ROW_CHEST;
    }

    @Override
    public Map<Integer, MenuButton> getButtons(final @NonNull Player player) {
        HashMap<Integer, MenuButton> toReturn = new HashMap<Integer, MenuButton>();
        
        toReturn.put(1, new SimpleButton(new ItemstackBuilder(Material.DIRT).build(), false, null));
        
        return toReturn;
    }
}
```

Making a menu update/refresh is quickly done by overriding the `getUpdateType(ButtonUpdateType)#`. To disable all update/refreshing of buttons you simply have to remove the overriding method. It will default to `ButtonUpdateType.NONE`.

</br>

### Buttons
We have provided you with `SimpleButton#` to speed up development using this Framework. We have provided you an example below.
```java
new SimpleButton(new ItemstackBuilder(Material.DIRT).build(), false, null);
```

Buttons can also have a listener attached to them. This can be in an in-line or seperate class style or simply set to null if not required. We have provided you an example below.
```java
// In-line style

new SimpleButton(new ItemstackBuilder(Material.DIRT).build(), false, (InventoryClickEvent event) -> { 
            event.getWhoClicked().sendMessage("Hello World from inline class!");
        });
```

```java
// Seperate class style

public class ExampleButtonListener implements MenuButtonListener, Listener {

  public void onButtonClick(InventoryClickEvent event) {
    event.getWhoClicked().sendMessage("Hello World from seperate class!");
  }
}

```
This method can be paired with the provided `ItemstackBuilder#` class and methods to easily create the button `ItemStack#`. 
* JavaDoc
  * SimpleButton(ItemStack itemStack, boolean editable, MenuButtonListener menuButtonListener)

</br>

### Registering The Listener
Once you have created your menu, buttons, it's time to register the listener. We have provided you an example below.
```java
public class ExamplePlugin extends JavaPlugin {

  @Override
  public void onEnable() {
    getServer().getPluginManager().registerEvents(new MenuListener(), (Plugin)this);
  }
}
```
</br>

### Opening A Menu
Once you have created your menu, buttons and registered the listener, you can now open it! We have provided you an example below.
```java
new ExampleMenu(instance).open(player);
```
* JavaDoc
  * ExampleMenu(JavaPlugin javaPlugin)

</br>

<div align="center">
  <h2>Authors</h2> 
  <a href="https://github.com/ericstolly">Eric Stolly</a> </br>
  <a href="https://github.com/RealCharlotte">Charlotte</a> </br>
</div>
