package me.arch.mcdatagen.util;

import net.minecraft.client.MinecraftClient;
import net.minecraft.resource.DataPackSettings;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.registry.DynamicRegistryManager;
import net.minecraft.world.Difficulty;
import net.minecraft.world.GameMode;
import net.minecraft.world.GameRules;
import net.minecraft.world.gen.GeneratorOptions;
import net.minecraft.world.level.LevelInfo;
import java.util.Objects;

public class TitleScreenHelper {
    private static final String DEMO_WORLD_NAME = "Demo_World";
    public static void joinLocalWorld () {
        try {
            var b = MinecraftClient.getInstance().getLevelStorage();
            System.out.println(b.getLevelList());
            if (true) {
                MinecraftClient.getInstance().startIntegratedServer(DEMO_WORLD_NAME);
            } else {
                DynamicRegistryManager.Impl impl = DynamicRegistryManager.create();
                MinecraftClient.getInstance().createWorld(DEMO_WORLD_NAME, new LevelInfo("Demo World", GameMode.SURVIVAL, false, Difficulty.NORMAL, true, new GameRules(), DataPackSettings.SAFE_MODE), impl, GeneratorOptions.createDemo(impl));
            }
        } catch (Exception ignored) {}
    }
}
