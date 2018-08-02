package me.laria.code.idea_caseconv;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.command.WriteCommandAction;
import com.intellij.openapi.editor.Caret;
import com.intellij.openapi.editor.CaretModel;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.project.Project;

import java.util.ArrayList;

abstract class SelectionReplacerAction extends AnAction {
    @Override
    public void update(final AnActionEvent e) {
        //Get required data keys
        final Project project = e.getData(CommonDataKeys.PROJECT);
        final Editor editor = e.getData(CommonDataKeys.EDITOR);
        //Set visibility only in case of existing project and editor and if some text in the editor is selected
        e.getPresentation().setVisible(
            project != null
                && editor != null
                && editor.getSelectionModel().hasSelection()
        );
    }

    @Override
    public void actionPerformed(AnActionEvent anActionEvent) {
        Editor editor = anActionEvent.getData(CommonDataKeys.EDITOR);
        Project project = anActionEvent.getData(CommonDataKeys.PROJECT);
        assert editor != null;
        assert project != null;

        CaretModel caretModel = editor.getCaretModel();
        Document document = editor.getDocument();

        ArrayList<Replacement> replacements = new ArrayList<>();
        for (Caret caret : caretModel.getAllCarets()) {
            if (!caret.hasSelection()) {
                continue;
            }

            replacements.add(new Replacement(
                caret.getSelectionStart(),
                caret.getSelectionEnd(),
                this.replace(caret.getSelectedText())
            ));
        }

        // Sort in reverse order so a replacement won't mess up the indices of the other replacements
        replacements.sort((o1, o2) -> -o1.compareTo(o2));

        WriteCommandAction.runWriteCommandAction(project, () -> replacements.forEach(r -> r.doReplace(document)));
    }

    abstract protected String replace(String s);
}
