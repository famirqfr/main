package ir.qwerty.myapplication.adapter;

import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.net.URL;
import java.util.List;

import ir.qwerty.myapplication.ChatMessageActivity;
import ir.qwerty.myapplication.R;
import ir.qwerty.myapplication.model.MessageModel;

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.MessageViewHolder> {
    List<MessageModel> messageModels;
    ConstraintLayout constraintLayout;

    public MessageAdapter(List<MessageModel> messageModels) {
        this.messageModels = messageModels;
    }

    @NonNull
    @Override
    public MessageViewHolder onCreateViewHolder(@NonNull final ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.message_item_style, parent, false);
        constraintLayout = view.findViewById(R.id.messageFrame);
        constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent messagePage = new Intent(parent.getContext(), ChatMessageActivity.class);
                parent.getContext().startActivity(messagePage);
            }
        });
        return new MessageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MessageViewHolder holder, int position) {

        MessageModel m = messageModels.get(position);
        Picasso.get().load(m.getImage()).into(holder.avatar);
        holder.name.setText(m.getName());
        holder.context.setText(m.getContext());
        holder.date.setText(m.getDate());
    }

    @Override
    public int getItemCount() {
        return messageModels.size();
    }

    public class MessageViewHolder extends RecyclerView.ViewHolder {
        ImageView avatar;
        TextView name;
        TextView context;
        TextView date;

        public MessageViewHolder(@NonNull View itemView) {
            super(itemView);
            avatar = itemView.findViewById(R.id.avatar);
            name = itemView.findViewById(R.id.name);
            context = itemView.findViewById(R.id.context);
            date = itemView.findViewById(R.id.date);

        }
    }
}
