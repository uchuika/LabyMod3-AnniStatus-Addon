package com.uchuika.anniaddon;

import java.util.List;

import com.uchuika.anniaddon.module.ActiveKillModule;
import com.uchuika.anniaddon.module.NexusCounterModule;
import com.uchuika.anniaddon.module.TotalKillModule;
import net.labymod.api.LabyModAddon;
import net.labymod.settings.elements.BooleanElement;
import net.labymod.settings.elements.ControlElement;
import net.labymod.settings.elements.ControlElement.IconData;
import net.labymod.settings.elements.KeyElement;
import net.labymod.settings.elements.SettingsElement;
import net.labymod.utils.Consumer;
import net.labymod.utils.Keyboard;
import net.labymod.utils.Material;

public class AnniStatusAddon extends LabyModAddon {

  private static AnniStatusAddon instance;
  @Override
  public void onEnable() {
    instance = this;

    AnniPlayerData.meleekillCount = 0;
    AnniPlayerData.activekillCount = 0;
    AnniPlayerData.nexus = 0;

    getApi().getEventService().registerListener(new AnniMessageReciveEvent());



    getApi().registerModule(new ActiveKillModule());
    getApi().registerModule(new TotalKillModule());
    getApi().registerModule(new NexusCounterModule());
  }

  @Override
  public void loadConfig() {

  }

  @Override
  protected void fillSettings(List<SettingsElement> list) {
    list.add(new BooleanElement("test", new IconData(Material.ACACIA_FENCE)));

    list.add( new BooleanElement( "killCountReset" /* Display name */, new ControlElement.IconData( Material.LEVER ), new Consumer<Boolean>() {
      @Override
      public void accept( Boolean accepted ) {
        AnniPlayerData.meleekillCount = 0;
        AnniPlayerData.activekillCount = 0;
        AnniPlayerData.nexus = 0;
      }
    } /* Change listener */, true /* current value */ ) );


    /*
    list.add(new KeyElement( "Open Module Editor" ,
            new ControlElement.IconData( "labymod/textures/settings/elements/settings/keymoduleeditor.png" ),
            Integer.parseInt(Keyboard.getKeyName(70)) , accepted -> {
              if ( accepted == -1 ) {
                System.out.println( "Set new key to NONE" );
                return;
              }

              System.out.println( "Set new key: " + Keyboard.getKeyName( accepted ) );
            }));

     */
  }



  public static AnniStatusAddon get() {
    return instance;
  }
}
