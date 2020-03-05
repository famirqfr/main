package ir.qwerty.myapplication.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import ir.qwerty.myapplication.R;
import ir.qwerty.myapplication.model.ReportModel;

public class ReportAdapter extends RecyclerView.Adapter<ReportAdapter.ReportViewHolder>{
    List<ReportModel> reportModels;

    public ReportAdapter(List<ReportModel> reportModels) {
        this.reportModels = reportModels;
    }

    @NonNull
    @Override
    public ReportViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.report_item_style,parent,false);
        return new ReportViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ReportViewHolder holder, int position) {
        ReportModel r= reportModels.get(position);
        holder.title.setText(r.getTitle());

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
