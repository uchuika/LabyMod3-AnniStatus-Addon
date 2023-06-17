package com.uchuika.anniaddon.module;

import com.uchuika.anniaddon.AnniPlayerData;
import net.labymod.ingamegui.moduletypes.SimpleModule;
import net.labymod.settings.elements.ControlElement;
import net.labymod.utils.Material;

public class TotalKillModule extends SimpleModule {
    @Override
    public String getDisplayName() {
        return "TotalKIll";
    }

    @Override
    public String getDisplayValue() {
        return ""+AnniPlayerData.meleekillCount;
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
        return new ControlElement.IconData(Material.IRON_SWORD);
    }

    @Override
    public void loadSettings() {

    }

    @Override
    public String getSettingName() {
        return "TotalKillModule";
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