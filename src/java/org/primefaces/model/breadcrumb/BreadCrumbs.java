/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.primefaces.model.breadcrumb;

/**
 *
 * @author eros
 */
import br.com.primetestes.TableBean.ColumnModel;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
import org.primefaces.component.column.Column;
import org.primefaces.component.commandlink.CommandLink;
import org.primefaces.component.datatable.DataTable;
import org.primefaces.component.menubar.Menubar;
import org.primefaces.component.menuitem.MenuItem;
import org.primefaces.component.submenu.Submenu;
import org.primefaces.model.MenuModel;

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
    
    private DataTable tableDyno = new DataTable();
    private List<ColumnModel> simpleColumns;  
    
   private MenuModel menuModel; 
   public MenuModel getMenuModel() {
return menuModel;
}

public void setMenuModel(MenuModel menuModel) {
this.menuModel = menuModel;
}

   

    /** Creates a new instance of BreadCrumbs */
    public BreadCrumbs() {
        
        
        Submenu submenu = new Submenu();
            submenu.setId("hollycrapmotherogod");
            
            Submenu submenu2 = new Submenu();
            submenu2.setId("hollycrapmotherogod2");
            
            MenuItem mitem = new MenuItem();
            mitem.setValue("Function");
            mitem.setId("godsaveusall");
            
            MenuItem mitem2 = new MenuItem();
            mitem2.setValue("Function2");
            mitem2.setId("godsaveusall2");
            
            submenu.setLabel("Module");
            submenu.getChildren().add(mitem);

//            menuBar.getChildren().add(mitem2);

            menuModel = new org.primefaces.model.DefaultMenuModel();

            menuModel.addSubmenu(submenu);
            menuModel.addMenuItem(mitem);
            menuModel.addMenuItem(mitem2);
        
        
//        items = new ArrayList<BreadCrumbItem>();
//        items.add(new BreadCrumbItem("Home", false));
//        items.add(new BreadCrumbItem("New", false));
//        items.add(new BreadCrumbItem("Edit", false));
//        items.add(new BreadCrumbItem("Step 1", true));
//        items.add(new BreadCrumbItem("Step 2", true));
//        
//        simpleColumns = new ArrayList<ColumnModel>();  
//        simpleColumns.add(new ColumnModel("Model", "model"));  
//        simpleColumns.add(new ColumnModel("Manufacturer", "manufacturer"));  
//        simpleColumns.add(new ColumnModel("Model", "model"));  
//        simpleColumns.add(new ColumnModel("Manufacturer", "manufacturer"));  
//        simpleColumns.add(new ColumnModel("Model", "model"));  
//        simpleColumns.add(new ColumnModel("Manufacturer", "manufacturer"));  
//        simpleColumns.add(new ColumnModel("Model", "model"));  
//        simpleColumns.add(new ColumnModel("Manufacturer", "manufacturer"));  
//        simpleColumns.add(new ColumnModel("Model", "model"));  
//        simpleColumns.add(new ColumnModel("Manufacturer", "manufacturer"));  
//        simpleColumns.add(new ColumnModel("Model", "model"));  
//        simpleColumns.add(new ColumnModel("Manufacturer", "manufacturer"));  
//        simpleColumns.add(new ColumnModel("Model", "model"));  
//        simpleColumns.add(new ColumnModel("Manufacturer", "manufacturer"));  simpleColumns.add(new ColumnModel("Model", "model"));  
//        simpleColumns.add(new ColumnModel("Manufacturer", "manufacturer"));  
//        simpleColumns.add(new ColumnModel("Model", "model"));  
//        simpleColumns.add(new ColumnModel("Manufacturer", "manufacturer"));  
//        simpleColumns.add(new ColumnModel("Model", "model"));  
//        simpleColumns.add(new ColumnModel("Manufacturer", "manufacturer"));  
//        
//        
        
    }

    public List<ColumnModel> getSimpleColumns() {
        return simpleColumns;
    }

    public void setSimpleColumns(List<ColumnModel> simpleColumns) {
        this.simpleColumns = simpleColumns;
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
