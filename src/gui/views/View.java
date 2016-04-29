package gui.views;

import java.awt.event.MouseListener;
import java.util.Hashtable;

/**
 * Created by guillaume on 29/04/16.
 */
public interface View {

    void init();
    void setListeners(Hashtable<String, MouseListener> listener);
}
