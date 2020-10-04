package me.laria.code.idea_caseconv.settings;

import com.intellij.openapi.components.PersistentStateComponent;
import com.intellij.openapi.components.ServiceManager;
import com.intellij.openapi.components.State;
import com.intellij.openapi.components.Storage;
import com.intellij.util.xmlb.XmlSerializerUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@State(
        name = "me.laria.code.idea_caseconv.SettingsState",
        storages = {@Storage("me_laria_code_idea_caseconv_plugin.xml")}
)
public class Settings implements PersistentStateComponent<Settings> {
    public NewlineMode newlineMode = NewlineMode.WHITESPACE;


    public static Settings getInstance() {
        return ServiceManager.getService(Settings.class);
    }

    @Nullable
    @Override
    public Settings getState() {
        return this;
    }

    @Override
    public void loadState(@NotNull Settings state) {
        XmlSerializerUtil.copyBean(state, this);
    }
}
