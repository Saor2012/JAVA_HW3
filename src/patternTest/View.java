package patternTest;

public class View implements IView{
    public View() {
        presenter.init(this);
    }
    public void init() {
        presenter.init(this);
    }

    public void print(String message) {
        System.out.println(message);
    }

    public void event() {
        prevented.
    }
}
