package co.personal.validtest.ui;

import java.util.List;

public interface MainView {

    void getDataReciclerView(List mTopartists);
    void showMessage(String message);
    void showProgressBar();
    void hideProgressBar();
}
