/*************************************************************************

Copyright (C) 2012 Grandite

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
package org.modelsphere.jack.srtool.features.layout;

import java.util.List;

import org.modelsphere.jack.baseDb.db.DbException;
import org.modelsphere.jack.baseDb.db.DbGraphicalObjectI;
import org.modelsphere.jack.baseDb.db.DbObject;
import org.modelsphere.jack.graphic.Diagram;
import org.modelsphere.jack.srtool.features.layout.graph.Graph;

/**
 * A factory for creating Graph objects.
 */
public class GraphFactory {

    /** The default factory. */
    private static GraphFactory defaultFactory = new GraphFactory();

    /**
     * Gets the default factory.
     * 
     * @return the default factory
     */
    public static GraphFactory getDefaultFactory() {
        return defaultFactory;
    }

    /**
     * Sets the default.
     * 
     * @param graphFactory
     *            the new default
     */
    public static void setDefault(GraphFactory graphFactory) {
        if (graphFactory != null) {
            defaultFactory = graphFactory;
        }
    }

    /**
     * Creates a new Graph object.
     * 
     * @param diagramGo
     *            the diagram go
     * @param diagram
     *            the diagram
     * @return the graph
     * @throws DbException
     *             the db exception
     */
    public Graph createGraph(DbObject diagramGo, Diagram diagram, List<DbGraphicalObjectI> scope) throws DbException {
        return null;
    }
}
