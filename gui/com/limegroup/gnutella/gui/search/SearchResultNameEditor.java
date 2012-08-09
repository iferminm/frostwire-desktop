/*
 * Created by Angel Leon (@gubatron), Alden Torres (aldenml)
 * Copyright (c) 2011, 2012, FrostWire(R). All rights reserved.
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

package com.limegroup.gnutella.gui.search;

import java.awt.Component;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.AbstractCellEditor;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author gubatron
 * @author aldenml
 *
 */
public class SearchResultNameEditor extends AbstractCellEditor implements TableCellEditor {

    private static final long serialVersionUID = -1173782952710148468L;

    private static final Log LOG = LogFactory.getLog(SearchResultNameEditor.class);

    public SearchResultNameEditor() {
    }

    public Object getCellEditorValue() {
        return null;
    }

    public Component getTableCellEditorComponent(final JTable table, Object value, boolean isSelected, int row, int column) {
        SearchResultNameHolder in = (SearchResultNameHolder) value;

        final Component component = new SearchResultNameRenderer().getTableCellRendererComponent(table, value, isSelected, true, row, column);
        //        component.addMouseListener(new MouseAdapter() {
        //            @Override
        //            public void mouseReleased(MouseEvent e) {
        //                if (e.getButton() == MouseEvent.BUTTON1) {
        //                    if (actionRegion == null) {
        //                        component_mousePressed(e);
        //                    } else {
        //                        if (actionRegion.contains(e.getPoint())) {
        //                            component_mousePressed(e);
        //                        } else {
        //                            if (e.getClickCount() >= 2) {
        //                                Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(new MouseEvent(table, MouseEvent.MOUSE_CLICKED, e.getWhen(), e.getModifiers(), component.getX() + e.getX(), component.getY() + e.getY(), e.getClickCount(), false));
        //                            }
        //                        }
        //                    }
        //                } else if (e.getButton() == MouseEvent.BUTTON3) {
        //                    Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(new MouseEvent(table, e.getID(), e.getWhen(), e.getModifiers(), component.getX() + e.getX(), component.getY() + e.getY(), e.getClickCount(), true));
        //                }
        //            }
        //        });

        return component;
    }

    protected void component_mousePressed(MouseEvent e) {
        //        if (action != null) {
        //            try {
        //                action.actionPerformed(new ActionEvent(e.getSource(), e.getID(), ""));
        //            } catch (Throwable e1) {
        //                LOG.error("Error performing action", e1);
        //            }
        //        }
    }
}