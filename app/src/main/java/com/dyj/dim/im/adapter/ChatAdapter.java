package com.dyj.dim.im.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dyj.dim.R;
import com.dyj.dim.im.entity.ChatMessage;
import com.dyj.dim.im.type.ChatMessageType;

import java.util.ArrayList;

/**
 * Created by DYJ on 2016/12/13.
 */

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.ChatHolder> {

    private ArrayList<ChatMessage> chatMessages;

    public ChatAdapter(ArrayList<ChatMessage> chatMessages) {
        this.chatMessages = chatMessages;
    }

    @Override
    public int getItemViewType(int position) {
        int type = chatMessages.get(position).getMessageType();
        return type;
    }

    @Override
    public ChatHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ChatHolder chatHolder = null;
        switch (viewType) {
            case ChatMessageType.TEXT:

                break;
            case ChatMessageType.IMAGE:

                break;
        }
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_chat, null);
        itemView.setLayoutParams(new RecyclerView.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        return new ChatHolder(itemView);
    }

    @Override
    public int getItemCount() {
        return chatMessages == null ? 0 : chatMessages.size();
    }

    @Override
    public void onBindViewHolder(ChatHolder holder, int position) {
        ChatMessage chatMessage = chatMessages.get(position);
        holder.tv_chat_msg_time.setText(String.valueOf(chatMessage.getMessageTime()));
    }

    public class ChatHolder extends RecyclerView.ViewHolder {

        public TextView tv_chat_msg_time;

        public ChatHolder(View itemView) {
            super(itemView);
            tv_chat_msg_time = (TextView) itemView.findViewById(R.id.tv_chat_msg_time);
        }
    }

}
