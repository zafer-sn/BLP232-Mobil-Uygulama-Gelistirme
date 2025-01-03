package com.example.messageappwtk

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.messageappwtk.databinding.MessageRowBinding

class MessageAdapter(val messages: ArrayList<Message>) : RecyclerView.Adapter<MessageAdapter.MessageViewHolder>()
{
    class MessageViewHolder(val binding: MessageRowBinding) : RecyclerView.ViewHolder(binding.root)
    {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageViewHolder {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        return messages.size
    }

    override fun onBindViewHolder(holder: MessageViewHolder, position: Int) {
        TODO("Not yet implemented")
    }
}