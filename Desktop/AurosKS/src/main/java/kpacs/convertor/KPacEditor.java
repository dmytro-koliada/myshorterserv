package kpacs.convertor;

import java.beans.PropertyEditorSupport;
import java.util.List;
import kpacs.model.KnowledgePackage;

public class KPacEditor extends PropertyEditorSupport {
    private final List<KnowledgePackage> knowledgePackages;

    public KPacEditor(List<KnowledgePackage> knowledgePackages) {
        this.knowledgePackages = knowledgePackages;
    }

    @Override
    public void setAsText(String id) throws IllegalArgumentException {
        KnowledgePackage knowledgePackage;
        for (KnowledgePackage element: knowledgePackages) {
            if (element.getId() == Long.parseLong(id)) {
                this.setValue(element);
                return;
            }
        }
        this.setValue(null);
    }
}
