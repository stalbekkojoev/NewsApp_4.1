package com.example.newsapp_41;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newsapp_41.databinding.ItemPagerBinding;

public class BoardAdapter extends RecyclerView.Adapter<BoardAdapter.MyViewHolder> {
    String[] textTheme = new String[]{"GeekTech", "Android", "GeekCamp"};
    String[] textDesc = new String[]{"Студенты", "Kotlin", "Android"};
    int[] image = new int[]{R.drawable.pngwing_com_1_, R.drawable.pngwing_com_2_, R.drawable.pngwing_com_3_};

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemPagerBinding binding = ItemPagerBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return image.length;
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        private ItemPagerBinding binding;

        public MyViewHolder(@NonNull ItemPagerBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(int position) {
            binding.textThemeBoard.setText(textTheme[position]);
            binding.textBoardDescription.setText(textDesc[position]);
            binding.imageBoard.setImageResource(image[position]);
        }
    }
}
