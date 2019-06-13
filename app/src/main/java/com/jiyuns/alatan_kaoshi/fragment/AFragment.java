package com.jiyuns.alatan_kaoshi.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.jiyuns.alatan_kaoshi.R;
import com.jiyuns.alatan_kaoshi.adapter.MyAdapter;
import com.jiyuns.alatan_kaoshi.api.ApiService;
import com.jiyuns.alatan_kaoshi.bean.CateBean;
import com.jiyuns.alatan_kaoshi.bean.DataBean;
import com.jiyuns.alatan_kaoshi.utils.DbUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * A simple {@link Fragment} subclass.
 */
public class AFragment extends Fragment {


    private View view;
    private RecyclerView mRecyclerView;
    private ArrayList<DataBean> dataBeans;
    private MyAdapter myAdapter;

    public AFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_a, container, false);
        initView(inflate);
        initData(inflate);
        return inflate;
    }

    private void initData(View inflate) {
        Retrofit retrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(ApiService.baseUrl)
                .build();
        ApiService apiService = retrofit.create(ApiService.class);
        Observable<CateBean> data = apiService.getData();
        data.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<CateBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(CateBean cateBean) {
                        List<DataBean> data1 = cateBean.getData();
                        dataBeans.addAll(data1);
                        myAdapter.setList(dataBeans);
                        myAdapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.i("TAG", " " + e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    private void initView(View inflate) {
        mRecyclerView = (RecyclerView) inflate.findViewById(R.id.recyclerView);
        dataBeans = new ArrayList<>();
        myAdapter = new MyAdapter(getActivity(), dataBeans);
        mRecyclerView.setAdapter(myAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));


    }
}
