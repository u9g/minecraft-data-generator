package me.arch.mcdatagen.mixin;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.client.util.math.MatrixStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Objects;

@Mixin(InGameHud.class)
public class HotbarRenderMixin {
    @Inject(method = "renderHotbar(FLnet/minecraft/client/util/math/MatrixStack;)V", at = @At("TAIL"))
    public void onHotbarRendered(float tickDelta, MatrixStack matrices, CallbackInfo ci) {
        Objects.requireNonNull(MinecraftClient.getInstance().player).sendChatMessage("/generatedata");
    }
}
