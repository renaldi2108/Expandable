package net.seowars.expandable;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class MainActivity extends AppCompatActivity {
    Unbinder unbinder;

    @BindView(R.id.icon)
    ImageView icon;
    @BindView(R.id.container)
    LinearLayout container;
    @BindView(R.id.txtView)
    TextView txtView;

    int state = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        unbinder = ButterKnife.bind(this);
    }

    @OnClick(R.id.cardView)
    protected void onClickExpand() {
        if(state == 0){
            state = 1;
            icon.animate().rotation(0).start();
            txtView.setVisibility(View.GONE);
//            rv.setVisibility(View.GONE);
            TransitionManager.beginDelayedTransition(container, new AutoTransition());
        } else {
            state = 0;
            icon.animate().rotation(180).start();
            txtView.setVisibility(View.VISIBLE);
//            rv.setVisibility(View.VISIBLE);
            TransitionManager.beginDelayedTransition(container, new AutoTransition());
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }
}
