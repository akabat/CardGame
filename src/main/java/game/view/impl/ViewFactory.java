package game.view.impl;

import game.view.IView;

public class ViewFactory {
    public enum ViewType {
        CLI,
        SWING
    }
    
    public static IView makeView(ViewType vType) {
        IView view = null;
        switch(vType) {
        case CLI:
            view = new CommandLineView();
            break;
        case SWING:
            view = new SwingView();
            break;
        }
        return view;
    } 

}
