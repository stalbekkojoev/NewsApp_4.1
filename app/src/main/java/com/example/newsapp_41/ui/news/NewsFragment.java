package com.example.newsapp_41.ui.news;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.newsapp_41.Click;
import com.example.newsapp_41.NewsAdapter;
import com.example.newsapp_41.R;
import com.example.newsapp_41.databinding.FragmentHomeBinding;
import com.example.newsapp_41.databinding.FragmentNewsBinding;
import com.example.newsapp_41.modals.Article;

import java.util.ArrayList;

public class NewsFragment extends Fragment implements Click {
    private FragmentNewsBinding binding;
    private NewsAdapter adapter;
    private ArrayList<Article> list;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        adapter = new NewsAdapter(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentNewsBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                save();
            }
        });
    }

    private void save() {
        String text = binding.editText.getText().toString();
        Bundle bundle=new Bundle();
        Article article = new Article(text, System.currentTimeMillis());
        bundle.putSerializable("article", article);
        getParentFragmentManager().setFragmentResult("rk_news", bundle);
        close();
    }

    private void close() {
        NavController navController = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment_activity_main);
        navController.navigateUp();
    }

    @Override
    public void click(Article article) {

    }

    @Override
    public void longClick(int position) {

    }
}