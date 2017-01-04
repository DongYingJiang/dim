package com.dyj.dim.im.fragment;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dyj.dim.R;
import com.dyj.dim.base.fragment.BaseFragment;
import com.dyj.dim.databinding.FragmentChatBinding;
import com.dyj.dim.im.adapter.ChatAdapter;
import com.dyj.dim.im.entity.ChatMessage;

import java.util.ArrayList;

/**
 * Created by DYJ.
 * 日期：2016/12/15.
 * 描述：
 * 备注：
 */

public class ChatFragment extends BaseFragment {

    //常量部分
    private static final String USER_ID_KEY = "userId";
    private static final String CHAT_TYPE_KEY = "chatType";

    private ChatAdapter adapter;
    private ArrayList<ChatMessage> chatMessages = new ArrayList<>();
    private FragmentChatBinding binding;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_chat, container, false);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        binding.rvChatList.setLayoutManager(layoutManager);
        binding.rvChatList.setItemAnimator(new DefaultItemAnimator());
        adapter = new ChatAdapter(chatMessages);
        binding.setListener(new ChatListener());
        binding.rvChatList.setAdapter(adapter);
        return binding.getRoot();
    }

    public class ChatListener {
        public void OnClick(View view) {
            chatMessages.add(new ChatMessage(System.currentTimeMillis()));
            binding.rvChatList.smoothScrollToPosition(chatMessages.size() - 1);
            adapter.notifyItemChanged(chatMessages.size() - 1);
        }
    }

    public static ChatFragment newInstance(long userId, int chatType) {
        Bundle bundle = new Bundle();
        bundle.putLong(USER_ID_KEY, userId);
        bundle.putLong(CHAT_TYPE_KEY, chatType);
        ChatFragment fragment = new ChatFragment();
        fragment.setArguments(bundle);
        return fragment;
    }
}
