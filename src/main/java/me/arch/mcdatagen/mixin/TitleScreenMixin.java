package me.arch.mcdatagen.mixin;

import me.arch.mcdatagen.util.TitleScreenHelper;
import net.minecraft.client.gui.screen.TitleScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(TitleScreen.class)
public abstract class TitleScreenMixin {
    @Inject(method = "initWidgetsNormal", at = @At("TAIL"))
    private void afterInit(CallbackInfo callbackInfo) {
//        TitleScreenHelper.joinLocalWorld();
    }
}
