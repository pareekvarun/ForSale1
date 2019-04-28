package se.com.group13;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class activity_vew_myPosts extends AppCompatActivity {
    ImageView imageView;
    TextView title, description, price, misc;
    Button btn_deletePost;
    String recd_city="";
    String recd_contact_email="";
    String recd_country="";
    String recd_description="";

    String recd_image="";
    String recd_misc="";
    String recd_post_id="";
    String recd_price="";

    String recd_state="";
    String recd_title="";
    String recd_user_id="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vew_my_posts);

        Intent intent = getIntent();
        recd_post_id = intent.getStringExtra("post_id");
        recd_user_id = intent.getStringExtra("user_id");
        recd_title = intent.getStringExtra("title");
        recd_description = intent.getStringExtra("description");
        recd_image = intent.getStringExtra("image");
        recd_price = intent.getStringExtra("price");
        recd_country = intent.getStringExtra("country");
        recd_state = intent.getStringExtra("state");
        recd_city = intent.getStringExtra("city");
        recd_contact_email = intent.getStringExtra("contact_email");

        String recd_misc = "Hostel/College:   "+recd_state+" |  City:   "+recd_city;

        Log.d("test-postId",recd_post_id);

        imageView=(ImageView)findViewById(R.id.imageViewPost);
        title=(TextView)findViewById(R.id.textViewTitle);
        price=(TextView)findViewById(R.id.textViewPrice);
        description=(TextView)findViewById(R.id.textViewDescription);
        misc=(TextView)findViewById(R.id.textViewMisc);

        String set_price="Price offered by seller: "+recd_price;
        String set_description="----Item Description---- \n"+recd_description;
        String set_address ="----Address--- \n "+recd_misc+"\nContact Email: "+recd_contact_email;
        title.setText(recd_title);
        price.setText(set_price);
        description.setText(set_description);
        misc.setText(set_address);
        Glide.with(getApplicationContext()).load(recd_image).into(imageView);

        btn_deletePost = (Button)findViewById(R.id.btn_deletePost);

    }

    @Override
    protected void onStart() {
        super.onStart();
        btn_deletePost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //delete Post and go back to activity_view_myPosts
                deletePost(recd_post_id);
                Intent intent= new Intent(getApplicationContext(), activity_myItems.class);
                startActivity(intent);

            }
        });
    }

    private void deletePost(String postId){
        DatabaseReference deletePost = FirebaseDatabase.getInstance().getReference("posts").child(postId);
        deletePost.removeValue();
    }
}
