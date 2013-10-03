package com.acrobot.chestshop.towny;

import com.Acrobot.Breeze.Configuration.Configuration;
import com.acrobot.chestshop.towny.properties.Properties;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;

/**
 * @author Acrobot
 */
public class Towny extends JavaPlugin {
    private static File dataFolder;

    public void onEnable() {
        dataFolder = getDataFolder();

        Configuration.pairFileAndClass(loadFile("config.yml"), Properties.class);

        if (Properties.BUILDING_INSIDE_PLOTS) {
            getServer().getPluginManager().registerEvents(new PlotListener(), this);
        }
    }

    public static File loadFile(String string) {
        File file = new File(dataFolder, string);

        return loadFile(file);
    }

    private static File loadFile(File file) {
        if (!file.exists()) {
            try {
                file.getParentFile().mkdirs();
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return file;
    }
}
