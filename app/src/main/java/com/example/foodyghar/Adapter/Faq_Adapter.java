package com.example.foodyghar.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodyghar.Model.Faq_model;
import com.example.foodyghar.R;

import java.util.List;

public class Faq_Adapter extends RecyclerView.Adapter<Faq_Adapter.FaqVH>
{
            List<Faq_model> faqModelList;

    public Faq_Adapter(List<Faq_model> faqModelList) {
        this.faqModelList = faqModelList;
    }


    @NonNull
    @Override
    public FaqVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.faq_raw, parent, false);
        return new FaqVH(v);
    }

    @Override
    public void onBindViewHolder(@NonNull Faq_Adapter.FaqVH holder, int position) {

        Faq_model faq_model = faqModelList.get(position);
        holder.questions.setText(faq_model.getQuestions());
        holder.answers.setText(faq_model.getAnswers());

        boolean isExpandable = faqModelList.get(position).isExpandle();
        holder.expandableLayout.setVisibility(isExpandable ? View.VISIBLE : View.GONE);

    }

    @Override
    public int getItemCount() {
        return faqModelList.size();
    }

    public class FaqVH extends RecyclerView.ViewHolder {

        TextView questions, answers;
        LinearLayout linearLayout;
        RelativeLayout expandableLayout;

        public FaqVH(@NonNull View itemView) {
            super(itemView);

            questions = itemView.findViewById(R.id.que1);
            answers = itemView.findViewById(R.id.ans1);

            linearLayout = itemView.findViewById(R.id.linear_layout);
            expandableLayout = itemView.findViewById(R.id.expadable_layout);

            linearLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Faq_model faq_model = faqModelList.get(getAdapterPosition());
                    faq_model.setExpandle(!faq_model.isExpandle());
                    notifyItemChanged(getAdapterPosition());
                }
            });

        }
    }
}
