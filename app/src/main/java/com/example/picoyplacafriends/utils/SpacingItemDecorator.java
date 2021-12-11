package com.example.picoyplacafriends.utils;

import android.graphics.Rect;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Esta clase permite añadir espacio entre los elementos del recycler
 */
public class SpacingItemDecorator extends RecyclerView.ItemDecoration {
    private final int verticalHeight;

    public SpacingItemDecorator(int verticalHeight) {
        this.verticalHeight = verticalHeight;
    }

    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        outRect.bottom = verticalHeight;
    }
}
