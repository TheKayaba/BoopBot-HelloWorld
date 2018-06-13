package com.boopbot.helloworld.commands;

import com.boopbot.commands.Category;
import com.boopbot.commands.CategoryHandler;
import com.boopbot.commands.CommandMessage;
import com.boopbot.contracts.commands.Command;
import com.boopbot.helloworld.HelloWorldPlugin;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class HelloWorldCommand extends Command {

    private final HelloWorldPlugin plugin;

    public HelloWorldCommand(HelloWorldPlugin plugin) {
        super(plugin, false);

        this.plugin = plugin;
    }

    @Override
    public String getName() {
        return "Example Command";
    }

    @Override
    public String getDescription() {
        return "Example Description for the command goes here!";
    }

    @Override
    public List<String> getUsageInstructions() {
        return Arrays.asList(
                "`:command` - Displays the hello world"
        );
    }

    @Override
    public List<String> getExampleUsage() {
        return Collections.singletonList(
                "`:command` - Shows the Hello World! statement"
        );
    }

    @Override
    public List<String> getTriggers() {
        return Collections.singletonList("helloworld");
    }

    @Override
    public List<String> getMiddleware() {
        return Arrays.asList(
                "require:user,general.manage_server",
                "throttle:guild,1,5"
        );
    }

    @Override
    public Category getCategory() {
        return CategoryHandler.fromLazyName("utility");
    }

    @Override
    public boolean onCommand(CommandMessage context, String[] args) {
        context.makeSuccess("Hello World!")
                .queue();
        return true;
    }
}
