/*************************************************************************

Copyright (C) 2008 Grandite

This file is part of Open ModelSphere.

Open ModelSphere is free software; you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation; either version 3 of the License, or
(at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program; if not, write to the Free Software
Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA 
or see http://www.gnu.org/licenses/.

You can reach Grandite at: 

20-1220 Lebourgneuf Blvd.
Quebec, QC
Canada  G2K 2G4

or

open-modelsphere@grandite.com

 **********************************************************************/

package org.modelsphere.sms.plugins.report.model;

// JDK
import java.awt.Color;

import javax.swing.text.html.HTML;

import org.modelsphere.jack.baseDb.db.DbObject;
import org.modelsphere.jack.baseDb.meta.MetaClass;
import org.modelsphere.jack.baseDb.meta.MetaField;
import org.modelsphere.sms.plugins.report.LocaleMgr;

// Jack

// Sms

public class ComponentAttributeProperties implements Properties {

    private MetaClass m_metaClass;
    private MetaField m_metaField;
    private MetaClass m_compositeMetaClass;

    public ComponentAttributeProperties(MetaClass compositeMetaClass, MetaClass metaClass,
            MetaField metaField) {
        m_compositeMetaClass = compositeMetaClass;
        m_metaClass = metaClass;
        m_metaField = metaField;
    }

    public static final String BACKGROUND_PROPERTY_KEY = "Background"; //NOT LOCALIZABLE
    public static final String TEXT_PROPERTY_KEY = "Text"; //NOT LOCALIZABLE
    public static final String HORIZONTAL_PROPERTY_KEY = "Horizontal"; //NOT LOCALIZABLE
    public static final String VERTICAL_PROPERTY_KEY = "Vertical"; //NOT LOCALIZABLE
    public static final String WIDTH_PROPERTY_KEY = "Width"; //NOT LOCALIZABLE
    public static final String HEIGHT_PROPERTY_KEY = "Height"; //NOT LOCALIZABLE
    public static final String NOWRAP_PROPERTY_KEY = "NoWrap"; //NOT LOCALIZABLE

    public static final String WIDTHUNIT_PROPERTY_KEY = "WidthUnit"; //NOT LOCALIZABLE
    public static final String HEIGHTUNIT_PROPERTY_KEY = "HeightUnit"; //NOT LOCALIZABLE

    public static final String COLUMN_COLORS_GROUP = LocaleMgr.misc.getString("ColumnColors"); //NOT LOCALIZABLE
    public static final String COLUMN_DIMENSIONS_GROUP = LocaleMgr.misc
            .getString("ColumnDimensions"); //NOT LOCALIZABLE
    public static final String COLUMN_ALIGNMENT_GROUP = LocaleMgr.misc.getString("ColumnAlignment"); //NOT LOCALIZABLE
    public static final String COLUMN_GENERAL_GROUP = LocaleMgr.misc.getString("ColumnGeneral"); //NOT LOCALIZABLE

    private PropertyGroup[] groups = new PropertyGroup[] {
    // Group 1
            new PropertyGroup(COLUMN_COLORS_GROUP, // NOT LOCALIZABLE
                    new Property[] {
                            new Property(LocaleMgr.misc.getString(BACKGROUND_PROPERTY_KEY),
                                    BACKGROUND_PROPERTY_KEY, Color.white, HTML.Attribute.BGCOLOR), // NOT LOCALIZABLE
                            new Property(LocaleMgr.misc.getString(TEXT_PROPERTY_KEY),
                                    TEXT_PROPERTY_KEY, Color.black) // NOT LOCALIZABLE
                    }),

            // Group 2
            new PropertyGroup(COLUMN_DIMENSIONS_GROUP, // NOT LOCALIZABLE
                    new Property[] {
                            new Property(LocaleMgr.misc.getString(WIDTH_PROPERTY_KEY),
                                    WIDTH_PROPERTY_KEY, new Integer(600)), // NOT LOCALIZABLE
                            new Property(LocaleMgr.misc.getString(WIDTHUNIT_PROPERTY_KEY),
                                    WIDTHUNIT_PROPERTY_KEY, UnitDomain.getInstance(2)), // NOT LOCALIZABLE
                            new Property(LocaleMgr.misc.getString(HEIGHT_PROPERTY_KEY),
                                    HEIGHT_PROPERTY_KEY, new Integer(0)), // NOT LOCALIZABLE
                            new Property(LocaleMgr.misc.getString(HEIGHTUNIT_PROPERTY_KEY),
                                    HEIGHTUNIT_PROPERTY_KEY, UnitDomain.getInstance(1)) // NOT LOCALIZABLE
                    }),

            // Group 3
            new PropertyGroup(COLUMN_ALIGNMENT_GROUP, // NOT LOCALIZABLE
                    new Property[] {
                            new Property(LocaleMgr.misc.getString(HORIZONTAL_PROPERTY_KEY),
                                    HORIZONTAL_PROPERTY_KEY, ColumnHorizontalAlignmentDomain
                                            .getInstance(2), HTML.Attribute.HALIGN), // NOT LOCALIZABLE
                            new Property(LocaleMgr.misc.getString(VERTICAL_PROPERTY_KEY),
                                    VERTICAL_PROPERTY_KEY, ColumnVerticalAlignmentDomain
                                            .getInstance(5), HTML.Attribute.VALIGN) // NOT LOCALIZABLE
                    }),

            // Group 4
            new PropertyGroup(COLUMN_GENERAL_GROUP, // NOT LOCALIZABLE
                    new Property[] { new Property(LocaleMgr.misc.getString(NOWRAP_PROPERTY_KEY),
                            NOWRAP_PROPERTY_KEY, Boolean.TRUE, HTML.Attribute.NOWRAP) // NOT LOCALIZABLE
                    }) };

    /*
     * public ConceptAttributeProperties(MetaField metaField) { m_metaField = metaField; }
     */

    public MetaField getMetaField() {
        return m_metaField;
    }

    public PropertyGroup[] getProperties() {
        return groups;
    }

    public String toString() {
        return m_metaField.getGUIName();
    }

    private static final String DOT = ".";

    public String getBaseKey() {
        String baseKey = m_compositeMetaClass.getJClass().getName() + DOT
                + DbObject.fComponents.getJName() + DOT + m_metaClass.getJClass().getName() + DOT
                + m_metaField.getJName();
        return baseKey;
    }

    public Property getProperty(String groupName, String propertyKey) {
        PropertyGroup group = getPropertyGroup(groupName);

        if (group != null) {
            for (int i = 0; i < group.properties.length; i++) {
                if (group.properties[i].getKey().equals(propertyKey))
                    return group.properties[i];
            }
        }

        return null;
    }

    public PropertyGroup getPropertyGroup(String groupName) {
        for (int i = 0; i < groups.length; i++) {
            if (groups[i].toString().equals(groupName))
                return groups[i];
        }

        return null;
    }
}
