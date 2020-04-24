package com.alexthekap.societe_generale.app.presentation_layer.Main;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.alexthekap.societe_generale.R;
import com.alexthekap.societe_generale.app.presentation_layer.Map.MapsActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class MainActivity extends AppCompatActivity implements MainContract.View {

    private MainPresenter mPresenter;
    private Unbinder unbinder;

    @BindView(R.id.go_to_map)
    TextView mapBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        unbinder = ButterKnife.bind(this);
        mPresenter = new MainPresenter();
        mapBtn.setOnClickListener(v -> mPresenter.onGoToMapClick());
    }

    @Override
    protected void onResume() {
        super.onResume();
        mPresenter.wire(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mPresenter.unWire();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }

    @Override
    public void showMap() {
        Intent intent = new Intent(this, MapsActivity.class);
        startActivity(intent);
    }
}
