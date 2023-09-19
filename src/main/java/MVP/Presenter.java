package MVP;

public class Presenter {
    private IView view;
    private Model model;

    public Presenter(IView view, Model model) {
        this.view = view;
        this.model = model;
    }



}
