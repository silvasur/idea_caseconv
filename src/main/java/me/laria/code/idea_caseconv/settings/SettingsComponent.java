package me.laria.code.idea_caseconv.settings;

import com.intellij.openapi.ui.ComboBox;
import com.intellij.util.ui.FormBuilder;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

public class SettingsComponent {
    final private JPanel mainPanel;
    final private ComboBox<String> newlineModeSelect;

    public SettingsComponent() {
        newlineModeSelect = new ComboBox<>(new String[]{
                "White space",
                "Record separator",
        });

        mainPanel = FormBuilder.createFormBuilder()
                .addLabeledComponent(
                        "Treat newline as",
                        newlineModeSelect,
                        1,
                        false
                )
                .addComponentFillVertically(new JPanel(), 0)
                .getPanel();
    }

    public NewlineMode getNewlineMode() {
        switch (newlineModeSelect.getSelectedIndex()) {
            case 0:
                return NewlineMode.WHITESPACE;
            case 1:
                return NewlineMode.RECORD_SEPARATOR;
            default:
                throw new IndexOutOfBoundsException("newlineModeSelect returned invalid index");
        }
    }

    public void setNewlineMode(@NotNull NewlineMode newlineMode) {
        switch (newlineMode) {
            case WHITESPACE:
                newlineModeSelect.setSelectedIndex(0);
                break;
            case RECORD_SEPARATOR:
                newlineModeSelect.setSelectedIndex(1);
                break;
        }
    }

    public JComponent getPanel() {
        return mainPanel;
    }
}
