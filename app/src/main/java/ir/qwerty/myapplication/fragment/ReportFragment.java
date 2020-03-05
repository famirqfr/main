package ir.qwerty.myapplication.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import ir.qwerty.myapplication.R;
import ir.qwerty.myapplication.adapter.ReportAdapter;
import ir.qwerty.myapplication.model.ReportModel;


public class ReportFragment extends Fragment {

    View view;

    private List<ReportModel> reportModels=new ArrayList<>();
    private RecyclerView recyclerView;
    private ReportAdapter reportAdapter;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view=inflater.inflate(R.layout.fragment_report,container,false);

        recyclerView=view.findViewById(R.id.recyclerViewFragmentReport);
        reportAdapter =new ReportAdapter(reportModels);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(reportAdapter);




        return view;

    }
}
