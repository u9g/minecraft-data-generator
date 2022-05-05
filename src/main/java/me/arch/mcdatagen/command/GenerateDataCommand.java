package me.arch.mcdatagen.command;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.context.CommandContext;
import me.arch.mcdatagen.generators.DataGenerators;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientLifecycleEvents;
import net.minecraft.MinecraftVersion;
import net.minecraft.client.MinecraftClient;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.Text;

import java.nio.file.Path;

public class GenerateDataCommand {
    private static boolean hasRunOnce = false;

    private static int executeCommand(CommandContext<ServerCommandSource> context) {
        if (!hasRunOnce) hasRunOnce = true;
        String versionName = MinecraftVersion.CURRENT.getName();
        Path serverRootDirectory = context.getSource().getServer().getRunDirectory().toPath().toAbsolutePath();
        Path dataDumpDirectory = serverRootDirectory.resolve("minecraft-data").resolve(versionName);

        if (DataGenerators.runDataGenerators(dataDumpDirectory)) {
            context.getSource().sendFeedback(Text.of("Data dumped successfully to server run directory"), false);
            MinecraftClient.getInstance().execute(() -> {
                MinecraftClient.getInstance().close();
            });
            return 0;
        } else {
            context.getSource().sendError(Text.of("Data generation failed, some generators have errored. Check log for details"));
            MinecraftClient.getInstance().execute(() -> {
                MinecraftClient.getInstance().close();
            });
            return 1;
        }
    }

    public static void register(CommandDispatcher<ServerCommandSource> dispatcher) {
        dispatcher.register(
                CommandManager.literal("generatedata")
                .requires(source -> source.hasPermissionLevel(2))
                .executes(GenerateDataCommand::executeCommand));
    }
}
