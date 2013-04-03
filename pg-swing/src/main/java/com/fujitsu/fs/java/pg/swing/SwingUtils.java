package com.fujitsu.fs.java.pg.swing;

import java.awt.Component;
import java.awt.Dimension;

public final class SwingUtils {

    /**
     * It is an utility class, private constructor to prevent initialization.
     */
    private SwingUtils() {
    }

    public static int makeSameWidth(Component... components) {
        int maxWidth = findMaxPreferredWidth(components);
        for (Component component : components) {
//            Dimension preferredSize = component.getPreferredSize();
//            preferredSize.width = maxWidth;
//            component.setPreferredSize(preferredSize);

//            Dimension minimumSize = component.getMinimumSize();
//            minimumSize.width = maxWidth;
//            component.setMinimumSize(minimumSize);

            Dimension maximumSize = component.getPreferredSize();
            maximumSize.width = maxWidth;
            component.setMaximumSize(maximumSize);
        }
        return maxWidth;
    }

    private static int findMaxPreferredWidth(Component... components) {
        int maxWidth = 0;
        for (Component component : components) {
            if (component.getPreferredSize().width > maxWidth) {
                maxWidth = component.getPreferredSize().width;
            }
        }
        return maxWidth;
    }

}
