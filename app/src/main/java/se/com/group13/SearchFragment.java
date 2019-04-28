package se.com.group13;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

/**
 * Created by User on 10/22/2017.
 */

public class SearchFragment extends Fragment {

    private static final String TAG = "SearchFragment";
    ImageButton btn_allItems, btn_electronics,btn_books, btn_cycle, btn_misc, btn_mobiles, btn_myitems;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search, container, false);

        btn_allItems = (ImageButton) view.findViewById(R.id.btn_allItems);
        btn_books=(ImageButton)view.findViewById(R.id.btn_books);
        btn_electronics=(ImageButton)view.findViewById(R.id.btn_electronics);
        btn_cycle=(ImageButton)view.findViewById(R.id.btn_cycle);
        btn_misc=(ImageButton)view.findViewById(R.id.btn_misc);
        btn_myitems=(ImageButton)view.findViewById(R.id.btn_myList);
        btn_mobiles=(ImageButton)view.findViewById(R.id.btn_mobiles);

        btn_allItems.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                intent = new Intent(getActivity(), activity_all_Items.class);
                intent.putExtra("category", "all_items");
                startActivity(intent);
            }
        });

        btn_electronics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                intent = new Intent(getActivity(), activity_all_Items.class);
                intent.putExtra("category", "electronics");
                startActivity(intent);
            }
        });

        btn_books.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                intent = new Intent(getActivity(), activity_all_Items.class);
                intent.putExtra("category", "books");
                startActivity(intent);
            }
        });

        btn_cycle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                intent = new Intent(getActivity(), activity_all_Items.class);
                intent.putExtra("category", "cycle");
                startActivity(intent);
            }
        });

        btn_misc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                intent = new Intent(getActivity(), activity_all_Items.class);
                intent.putExtra("category", "misc");
                startActivity(intent);
            }
        });
        btn_mobiles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                intent = new Intent(getActivity(), activity_myItems.class);
                intent.putExtra("category", "mobiles");
                startActivity(intent);
            }
        });

        btn_myitems.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                intent = new Intent(getActivity(), activity_myItems.class);
                intent.putExtra("category", "misc");
                startActivity(intent);
            }
        });

        return view;

    }



}







