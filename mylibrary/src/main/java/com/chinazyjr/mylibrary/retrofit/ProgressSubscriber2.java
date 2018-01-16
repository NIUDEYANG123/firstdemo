package com.chinazyjr.mylibrary.retrofit;

import android.content.Context;
import android.util.Log;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;


/**
 * 按照rxjava2进行改进
 *
 * @param <T>
 */
public class ProgressSubscriber2<T> implements Observer<T>, ProgressCancelListener {
    private static final String TAG = "ProgressSubscriber";
    String tag = this.getClass().getSimpleName();
    private SubscriberOnNextListener<T> mSubscriberOnNextListener;
    private ProgressDialogHandler mProgressDialogHandler;

    private Context context;
    private Disposable disposable;

    public ProgressSubscriber2(SubscriberOnNextListener<T> mSubscriberOnNextListener, Context context) {
        this.mSubscriberOnNextListener = mSubscriberOnNextListener;
        this.context = context;
        mProgressDialogHandler = new ProgressDialogHandler(context, this, true);
    }

    private void showProgressDialog() {
        if (mProgressDialogHandler != null) {
            mProgressDialogHandler.obtainMessage(ProgressDialogHandler.SHOW_PROGRESS_DIALOG).sendToTarget();
        }
    }

    private void dismissProgressDialog() {
        if (mProgressDialogHandler != null) {
            mProgressDialogHandler.obtainMessage(ProgressDialogHandler.DISMISS_PROGRESS_DIALOG).sendToTarget();
            mProgressDialogHandler = null;
        }
    }
    @Override
    public void onCancelProgress() {
        if(!disposable.isDisposed()){
            disposable.dispose();
        }
    }

    @Override
    public void onSubscribe(Disposable d) {
        disposable =d;
        showProgressDialog();
        mSubscriberOnNextListener.onSubscribe(d);
    }

    @Override
    public void onNext(T t) {
        mSubscriberOnNextListener.onNext(t);
    }

    @Override
    public void onError(Throwable e) {
        Log.e(TAG, "onError: " + e.getMessage());
        dismissProgressDialog();
        mSubscriberOnNextListener.onError(e);
    }

    @Override
    public void onComplete() {
       dismissProgressDialog();
    }


}