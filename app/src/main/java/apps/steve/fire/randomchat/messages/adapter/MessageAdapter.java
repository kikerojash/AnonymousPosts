package apps.steve.fire.randomchat.messages.adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import apps.steve.fire.randomchat.R;
import apps.steve.fire.randomchat.main.ui.entity.Message;
import apps.steve.fire.randomchat.messages.adapter.holder.MessageHolder;
import apps.steve.fire.randomchat.messages.listener.MessagesListener;
import butterknife.BindView;

/**
 * Created by @stevecampos on 19/12/2017.
 */

public class MessageAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final String TAG = MessageAdapter.class.getSimpleName();
    private List<Message> messages = new ArrayList<>();
    private RecyclerView recyclerView;
    private MessagesListener listener;

    public MessageAdapter() {
    }

    public void setListener(MessagesListener listener) {
        this.listener = listener;
    }

    public void setRecyclerView(RecyclerView recyclerView) {
        this.recyclerView = recyclerView;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_message, parent, false);
        return new MessageHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Message message = messages.get(position);
        Log.d(TAG, "onBindViewHolder message: " + message.toString());
        ((MessageHolder) holder).bind(message, listener);
    }

    @Override
    public int getItemCount() {
        return messages.size();
    }

    public void addMessage(Message message) {
        if (!messages.contains(message)) {
            int position = 0;
            messages.add(position, message);
            notifyItemInserted(position);
        }
    }
}
