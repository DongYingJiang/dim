package com.dyj.dim;

import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.dyj.dim.base.activity.BaseActivity;
import com.dyj.dim.im.adapter.ChatAdapter;
import com.dyj.dim.im.entity.ChatMessage;

import java.util.ArrayList;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    private RecyclerView rv_chat_list;
    private ChatAdapter adapter;
    private ArrayList<ChatMessage> chatMessages = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.add).setOnClickListener(this);
        rv_chat_list = (RecyclerView) findViewById(R.id.rv_chat_list);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        rv_chat_list.setLayoutManager(layoutManager);
        rv_chat_list.setItemAnimator(new DefaultItemAnimator());
        adapter = new ChatAdapter(chatMessages);
        rv_chat_list.setAdapter(adapter);
    }

    @Override
    public void onClick(View view) {
        chatMessages.add(new ChatMessage(System.currentTimeMillis()));
        rv_chat_list.smoothScrollToPosition(chatMessages.size() - 1);
        adapter.notifyItemChanged(chatMessages.size() - 1);
    }
}
