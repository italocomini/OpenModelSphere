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
package com.neosapiens.plugins.reverse.java.ui;

import javax.swing.JFrame;
import javax.swing.UIManager;

import com.neosapiens.plugins.reverse.java.ReverseJavaBytecodeParameters;

public class WizardTest {

    //
    // UNIT TEST (HOW TO USE IT)
    //
    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

    /**
     * Create the GUI and show it. For thread safety, this method should be invoked from the
     * event-dispatching thread.
     */
    private static void createAndShowGUI() {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (Exception ex) {
        }

        //Create and set up the window.
        JFrame frame = new JFrame("ImportJavaClassFilesDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.pack();
        frame.setVisible(true);

        ReverseJavaBytecodeParameters params = new ReverseJavaBytecodeParameters();
        Wizard<? extends WizardParameters> wizard = new ReverseJavaBytecodeWizard(params);
        wizard.showOpenDialog(frame, "Test");
    }
}
