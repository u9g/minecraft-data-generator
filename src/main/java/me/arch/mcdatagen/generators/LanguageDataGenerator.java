package me.arch.mcdatagen.generators;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import net.minecraft.util.registry.Registry;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

public class LanguageDataGenerator implements IDataGenerator {
    @Override
    public String getDataName() {
        return "language";
    }

    @Override
    public JsonElement generateDataJson() {
        try {
            InputStream inputStream = Objects.requireNonNull(this.getClass().getResourceAsStream("/assets/minecraft/lang/en_us.json"));
            return new Gson().fromJson(new InputStreamReader(inputStream, StandardCharsets.UTF_8), JsonObject.class);
        } catch (Exception ignored) {}
        throw new RuntimeException("Failed to generate language file");
    }
}
