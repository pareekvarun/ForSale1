package se.com.group13;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import se.com.group13.models.Post;
import se.com.group13.util.PostList;

public class activity_myItems extends AppCompatActivity {
    private Query databasePost;
    private String category;
    private ListView listViewPost;

    private List<Post> postList;
    private Post post;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ImageButton btn_back, btn_home;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_items);

        btn_back = (ImageButton)findViewById(R.id.btn_back);
        btn_home = (ImageButton)findViewById(R.id.btn_home);

        listViewPost=(ListView) findViewById(R.id.result_list);
        postList = new ArrayList<>();

        FirebaseUser currentFirebaseUser = FirebaseAuth.getInstance().getCurrentUser() ;
        //Log.d("test-currentUser",currentFirebaseUser.getUid());
        databasePost= FirebaseDatabase.getInstance().getReference("posts").orderByChild("user_id").equalTo(currentFirebaseUser.getUid());

        listViewPost.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override

            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                //Log.d("test-index", position.toString());
                post=postList.get(position);
                Intent intent = new Intent(getApplicationContext(),activity_vew_myPosts.class);
                intent.putExtra("post_id", post.getPost_id());
                intent.putExtra("user_id", post.getUser_id());
                intent.putExtra("image", post.getImage());
                Log.d("test-image",post.getImage());
                intent.putExtra("title", post.getTitle());
                intent.putExtra("description", post.getDescription());
                intent.putExtra("price", post.getPrice());
                intent.putExtra("country", post.getCountry());
                intent.putExtra("state", post.getState_province());
                intent.putExtra("city", post.getCity());
                intent.putExtra("contact_email", post.getContact_email());

                startActivity(intent);
            }
        });

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(activity_myItems.this, SearchActivity.class);
                startActivity(intent1);
            }
        });

        btn_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent1 = new Intent(activity_myItems.this, SearchActivity.class);
                startActivity(intent1);
            }
        });

    }

    protected void onStart() {
        super.onStart();




        databasePost.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                postList.clear();
                for(DataSnapshot postSnapshot:dataSnapshot.getChildren()){
                    post = postSnapshot.getValue(Post.class);
                    Log.d("Post detail",post.toString());
                    postList.add(post);
                }
                PostList adapter = new PostList(activity_myItems.this, postList);
                listViewPost.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
