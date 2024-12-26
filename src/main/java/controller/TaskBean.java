package controller;

import jakarta.faces.bean.ManagedBean;
import jakarta.faces.bean.RequestScoped;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@ManagedBean(name = "taskBean")
@RequestScoped
public class TaskBean {

    private String selectedTask;

    public String selectTask() {
        if ("2.1".equals(selectedTask)) {
            return "index.xhtml?faces-redirect=true";
        } else if ("2.2".equals(selectedTask)) {
            return "tabulation.xhtml?faces-redirect=true";
        }
        return "index.xhtml?faces-redirect=true";
    }
}