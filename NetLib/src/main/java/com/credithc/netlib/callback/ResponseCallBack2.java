package com.credithc.netlib.callback;

import com.credithc.netlib.bean.ResultModel;

import io.reactivex.subscribers.DisposableSubscriber;

/**
 * @author liyong
 * @date 2019/10/31
 * @des 网络请求回调类(支持背压Flowable)
 */
public abstract class ResponseCallBack2<T> extends DisposableSubscriber<ResultModel<T>> implements BaseResponseCallBack<T> {

    private static CommonWrapCallBack commonBack = new CommonWrapCallBack();

    @Override
    protected final void onStart() {
        super.onStart();
        commonBack.onStart(this);
    }

    @Override
    public final void onNext(ResultModel<T> tResultModel) {
        commonBack.onNext(tResultModel, this);
    }

    @Override
    public final void onError(Throwable e) {
        commonBack.onError(e, this);
        onComplete();
    }

    @Override
    public final void onComplete() {
        commonBack.onComplete(this);
    }
}