package com.kinishinai.myapplication;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.text.Html;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ResultRecyclerViewAdapter extends RecyclerView.Adapter<ResultRecyclerViewAdapter.ViewHolder>{

    private ArrayList<CitationResult>userInsertedData = new ArrayList<>();
    private Context context;
    private ClipboardManager clipboardManager;
    public ResultRecyclerViewAdapter(ResultActivity resultActivity) {
        this.context = resultActivity;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.result_list, parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        String bookTitle = userInsertedData.get(position).getBookTitle();
        String workCited1 = userInsertedData.get(position).getWorkCited();
        String workCited2 = userInsertedData.get(position).getWorkCited2();
        String intextCitation = userInsertedData.get(position).getInTextCited();



        Spanned styledText = Html.fromHtml( workCited1+"<i>"+bookTitle+"</i>"+workCited2);


        holder.citedResult.setText(styledText);
        holder.intextCitationResult.setText(intextCitation);
        holder.btnCopy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String workCitedResultCopy = holder.citedResult.getText().toString();
                clipboardManager = (ClipboardManager) v.getContext().getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clipData = ClipData.newPlainText("result", workCitedResultCopy);
                clipboardManager.setPrimaryClip(clipData);
                Toast.makeText(context, "Copied to clipboard", Toast.LENGTH_SHORT).show();
            }
        });
        holder.btnCopy2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inTextResultCopy = holder.intextCitationResult.getText().toString();
                clipboardManager = (ClipboardManager) v.getContext().getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clipData = ClipData.newPlainText("result", inTextResultCopy);
                clipboardManager.setPrimaryClip(clipData);
                Toast.makeText(context, "Copied to clipboard", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return userInsertedData.size();
    }

    public void setUserInsertedData(ArrayList<CitationResult> userInsertedData) {
        this.userInsertedData = userInsertedData;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView workCitedTextView, citedResult, inTextTextView, intextCitationResult;
        private CardView cardViewResultCite;
        private ImageButton btnCopy, btnCopy2;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            // button
            btnCopy = itemView.findViewById(R.id.btn_copy);
            btnCopy2 = itemView.findViewById(R.id.btn_copy2);


            workCitedTextView = itemView.findViewById(R.id.work_citedTextView);
            //the data sa baba
            citedResult = itemView.findViewById(R.id.citedResult);

            inTextTextView = itemView.findViewById(R.id.in_text_textView);
            //the data sa baba
            intextCitationResult = itemView.findViewById(R.id.intextCitationResult);

            cardViewResultCite = itemView.findViewById(R.id.cardViewResultCite);
        }


    }
}
