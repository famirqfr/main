package ir.qwerty.myapplication.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import ir.qwerty.myapplication.ChatReportActivity;
import ir.qwerty.myapplication.R;
import ir.qwerty.myapplication.model.ReportModel;

public class ReportAdapter extends RecyclerView.Adapter<ReportAdapter.ReportViewHolder>{
    List<ReportModel> reportModels;
    ConstraintLayout constraintLayout;

    public ReportAdapter(List<ReportModel> reportModels) {
        this.reportModels = reportModels;
    }

    @NonNull
    @Override
    public ReportViewHolder onCreateViewHolder(@NonNull final ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.report_item_style,parent,false);
        constraintLayout=view.findViewById(R.id.reportFrame);
        constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(parent.getContext(), ChatReportActivity.class);
                parent.getContext().startActivity(intent);
            }
        });


        return new ReportViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ReportViewHolder holder, int position) {
        ReportModel r= reportModels.get(position);
        holder.title.setText(r.getTitle());
        holder.context.setText(r.getContext());
        holder.importance.setText(r.getImportance());
    }

    @Override
    public int getItemCount() {
        return reportModels.size();
    }

    public class ReportViewHolder extends RecyclerView.ViewHolder {

        TextView title;
        TextView context;
         TextView importance;

        public ReportViewHolder(@NonNull View itemView) {


            super(itemView);
            title=itemView.findViewById(R.id.titleReport);
            context=itemView.findViewById(R.id.contextReport);
            importance=itemView.findViewById(R.id.importanceReport);
        }
    }
}
