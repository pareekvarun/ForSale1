package se.com.group13;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.google.firebase.database.Query;

import java.util.List;

import se.com.group13.models.Post;

/**
 * Created by User on 10/22/2017.
 */

public class WatchListFragment extends Fragment {
    private Query databasePost;
    private String category;
    private ListView listViewPost;

    private List<Post> postList;
    private Post post;

    private static final String TAG = "WatchListFragment";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_watch_list, container, false);


//        listViewPost=(ListView) getActivity().findViewById(R.id.result_list);
//
//        postList = new ArrayList<>();
//
//        databasePost= FirebaseDatabase.getInstance().getReference("posts");
//        listViewPost.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//
//                //Log.d("test-index", position.toString());
//                post=postList.get(position);
//                Intent intent = new Intent(getActivity().getApplicationContext(),activity_view_post.class);
//                intent.putExtra("post_id", post.getPost_id());
//                intent.putExtra("user_id", post.getUser_id());
//                intent.putExtra("image", post.getImage());
//                Log.d("test-image",post.getImage());
//                intent.putExtra("title", post.getTitle());
//                intent.putExtra("description", post.getDescription());
//                intent.putExtra("price", post.getPrice());
//                intent.putExtra("country", post.getCountry());
//                intent.putExtra("state", post.getState_province());
//                intent.putExtra("city", post.getCity());
//                intent.putExtra("contact_email", post.getContact_email());
//
//                startActivity(intent);
//            }
//        });
//


        return view;
    }

//    @Override
//    public void onResume() {
//        super.onResume();
//
//
//
//        databasePost.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                postList.clear();
//                for(DataSnapshot postSnapshot:dataSnapshot.getChildren()){
//                    post = postSnapshot.getValue(Post.class);
//                    Log.d("Post detail",post.toString());
//                    postList.add(post);
//                }
//                PostList adapter = new PostList(getActivity(), postList);
//                listViewPost.setAdapter(adapter);
//            }
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//
//            }
//        });
//    }


}
