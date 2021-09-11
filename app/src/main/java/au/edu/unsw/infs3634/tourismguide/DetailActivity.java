package au.edu.unsw.infs3634.tourismguide;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class DetailActivity extends AppCompatActivity {
    public static final String INTENT_MESSAGE = "au.edu.unsw.infs3634.tourismguide.intent_message";

    private TextView mName;
    private ImageView mImage;
    private TextView mType;
    private TextView mLocation;
    private TextView mPrice;
    private TextView mRating;
    private TextView mAbout;
    private TextView mBlurb;
    private TextView mThoughts;
    private TextView mComments;
    private ImageView mAddressIcon;
    private TextView mAddress;
    private ImageView mWebsiteIcon;
    private TextView mWebsite;
    private ImageView mPhoneIcon;
    private TextView mPhone;
    private RatingBar mRatingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        TextView mName = findViewById(R.id.tvName);
        ImageView mImage = findViewById(R.id.ivImage);
        TextView mType = findViewById(R.id.tvType);
        TextView mLocation = findViewById(R.id.tvLocation);
        TextView mPrice = findViewById(R.id.tvPrice);
        TextView mRating = findViewById(R.id.tvRating);
        //TextView mAbout = findViewById(R.id.tvAbout);
        TextView mBlurb = findViewById(R.id.tvBlurb);
        //TextView mThoughts = findViewById(R.id.tvThoughts);
        TextView mComments = findViewById(R.id.tvComments);
        ImageView mAddressIcon = findViewById(R.id.ivAddress);
        TextView mAddress = findViewById(R.id.tvAddress);
        ImageView mWebsiteIcon = findViewById(R.id.ivWeb);
        TextView mWebsite = findViewById(R.id.tvWebsite);
        ImageView mPhoneIcon = findViewById(R.id.ivPhone);
        TextView mPhone = findViewById(R.id.tvPhone);
        RatingBar mRatingBar = findViewById(R.id.rbRating);

        Intent intent = getIntent();
        String attractionName = intent.getStringExtra(INTENT_MESSAGE);

        ArrayList<Attraction> attractions = Attraction.getAttractions();
        for(final Attraction attraction : attractions) {
            if(attraction.getName().equals(attractionName)) {
                setTitle(attraction.getName());
                mName.setText(attraction.getName());
                mImage.setImageResource(attraction.getIcon());
                mType.setText(attraction.getType());
                mLocation.setText(attraction.getLocation());
                mPrice.setText(attraction.getPrice());
                mRating.setText(attraction.getRating());
                mBlurb.setText(attraction.getBlurb());
                mComments.setText(attraction.getComments());
                mAddress.setText(attraction.getAddress());
                mWebsite.setText(attraction.getWebsite());
                mPhone.setText(attraction.getPhoneNo());
                mRatingBar.setRating(Float.parseFloat(attraction.getRating()));

                mWebsiteIcon.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        searchGoogle(attraction.getWebsite());
                    }
                });
                mWebsite.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        searchGoogle(attraction.getWebsite());
                    }
                });
                mAddress.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        searchMaps(attraction.getName());
                    }
                });
                mAddressIcon.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        searchMaps(attraction.getName());
                    }
                });
                mPhone.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialPhone(attraction.getPhoneNo());
                    }
                });
                mPhoneIcon.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialPhone(attraction.getPhoneNo());
                    }
                });
            }
        }
    }


    private void searchGoogle(String website) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(website));
        startActivity(intent);
    }

    private void searchMaps(String address) {
        // Create a Uri from an intent string. Use the result to create an Intent.
        Uri gmmIntentUri = Uri.parse("geo:0,0?q=" + address);
        // Create an Intent from gmmIntentUri. Set the action to ACTION_VIEW
        Intent intent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        // Make the Intent explicit by setting the Google Maps package
        intent.setPackage("com.google.android.apps.maps");
        // Attempt to start an activity that can handle the Intent
        startActivity(intent);
    }

    private void dialPhone (String phoneNo) {
        Uri intentUri = Uri.parse("tel:" + phoneNo);
        Intent intent = new Intent(Intent.ACTION_DIAL, intentUri);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}
