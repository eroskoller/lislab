/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.primefaces.model.breadcrumb;

/**
 *
 * @author eros
 */
import java.util.Collections;
import java.util.List;

import javax.faces.model.ArrayDataModel;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.ScalarDataModel;


/**
 * Custom breadcrumb component.
 *
 */
public class BreadCrumbEros extends org.primefaces.component.breadcrumb.BreadCrumb
{
        //~ Enums ------------------------------------------------------------------

        /**
         * Properties that are tracked by state saving.
         *
         * @author  ova / last modified by $Author: ova $
         * @version $Revision: 66587 $
         */
        protected enum PropertyKeys
        {
                items, var, curIndex;

                String toString;

                PropertyKeys(String toString)
                {
                        this.toString = toString;
                }

                PropertyKeys()
                {
                }

                @Override
                public String toString()
                {
                        return ((this.toString != null) ? this.toString : super.toString());
                }
        }

        //~ Instance fields --------------------------------------------------------

        /**
         * <p>The {@link DataModel} associated with this component to build breadcrumb items dynamically, lazily
         * instantiated if requested. This object is not part of the saved and restored state of the component.</p>
         */
        private DataModel model = null;

        //~ Methods ----------------------------------------------------------------

        /**
         * <p>Return the request-scope attribute under which the data object for the current breadcrumb item will be exposed
         * when iterating. This property is <strong>not</strong> enabled for value binding expressions.</p>
         *
         * @return String the request-scope attribute name
         */
        public String getVar()
        {
                return (String) getStateHelper().get(PropertyKeys.var);
        }

        /**
         * <p>Set the request-scope attribute under which the data object for the current breadcrumb item will be exposed
         * when iterating.</p>
         *
         * @param var the new request-scope attribute name
         */
        public void setVar(String var)
        {
                getStateHelper().put(PropertyKeys.var, var);
        }

        /**
         * <p>Return the request-scope attribute under which the current breadcrumb item index will be exposed when
         * iterating. This property is <strong>not</strong> enabled for value binding expressions.</p>
         *
         * @return String the request-scope attribute name
         */
        public String getCurIndex()
        {
                return (String) getStateHelper().get(PropertyKeys.curIndex);
        }

        /**
         * <p>Set the request-scope attribute under which the current breadcrumb item index will be exposed when
         * iterating.</p>
         *
         * @param curIndex the new request-scope attribute name
         */
        public void setCurIndex(String curIndex)
        {
                getStateHelper().put(PropertyKeys.curIndex, curIndex);
        }

        /**
         * <p>Return items of the breadcrumb. This value must either be be of type {@link DataModel}, or a type that can be
         * adapted into a {@link DataModel}:</p>
         *
         * <ul>
         *   <li>Arrays</li>
         *   <li><code>java.util.List</code></li>
         * </ul>
         *
         * <p>All other types will be adapted using the {@link ScalarDataModel} class, which will treat the object as a
         * single breadcrumb item.</p>
         *
         * @return Object
         */
        public Object getItems()
        {
                return getStateHelper().eval(PropertyKeys.items, null);
        }

        /**
         * <p>Set items of the breadcrumb. This items object must either be be of type {@link DataModel}, or a type that can
         * be adapted into a {@link DataModel}.</p>
         *
         * @param items new items
         */
        public void setItems(Object items)
        {
                setDataModel(null);
                getStateHelper().put(PropertyKeys.items, items);
        }

        /**
         * Sets data model.
         *
         * @param model data model
         */
        public void setDataModel(DataModel model)
        {
                this.model = model;
        }

        /**
         * Gets data model.
         *
         * @return DataModel
         */
        public DataModel getDataModel()
        {
                if (this.model != null) {
                        return model;
                }

                Object items = getItems();
                if (items == null) {
                        setDataModel(new ListDataModel(Collections.EMPTY_LIST));
                } else if (items instanceof DataModel) {
                        setDataModel((DataModel) items);
                } else if (items instanceof List) {
                        setDataModel(new ListDataModel((List) items));
                } else if (Object[].class.isAssignableFrom(items.getClass())) {
                        setDataModel(new ArrayDataModel((Object[]) items));
                } else {
                        setDataModel(new ScalarDataModel(items));
                }

                return model;
        }
}
