package com.example.newsapp_41;

import com.example.newsapp_41.modals.Article;

public interface Click {
    void click(Article article);
    void longClick(int position);
}
