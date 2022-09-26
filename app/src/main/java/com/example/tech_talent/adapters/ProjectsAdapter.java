package com.example.tech_talent.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.tech_talent.R;
import com.example.tech_talent.model.Projects;

import java.util.List;

public class ProjectsAdapter extends RecyclerView.Adapter<ProjectsAdapter.ProjectsViewHolder> {
    private List<Projects> listProject;

    public ProjectsAdapter(List<Projects> listProject) {
        this.listProject = listProject;
    }

    @NonNull
    @Override
    public ProjectsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_projects_viewholder, parent, false);

        return new ProjectsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProjectsViewHolder holder, int position) {
        holder.layout.findViewById(R.id.pFundoLayout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        ((TextView) holder.layout.findViewById(R.id.txtId)).setText(listProject.get(position).getId());
        ((TextView) holder.layout.findViewById(R.id.txtTitle)).setText(listProject.get(position).getAmount_people());
        ((TextView) holder.layout.findViewById(R.id.txtDescription)).setText(listProject.get(position).getDescription());
        ((TextView) holder.layout.findViewById(R.id.txtStartDate)).setText(listProject.get(position).getDescription());
        ((TextView) holder.layout.findViewById(R.id.txtExpectedEndDate)).setText(listProject.get(position).getDescription());
        ((TextView) holder.layout.findViewById(R.id.txtAmountPeople)).setText(listProject.get(position).getDescription());
    }

    @Override
    public int getItemCount() {
        return listProject.size();
    }

    class ProjectsViewHolder extends RecyclerView.ViewHolder {
        public View layout;
        public ProjectsViewHolder(@NonNull View itemView) {
            super(itemView);
            this.layout = itemView;
        }
    }
}