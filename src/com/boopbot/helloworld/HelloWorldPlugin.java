package com.boopbot.helloworld;

import com.boopbot.helloworld.commands.HelloWorldCommand;
import com.boopbot.plugin.JavaPlugin;

public class HelloWorldPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        saveDefaultConfig();
        reloadConfig();

        registerCommand(new HelloWorldCommand(this));
    }
}

