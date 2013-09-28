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

import java.awt.Polygon;
import java.awt.geom.Rectangle2D;
import java.util.List;

import org.modelsphere.jack.srtool.features.layout.graph.Node;

/**
 * The Class LayoutUtilities.
 */
public class LayoutUtilities {

    /**
     * Gets the polygon.
     * 
     * @param nodes
     *            the nodes
     * @return the polygon
     */
    public static Polygon getPolygon(List<Node> nodes) {
        Polygon polygon = new Polygon();
        for (Node node : nodes) {
            Rectangle2D rect = node.getBounds();
            if (polygon.contains(rect)) {
                continue;
            }
            int x = (int) rect.getX();
            int y = (int) rect.getY();
            int w = (int) rect.getWidth();
            int h = (int) rect.getHeight();
            polygon.addPoint(x, y);
            polygon.addPoint(x + w, y);
            polygon.addPoint(x, y + h);
            polygon.addPoint(x + w, y + h);
        }

        return polygon;
    }

    /**
     * Translate nodes.
     * 
     * @param nodes
     *            the nodes
     * @param dx
     *            the dx
     * @param dy
     *            the dy
     */
    public static void translateNodes(List<Node> nodes, int dx, int dy) {
        if (nodes == null) {
            return;
        }
        for (Node node : nodes) {
            node.translate(dx, dy);
        }
    }

    /**
     * Instantiates a new layout utilities.
     */
    private LayoutUtilities() {
    }

}