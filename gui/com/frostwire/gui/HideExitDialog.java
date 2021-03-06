/*
 * Created by Angel Leon (@gubatron), Alden Torres (aldenml)
 * Copyright (c) 2011-2014, FrostWire(R). All rights reserved.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.frostwire.gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

import com.limegroup.gnutella.gui.GUIUtils;
import com.limegroup.gnutella.gui.I18n;
import com.limegroup.gnutella.settings.ApplicationSettings;

/**
 * @author gubatron
 * @author aldenml
 *
 */
public class HideExitDialog extends JDialog {

    public static final int NONE = 0;
    public static final int HIDE = 1;
    public static final int EXIT = 2;

    private JLabel _label;
    private JCheckBox _checkBox;
    private JButton _buttonHide;
    private JButton _buttonExit;

    private int _result;

    public HideExitDialog(JFrame frame) {
        super(frame, I18n.tr("Do you want to hide FrostWire?"));
        
        _result = NONE;
        
        setupUI();
        setLocationRelativeTo(frame);
    }

    protected void setupUI() {
        setResizable(false);

        getContentPane().setLayout(new GridBagLayout());

        GridBagConstraints c;

        _label = new JLabel("<html>" + I18n.tr("Closing the FrostWire window will only hide the application") + "<p>" + I18n.tr("This way file transfers may continue in the background.") + "</html>");
        c = new GridBagConstraints();
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.anchor = GridBagConstraints.WEST;
        c.insets = new Insets(5, 5, 5, 5);
        getContentPane().add(_label, c);

        _checkBox = new JCheckBox(I18n.tr("Don't show this again"));
        _checkBox.setSelected(true);
        c = new GridBagConstraints();
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.anchor = GridBagConstraints.WEST;
        c.insets = new Insets(5, 5, 5, 5);
        getContentPane().add(_checkBox, c);

        // hide button
        _buttonHide = new JButton(I18n.tr("Hide"));
        _buttonHide.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonHide_actionPerformed(e);
            }
        });
        c = new GridBagConstraints();
        c.insets = new Insets(4, 430, 8, 4);
        c.fill = GridBagConstraints.NONE;
        c.gridwidth = GridBagConstraints.RELATIVE;
        c.anchor = GridBagConstraints.EAST;
        c.ipadx = 20;
        getContentPane().add(_buttonHide, c);

        // exit button
        _buttonExit = new JButton(I18n.tr("Exit"));
        _buttonExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonExit_actionPerformed(e);
            }
        });
        c = new GridBagConstraints();
        c.insets = new Insets(4, 0, 8, 6);
        c.fill = GridBagConstraints.NONE;
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.anchor = GridBagConstraints.EAST;
        c.ipadx = 18;
        getContentPane().add(_buttonExit, c);

        pack();
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setModalityType(ModalityType.APPLICATION_MODAL);
        getRootPane().setDefaultButton(_buttonHide);
        GUIUtils.addHideAction((JComponent) getContentPane());
    }

    protected void buttonHide_actionPerformed(ActionEvent e) {
        _result = HIDE;
        if (_checkBox.isSelected()) {
            ApplicationSettings.MINIMIZE_TO_TRAY.setValue(true);
            ApplicationSettings.SHOW_HIDE_EXIT_DIALOG.setValue(false);
        }
        GUIUtils.getDisposeAction().actionPerformed(e);
    }

    protected void buttonExit_actionPerformed(ActionEvent e) {
        _result = EXIT;
        if (_checkBox.isSelected()) {
            ApplicationSettings.MINIMIZE_TO_TRAY.setValue(false);
            ApplicationSettings.SHOW_HIDE_EXIT_DIALOG.setValue(false);
        }
        GUIUtils.getDisposeAction().actionPerformed(e);
    }

    public int getResult() {
        return _result;
    }
}
