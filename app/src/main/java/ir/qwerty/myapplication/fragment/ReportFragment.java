package ir.qwerty.myapplication.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.github.clans.fab.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import ir.qwerty.myapplication.ChatReportActivity;
import ir.qwerty.myapplication.R;
import ir.qwerty.myapplication.adapter.ReportAdapter;
import ir.qwerty.myapplication.model.ReportModel;


public class ReportFragment extends Fragment {

    View view;
    FloatingActionButton fab;
    private List<ReportModel> reportModels=new ArrayList<>();
    private RecyclerView recyclerView;
    private ReportAdapter reportAdapter;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view=inflater.inflate(R.layout.fragment_report,container,false);
        fab=view.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(getActivity(), ChatReportActivity.class);
                startActivity(intent);
            }
        });

        recyclerView=view.findViewById(R.id.recyclerView);
        reportAdapter =new ReportAdapter(reportModels);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(reportAdapter);
        setData();
        return view;
    }


    private void setData(){
        reportModels.clear();
        reportModels.add(new ReportModel("hdshv","hdkssghkvggcgs","yess"));

    }
}
