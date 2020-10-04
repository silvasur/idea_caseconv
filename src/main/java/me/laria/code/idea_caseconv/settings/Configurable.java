package me.laria.code.idea_caseconv.settings;

import com.intellij.openapi.options.ConfigurationException;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class Configurable implements com.intellij.openapi.options.Configurable {
    private SettingsComponent settingsComponent = null;

    @Nls(capitalization = Nls.Capitalization.Sentence)
    @Override
    public String getDisplayName() {
        return "Case conversion";
    }

    @Nullable
    @Override
    public JComponent createComponent() {
        settingsComponent = new SettingsComponent();
        return settingsComponent.getPanel();
    }

    @Override
    public void disposeUIResources() {
        settingsComponent = null;
    }

    @Override
    public boolean isModified() {
        return Settings.getInstance().newlineMode != settingsComponent.getNewlineMode();
    }

    @Override
    public void apply() throws ConfigurationException {
        Settings.getInstance().newlineMode = settingsComponent.getNewlineMode();
    }

    @Override
    public void reset() {
        settingsComponent.setNewlineMode(Settings.getInstance().newlineMode);
    }
}
