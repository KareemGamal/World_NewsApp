package el1000mile.tpd2.b5twa.navdrawer;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class Latest_Frag extends Fragment {


    View v1;
    RecyclerView rv;
    RecyclerAdapter recyclerAdapter;
    ArrayList<News> arrayList;

    News n ;

    int source ;
    SharedPreferences sharedPreferences;

    String [] SouresURl =
            {       "https://newsapi.org/v1/articles?source=reuters&sortBy=latest&apiKey=beddc17c318f45a79f3bbb0cb83cce26",
                    "https://newsapi.org/v1/articles?source=time&sortBy=latest&apiKey=beddc17c318f45a79f3bbb0cb83cce26",
                    "https://newsapi.org/v1/articles?source=daily-mail&sortBy=latest&apiKey=beddc17c318f45a79f3bbb0cb83cce26",
                    "https://newsapi.org/v1/articles?source=the-guardian-uk&sortBy=latest&apiKey=beddc17c318f45a79f3bbb0cb83cce26",
                    "https://newsapi.org/v1/articles?source=bbc-news&sortBy=top&apiKey=beddc17c318f45a79f3bbb0cb83cce26",
                    "https://newsapi.org/v1/articles?source=fox-sports&sortBy=top&apiKey=beddc17c318f45a79f3bbb0cb83cce26",
                    "https://newsapi.org/v1/articles?source=four-four-two&sortBy=top&apiKey=beddc17c318f45a79f3bbb0cb83cce26"

            };


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        sharedPreferences = this.getActivity().getSharedPreferences("source" , Context.MODE_PRIVATE);
        source=sharedPreferences.getInt("Source_URL",0);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        v1 = inflater.inflate(R.layout.fragment_latest, container, false);
        rv = (RecyclerView) v1.findViewById(R.id.Rec_3rdFrag);

        showimg();
        getData();

        return v1;
    }

    public void getData(){
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, SouresURl[source] , null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            arrayList = new ArrayList<>();
                              JSONArray ob = response.getJSONArray("articles");
                             int size = ob.length();
                             News sources;

                            for(int i=9  ; i >= 0; i--){
                                sources = new News("" , "" , "" , "" , "" , "");
                                sources.setTitle(ob.getJSONObject((i)).getString("title"));
                                sources.setBy(ob.getJSONObject((i)).getString("author"));
                                sources.setDesc(ob.getJSONObject(i).getString("description"));
                                sources.setDate(ob.getJSONObject(i).getString("publishedAt"));
                                sources.setImg(ob.getJSONObject(i).getString("urlToImage"));
                                sources.setURL(ob.getJSONObject(i).getString("url"));



                                arrayList.add(sources);
                            }

                            recyclerAdapter = new RecyclerAdapter(getContext() , arrayList);

                            rv.setLayoutManager(new LinearLayoutManager(getActivity()));
                            rv.setAdapter(recyclerAdapter);


                            ItemClickSupport.addTo(rv)
                                    .setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
                                        @Override
                                        public void onItemClicked(RecyclerView recyclerView, int position, View v) {

                                            Intent intent = new Intent(getContext() , WebBrowserActivity.class);
                                            intent.putExtra("url" , arrayList.get(position).getURL());
                                            startActivity(intent);
                                        }
                                    });


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getActivity(), error.toString(),Toast.LENGTH_LONG).show();
            }

        });
        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        requestQueue.add(request);
    }

    public void showimg() {

        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(getActivity()).build();
        com.nostra13.universalimageloader.core.ImageLoader.getInstance().init(config);
    }
}
