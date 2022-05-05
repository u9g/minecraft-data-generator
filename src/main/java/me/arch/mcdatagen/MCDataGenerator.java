package me.arch.mcdatagen;

import me.arch.mcdatagen.command.GenerateDataCommand;
import me.arch.mcdatagen.util.TitleScreenHelper;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientLifecycleEvents;
import net.fabricmc.fabric.api.command.v1.CommandRegistrationCallback;

public class MCDataGenerator implements ModInitializer {

	@Override
	public void onInitialize() {
		CommandRegistrationCallback.EVENT.register((dispatcher, dedicated) ->
				GenerateDataCommand.register(dispatcher));
		ClientLifecycleEvents.CLIENT_STARTED.register((a) -> TitleScreenHelper.joinLocalWorld());
	}
}
