package com.kinishinai.myapplication;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;

public class CitationStyleListAdapter extends RecyclerView.Adapter<CitationStyleListAdapter.ViewHolder>{

    private ArrayList<Styles>citationFormat = new ArrayList<>();
    private Context context;

    public CitationStyleListAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.citation_styles_list, parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.txtsourceView.setText(citationFormat.get(position).getSource());
        holder.imageStyle.setImageResource(citationFormat.get(position).getImageStyle());
        holder.citationStyleTextview.setText(citationFormat.get(position).getCitationStyle());
        holder.textVersion.setText(citationFormat.get(position).getVersion());

        holder.cardviewParent.setOnClickListener(new View.OnClickListener() {
            private Intent intent;
            @Override
            public void onClick(View v) {
                //TODO: gawa ka bagong mga activity.
                if(citationFormat.get(position).getId() == 1){
                    intent = new Intent(context, FillUpActivity.class);
                    context.startActivity(intent);
                    Toast.makeText(context, citationFormat.get(position).getSource()+", "+citationFormat.get(position).getCitationStyle(), Toast.LENGTH_SHORT).show();
                }
                if (citationFormat.get(position).getId() == 2){
                    intent = new Intent(context, FillUpActivity2.class);
                    context.startActivity(intent);
                    Toast.makeText(context, citationFormat.get(position).getSource()+", "+citationFormat.get(position).getCitationStyle(), Toast.LENGTH_SHORT).show();
                }
                if(citationFormat.get(position).getId() == 3){
                    intent = new Intent(context, FillUpActivity3.class);
                    context.startActivity(intent);
                    Toast.makeText(context, citationFormat.get(position).getSource()+", "+citationFormat.get(position).getCitationStyle(), Toast.LENGTH_SHORT).show();
                }
                if (citationFormat.get(position).getId() == 4){
                    intent = new Intent(context, FillUpActivity4.class);
                    context.startActivity(intent);
                    Toast.makeText(context, citationFormat.get(position).getSource()+", "+citationFormat.get(position).getCitationStyle(), Toast.LENGTH_SHORT).show();
                }
                if (citationFormat.get(position).getId() == 5){
                    intent = new Intent(context, FillUpActivity5.class);
                    context.startActivity(intent);
                    Toast.makeText(context, citationFormat.get(position).getSource()+", "+citationFormat.get(position).getCitationStyle(), Toast.LENGTH_SHORT).show();
                }
                if (citationFormat.get(position).getId() == 6){
                    intent = new Intent(context, FillUpActivity6.class);
                    context.startActivity(intent);
                    Toast.makeText(context, citationFormat.get(position).getSource()+", "+citationFormat.get(position).getCitationStyle(), Toast.LENGTH_SHORT).show();
                }
                if (citationFormat.get(position).getId() == 7){
                    intent = new Intent(context, FillUpActivity7.class);
                    context.startActivity(intent);
                    Toast.makeText(context, citationFormat.get(position).getSource()+", "+citationFormat.get(position).getCitationStyle(), Toast.LENGTH_SHORT).show();
                }
                if (citationFormat.get(position).getId() == 8){
                    intent = new Intent(context, FillUpActivity8.class);
                    context.startActivity(intent);
                    Toast.makeText(context, citationFormat.get(position).getSource()+", "+citationFormat.get(position).getCitationStyle(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return citationFormat.size();
    }

    public void setCitationFormat(ArrayList<Styles> citationFormats){
        this.citationFormat = citationFormats;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private CardView cardviewParent;
        private TextView txtsourceView;
        private TextView citationStyleTextview;
        private TextView textVersion;
        private ImageView imageStyle;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cardviewParent = itemView.findViewById(R.id.cardviewParent);
            txtsourceView = itemView.findViewById(R.id.sourceName);
            citationStyleTextview = itemView.findViewById(R.id.citationStyleTextview);
            textVersion = itemView.findViewById(R.id.versionTextView);
            imageStyle = itemView.findViewById(R.id.imageStyle);

        }
    }
}
