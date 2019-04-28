package se.com.group13.util;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import se.com.group13.R;
import se.com.group13.models.Post;

public class PostList extends ArrayAdapter<Post> {
    private String  post_id;
    private Activity context;
    private List<Post> postList;

    public PostList(Activity context, List<Post> postList){
        super(context, R.layout.list_layout, postList);
        this.context=context;
        this.postList=postList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.list_layout,null,true);
        TextView textViewTitle = (TextView)listViewItem.findViewById(R.id.title_text);
        TextView textViewPrice = (TextView)listViewItem.findViewById(R.id.price_text);
        ImageView imageViewItem = (ImageView)listViewItem.findViewById(R.id.item_image);


        Post post =postList.get(position);

        textViewTitle.setText(post.getTitle());
        textViewPrice.setText(post.getPrice());
        Glide.with(context).load(post.getImage()).into(imageViewItem);
        post_id = post.getPost_id();
        return listViewItem;

    }
}
