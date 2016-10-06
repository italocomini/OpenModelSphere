/*************************************************************************

Copyright (C) 2009 by neosapiens inc.

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

You can reach neosapiens inc. at: 

neosapiens inc.
1236 Gaudias-Petitclerc
Qu&eacute;bec, Qc, G1Y 3G2
CANADA
Telephone: 418-561-8403
Fax: 418-650-2375
http://www.neosapiens.com/
Email: marco.savard@neosapiens.com
       gino.pelletier@neosapiens.com

 **********************************************************************/

package com.neosapiens.plugins.codegen.wrappers;

import org.modelsphere.jack.baseDb.db.DbException;
import org.modelsphere.sms.or.db.DbORColumn;
import org.modelsphere.sms.or.db.DbORDomain;
import org.modelsphere.sms.or.db.DbORTypeClassifier;

public class DbColumnWrapper extends DbObjectWrapper {
    private DbORColumn m_dbCol;

    public DbColumnWrapper(DbORColumn dbCol) {
        m_dbCol = dbCol;
    }

    public StringWrapper getName() throws DbException {
        String s = m_dbCol.getName();
        return new StringWrapper(s);
    }

    public StringWrapper getPhysicalName() throws DbException {
        StringWrapper sw = new StringWrapper(m_dbCol.getPhysicalName());
        return sw;
    }

    public StringWrapper getType() throws DbException {
        DbORTypeClassifier type = m_dbCol.getType();
        String s = type.getName();
        return new StringWrapper(s);
    }

    public boolean isNull() throws DbException {
        return m_dbCol.isNull();
    }

    public boolean isMandatory() throws DbException {
        return !(m_dbCol.isNull());
    }

    public int getLength() throws DbException {
        Integer i = m_dbCol.getLength();
        return (i == null) ? 0 : i;
    }

    public StringWrapper getFoundationType() throws DbException {
        DbORTypeClassifier type = m_dbCol.getType();
        DbORTypeClassifier srcType = getSourceType(type);

        String s = (srcType == null) ? "???" : srcType.getPhysicalName();
        String ft;

        if ("BIT".equals(s)) {
            ft = "TypeBool";
        } else if ("DATETIME".equals(s)) {
            ft = "TypeDateTime";
        } else if ("INT".equals(s)) {
            ft = "TypeInt";
        } else if ("INTEGER".equals(s)) {
            ft = "TypeInt";
        } else {
            ft = "TypeString";
        } //end 

        return new StringWrapper(ft);
    }

    private DbORTypeClassifier getSourceType(DbORTypeClassifier type) throws DbException {
        if (type instanceof DbORDomain) {
            DbORDomain domain = (DbORDomain) type;
            DbORTypeClassifier srcType = domain.getSourceType();
            return getSourceType(srcType);
        } else {
            return type;
        }
    }

}
