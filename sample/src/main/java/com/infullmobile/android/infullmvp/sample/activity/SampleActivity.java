package com.infullmobile.android.infullmvp.sample.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.infullmobile.android.infullmvp.InFullMvpActivity;
import com.infullmobile.android.infullmvp.sample.activity.di.SampleActivityGraph;

import javax.inject.Inject;

public class SampleActivity extends InFullMvpActivity<SampleActivityPresenter, SampleActivityView> {

    @Inject SampleActivityPresenter sampleActivityPresenter;
    @Inject SampleActivityView sampleActivityView;

    protected SampleActivityGraph sampleActivityGraph;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sampleActivityGraph = new SampleActivityGraph(this);
    }

    @Override
    protected SampleActivityPresenter getPresenter() {
        return sampleActivityPresenter;
    }

    @Override
    protected SampleActivityView getPresentedView() {
        return sampleActivityView;
    }

    @Override
    protected void injectIntoGraph() {
        sampleActivityGraph.inject(this);
    }

    public static Intent getIntent(Context context) {
        return new Intent(context, SampleActivity.class);
    }
}
