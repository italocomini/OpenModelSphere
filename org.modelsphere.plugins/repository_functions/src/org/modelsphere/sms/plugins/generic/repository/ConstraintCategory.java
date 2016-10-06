/*************************************************************************

Copyright (C) 2009 Grandite

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

You can redistribute and/or modify this particular file even under the
terms of the GNU Lesser General Public License (LGPL) as published by
the Free Software Foundation; either version 3 of the License, or
(at your option) any later version.

You should have received a copy of the GNU Lesser General Public License 
(LGPL) along with this program; if not, write to the Free Software
Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA 
or see http://www.gnu.org/licenses/.

You can reach Grandite at: 

20-1220 Lebourgneuf Blvd.
Quebec, QC
Canada  G2K 2G4

or

open-modelsphere@grandite.com

 **********************************************************************/

package org.modelsphere.sms.plugins.generic.repository;

import java.io.IOException;
import java.io.Serializable;
import java.io.Writer;

import org.modelsphere.jack.baseDb.db.DbException;
import org.modelsphere.jack.plugins.PluginSignature;
import org.modelsphere.jack.srtool.ApplicationContext;
import org.modelsphere.jack.srtool.forward.*;
import org.modelsphere.sms.or.db.DbORCheck;
import org.modelsphere.sms.or.db.DbORForeign;
import org.modelsphere.sms.or.db.DbORPrimaryUnique;

/**
 * For a constraint (primary key, unique key, foreign key or check constraint), returns respectively
 * the string 'Primary', 'Unique', 'Foreign' or 'Check'. <br>
 * Target System : <b>All Except Java</b><br>
 * Type : <b>User Function</b><br>
 * Parameters : none.<br>
 */
public final class ConstraintCategory extends UserDefinedField {
    private static final PluginSignature signature = new PluginSignature("ConstraintCategory",
            "$Revision: 4 $", ApplicationContext.APPLICATION_AUTHOR, "$Date: 2009/04/14 14:00p $",
            212); // NOT LOCALIZABLE

    public ConstraintCategory() {
    } //Parameter-less constructor required by jack.io.Plugins

    public ConstraintCategory(String ruleName, String subrule, Modifier[] modifiers)
            throws RuleException {
        super(ruleName, subrule, modifiers);
    }

    public PluginSignature getSignature() {
        return signature;
    }

    public boolean expand(Writer output, Serializable object, Rule.RuleOptions options)
            throws IOException, RuleException {
        boolean expanded = false;

        String category = new String();

        try {
            if (object instanceof DbORPrimaryUnique) {
                DbORPrimaryUnique primaryUnique = (DbORPrimaryUnique) object;
                if (primaryUnique.isPrimary())
                    category = "Primary"; // resources ??? // NOT LOCALIZABLE
                else
                    category = "Unique"; // NOT LOCALIZABLE
            } else if (object instanceof DbORForeign) {
                category = "Foreign"; // NOT LOCALIZABLE
            } else if (object instanceof DbORCheck) {
                category = "Check"; // NOT LOCALIZABLE
            }

            if (prefixModifier != null) {
                prefixModifier.expand(output, object, options);
            }

            //write the converted text

            output.write(category);
            expanded = true;

            if (suffixModifier != null) {
                suffixModifier.expand(output, object, options);
            }

        } catch (DbException ex) {
            throw new RuleException(ex.getMessage());
        }

        return expanded;
    }
} //end of ObjectID
