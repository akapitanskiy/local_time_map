package com.alexthekap.societe_generale.app.presentation_layer.Map;

import com.alexthekap.societe_generale.app.business.time.AskGeoComInteractor;
import com.alexthekap.societe_generale.app.di.Injector;
import com.alexthekap.societe_generale.app.presentation_layer.BasePresenterImpl;
import com.google.android.gms.maps.model.LatLng;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


/**
 * created on 19.04.2020
 */
public class MapsPresenter extends BasePresenterImpl<MapContract.View> implements MapContract.Presenter {

    AskGeoComInteractor askGeoComInteractor;

    @Inject
    public MapsPresenter(AskGeoComInteractor askGeoComInteractor) {
        this.askGeoComInteractor = askGeoComInteractor;
    }

    @Override
    public void onMapClick(LatLng latLng) {
//        getCompositeDisposable().add(askGeoComInteractor.getTime(latLng));
        getCompositeDisposable().add(askGeoComInteractor.getTime(latLng)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(d -> {
                    getView().showLoading(true);
                    getView().setClickable(false);
                })
                .doFinally(() -> {
                    getView().showLoading(false);
                    getView().setClickable(true);
                })
                .subscribe(askGeoComResponse -> {
                            int offset = askGeoComResponse.getData().get(0).getTimeZone().getCurrentOffsetMs();
                            DateFormat df = new SimpleDateFormat("HH:mm", Locale.ENGLISH);
                            String localTime = df.format(new Date().getTime() + offset);
                            getView().showTime(localTime);
                        },
                        throwable -> getView().onDataNotAvailable()));
    }

    public static MapsPresenter getInstance() {
        Factory factory = new MapsPresenter.Factory();
        Injector.INSTANCE.getAppComponent().inject(factory);
        return factory.create();
    }

    public static class Factory {
        @Inject
        AskGeoComInteractor askGeoComInteractor;

        MapsPresenter create() {
            return new MapsPresenter(askGeoComInteractor);
        }
    }
}
