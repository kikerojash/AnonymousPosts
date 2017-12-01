package apps.steve.fire.randomchat.main;

import android.content.res.Resources;
import android.util.Log;

import java.util.List;

import apps.steve.fire.randomchat.base.usecase.UseCaseHandler;
import apps.steve.fire.randomchat.main.ui.entity.Item;
import apps.steve.fire.randomchat.main.usecase.PublishPost;

/**
 * Created by Steve on 25/11/2017.
 */

public class MainPresenterImpl implements MainPresenter {
    private static final String TAG = MainPresenterImpl.class.getSimpleName();
    private Resources res;
    private UseCaseHandler handler;
    private PublishPost useCasePublishPost;

    public MainPresenterImpl(Resources res, UseCaseHandler handler, PublishPost publishPost) {
        this.res = res;
        this.handler = handler;
        this.useCasePublishPost = publishPost;
    }

    private MainView view;

    @Override
    public void attachView(MainView view) {
        Log.d(TAG, "attachView");
        this.view = view;
    }

    @Override
    public void onCreate() {
        Log.d(TAG, "onCreate");
    }

    @Override
    public void onStart() {
        Log.d(TAG, "onStart");
    }

    @Override
    public void onResume() {
        Log.d(TAG, "onResume");
    }

    @Override
    public void onPause() {
        Log.d(TAG, "onPause");
    }

    @Override
    public void onStop() {
        Log.d(TAG, "onStop");
    }

    @Override
    public void onDestroy() {
        Log.d(TAG, "onDestroy");
        view = null;
    }

    @Override
    public void onBurgerIconClicked() {
        Log.d(TAG, "onBurgerIconClicked");
        openNav();
    }

    private boolean isNavOpen;

    private void openNav() {
        if (view != null) {
            view.openNavigation();
        }
        isNavOpen = true;
    }

    private void closeNav() {
        if (view != null) {
            view.closeNavigation();
        }
    }

    @Override
    public void onSubmitPost(String content, List<String> tagList) {
        Log.d(TAG, "onSubmitPost");
        hidePublishDialog();
    }

    private boolean isPublishDialogVisible;

    @Override
    public void onFabClicked() {
        if (!isPublishDialogVisible) {
            showPublishDialog();
        } else {
            hidePublishDialog();
        }
    }

    private void showPublishDialog() {
        if (view != null) {
            view.showPublishDialog();
        }
        isPublishDialogVisible = true;
    }

    private void hidePublishDialog() {
        if (view != null) {
            view.hidePublishDialog();
        }
        isPublishDialogVisible = false;
    }


    @Override
    public void onBackPressed() {
        if (isPublishDialogVisible) {
            hidePublishDialog();
        } else {
            view.superOnBackPressed();
        }
    }

    @Override
    public void onMenuItemSelected(Item item) {
        closeNav();
    }
}