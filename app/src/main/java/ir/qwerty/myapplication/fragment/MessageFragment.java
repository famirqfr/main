package ir.qwerty.myapplication.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.github.clans.fab.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import ir.qwerty.myapplication.ChatMessageActivity;
import ir.qwerty.myapplication.ChatReportActivity;
import ir.qwerty.myapplication.R;
import ir.qwerty.myapplication.adapter.MessageAdapter;
import ir.qwerty.myapplication.model.MessageModel;

public class MessageFragment extends Fragment {

    View view;
    FloatingActionButton fab;

    private List<MessageModel> messageModels = new ArrayList<>();
    private RecyclerView recyclerView;
    private MessageAdapter messageAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_message, container, false);

        fab = view.findViewById(R.id.fab);
        recyclerView = view.findViewById(R.id.recyclerView);
        messageAdapter = new MessageAdapter(messageModels);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ChatMessageActivity.class);
                startActivity(intent);
            }
        });

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(messageAdapter);
        setData();
        return view;
    }


    private void setData() {
        messageModels.clear();
        messageModels.add(new MessageModel("https://b2n.ir/663328", "امیرمحمد", "2020/10/10", "لورم ایپسوم متن ساختگی با تولید سادگی نامفهوم از صنعت چاپ، و با استفاده از طراحان گرافیک است"));
        messageModels.add(new MessageModel("https://b2n.ir/488748", "محمد", "2020/10/9", "لورم ایپسوم متن ساختگی با تولید سادگی نامفهوم از صنعت چاپ، و با استفاده از طراحان گرافیک است"));
        messageModels.add(new MessageModel("https://b2n.ir/747849", "مهدی", "2020/10/9", "لورم ایپسوم متن ساختگی با تولید سادگی نامفهوم از صنعت چاپ، و با استفاده از طراحان گرافیک است"));

    }
}
