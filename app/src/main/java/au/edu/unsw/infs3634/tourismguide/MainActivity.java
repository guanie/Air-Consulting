package au.edu.unsw.infs3634.tourismguide;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.SearchView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private ListAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = findViewById(R.id.rvList);
        mRecyclerView.setHasFixedSize(true);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        ListAdapter.RecyclerViewClickListener listener = new ListAdapter.RecyclerViewClickListener() {
            @Override
            public void onClick(View view, String name) {
                launchDetailActivity(name);
            }
        };

        //OnClick
        mAdapter = new ListAdapter(Attraction.getAttractions(), listener);
        mRecyclerView.setAdapter(mAdapter);
    }

    //launch DetailActivity
    private void launchDetailActivity(String message) {
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra(DetailActivity.INTENT_MESSAGE, message);
        startActivity(intent);
    }

    //override on create options menu to instantiate the menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        SearchView searchView = (SearchView) menu.findItem(R.id.action_search).getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                //mAdapter.getFilter().filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                mAdapter.getFilter().filter(newText);
                return false;
            }
        });
        return true;
    }


    //override the onOptionsItemSelected to react to user interactions with the menu
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.sort_rating_low:
                mAdapter.sort(ListAdapter.SORT_METHOD_RATING_LOW);
                return true;
            case R.id.sort_rating_high:
                mAdapter.sort(ListAdapter.SORT_METHOD_RATING_HIGH);
                return true;
            case R.id.sort_price_low:
                mAdapter.sort(ListAdapter.SORT_METHOD_PRICE_LOW);
                return true;
            case R.id.sort_price_high:
                mAdapter.sort(ListAdapter.SORT_METHOD_PRICE_HIGH);
                return true;
            default:
                return super.onOptionsItemSelected(item);
            ///mAdapter.sort(ListAdapter.SORT_METHOD_RATING_LOW);
        }
    }
}