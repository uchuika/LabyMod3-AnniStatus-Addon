package com.uchuika.anniaddon.module;

import com.uchuika.anniaddon.AnniPlayerData;
import net.labymod.ingamegui.moduletypes.SimpleModule;
import net.labymod.settings.elements.ControlElement;
import net.labymod.utils.Material;

public class NexusCounterModule extends SimpleModule {
    @Override
    public String getDisplayName() {
        return "Nexus";
    }

    @Override
    public String getDisplayValue() {
        return ""+ AnniPlayerData.nexus;
    }

    /**
     * The value that will be shown if TestSimpleModule#isShown() returns <code>false</code>
     * @return the default value
     */
    @Override
    public String getDefaultValue() {
        return "?";
    }

    @Override
    public ControlElement.IconData getIconData() {
        return new ControlElement.IconData(Material.END_STONE);
    }

    @Override
    public void loadSettings() {

    }

    @Override
    public String getSettingName() {
        return "NexusConter Module";
    }

    @Override
    public String getDescription() {
        return "";
    }

    @Override
    public int getSortingId() {
        return 0;
    }
}
