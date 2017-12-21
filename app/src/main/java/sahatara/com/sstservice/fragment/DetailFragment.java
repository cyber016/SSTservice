package sahatara.com.sstservice.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import sahatara.com.sstservice.MainActivity;
import sahatara.com.sstservice.R;

/**
 * Created by Aum on 21/12/2560.
 */

public class DetailFragment extends Fragment {
    private String idString, nameString, catString, imageString, priceString, detailString;

    public static DetailFragment detailInstanc(String idString,
                                               String nameString,
                                               String catString,
                                               String imageString,
                                               String priceString,
                                               String detailString) {
        DetailFragment detailFragment = new DetailFragment();
        Bundle bundle = new Bundle();
        bundle.putString("id", idString);
        bundle.putString("Name", nameString);
        bundle.putString("Category", catString);
        bundle.putString("Image", imageString);
        bundle.putString("Price", priceString);
        bundle.putString("Detail", detailString);
        detailFragment.setArguments(bundle);

        return detailFragment;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

//         Get Argument
        getArgument();

//        Create Toolbar
        createToolbar();

//        ShowView
        showView();



    }   //  Main method

    private void showView() {
        TextView catTextView = getView().findViewById(R.id.category);
        catTextView.setText(catString);

        ImageView imageView = getView().findViewById(R.id.imageFood);
        Picasso.with(getActivity()).load(imageString).into(imageView);

        TextView priceTextView = getView().findViewById(R.id.txtprice);
        priceTextView.setText(priceString+" THB.");

        TextView detailTextView = getView().findViewById(R.id.txtDetail);
        detailTextView.setText(detailString);
    }

    private void createToolbar() {
        Toolbar toolbar = getView().findViewById(R.id.toolbarDetailFragment);

        ((MainActivity)getActivity()).setSupportActionBar(toolbar);
        ((MainActivity) getActivity()).getSupportActionBar()
                .setTitle(nameString);
        ((MainActivity)getActivity()).getSupportActionBar()
                .setHomeButtonEnabled(true);
        ((MainActivity)getActivity()).getSupportActionBar()
                .setDisplayHomeAsUpEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().popBackStack();
            }
        });
    }

    private void getArgument() {
        idString = getArguments().getString("id");
        nameString = getArguments().getString("Name");
        catString = getArguments().getString("Category");
        imageString = getArguments().getString("Image");
        priceString = getArguments().getString("Price");
        detailString  = getArguments().getString("Detail");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail, container, false);

        return view;
    }
}   //Main Class

