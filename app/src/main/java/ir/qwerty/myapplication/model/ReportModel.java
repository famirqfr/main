package ir.qwerty.myapplication.model;

public class ReportModel {
    String title;
    String context;
    String importance;

    public ReportModel(String title, String context, String importance) {
        this.title = title;
        this.context = context;
        this.importance = importance;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getImportance() {
        return importance;
    }

    public void setImportance(String importance) {
        this.importance = importance;
    }
}
