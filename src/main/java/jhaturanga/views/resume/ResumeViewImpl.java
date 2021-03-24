package jhaturanga.views.resume;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import jhaturanga.views.AbstractJavaFXView;
import jhaturanga.views.pages.PageLoader;
import jhaturanga.views.pages.Pages;

public final class ResumeViewImpl extends AbstractJavaFXView implements ResumeView {

    @Override
    public void init() {
        this.getStage().setMinHeight(this.getStage().getHeight());
        this.getStage().setMinWidth(this.getStage().getWidth());
    }

    @FXML
    public void onBackClick(final ActionEvent event) {
        PageLoader.switchPage(this.getStage(), Pages.SETUP, this.getController().getApplicationInstance());
    }

    @FXML
    public void onStartClick(final ActionEvent event) {
        System.out.println("start");
    }

}
