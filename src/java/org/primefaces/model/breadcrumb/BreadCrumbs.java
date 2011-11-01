/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.primefaces.model.breadcrumb;

/**
 *
 * @author eros
 */
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
import org.primefaces.component.commandlink.CommandLink;

/**
 *
 * @author Oleg
 */
@ManagedBean(name = "breadCrumbs")
@SessionScoped
public class BreadCrumbs implements Serializable {

    private static final long serialVersionUID = 20100207L;
    private List<BreadCrumbItem> items;
    private String selection;

    /** Creates a new instance of BreadCrumbs */
    public BreadCrumbs() {
        items = new ArrayList<BreadCrumbItem>();
        items.add(new BreadCrumbItem("Home", false));
        items.add(new BreadCrumbItem("New", false));
        items.add(new BreadCrumbItem("Edit", false));
        items.add(new BreadCrumbItem("Step 1", true));
        items.add(new BreadCrumbItem("Step 2", true));
    }

    /**
     * @return the items
     */
    public List<BreadCrumbItem> getItems() {
        return items;
    }

    /**
     * @param items the items to set
     */
    public void setItems(List<BreadCrumbItem> items) {
        this.items = items;
    }

    /**
     * @return the selection
     */
    public String getSelection() {
        return selection;
    }

    /**
     * @param selection the selection to set
     */
    public void setSelection(String selection) {
        this.selection = selection;
    }

    public void updateSelection(ActionEvent ae) {
        CommandLink cl = (CommandLink) ae.getComponent();
        setSelection(cl.getValue().toString());
    }

    public class BreadCrumbItem {

        private boolean disabled;
        private String name;

        public BreadCrumbItem(String name, boolean disabled) {
            this.name = name;
            this.disabled = disabled;
        }

        /**
         * @return the disabled
         */
        public boolean isDisabled() {
            return disabled;
        }

        /**
         * @param disabled the disabled to set
         */
        public void setDisabled(boolean disabled) {
            this.disabled = disabled;
        }

        /**
         * @return the name
         */
        public String getName() {
            return name;
        }

        /**
         * @param name the name to set
         */
        public void setName(String name) {
            this.name = name;
        }
    }
}
