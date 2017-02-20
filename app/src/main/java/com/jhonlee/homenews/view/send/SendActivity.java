package com.jhonlee.homenews.view.send;

import android.os.Bundle;
import android.os.Parcel;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.EditText;
import android.widget.Toast;

import com.jhonlee.homenews.R;
import com.jhonlee.homenews.contract.RobotContract;
import com.jhonlee.homenews.pojo.Message;
import com.jhonlee.homenews.pojo.Robot;
import com.jhonlee.homenews.presenter.RobotPresenterImpl;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * Created by lijin on 2017/2/19.
 */

public class SendActivity extends AppCompatActivity implements RobotContract.View{

    @BindView(R.id.editText)
    EditText mEt;
    @BindView(R.id.recycle)
    RecyclerView recycle;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    private List<Message> mList;
    private RobotContract.Presenter presenter;
    private SendAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send);
        ButterKnife.bind(this);
        presenter = new RobotPresenterImpl(this);
        toolbar.setTitle("Robot");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);//返回按钮
        initRecycler();
    }

    private void initRecycler(){
        mList = new ArrayList<>();
        adapter = new SendAdapter(this,mList);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recycle.setLayoutManager(manager);
        recycle.setAdapter(adapter);

    }

    @OnClick(R.id.btn_send)
    public void Click(){
        if (!mEt.getText().toString().equals("")){
            Message msg = new Message(Parcel.obtain());
            msg.setmType(0);
            msg.setmMessage(mEt.getText().toString());
            mList.add(msg);
            adapter.notifyDataSetChanged();
            presenter.getMessage(mEt.getText().toString());
        }
        mEt.setText("");
    }

    @Override
    public void showError(String error) {
        Toast.makeText(this,error,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void getMessage(Message message) {

        mList.add(message);
        adapter.notifyDataSetChanged();
    }
}
