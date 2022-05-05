package me.arch.mcdatagen.mixin;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.GameMenuScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Objects;

@Mixin(GameMenuScreen.class)
public class GameMenuScreenMixin {
    @Inject(method = "init", at = @At("TAIL"))
    private void afterInit(CallbackInfo callbackInfo) {
        Objects.requireNonNull(MinecraftClient.getInstance().player).sendChatMessage("/generatedata");
    }
}
